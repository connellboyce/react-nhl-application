package com.connellboyce.reactnhl.dataloader;

import com.connellboyce.reactnhl.model.Team;
import com.connellboyce.reactnhl.repository.TeamRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(prefix = "nhl.api")
public class TeamDataLoader implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(TeamDataLoader.class);
    private String rooturl;
    private final RestTemplate restTemplate;
    private final TeamRepository teamRepository;

    public TeamDataLoader(RestTemplateBuilder restTemplateBuilder, TeamRepository teamRepository) {
        this.restTemplate = restTemplateBuilder.build();
        this.teamRepository = teamRepository;
    }

    public void setRooturl(String rooturl) {
        this.rooturl = rooturl;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Initializing dataloader with root URL={}", rooturl);
        fetchTeams();
    }

    private void fetchTeams() {
        TeamHolder outerData = this.restTemplate.getForObject(rooturl+"/teams", TeamHolder.class);
        assert outerData != null;
        outerData.getTeams().parallelStream().forEach(team -> {
            team.setLogoURL(guessLogoURL(team));
            logger.info(team.toString());
            teamRepository.save(team);
        });
    }

    private String guessLogoURL(Team team) {
        String urlStart = "http://loodibee.com/wp-content/uploads/nhl-";
        String urlEnd = "-logo.png";
        StringBuilder builder = new StringBuilder();
        builder.append(urlStart)
                .append(normalizeForLogo(team.getName()))
                .append(urlEnd);
        return builder.toString();
    }

    private String normalizeForLogo(String name) {
        return StringUtils.stripAccents(name)
                .replace(".","")
                .replace(" ", "-")
                .toLowerCase();
    }
}

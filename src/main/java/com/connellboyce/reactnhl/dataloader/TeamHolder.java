package com.connellboyce.reactnhl.dataloader;

import com.connellboyce.reactnhl.model.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.StringJoiner;

@JsonIgnoreProperties
public class TeamHolder {
    private String copyright;
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TeamHolder.class.getSimpleName() + "[", "]")
                .add("copyright='" + copyright + "'")
                .add("teams=" + teams)
                .toString();
    }
}

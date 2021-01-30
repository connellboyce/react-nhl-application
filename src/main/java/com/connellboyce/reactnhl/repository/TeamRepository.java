package com.connellboyce.reactnhl.repository;

import com.connellboyce.reactnhl.model.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "teams", path = "teams")
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
    List<Team> findByName(@Param("name") String name);
}

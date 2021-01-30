package com.connellboyce.reactnhl.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Team {
    private @Id @GeneratedValue Long id;
    private String name;
    private String location;
    private String abbreviation;
    private String logoURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Team.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("location='" + location + "'")
                .add("abbreviation='" + abbreviation + "'")
                .add("logoURL='" + logoURL + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) &&
                Objects.equals(name, team.name) &&
                Objects.equals(location, team.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location);
    }
}

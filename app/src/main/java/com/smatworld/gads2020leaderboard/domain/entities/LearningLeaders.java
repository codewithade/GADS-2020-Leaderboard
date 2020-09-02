package com.smatworld.gads2020leaderboard.domain.entities;

import java.util.Objects;

public class LearningLeaders {
    private String name;
    private String hours;
    private String country;
    private String badgeUrl;

    public LearningLeaders() {
    }

    public LearningLeaders(String name, String hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    @Override
    public String toString() {
        return "LearningLeaders{" +
                "name='" + name + '\'' +
                ", hours='" + hours + '\'' +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LearningLeaders)) return false;
        LearningLeaders that = (LearningLeaders) o;
        return name.equals(that.name) &&
                hours.equals(that.hours) &&
                country.equals(that.country) &&
                Objects.equals(badgeUrl, that.badgeUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hours, country, badgeUrl);
    }
}

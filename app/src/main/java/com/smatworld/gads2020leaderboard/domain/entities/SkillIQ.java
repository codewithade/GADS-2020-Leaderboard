package com.smatworld.gads2020leaderboard.domain.entities;

import java.util.Objects;

public class SkillIQ {
    private String name;
    private String score;
    private String country;
    private String badgeUrl;

    public SkillIQ(String name, String score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public SkillIQ() {
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillIQ)) return false;
        SkillIQ skillIQ = (SkillIQ) o;
        return getName().equals(skillIQ.getName()) &&
                getScore().equals(skillIQ.getScore()) &&
                getCountry().equals(skillIQ.getCountry()) &&
                Objects.equals(getBadgeUrl(), skillIQ.getBadgeUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getScore(), getCountry(), getBadgeUrl());
    }

    @Override
    public String toString() {
        return "SkillIQ{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }
}

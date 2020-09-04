package com.smatworld.gads2020leaderboard.domain.entities;

public class SubmissionDetails {
    String firstName;
    String lastName;
    String email;
    String projectLink;

    public SubmissionDetails() {
    }

    public SubmissionDetails(String firstName, String lastName, String email, String projectLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.projectLink = projectLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getProjectLink() {
        return projectLink;
    }

    @Override
    public String toString() {
        return "SubmissionDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", projectLink='" + projectLink + '\'' +
                '}';
    }
}

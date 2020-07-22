package com.softserve.edu.dto;

import java.util.Objects;

public class SprintScore {
    private String sprintName;
    private int score;
    // TODO

    public SprintScore(String sprintName, int score) {
        this.sprintName = sprintName;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SprintScore)) return false;
        SprintScore that = (SprintScore) o;
        return getScore() == that.getScore() &&
                getSprintName().equals(that.getSprintName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSprintName(), getScore());
    }

    public String getSprintName() {
        return sprintName;
    }

    public int getScore() {
        return score;
    }
}

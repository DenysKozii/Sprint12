package com.softserve.edu.dto;

import java.util.List;
import java.util.Objects;

public class StudentScore {
    private String studentName;
    private List<SprintScore> sprintScore;
    // TODO

    public StudentScore(String studentName, List<SprintScore> sprintScore) {
        this.studentName = studentName;
        this.sprintScore = sprintScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentScore)) return false;
        StudentScore that = (StudentScore) o;
        return studentName.equals(that.studentName) &&
                sprintScore.equals(that.sprintScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, sprintScore);
    }
}

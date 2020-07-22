package com.softserve.edu.dto;

import org.springframework.stereotype.Component;

import java.util.Objects;

public class AverageScore {
    private String studentName;
    private double avgScore;
    // TODO

    public AverageScore(String studentName, double avgScore) {
        this.studentName = studentName;
        this.avgScore = avgScore;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AverageScore)) return false;
        AverageScore that = (AverageScore) o;
        return Double.compare(that.getAvgScore(), getAvgScore()) == 0 &&
                getStudentName().equals(that.getStudentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentName(), getAvgScore());
    }

    public String getStudentName() {
        return studentName;
    }

    public double getAvgScore() {
        return avgScore;
    }
}

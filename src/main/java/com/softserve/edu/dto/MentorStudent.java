package com.softserve.edu.dto;

import java.util.List;
import java.util.Objects;

public class MentorStudent {
    private String mentortName;
    private List<String> studentNames;
    // TODO


    public MentorStudent(String mentortName, List<String> studentNames) {
        this.mentortName = mentortName;
        this.studentNames = studentNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MentorStudent)) return false;
        MentorStudent that = (MentorStudent) o;
        return getMentortName().equals(that.getMentortName()) &&
                getStudentNames().equals(that.getStudentNames());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMentortName(), getStudentNames());
    }

    public String getMentortName() {
        return mentortName;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }
}

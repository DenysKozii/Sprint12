package com.softserve.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.DataService;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    private List<Entity> students;
    private List<Entity> mentors;
    private List<Entity> sprints;
    private List<Communication> communication;
    private List<Solution> solution;

    public DataServiceImpl() {
        students = new ArrayList<>();
        mentors = new ArrayList<>();
        sprints = new ArrayList<>();
        communication = new ArrayList<>();
        solution = new ArrayList<>();
    }

    public void addStudent(String studentName) {
        students.add(new Entity(studentName));
    }

    public void addMentor(String mentorName) {
        mentors.add(new Entity(mentorName));
    }

    public void addSprint(String sprintName) {
        sprints.add(new Entity(sprintName));
    }

    public void addCommunication(String studentName, String mentorName) {
        Entity student = students.stream().filter(o->o.getName().equals(studentName)).findFirst().orElse(null);
        Entity mentor = mentors.stream().filter(o->o.getName().equals(mentorName)).findFirst().orElse(null);
        assert student != null: "Student is null";
        assert mentor != null: "Mentor is null";

        communication.add(new Communication(student.getId(),mentor.getId()));
    }

    public void addSolution(String studentName, String sprintName, int score) {
        Entity student = students.stream().filter(o->o.getName().equals(studentName)).findFirst().orElse(null);
        Entity sprint = sprints.stream().filter(o->o.getName().equals(sprintName)).findFirst().orElse(null);
        assert student != null: "Student is null";
        assert sprint != null: "Sprint is null";
        solution.add(new Solution(student.getId(),sprint.getId(),score));
    }

    public List<Entity> getStudents() {
        return students;
    }

    public List<Entity> getMentors() {
        return mentors;
    }

    public List<Entity> getSprints() {
        return sprints;
    }

    public List<Communication> getCommunication() {
        return communication;
    }

    public List<Solution> getSolution() {
        return solution;
    }

    public void setStudents(List<Entity> students) {
        this.students = students;
    }

    public void setMentors(List<Entity> mentors) {
        this.mentors = mentors;
    }

    public void setSprints(List<Entity> sprints) {
        this.sprints = sprints;
    }

    public void setCommunication(List<Communication> communication) {
        this.communication = communication;
    }

    public void setSolution(List<Solution> solution) {
        this.solution = solution;
    }

    // TODO
}

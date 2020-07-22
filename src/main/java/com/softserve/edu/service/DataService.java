package com.softserve.edu.service;

import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;

import java.util.List;

public interface DataService {
    public void setStudents(List<Entity> students);

    public void setMentors(List<Entity> mentors);

    public void setSprints(List<Entity> sprints);

    public void setCommunication(List<Communication> communication);

    public void setSolution(List<Solution> solution);

    public void addStudent(String studentName);

    public void addMentor(String mentorName);

    public void addSprint(String sprintName);

    public void addCommunication(String studentName, String mentorName);
    
    public void addSolution(String studentName, String sprintName, int score);
    
}

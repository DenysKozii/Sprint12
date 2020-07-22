package com.softserve.edu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

@Service
public class MarathonServiceImpl implements MarathonService {


    private DataServiceImpl dataService;

    @Autowired
    public MarathonServiceImpl(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

    public List<String> getStudents() {
        return entityToString(dataService.getStudents());
    }

    public List<String> getMentors() {
        return entityToString(dataService.getMentors());
    }

    public StudentScore studentResult(String studentName) {
        Entity student = getStudentByName(studentName);
        List<SprintScore> sprintScores = dataService.getSolution().stream()
                .filter(o -> o.getIdStudent() == student.getId())
                .map(t -> new SprintScore(sprintById(t.getIdSprint()).getName(), t.getScore()))
                .collect(Collectors.toList());
        return new StudentScore(studentName, sprintScores);
    }

    public List<StudentScore> allStudentsResult() {
        return getStudents().stream().map(this::studentResult).collect(Collectors.toList());
    }

    public AverageScore studentAverage(String studentName) {
        Entity student = getStudentByName(studentName);
        List<Solution> studentSolutions = dataService.getSolution()
                .stream()
                .filter(o -> o.getIdStudent() == student.getId()).collect(Collectors.toList());
        double averageScore = studentSolutions.stream()
                .map(Solution::getScore)
                .reduce(Integer::sum).orElse(0).doubleValue() / studentSolutions.size();
        return new AverageScore(studentName, averageScore);
    }

    public List<AverageScore> allStudentsAverage() {
        return getStudents().stream().map(this::studentAverage).collect(Collectors.toList());
    }

    public MentorStudent mentorStudents(String mentorName) {
        Entity mentor = dataService.getMentors().stream().filter(o -> o.getName().equals(mentorName)).findFirst().orElse(null);
        List<String> students = dataService.getCommunication().stream()
                .filter(o -> o.getIdMentor() == mentor.getId())
                .map(t -> getStudentById(t.getIdStudent()).getName())
                .collect(Collectors.toList());
        return new MentorStudent(mentorName, students);
    }

    public DataServiceImpl getDataService() {
        return dataService;
    }


    // addition methods

    private List<String> entityToString(List<Entity> entities) {
        return entities.stream().map(Entity::getName).collect(Collectors.toList());
    }

    private Entity sprintById(int id) {
        return dataService.getSprints().stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }

    private Entity getStudentByName(String name) {
        return dataService.getStudents().stream().filter(o -> o.getName().equals(name)).findFirst().orElse(null);
    }

    private Entity getStudentById(int id) {
        return dataService.getStudents().stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }

}

package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.impl.DataServiceImpl;

public interface MarathonService {
    public DataServiceImpl getDataService();

    public List<String> getStudents();

    public List<String> getMentors();

    public StudentScore studentResult(String studentName);

    public List<StudentScore> allStudentsResult();

    public AverageScore studentAverage(String studentName);

    public List<AverageScore> allStudentsAverage();

    public MentorStudent mentorStudents(String mentorName);


}

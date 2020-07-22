package com.softserve.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTest {

    private MarathonService marathonService;

    private DataService dataService;

    @Autowired
    public ApplicationTest(MarathonService marathonService, DataService dataService) {
        this.marathonService = marathonService;
        this.dataService = dataService;
        if (marathonService.getStudents().isEmpty() && marathonService.getMentors().isEmpty())
            fillDataService();
    }

    private void fillDataService() {
        dataService.addStudent("Denys");
        dataService.addStudent("Elya");
        dataService.addMentor("Mentor1");
        dataService.addMentor("Mentor2");
        dataService.addCommunication("Denys", "Mentor1");
        dataService.addCommunication("Elya", "Mentor1");
        dataService.addSprint("Sprint01");
        dataService.addSprint("Sprint02");
        dataService.addSolution("Denys", "Sprint01", 99);
        dataService.addSolution("Elya", "Sprint01", 100);
        dataService.addSolution("Denys", "Sprint02", 95);
        dataService.addSolution("Elya", "Sprint02", 94);
    }

    @Test
    public void checkGetStudentsNotNull() {
        List<String> expected = Arrays.asList("Denys", "Elya");
        List<String> actual = marathonService.getStudents();
        Assertions.assertEquals(expected, actual, "checkGetStudentsNotNull()");
    }

    @Test
    public void checkGetMentors() {
        List<String> expected = Arrays.asList("Mentor1", "Mentor2");
        List<String> actual = marathonService.getMentors();
        Assertions.assertEquals(expected, actual, "checkGetMentors()");
    }

    @Test
    public void checkStudentResult() {
        List<SprintScore> sprintScores = Arrays.asList(new SprintScore("Sprint01", 99),
                        new SprintScore("Sprint02", 95));
        StudentScore expected = new StudentScore("Denys", sprintScores);
        StudentScore actual = marathonService.studentResult("Denys");
        Assertions.assertEquals(expected, actual, "checkStudentResult()");
    }

    @Test
    public void checkAllStudentsResult() {
        List<SprintScore> sprintScoresDenys = Arrays.asList(new SprintScore("Sprint01", 99),
                        new SprintScore("Sprint02", 95));
        List<SprintScore> sprintScoresElya = Arrays.asList(new SprintScore("Sprint01", 100),
                        new SprintScore("Sprint02", 94));
        StudentScore expectedElya = new StudentScore("Elya", sprintScoresElya);
        StudentScore expectedDenys = new StudentScore("Denys", sprintScoresDenys);
        List<StudentScore> expected = Arrays.asList(expectedDenys, expectedElya);
        List<StudentScore> actual = marathonService.allStudentsResult();
        Assertions.assertEquals(expected, actual, "checkAllStudentsResult()");
    }

    @Test
    public void checkStudentAverage() {
        AverageScore expected = new AverageScore("Denys", 97);
        AverageScore actual = marathonService.studentAverage("Denys");
        Assertions.assertEquals(expected, actual, "checkStudentAverage()");
    }
    @Test
    public void checkStudentAverage2() {
        AverageScore expected = new AverageScore("Elya", 97);
        AverageScore actual = marathonService.studentAverage("Elya");
        Assertions.assertEquals(expected, actual, "checkStudentAverage2()");
    }
    @Test
    public void checkAllStudentAverage() {
        AverageScore expectedDenys = new AverageScore("Denys", 97);
        AverageScore expectedElya = new AverageScore("Elya", 97);
        List<AverageScore> expected = Arrays.asList(expectedDenys, expectedElya);
        List<AverageScore> actual = marathonService.allStudentsAverage();
        Assertions.assertEquals(expected, actual, "checkAllStudentAverage()");
    }

    @Test
    public void checkMentorStudents1() {
        MentorStudent expected = new MentorStudent("Mentor1", Arrays.asList("Denys","Elya"));
        MentorStudent actual = marathonService.mentorStudents("Mentor1");
        Assertions.assertEquals(expected, actual, "checkMentorStudents1()");
    }

    @Test
    public void checkMentorStudents2() {
        MentorStudent expected = new MentorStudent("Mentor2", Arrays.asList());
        MentorStudent actual = marathonService.mentorStudents("Mentor2");
        Assertions.assertEquals(expected, actual, "checkMentorStudents2()");
    }


}

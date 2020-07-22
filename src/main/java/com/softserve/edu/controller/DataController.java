package com.softserve.edu.controller;

import com.softserve.edu.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DataController {
    private DataServiceImpl dataService;

    @Value("${welcome.message}")
    private String message;

    @Autowired
    public DataController(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

//    @PostMapping("registration/{studentName}")
//    public String addStudent(@PathVariable String studentName, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("error", true);
//            return "registration";
//        }
//        if(dataService.addStudent(studentName))
//            return "sprints";
//        model.addAttribute("message", "User already exists!");
//        return "registration";
//    }
//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }
}

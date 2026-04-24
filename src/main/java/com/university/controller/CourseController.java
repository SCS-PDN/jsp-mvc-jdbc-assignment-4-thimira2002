package com.university.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.university.dao.CourseDAO;
import com.university.model.Course;

@Controller
public class CourseController {

    @GetMapping("/courses")
    public String showCourses(HttpSession session, Model model) {

        if (session.getAttribute("email") == null) {
            return "redirect:/login";
        }

        CourseDAO dao = new CourseDAO();
        List<Course> courses = dao.getAllCourses();

        model.addAttribute("courses", courses);

        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable int courseId,
                                 Model model) {

        model.addAttribute("message", "Course registered successfully!");

        return "success";
    }
}
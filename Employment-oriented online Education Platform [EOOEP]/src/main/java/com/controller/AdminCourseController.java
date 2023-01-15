package com.controller;
import com.domain.Course;
import com.exception.BadRequestAlertException;
import com.service.CourseService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/*@Controller*/
@RestController
@RequestMapping("/admin/course/api")
public class AdminCourseController {

    private CourseService courseService;

    public AdminCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) throws Exception {
        if (course.getCourse_id() != null) {
            throw new BadRequestAlertException("A new leave application cannot have an id value");
        }
        System.out.println(course);
        courseService.insert(course);
        return ResponseEntity.created(new URI("/tax_result"))
                .body(course);
    }

    @CrossOrigin
    @GetMapping("/allUser")
    public ResponseEntity<List<Course>> getAllTaxHistory() {
        List<Course> courses = courseService.getAll();
        return ResponseEntity.ok().body(courses);
    }

    @CrossOrigin
    @PutMapping("/user/{user_name}")
    public ResponseEntity<Course> updateUser(@Valid @RequestBody Course course,@PathVariable String user_name) throws Exception {
        Course t = courseService.getByUserName(user_name);
        course.setCourse_id(t.getCourse_id());
        System.out.println(course.getCourse_id());
        if (course.getCourse_id() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        courseService.update(course);
        return ResponseEntity.created(new URI("/leaveApplications/"))
                .body(course);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{user_name}")
    public ResponseEntity<Course> deleteUser(@PathVariable String user_name) {
        Course t = courseService.getByUserName(user_name);
        System.out.println(t);
        courseService.delete(t.getCourse_id());
        return ResponseEntity.noContent().build();
    }

}

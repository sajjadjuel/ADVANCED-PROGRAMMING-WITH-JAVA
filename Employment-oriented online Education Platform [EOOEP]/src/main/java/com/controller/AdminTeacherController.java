package com.controller;
import com.domain.Teacher;
import com.exception.BadRequestAlertException;
import com.service.TeacherService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/*@Controller*/
@RestController
@RequestMapping("/admin/teacher/api")
public class AdminTeacherController {

    private TeacherService teacherService;

    public AdminTeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Teacher> createTax(@Valid @RequestBody Teacher teacher) throws Exception {
        if (teacher.getUser_id() != null) {
            throw new BadRequestAlertException("A new leave application cannot have an id value");
        }
        System.out.println(teacher);
        teacherService.insert(teacher);
        return ResponseEntity.created(new URI("/tax_result"))
                .body(teacher);
    }

    @CrossOrigin
    @GetMapping("/allUser")
    public ResponseEntity<List<Teacher>> getAllTaxHistory() {
        List<Teacher> taxUsers = teacherService.getAll();
        return ResponseEntity.ok().body(taxUsers);
    }

    @CrossOrigin
    @PutMapping("/user/{user_name}")
    public ResponseEntity<Teacher> updateUser(@Valid @RequestBody Teacher teacher,@PathVariable String user_name) throws Exception {
        Teacher t = teacherService.getByUserName(user_name);
        teacher.setUser_id(t.getUser_id());
        System.out.println(teacher.getUser_id());
        if (teacher.getUser_id() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        teacherService.update(teacher);
        return ResponseEntity.created(new URI("/leaveApplications/"))
                .body(teacher);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{user_name}")
    public ResponseEntity<Teacher> deleteUser(@PathVariable String user_name) {
        Teacher t = teacherService.getByUserName(user_name);
        System.out.println(t);
        teacherService.delete(t.getUser_id());
        return ResponseEntity.noContent().build();
    }

}

package com.controller;

import com.domain.StudentEooep;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.StudentEooepService;
import com.service.StudentEooepService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/studentEooep")
public class StudentEooepController {

    private StudentEooepService studentEooepService;

    public StudentEooepController(StudentEooepService studentEooepService) {
        this.studentEooepService = studentEooepService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @CrossOrigin
    @PostMapping("/usr")
    public ResponseEntity<StudentEooep> createStudentEooep(@Valid @RequestBody StudentEooep studentEooep) throws Exception {
        if (studentEooep.getId() != null) {
            throw new BadRequestAlertException("A new leave application cannot have an id value");
        }
        System.out.println(studentEooep);
        studentEooepService.insert(studentEooep);
        return ResponseEntity.created(new URI("/usr/"))
                .body(studentEooep);
    }
    @CrossOrigin
    @PutMapping("/usr")
    public ResponseEntity<StudentEooep> updateStudentEooep(@Valid @RequestBody StudentEooep studentEooep) throws Exception {
        if (studentEooep.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        studentEooepService.update(studentEooep);
        return ResponseEntity.created(new URI("/usr/"))
                .body(studentEooep);
    }

    @CrossOrigin
    @PutMapping("/usr/{studentEooep_name}")
    public ResponseEntity<StudentEooep> updateStudentEooep(@Valid @RequestBody StudentEooep studentEooep,@PathVariable String studentEooep_name) throws Exception {
        StudentEooep t = studentEooepService.getByStudentEooepName(studentEooep_name);
        // taxStudentEooep.setStudentEooep_id(t.getStudentEooep_id());
        studentEooep.setId(t.getId());
        System.out.println(studentEooep.getId());
        if (studentEooep.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        studentEooepService.update(studentEooep);
        return ResponseEntity.created(new URI("/usr/"))
                .body(studentEooep);
    }

    @CrossOrigin
    @GetMapping("/usr")
    public ResponseEntity<List<StudentEooep>> getAllStudentEooep() {
        List<StudentEooep> studentEooep = studentEooepService.getAll();
        //System.out.println(studentEooep.);
        return ResponseEntity.ok().body(studentEooep);
    }
    @CrossOrigin
    @GetMapping("/usr/{id}")
    public ResponseEntity<StudentEooep> getStudentEooep(@PathVariable Long id) {
        Optional<StudentEooep> studentEooep = Optional.ofNullable(studentEooepService.get(id));
        if (studentEooep.isPresent()) {
            return ResponseEntity.ok().body(studentEooep.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }
    @CrossOrigin
    @DeleteMapping("/usr/{id}")
    public ResponseEntity<StudentEooep> deleteStudentEooep(@PathVariable Long id) {
        studentEooepService.delete(id);
        return ResponseEntity.noContent().build();
    }




}

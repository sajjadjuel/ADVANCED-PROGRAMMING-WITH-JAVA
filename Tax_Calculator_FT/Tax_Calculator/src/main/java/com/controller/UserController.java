package com.controller;

import com.domain.User;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.UserService;
import com.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @CrossOrigin
    @PostMapping("/usr")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws Exception {
        if (user.getId() != null) {
            throw new BadRequestAlertException("A new leave application cannot have an id value");
        }
        System.out.println(user);
        userService.insert(user);
        return ResponseEntity.created(new URI("/usr/"))
                .body(user);
    }
    @CrossOrigin
    @PutMapping("/usr")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws Exception {
        if (user.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        userService.update(user);
        return ResponseEntity.created(new URI("/usr/"))
                .body(user);
    }

    @CrossOrigin
    @PutMapping("/usr/{user_name}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user,@PathVariable String user_name) throws Exception {
        User t = userService.getByUserName(user_name);
       // taxUser.setUser_id(t.getUser_id());
        user.setId(t.getId());
        System.out.println(user.getId());
        if (user.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        userService.update(user);
        return ResponseEntity.created(new URI("/usr/"))
                .body(user);
    }

    @CrossOrigin
    @GetMapping("/usr")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> user = userService.getAll();
        //System.out.println(user.);
        return ResponseEntity.ok().body(user);
    }
    @CrossOrigin
    @GetMapping("/usr/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> user = Optional.ofNullable(userService.get(id));
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }
    @CrossOrigin
    @DeleteMapping("/usr/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }




}

package com.service;

import com.domain.Teacher;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface TeacherService {

    public Teacher insert(Teacher teacher);

    public Teacher get(Long id);

    public List<Teacher> getAll();

    public Teacher getByUserName(String username);

    public Teacher update(Teacher teacher);

    public void delete(Long id);
}

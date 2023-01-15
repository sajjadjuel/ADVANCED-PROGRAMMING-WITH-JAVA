package com.repository;

import com.domain.Teacher;

import java.util.List;

public interface TeacherRepository {

    public List<Teacher> getAll();
    public Teacher getByUserName(String username);

    public Teacher create(Teacher teacher);

    public Teacher get(Long id);

    public Teacher update(Teacher teacher);

    public void delete(Long id);
}

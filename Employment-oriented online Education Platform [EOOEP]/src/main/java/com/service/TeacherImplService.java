package com.service;

import com.domain.Teacher;
import com.repository.TeacherImplRepository;
import com.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherImplService implements TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherImplService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Transactional
    public Teacher insert(Teacher teacher) {
        return teacherRepository.create(teacher);
    }

    @Transactional(readOnly = true)
    public Teacher get(Long id) {
        return teacherRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Teacher> getAll() {
        return teacherRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Teacher getByUserName(String username) {
        return teacherRepository.getByUserName(username);
    }

    @Transactional
    public Teacher update(Teacher teacher) {
        return teacherRepository.update(teacher);
    }

    @Transactional
    public void delete(Long id) {
        teacherRepository.delete(id);
    }
}

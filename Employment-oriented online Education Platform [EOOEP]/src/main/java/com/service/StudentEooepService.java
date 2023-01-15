package com.service;

import com.domain.StudentEooep;
//import com.repository.LeaveApplicationImplRepository;
import com.repository.StudentEooepRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentEooepService  {

    private StudentEooepRepository studentEooepRepository;

    public StudentEooepService(StudentEooepRepository studentEooepRepository) {
        this.studentEooepRepository = studentEooepRepository;
    }

    @Transactional
    public StudentEooep insert(StudentEooep studentEooep) {
        return studentEooepRepository.create(studentEooep);
    }

    @Transactional(readOnly = true)
    public StudentEooep get(Long id) {
        return studentEooepRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<StudentEooep> getAll() {
        return studentEooepRepository.getAll();
    }

    @Transactional
    public StudentEooep update(StudentEooep studentEooep) {
        return studentEooepRepository.update(studentEooep);
    }

    @Transactional
    public void delete(Long id) {
        studentEooepRepository.delete(id);
    }
    @Transactional(readOnly = true)
    public StudentEooep getByStudentEooepName(String studentEooepname) {
        return studentEooepRepository.getByStudentEooepname(studentEooepname);
    }
}

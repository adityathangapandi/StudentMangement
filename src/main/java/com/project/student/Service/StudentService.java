package com.project.student.Service;

import com.project.student.Entity.Student;
import com.project.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public Student addStudentDetails(Student s) {
        return repo.save(s);
    }

    public List<Student> getStudentAllDetails() {
        return repo.findAll();
    }

    public Boolean  deleteStudentDetails(Long id) {
        Optional<Student> deleteStudent=repo.findById(id);
        if(deleteStudent.isEmpty()){
            throw new RuntimeException("Student details are not available");
        }
        else{
             repo.deleteById(id);
             return true;
        }
    }
    public Student updateStudentDetails(Long id, Student s) {
        Optional<Student> presentStudent=repo.findById(id);
        if(presentStudent.isEmpty()){
            throw new RuntimeException("No Student present with the Id to update");
        }
        else{
            Student needToUpdate=presentStudent.get();
            needToUpdate.setName(s.getName());
            needToUpdate.setEmail(s.getEmail());
            needToUpdate.setRollno(s.getRollno());
            return repo.save(needToUpdate);
        }
    }
}

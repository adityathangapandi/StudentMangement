package com.project.student.Controller;

import com.project.student.Entity.Student;
import com.project.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;


@RequestMapping("/api/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/add-student")
    public HashMap<String, String> addStudent(@RequestBody Student s){
        HashMap<String,String> response=new HashMap<String,String>();
        try{
            Student addStudent=service.addStudentDetails(s);
            response.put("Message","Student details created");
            response.put("Student",addStudent.getName());
            return response;
        }
        catch(Exception e){
            response.put("Message","Something is fishy");
            return response;
        }

    }

}

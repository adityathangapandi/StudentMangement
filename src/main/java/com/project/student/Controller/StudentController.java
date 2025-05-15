package com.project.student.Controller;

import com.project.student.Entity.Student;
import com.project.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RequestMapping("/api/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/add-student")
    public HashMap<String, Object> addStudent(@RequestBody Student s){
        HashMap<String,Object> response=new HashMap<String,Object>();
        try{
            Student addStudent=service.addStudentDetails(s);
            response.put("Message","Student details created");
            response.put("Student",addStudent);
            return response;
        }
        catch(Exception e){
            response.put("Message","Something is fishy");
            return response;
        }

    }
     @GetMapping("/get-student")
    public HashMap<String,Object> getStudentData(){
        HashMap<String,Object> response=new HashMap<String,Object >();
        try {
            List<Student> presentStudent = service.getStudentAllDetails();
            response.put("message", "Successfully fetched");
            response.put("stundent", presentStudent);
            return response;
        }
        catch(Exception e){
            response.put("message","error occured");
            return  response;
        }
     }


}

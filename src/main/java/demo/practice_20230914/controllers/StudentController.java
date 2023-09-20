package demo.practice_20230914.controllers;

import demo.practice_20230914.models.GetStudentsBySubject;
import demo.practice_20230914.models.Student;
import demo.practice_20230914.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/excludeB2")
    public List<Student> getStudentsExcludeB2(){
        return studentService.getStudentsExcludeB2();
    };

    @GetMapping("/sortedByScoreAsc")
    public List<Student> getStudentsSortedByGradeAsc(){
        return studentService.getStudentsSortedByScoreAsc();
    }
    @GetMapping("/groupedBySubject")
    public Map<String, Integer> getStudentsGroupedBySubject(){
        return studentService.getStudentsGroupedBySubject();
    }

}

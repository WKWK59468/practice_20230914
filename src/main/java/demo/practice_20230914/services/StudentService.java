package demo.practice_20230914.services;

import demo.practice_20230914.dao.IStudentDao;
import demo.practice_20230914.models.GetStudentsBySubject;
import demo.practice_20230914.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final IStudentDao studentDao;
    @Autowired
    public StudentService(IStudentDao studentDao){
        this.studentDao = studentDao;
    }

    public List<Student> getStudentsExcludeB2(){
        List<Student> students = studentDao.getStudents();
        students.removeIf(student -> student.getName().equals("B2"));
        return students;
    }

    public List<Student> getStudentsSortedByScoreAsc(){
        List<Student> students = studentDao.getStudents();
        students.sort(Comparator.comparing(Student::getScore));
        return students;
    }

    public Map<String, Integer> getStudentsGroupedBySubject(){
        List<Student> students = studentDao.getStudents();
        Map<String, Integer> subjectScoreSumMap = students.stream().collect(Collectors.groupingBy(Student::getSubject, Collectors.summingInt(Student::getScore)));

        return subjectScoreSumMap;
    }
}

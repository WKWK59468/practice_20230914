package demo.practice_20230914.mapper;

import demo.practice_20230914.models.GetStudentsBySubject;
import demo.practice_20230914.models.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IStudentDao {
    @Select("SELECT * FROM students")
    List<Student> getStudents();
}

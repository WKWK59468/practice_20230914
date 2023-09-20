package demo.practice_20230914.dao;

import demo.practice_20230914.models.GetStudentsBySubject;
import demo.practice_20230914.models.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IStudentDao {
    //過濾學生=B2 的資料
    @Select("SELECT * FROM students")
    List<Student> getStudents();
}

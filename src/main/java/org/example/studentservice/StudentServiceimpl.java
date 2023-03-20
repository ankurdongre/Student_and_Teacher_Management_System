package org.example.studentservice;
import org.example.model.Student;

import java.util.List;

public interface StudentServiceimpl {
    void insertstudentteacher(Student student);
    void insertmulstudentteacher(List<Student> student);
    Student selectstudentteacher(int sid, int tid);
    List<Student> selectmulstudentteacher(List<Integer> sid, List<Integer> tid);
    List<Student> selectallstudentteacher();
    Student updatestudentteacher(Student student);
    List<Student> updatemulstudentteacher(List<Student> student);
    Boolean deletestudentteacher(int sid,int tid);
    List<Boolean> deletemulstudentteacher(List<Integer> sid,List<Integer> tid);
    Boolean deleteallstudentteacher();
}

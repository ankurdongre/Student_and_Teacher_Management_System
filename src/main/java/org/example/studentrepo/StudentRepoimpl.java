package org.example.studentrepo;
import org.example.model.Student;

import java.util.List;

public interface StudentRepoimpl {
    void insertstudentteacher(Student student);
    Student selectstudentteacher( int sid, int tid);
    List<Student> selectallstudentteacher();
    Student updatestudentteacher(Student student);
    Boolean deletestudentteacher(int sid,int tid);
    Boolean deleteallstudentteacher();
}

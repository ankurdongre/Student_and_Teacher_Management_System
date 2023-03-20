package org.example.studentservice;
import org.example.model.Student;
import org.example.studentrepo.StudentRepoimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceimpl{
    @Autowired
    private StudentRepoimpl repo;
    @Override
    public void insertstudentteacher(Student student){
        repo.insertstudentteacher(student);
    }
    @Override
    public void insertmulstudentteacher(List<Student> student){
        for(int i = 0 ; i < student.size();i++){
            repo.insertstudentteacher(student.get(i));
        }
    }
    @Override
    public Student selectstudentteacher(int sid, int tid){
        return repo.selectstudentteacher(sid,tid);
    }
    @Override
    public List<Student> selectmulstudentteacher(List<Integer> sid, List<Integer> tid){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0;i<sid.size();i++){
            Student s1 =  repo.selectstudentteacher(sid.get(i),tid.get(i));
            studentList.add(s1);
        }
        return studentList;
    }
    @Override
    public List<Student> selectallstudentteacher(){
      return repo.selectallstudentteacher();
    }
    @Override
    public Student updatestudentteacher(Student student){
        return repo.updatestudentteacher(student);
    }
    @Override
    public List<Student> updatemulstudentteacher(List<Student> student){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i<student.size();i++){
            Student s1 = updatestudentteacher(student.get(i));
            studentList.add(s1);
        }
     return studentList;
    }
    @Override
    public Boolean deletestudentteacher(int sid, int tid){
        return repo.deletestudentteacher(sid,tid);
    }
    @Override
    public List<Boolean> deletemulstudentteacher(List<Integer> sid, List<Integer> tid){
        List<Boolean> b2 = new ArrayList<>();
        for (int i= 0;i<sid.size();i++){
            Boolean b1 = deletestudentteacher(sid.get(i),tid.get(i));
            b2.add(b1);
        }
        return b2;
    }
    @Override
    public Boolean deleteallstudentteacher(){
        return repo.deleteallstudentteacher();
    }
}

package org.example.studentrepo;
import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo implements StudentRepoimpl {
    String url = "jdbc:mysql://localhost:3306/teststudent";
    String user = "root";
    String pass = "";

    @Override
    public void insertstudentteacher(Student student) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("insert into student values( '" +
                    student.getId() + "', '" +
                    student.getName() + "' ,'" +
                    student.getEmail() + "' )");
            st.executeUpdate("insert into teacher values( '" +
                    student.getTeacher().getId() + "', '" +
                    student.getTeacher().getName() + "' ,'" +
                    student.getTeacher().getEmail() + "' )");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public Student selectstudentteacher( int sid,  int tid){
        Student student = new Student();
        Teacher teacher = new Teacher();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where id = '"+sid+"'");
            while (rs.next()){
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            ResultSet rs1 = st.executeQuery("select * from teacher where id = '"+tid+"'");
            while (rs1.next()){
                teacher.setId(rs1.getInt(1));
                teacher.setName(rs1.getString(2));
                teacher.setEmail(rs1.getString(3));
                student.setTeacher(teacher);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return student;
    }
    public List<Student> selectallstudentteacher(){
       List<Student> studentList = new ArrayList<>();
       List<Teacher> teacherList = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                studentList.add(student);

            }
            ResultSet rs1 = st.executeQuery("select * from teacher");
            while (rs1.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs1.getInt(1));
                teacher.setName(rs1.getString(2));
                teacher.setEmail(rs1.getString(3));
                teacherList.add(teacher);
            }
            for (int i = 0 ; i<studentList.size();i++){
                Student s1 = studentList.get(i);
                s1.setTeacher(teacherList.get(i));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return studentList;
    }
    @Override
    public Student updatestudentteacher(Student student){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("update  student set name='"+
                    student.getName()+"',email='"+
                    student.getEmail()+"' where id = '"+student.getId()+"'");
            st.executeUpdate("update teacher set name = '"+student.getTeacher().getName()+"',email = '"+
                    student.getTeacher().getEmail()+"' where id = '"+student.getTeacher().getId()+"' ");
        }catch (Exception e){
            System.out.println(e);
        }
        selectstudentteacher(student.getId(),student.getTeacher().getId());
        return student;
    }
    @Override
    public Boolean deletestudentteacher(int sid,int tid){
        Boolean result = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete  from student where id = '"+sid+"' ");
            int count2 = st.executeUpdate("delete  from teacher where id = '"+tid+"' ");
            if(count != 0 && count2 != 0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public Boolean deleteallstudentteacher(){
        Boolean result = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete  from student");
            int count2 = st.executeUpdate("delete  from teacher");
            if(count != 0 && count2 != 0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}

package org.example.studentcontoller;
import org.example.model.Student;
import org.example.studentservice.StudentServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
public class StudentController {
    @Autowired
    private StudentServiceimpl service;

    @RequestMapping("/insertStudentTeacher")
    @ResponseBody
    public void insertstudentteacher(@RequestBody Student student){
        service.insertstudentteacher(student);
    }
    @RequestMapping("/insertMulStudentTeacher")
    @ResponseBody
    public void insertmulstudentteacher(@RequestBody List<Student> student){
        service.insertmulstudentteacher(student);
    }
    @RequestMapping("/selectStudentTeacher")
    @ResponseBody
    public Student selectstudentteacher(@RequestParam int sid,@RequestParam int tid){
        return service.selectstudentteacher(sid,tid);
    }
    @RequestMapping("/selectMulStudentTeacher")
    @ResponseBody
    public List<Student> selectmulstudentteacher(@RequestParam List<Integer> sid,@RequestParam List<Integer> tid){
        return service.selectmulstudentteacher(sid,tid);
    }
    @RequestMapping("/selectAllStudentTeacher")
    @ResponseBody
    public List<Student> selectallstudentteacher(){
        return service.selectallstudentteacher();
    }

    @RequestMapping("/updateStudentTeacher")
    @ResponseBody
    public Student updatestudentteacher(@RequestBody Student student){
        return service.updatestudentteacher(student);
    }

    @RequestMapping("/updateMulStudentTeacher")
    @ResponseBody
    public List<Student> updatemulstudentteacher(@RequestBody List<Student> student){
        return service.updatemulstudentteacher(student);
    }
    @RequestMapping("/deleteStudentTeacher")
    @ResponseBody
    public Boolean deletestudentteacher(@RequestParam int sid,@RequestParam int tid){
        return service.deletestudentteacher(sid,tid);
    }
    @RequestMapping("/deleteMulStudentTeacher")
    @ResponseBody
    public List<Boolean> deletemulstudentteacher(@RequestParam List<Integer> sid,@RequestParam List<Integer> tid){
        return service.deletemulstudentteacher(sid,tid);
    }
    @RequestMapping("/deleteAllStudentTeacher")
    @ResponseBody
    public Boolean deleteallstudentteacher(){
        return service.deleteallstudentteacher();
    }
}

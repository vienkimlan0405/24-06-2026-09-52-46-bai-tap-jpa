package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // 1. Lấy danh sách sinh viên
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 2. Tìm sinh viên theo ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên có ID: " + id));
    }

    // 3. Thêm sinh viên mới
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // 4. Cập nhật sinh viên
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setMajor(studentDetails.getMajor());
        return studentRepository.save(student);
    }

    // 5. Xoá sinh viên
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}

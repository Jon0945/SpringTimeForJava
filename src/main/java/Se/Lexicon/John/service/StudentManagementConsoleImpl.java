package Se.Lexicon.John.service;

import Se.Lexicon.John.data_access.StudentDao;
import Se.Lexicon.John.models.Student;
import Se.Lexicon.John.util.UserInputService;

import java.util.List;

public class StudentManagementConsoleImpl implements StudentManagement {
    private UserInputService scannerService;
    private StudentDao studentDao;

    @Override
    public Student create() {
        System.out.println("Please enter Student name: ");
        Student student = new Student(scannerService.getString());
        save(student);
        return student;
    }

    @Override
    public Student save(Student student) {
        studentDao.save(student);
        return student;
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student found = studentDao.find(id);
        studentDao.delete(id);
        return found;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        Student found = studentDao.find(student.getId());
        System.out.println("Please enter new ID: ");
        found.setId(scannerService.getInt());
        System.out.println("Please enter new name: ");
        found.setName(scannerService.getString());
        return found;
    }
}

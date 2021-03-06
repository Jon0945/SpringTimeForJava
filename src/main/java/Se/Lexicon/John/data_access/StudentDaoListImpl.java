package Se.Lexicon.John.data_access;

import Se.Lexicon.John.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {
    private static int idCounter = 1;
    private List<Student> students = new ArrayList<>(0);

    @Override
    public Student save(Student student) {
        student.setId(idCounter++);
        students.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        for(Student s : students) {
            if(s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        for(Student s : students) {
            if(s.getId() == id) {
                students.remove(s);
                break;
            }
        }
    }
}

package Se.Lexicon.John;

import static org.junit.Assert.*;
import Se.Lexicon.John.data_access.StudentDaoListImpl;
import Se.Lexicon.John.models.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoListImplTest {
    private StudentDaoListImpl testStudentDaoListImpl = new StudentDaoListImpl();
    private List<Student> testStudentList = new ArrayList<>();
    private Student testStudent;
    private final int testID = 0;
    private final String testName = "Ture Test";

    @Before
    public void createStudent() {
        testStudent = new Student(testID,testName);
        testStudentList.add(testStudent);
        testStudentDaoListImpl.save(testStudent);
    }

    @After
    public void killStudent() {
        testStudent = null;
        testStudentList.clear();
    }

    @Test
    public void testSaveStudent() {
        assertEquals(testStudentList,testStudentDaoListImpl.findAll());
    }

    @Test
    public void testFindById_ExcistingId() {
        assertEquals(testStudentDaoListImpl.findAll().get(0),testStudentDaoListImpl.find(testStudent.getId()));
    }

    @Test
    public void testFindById_NonExcistingId() {
        assertNull(testStudentDaoListImpl.find(Integer.MAX_VALUE));
    }

    @Test
    public void testFindAll() {
        assertEquals(testStudentList,testStudentDaoListImpl.findAll());
    }

    @Test
    public void testDeleteStudent_Correct(){
        testStudentDaoListImpl.delete(testStudent.getId());
        assertNotEquals(testStudentList,testStudentDaoListImpl.findAll());
    }

    @Test
    public void testDeleteStudent_Incorrect(){
        Student testStudent2 = new Student("Therese Test");
        testStudentDaoListImpl.delete(testStudent2.getId());
        assertNotNull(testStudentDaoListImpl.findAll());
    }
}

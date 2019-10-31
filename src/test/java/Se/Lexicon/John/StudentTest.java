package Se.Lexicon.John;

import Se.Lexicon.John.models.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    private Student testStudent;
    private final int testID = 1;
    private final String testName = "Ture Test";

    @Before
    public void createStudent()
    {
        testStudent = new Student(testID,testName);
    }

    @After
    public void killStudent() {
        testStudent = null;
    }

    @Test
    public void testBeforeWorks() {
        //Arrange
        String expectedName = testName;

        //Act
        // done by @Before

        //Assert
        assertTrue(testStudent.getId() > 0);
        assertEquals(expectedName, testStudent.getName());
    }

    @Test
    public void testSetName() {
        //Arrange
        String studentname = "Boaty McBoatface";

        //Act
        testStudent.setName(studentname);

        //Assert
        assertEquals(studentname, testStudent.getName());
    }

    @Test
    public void testSetId() {
        //Arrange
        int studenid = 42;

        //Act
        testStudent.setId(studenid);

        //Assert
        assertEquals(studenid, testStudent.getId());
    }

    @Test
    public void testToString() {

        //Act
        String result = testStudent.toString();

        //Assert
        assertTrue(result.contains(testName));
        assertTrue(result.contains(String.valueOf(testID)));

    }
}

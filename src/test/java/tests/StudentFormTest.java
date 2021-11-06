package tests;

import models.Student;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.GregorianCalendar;

public class StudentFormTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.studentHelper().selectItemForms();
        app.studentHelper().selectPracticeForm();
        app.studentHelper().hideFooter();
    }

    @Test
    public void studentFormTest() {

        Student student = Student.builder()
                .firstName("Gleb")
                .lastName("Boyar")
                .email("boyar@gmail.com")
                .gender(Student.Gender.FEMALE)
                .mobile("0598452136")
                .dateOfBirth(new GregorianCalendar(1989, 6, 17).getTime())
                .subjects(new String[]{"Math", "Computer Science", "Physics"})
                .sportsHobie(true)
                .musicHobie(true)
                .picture("E:\\QA30\\Qa30_DemoQa-master\\Student.jpg")
                .currentAddress("Moria ave 5")
                .state("Haruana")
                .city("Karnal")
                .build();

        app.studentHelper().fillStudentForm(student);
    }
}
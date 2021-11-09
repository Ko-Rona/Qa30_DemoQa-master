package tests;

import models.Student;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
                //.dateOfBirth(new GregorianCalendar(1989, 6, 17).getTime())
                .dateOfBDay("7 June 2000")
                .subject("Math, Computer Science, Physics")
                .sportsHobie(true)
                .musicHobie(true)
                .hobie("Sports,Reading")
                .picture("E:\\QA30\\Qa30_DemoQa-master\\Student.jpg")
                .currentAddress("Moria ave 5")
                .state(Student.State.Haryana)
                .city(Student.City.Karnal)
                .build();

        app.studentHelper().fillStudentForm(student);
        app.studentHelper().pause(5000);
        app.studentHelper().submit();
        app.studentHelper().pause(5000);
        app.studentHelper().closeSuccessDialog();

        Assert.assertTrue(app.studentHelper().isSubmittingForm());
    }
}
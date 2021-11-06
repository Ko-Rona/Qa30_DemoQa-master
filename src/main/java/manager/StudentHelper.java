package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class StudentHelper extends HelperBase {
    public StudentHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }

    public void fillStudentForm(Student student) {
        typeFirstName("firstName", student.getFirstName());
        typeLastName("lastName", student.getLastName());
        typeEmail("userEmail", student.getEmail());
        setGender(student.getGender());
        typeNumber("userNumber", student.getMobile());
        //selectDateOfBirth(student.getDateOfBirth());
        selectHobbies(student);
        //addPicture(student.getPicture());
        typeAddress("currentAddress", student.getCurrentAddress());

    }

    private void selectDateOfBirth(Date dateOfBirth) {
    }

    private void typeAddress(String currentAddress, String currentAddress2) {
        type(By.id(currentAddress), currentAddress2);
    }

    private void typeNumber(String userNumber, String mobile) {
        type(By.id(userNumber), mobile);
    }

    private void typeEmail(String userEmail, String email) {
        type(By.id(userEmail), email);
    }

    private void typeLastName(String lastName, String lastName2) {
        type(By.id(lastName), lastName2);
    }

    private void typeFirstName(String firstName, String firstName2) {
        type(By.id(firstName), firstName2);
    }

    private void addPicture(String path) {
        wd.findElement(By.id("uploadPicture"))
                .sendKeys(path);
    }

    private void selectHobbies(Student student) {
        if (student.isSportsHobie()) {
            clickParent(By.id("hobbies-checkbox-1"));
        }
        if (student.isReadingHobie()) {
            clickParent(By.id("hobbies-checkbox-2"));
        }
        if (student.isMusicHobie()) {
            clickParent(By.id("hobbies-checkbox-3"));
        }
    }

    private void setGender(Student.Gender gender) {
        switch (gender) {
            case MALE:
                clickParent(By.xpath("//input[@id='gender-radio-1']"));
                break;
            case FEMALE:
                clickParent(By.xpath("//input[@id='gender-radio-2']"));
                break;
            case OTHER:
                clickParent(By.xpath("//input[@id='gender-radio-3']"));
                break;
        }
    }
}
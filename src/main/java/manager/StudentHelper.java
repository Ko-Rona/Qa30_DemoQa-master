package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void submit() {
        click(By.id("submit"));
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
        //typeDateBDay("dateOfBirthInput", student.getDateOfBDay());
        typeDateBDaySelect("dateOfBirthInput", student.getDateOfBDay());
        addSubject(student.getSubject());
        //selectHobbies(student);
        selectHobie(student.getHobie());
        addPicture(student.getPicture());
        typeAddress("currentAddress", student.getCurrentAddress());
        typeState(student.getState());
        typeCity(student.getCity());
    }

    private void typeCity(Student.City city) {
        WebElement el = wd.findElement(By.id("react-select-4-input"));
        el.sendKeys(city.toString());
        el.sendKeys(Keys.ENTER);
    }

    private void typeState(Student.State state) {
        WebElement el = wd.findElement(By.id("react-select-3-input"));
        el.sendKeys(state.toString());
        el.sendKeys(Keys.ENTER);
    }

    private void selectHobie(String hobie) {
        List<String> list = new ArrayList<>(Arrays.asList(hobie.split(",")));
        if (list.isEmpty()) {
            return;
        }
        for (String s : list) {
            if (s.equals("Sports")) {
                clickParent(By.id("hobbies-checkbox-1"));
            }
            if (s.equals("Reading")) {
                clickParent(By.id("hobbies-checkbox-2"));
            }
            if (s.equals("Music")) {
                clickParent(By.id("hobbies-checkbox-3"));
            }
        }
    }

    private void addSubject(String subject) {
        String[] all = new String[0];
        if (subject != null && !subject.isEmpty()) {
            all = subject.split(",");
        }
        click(By.id("subjectsInput"));
        for (String sub : all) {
            wd.findElement(By.id("subjectsInput")).sendKeys(sub);
            //wd.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            click(By.id("react-select-2-option-0"));
            pause(4000);
        }
    }

    private void typeDateBDaySelect(String dateOfBirthInput, String dateOfBDay) {
        String[] data = dateOfBDay.split(" ");//20 3 1998

        click(By.id("dateOfBirthInput"));

        new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select"))).selectByVisibleText(data[1]);
        new Select(wd.findElement(By.cssSelector(".react-datepicker__year-select"))).selectByValue(data[2]);

        //click(By.xpath("//div[text()='20']"));
        String locator = "//div[text()='" + data[0] + "'";
        String locator2 = String.format("//div[text()='%s']", data[0]);
        List<WebElement> list = wd.findElements(By.xpath(locator2));

        if (list.size() > 1 && Integer.parseInt(data[0]) > 15)
            list.get(1).click();
        else list.get(0).click();

        //click(By.xpath(locator2));

        pause(6000);
    }

    private void typeDateBDay(String dateOfBirthInput, String dateOfBDay) {
        WebElement dBirth = wd.findElement(By.id(dateOfBirthInput));
        dBirth.click();
        String os = System.getProperty("os.name");
        System.out.println(os);

        if (os.startsWith("Mac")) {
            dBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dBirth.sendKeys(dateOfBDay);
        dBirth.sendKeys(Keys.ENTER);
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

    public void closeSuccessDialog() {
        click(By.id("closeLargeModal"));
    }

    public boolean isSubmittingForm() {
        WebElement we = wd.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"));
        String s = we.getText();
        return s.equals("Thanks for submitting the form");
    }
}

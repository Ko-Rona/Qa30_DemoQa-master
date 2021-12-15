package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper extends HelperBase {

    public ActionHelper(WebDriver wd) {
        super(wd);
    }


    public void droppebleTest() {

        WebElement dragMe = wd.findElement(By.id("draggable"));
        WebElement dropHere = wd.findElement(By.id("droppable"));
        pause(2000);
        dragMe.click();

        Actions actions = new Actions(wd);
        actions.dragAndDrop(dragMe, dropHere).build().perform();
        pause(3000);

        String text = dropHere.getText();

        if (text.equals("Dropped!")) {
            System.out.println(" Passed : Dropped");
        } else {
            System.out.println("Failed");
        }
    }

    public void selectInteraction() {
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[5]"));
        pause(500);
    }

    public void selectDroppable() {
        hideFooter();
        click(By.xpath("//span[text()='Droppable']"));
    }

    public void droppebleTest2() {

        WebElement dragMe = wd.findElement(By.id("draggable"));
        WebElement dropHere = wd.findElement(By.id("droppable"));
        pause(2000);
        dragMe.click();

        Dimension dimension = wd.manage().window().getSize();
        int x = (dimension.getHeight() / 10) * 6;
        int y = (dimension.getWidth() / 10) * 6;

        Actions actions = new Actions(wd);
        actions.dragAndDropBy(dragMe, x, y);

        String text = dropHere.getText();

        if (text.equals("Dropped!")) {
            System.out.println(" Passed : Dropped");
        } else {
            System.out.println("Failed");
        }
    }

}

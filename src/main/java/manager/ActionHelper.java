package manager;

import org.openqa.selenium.*;
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
        WebElement rectangle = wd.findElement(By.id("simpleDropContainer"));

        Rectangle rect = rectangle.getRect();
        int x = (rect.getWidth() / 2) - 40;
        int y = (rect.getHeight() / 2) - 35;

        pause(3000);
        dragMe.click();
        Actions actions = new Actions(wd);
        actions.dragAndDropBy(dragMe, x, y)
                .build().perform();

        String text = dropHere.getText();

        if (text.equals("Dropped!")) {
            System.out.println(" Passed : Dropped");
        } else {
            System.out.println("Failed");
        }
    }
}

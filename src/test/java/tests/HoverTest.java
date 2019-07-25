package tests;

import help.BaseTest;
import help.HelperMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoverTest  extends BaseTest {

    //declaram un obiect de tipul HelperMethods , daca dau ctrl+click pe HelperMethods ma duce la constructor

    public HelperMethods functions=new HelperMethods(driver);

    @Test
    public void test() {


        //hover pe Swich to  menu button

        WebElement switchbutton = driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]"));

        Actions action = new Actions(driver);
        action.moveToElement(switchbutton).build().perform();
        WebElement windowsbutton =driver.findElement(By.xpath("//a[@href='Windows.html']"));

        //wait explicit
        new WebDriverWait(driver,4500).until(ExpectedConditions.visibilityOf(windowsbutton));

        functions.clickmethod(windowsbutton); // in loc de windowsbutton.click();

    }
}

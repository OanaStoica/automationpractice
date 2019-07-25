package help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperMethods {

    WebDriver driver;

    //declaram un constructor

    public HelperMethods(WebDriver driver){

        this.driver=driver;

    }
    //click method

    public void clickmethod (WebElement element){

        element.click();
    }



    //select by value (select dupa valoare) metoda slectbyvaluedropdown cu parametrii Webelement si valorea pe care o dam: Dtrin value

    public void selectbyvauedropdown(WebElement element,String value){
        Select elementselect = new Select(element);
        elementselect.selectByValue(value); // valoarea o primesc din valoarea declarata mai sus in parametrii


    }

    //validam titlul unei pagini

    public void validatepgetitle(String expectedvalue,WebDriver driver){

        if(expectedvalue.length()>0){

            String actualvalue=driver.getTitle();
            Assert.assertEquals(expectedvalue,actualvalue);

        }

    }
}

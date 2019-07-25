package tests;

import help.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;



public class LoginTest extends BaseTest {

    @Test
    public void test1(){

        WebElement homebutton=driver.findElement(By.xpath("//a[@href='Index.html']"));
        homebutton.click();

        WebElement signinbutton=driver.findElement(By.xpath("//button[@id='btn1']"));
        signinbutton.click();

        String expectedloginpagevalue=BaseTest.getvalue("Loginpagetitle"); //keyLginpage luat din Inputdata.properties
        String actualloginpagevalue=driver.getTitle();
        Assert.assertEquals(expectedloginpagevalue,actualloginpagevalue);


//        driver.findElement(By.xpath("//input[@ ng-model='Email']")).sendKeys("oana_maria_stoica@yahoo.com");
//
//        driver.findElement(By.xpath("//input[@ ng-model='Password']")).sendKeys("Parola123");
//
//        WebElement enterbutton = driver.findElement(By.xpath("//img[@ id='enterbtn']"));
//        enterbutton.click();

//        String expectedloginpagevalue1="Web Table"; ????
//        String actualloginpagevalue1=driver.getTitle();
//        Assert.assertEquals(expectedloginpagevalue1,actualloginpagevalue1);

//

            WebElement email = driver.findElement(By.xpath("//input[@ ng-model='Email']"));
            email.sendKeys("incorrect email");
            WebElement password = driver.findElement( By.xpath("//input[@ ng-model='Password']"));
            password.sendKeys("Parola123");
            WebElement enterbutton = driver.findElement(By.xpath("//img[@ id='enterbtn']"));
            enterbutton.click();
            WebElement errormessage=driver.findElement(By.xpath("//label[@id='errormsg']"));
            String actualerrormessage=BaseTest.getvalue("Errormessagefile");


            Assert.assertTrue(actualerrormessage,errormessage.isDisplayed());


            //sa validez mesajul ca mai sus, apoi emailfield.clear()
            //cu refresh la pagina trece la urmatorul test case( poti intr-un for sa declari webelementele)






    }


}

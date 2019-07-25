package tests;

import help.BaseTest;
import help.HelperMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebElementTest extends BaseTest {

 public HelperMethods select = new HelperMethods(driver);

    @Test
    public void start() throws InterruptedException {

        //wait implicit, se aplica la toate liniile daca e nevoie, timpi morti pt a nu cadea testul din cauza netului prost de ex. sau alte motive
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //validam pagina pe care ne aflam, Register Page (din head, title din cod)

        String expectedregister=BaseTest.getvalue("Resgisterpagetitle");
        String actualregister=driver.getTitle();
        Assert.assertEquals(expectedregister,actualregister);

    //completez first name field

        String firstnamevalue= BaseTest.getvalue("Firstnamevalues");
        WebElement firstnameweb=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
                firstnameweb.sendKeys(firstnamevalue);
        String lastnamevalue=BaseTest.getvalue("Lastnamevalues");
        WebElement lastnameweb=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
                lastnameweb.sendKeys(lastnamevalue);

        // dam click
        WebElement maleweb=driver.findElement(By.xpath("//input[@value='Male']"));
        maleweb.click(); //metoda a unui webelement

        //Hobbieslist click

        String currentelement=BaseTest.getvalue("Hobbieslist");
        String[] parseHobbie=currentelement.split(",");


        for (int contor=0;contor<3;contor++) {
            List<WebElement> Hobbiesweblist=driver.findElements(By.xpath("//input[@type='checkbox']"));

            String curentelement = ""+ Hobbiesweblist.get(contor).getText(); //poate fi si .getAttribute(de ex value)

            if (contor==0) {
                curentelement=parseHobbie[0];
                Hobbiesweblist.get(contor).click();
                WebElement criketweb=driver.findElement(By.xpath("//input[@value='Cricket']"));
                criketweb.click();
                driver.navigate().refresh();
            }
            if (contor==1){
                curentelement=parseHobbie[1];
                Hobbiesweblist.get(contor).click();
                WebElement moviesweb=driver.findElement(By.xpath("//input[@value='Movies']"));
                moviesweb.click();
                driver.navigate().refresh();

            }
            if (contor==2){
                curentelement=parseHobbie[2];
                Hobbiesweblist.get(contor).click();
                WebElement hockeytweb=driver.findElement(By.xpath("//input[@value='Hockey']"));
                hockeytweb.click();
                driver.navigate().refresh();
            }
        }


        //dropdown
        WebElement yeardropdown=driver.findElement(By.xpath("//select[@placeholder='Year']"));
        String yearvalue=BaseTest.getvalue("Year");
        Select yearselect=new Select(yeardropdown);
        yearselect.selectByValue(yearvalue);

        WebElement monthdropdown=driver.findElement(By.xpath("//select[@placeholder='Month']"));
        String monthvalue=BaseTest.getvalue("Month");
        Select monthselect=new Select(monthdropdown);
        monthselect.selectByVisibleText(monthvalue);


        WebElement daydropdown=driver.findElement(By.xpath("//select[@placeholder='Day'] "));
        String dayvalue=BaseTest.getvalue("Day");
        Select dayselect=new Select(daydropdown);
        dayselect.selectByValue(dayvalue);

        //validam un mesaj care exista pe pagina
        String expectedmessage=BaseTest.getvalue("Expectedmessageonregisterpage");
        WebElement message=driver.findElement(By.xpath("//h2"));
        String actualmessage=message.getText();
        Assert.assertTrue(expectedmessage.equals(actualmessage));

        //Address field
        String addressvalue=BaseTest.getvalue("Address");
        WebElement addresssweb=driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
                addresssweb.sendKeys(addressvalue);

        //Email address field
        String emailaddressvalue=System.currentTimeMillis()+"@proba.com";
        WebElement emailaddressweb=driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
                emailaddressweb.sendKeys(emailaddressvalue);

        //Phone field

        String phonevalue=System.currentTimeMillis()+"";
        String newphone=phonevalue.substring(1,11);
        WebElement phoneweb=driver.findElement(By.xpath("//input[@ng-model='Phone']"));
                phoneweb.sendKeys(newphone);

        //click female gender
        WebElement femaleweb=driver.findElement(By.xpath("//input[@value='FeMale']"));
        femaleweb.click();

        // hobbies list -mai sus


        // language dropdown
//            WebElement languagedropdown=driver.findElement(By.xpath("//select[@id='countries']"));
//            String languagevalue="Romania";
//            Select languageselect=new Select(languagedropdown);
//            languageselect.selectByValue(languagevalue);

        //Languages dropdown list
        driver.findElement(By.id("msdd")).click();
        List<WebElement> languages=driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
        for(int i=0;i<languages.size();i++)
        {
            System.out.println(languages.get(i).getText());
            if(languages.get(i).getText().equalsIgnoreCase("Languagevalues"))
            {
                languages.get(i).click();
                break;
            }
        }
        //Skills dropdown
        WebElement skillsdropdown=driver.findElement(By.xpath("//select[@ng-model='Skill']"));
        String skillsvalue=BaseTest.getvalue("Skillsvalues");
        Select skillsselect=new Select(skillsdropdown);
        skillsselect.selectByValue(skillsvalue);

            // select country field dropdown
        WebElement selectcountrydropdown=driver.findElement(By.xpath("//select[@ng-init=\"country=''\"]  "));
        String selectcountryvalue=BaseTest.getvalue("Countryvalues");
        Select selectcountryselect=new Select(selectcountrydropdown);
        selectcountryselect.selectByValue(selectcountryvalue);

        // password field

        WebElement password=driver.findElement(By.xpath("//input[@id='firstpassword']"));
        String passwordvalue=BaseTest.getvalue("passwordvalues");
        password.sendKeys(passwordvalue);

        //confirm password field
        WebElement confirmpassword=driver.findElement(By.xpath("//input[@id='secondpassword']"));
        String confirmpasswordvalue=""+passwordvalue;
        confirmpassword.sendKeys(confirmpasswordvalue);

        //submit button
        WebElement submitbutton=driver.findElement(By.xpath("//button[@id='submitbtn'] "));
        submitbutton.click();

        //refresh button
//        WebElement refreshbutton=driver.findElement(By.xpath("//button[@id='Button1'] "));
//        refreshbutton.click();

        //photo??
        WebElement photoimage=driver.findElement(By.xpath("//img[@id='imagetrgt'] "));
        if (photoimage.isDisplayed()){

            Assert.assertTrue(photoimage.isDisplayed());
        }


//        //choose file button
//        WebElement choosefilebutton=driver.findElement(By.xpath("//input[@id='imagesrc'] "));
//        choosefilebutton.click();
//        //facebook logo
//        WebElement fblogo=driver.findElement(By.xpath("//a[@class='link facebook'] "));
//        fblogo.click();


            //validare ca suntem pe pagina noua
        //WebElement message1 = driver.findElement(By.xpath("//h4[1]"));

        //wait explicit (intre webelement si assert)

        //new WebDriverWait(driver,7500).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[1]")));

        //Thread.sleep(4500);

        //Assert.assertTrue("The message is displayed",message1.isDisplayed());




}}

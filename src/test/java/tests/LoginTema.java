

package tests;


import help.BaseTest;
import help.HelperMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//mosteneste driverul din BaseTest
    public class LoginTema extends BaseTest {

        public String emailvalue;
        public String passwordvalue;
        public HelperMethods functions=new HelperMethods(driver);

        @Test

        public void test1 (){
// validarea pagina de Register
            String expectedpaginaderesiter =BaseTest.getvalue("Resgisterpagetitle");
            functions.validatepgetitle(expectedpaginaderesiter,driver);

//din registerpage dam click pe home button
            WebElement homebutton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
            homebutton.click();

// validarea Homepage
            String expectedhomepage =BaseTest.getvalue("Homepagetitle");
            String actualhomepage = driver.getTitle();
            Assert.assertEquals(expectedhomepage,actualhomepage);

//dam click pe signin button
            WebElement signinbutton = driver.findElement(By.xpath("//button[@id='btn1']"));
            signinbutton.click();

//validam pagina signin
            String expectedsigninpage = BaseTest.getvalue("Loginpagetitle");
            String actualsigninpage = driver.getTitle();
            Assert.assertEquals(expectedsigninpage,actualsigninpage);

            //parsez valorile pentru email
            emailvalue=""+ BaseTest.getvalue("emailvalues");
            passwordvalue=""+ BaseTest.getvalue("passwordvalues");
            String[] parseEmail=emailvalue.split(",");
            String[] parsePassword=passwordvalue.split(",");

//            for (int index=0; index<3;index++){
//                WebElement emailfield1 = driver.findElement(By.xpath("//input[@placeholder='Email']"));
//                WebElement passwordfield1=driver.findElement(By.xpath("//input[@placeholder='Password']"));
//                WebElement enterbuuton4=driver.findElement(By.xpath("//img[@id='enterbtn']"));
//                String emailinexistentvalue = "xyz@hyg.kih";
//
//                String emaivalue="";
//                String passwordvalue="";

                //1.email si parola invalide

                if (index==0){

                    emailvalue=parseEmail[0];
                    passwordvalue=parsePassword[0];
                    emailfield1.sendKeys(emailvalue);
                    passwordfield1.sendKeys(passwordvalue);
                    enterbuuton4.click();
                    WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
                    String expectederrormessage = BaseTest.getvalue("Errormessagefile");
                    String actualerrormessage = errormessage.getText();
                    Assert.assertEquals(expectederrormessage,actualerrormessage);
                    driver.navigate().refresh();

                }
                    //2.email corect, parola invalida
                if (index==1){
                    emailvalue=parseEmail[1];
                    passwordvalue=parsePassword[1];
                    emailfield1.sendKeys(emailvalue);
                    passwordfield1.sendKeys(passwordvalue);
                    enterbuuton4.click();
                    WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
                    String expectederrormessage = BaseTest.getvalue("Errormessagefile");
                    String actualerrormessage = errormessage.getText();
                    Assert.assertEquals(expectederrormessage,actualerrormessage);
                    driver.navigate().refresh();

                }

                if (index==2){

                    emailvalue=parseEmail[2];
                    passwordvalue=parsePassword[2];
                    emailfield1.sendKeys(emailvalue);
                    passwordfield1.sendKeys(passwordvalue);
                    enterbuuton4.click();
                    WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
                    String expectederrormessage = BaseTest.getvalue("Errormessagefile");
                    String actualerrormessage = errormessage.getText();
                    Assert.assertEquals(expectederrormessage,actualerrormessage);
                    driver.navigate().refresh();

                }
            }

//1. login with inexistent values for all field
            WebElement emailfield1 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
            String emailinexistentvalue = "xyz@hyg.kih";
            emailfield1.sendKeys(emailinexistentvalue);

            WebElement passwordfield1 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            String pswinexistentvalue = "Test123";
            passwordfield1.sendKeys(pswinexistentvalue);

            WebElement enterbutton1 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
            enterbutton1.click();

// validam messajul de eroare si pagina de sign in
            WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
            String expectederrormessage = BaseTest.getvalue("Errormessagefile");
            String actualerrormessage = errormessage.getText();
            Assert.assertEquals(expectederrormessage,actualerrormessage);

            Assert.assertEquals(expectedsigninpage,actualsigninpage);


//// sterge email
//        driver.findElement(By.xpath("//input[@placeholder='E mail']")).clear();
//// sterge password
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
//   refresh la pagina
//        driver.get("http://demo.automationtesting.in/SignIn.html");
            driver.navigate().refresh();
//        driver.get(driver.getCurrentUrl());



// 2. email corect, password gresit
//        Assert.assertEquals(expectederrormessage,actualerrormessage);
            WebElement emailfield2 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
            String emailcorect = "1563385056652@gmail.com";
            emailfield2.sendKeys(emailcorect);

            WebElement passwordfield2 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            String passwordgresitvalue = "000";
            passwordfield2.sendKeys(passwordgresitvalue);

            WebElement enterbutton2 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
            enterbutton2.click();

            Assert.assertEquals(expectederrormessage,actualerrormessage);
            Assert.assertEquals(expectedsigninpage,actualsigninpage);

// 3. email gresit, password corect
//        WebElement toClearemail = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
//        toClearemail.clear();
//        WebElement toClearpassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
//        toClearpassword.clear();

            driver.navigate().refresh();

            WebElement emailfield3 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
            String emailgresitvalue = "vxccb@gmail";
            emailfield3.sendKeys(emailgresitvalue);

            WebElement passwordfield3 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            String passwordcorectvalue = "Test123";
            passwordfield3.sendKeys(passwordcorectvalue);

            WebElement enterbutton3 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
            enterbutton3.click();

            Assert.assertEquals(expectederrormessage,actualerrormessage);
            Assert.assertEquals(expectedsigninpage,actualsigninpage);

// 4. email si password gresit
//        driver.findElement(By.xpath("//input[@placeholder='E mail']")).clear();
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
            driver.navigate().refresh();

            WebElement emailfield4 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
            String emailgresit2 = "kkl.com";
            emailfield4.sendKeys(emailgresit2);

            WebElement passwordfield4 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            String passwordgresit2 = "123";
            passwordfield4.sendKeys(passwordgresit2);

            WebElement enterbutton4 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
            enterbutton4.click();

            WebElement errormsg = driver.findElement(By.xpath("//label[@id='errormsg']"));
            if (errormsg.isDisplayed()){
                Assert.assertTrue(errormsg.isDisplayed());
            }
            Assert.assertEquals(expectedsigninpage,actualsigninpage);

// 5. email + password cu caractere speciale
//        driver.findElement(By.xpath("//input[@placeholder='E mail']")).clear();
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
            driver.navigate().refresh();

            WebElement emailfield5 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
            String emailcaracter = "*/+@#.$#&";
            emailfield5.sendKeys(emailcaracter);

            WebElement passwordfield5 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            String passwordcaracter = "&^%$%^&";
            passwordfield5.sendKeys(passwordcaracter);

            WebElement enterbutton5 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
            enterbutton5.click();

            Assert.assertEquals(expectederrormessage,actualerrormessage);
            Assert.assertEquals(expectedsigninpage,actualsigninpage);

// 6. email + password cu spatiu
//        driver.findElement(By.xpath("//input[@placeholder='E mail']")).clear();
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
            driver.navigate().refresh();

            WebElement emailfield6 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
            String emailspatiu = "          ";
            emailfield6.sendKeys(emailspatiu);

            WebElement passwordfield6 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            String passwordspatiu = "        ";
            passwordfield6.sendKeys(passwordspatiu);

            WebElement enterbutton6 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
            enterbutton6.click();

            Assert.assertEquals(expectederrormessage,actualerrormessage);
            Assert.assertEquals(expectedsigninpage,actualsigninpage);
        }
    }



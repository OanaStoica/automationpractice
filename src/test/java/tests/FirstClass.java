package tests;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class FirstClass {


    //declaram o variabila WebDriver
    public WebDriver driver;

    //declaram o metoda
    @Test
    public void start1(){

        System.setProperty("webdriver.chrome.driver","C:\\Automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver(); // deschidem un broswer
        driver.get("https://www.ikea.com/ro/ro/"); // accesez un link , apelez metoda get cu driver
        driver.manage().window().maximize();
        driver.quit();
    }

    @Test
    public void start2(){

        System.setProperty("webdriver.chrome.driver","C:\\Automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver(); // deschidem un broswer
        driver.get("https://www.youtube.com/"); // accesez un link , apelez metoda get cu driver
        driver.manage().window().maximize();
        driver.quit();




    }

    @Test
    public void start()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.google.com/");
        driver.close();
        driver.switchTo().window(tabs.get(0));

        //driver.quit();
    }
}

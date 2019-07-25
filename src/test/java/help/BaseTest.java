package help;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    public WebDriver driver;

    public static Properties property; // static e tipul de variabila care isi va pastra pe durata testului aceeasi valoare

    public FileInputStream file;

    @Before

    public void setup() throws FileNotFoundException {


        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loadproperty();

    }

    //metoda care incarca un fisier de proprietati
    public void loadproperty () throws FileNotFoundException {

        property=new Properties();
        file=new FileInputStream("C:\\Users\\mariu\\IdeaProjects\\ProbaAutomation\\src\\test\\resources\\InputData.properties"); // il copiez din  resources InputData.properties

        try {
            property.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //metoda care retuneaza valoare dintr-un fisier properties pe baza unei key

    public static String getvalue(String key){

        return property.getProperty(key); // se retuneaza din proprietate val cheii pe care noi o dam

    }



    @After

    public void finish(){

        //driver.quit();
    }
}

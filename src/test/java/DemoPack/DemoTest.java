package DemoPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTest {
    WebDriver driver= new ChromeDriver();

    @BeforeTest()
    public void demoLaunch(){

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver.get("https://qa-ahammed.oucampusdemo.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void CreatedemoTest(){

        driver.findElement(By.xpath("//*[@class='add-contact-btn float-btn']")).click();
        driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys("Manish");
        driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Jha");
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("1234567891");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("manish.jha284@gmail.com");
        driver.findElement(By.xpath("//*[@class='save-btn']")).click();
    }

    @AfterTest
    public void ValidationDemo(){




    }
}

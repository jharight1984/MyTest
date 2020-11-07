package DemoPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoTest {
    WebDriver driver= new ChromeDriver();

    @BeforeTest()
    public void demoLaunch() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver.get("https://qa-ahammed.oucampusdemo.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }
    @Test(priority = 0)
     public void checkCreateButton(){

        Boolean Display=driver.findElement(By.xpath("//*[@class='add-contact-btn float-btn']")).isDisplayed();
        System.out.println("Element displayed is: "+Display);
    }

    @Test(priority = 1)
    public void CreatedemoTest(){

        driver.findElement(By.xpath("//*[@class='add-contact-btn float-btn']")).click();
        driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys("Manish");
        driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Jha");
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("1234567891");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("manish.jha284@gmail.com");
        driver.findElement(By.xpath("//*[@class='save-btn']")).click();
    }

    @Test(priority = 2)
    public void ValidationDemo(){


        //String Firstname="Manish Jha";
        List<WebElement> webElementList= (List<WebElement>) driver.findElements(By.xpath("//*[@class='contact-info']"));
        for(int i=0;i<=webElementList.size()-1;i++){

            if(webElementList.get(i).getText().equals("Manish Jha")){
                System.out.println("This test is passed successfully");
                break;
            }
        }





    }
}

package org.example.AppTestOne;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.YTLike.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestP {
    WebDriver driver;
    @BeforeTest
    public void test(){
        driver=new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://plaky.com/index.html");

    }
    @Test
    public void logovanje(){
        HomePageApp page = new HomePageApp(driver);
        page.login();
    }
    @Test
    public void pageInteract(){
        HomePageApp page = new HomePageApp(driver);
        page.pageInteract();

    }
}

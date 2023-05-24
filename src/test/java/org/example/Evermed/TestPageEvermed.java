package org.example.Evermed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestPageEvermed {
    WebDriver driver;
    @BeforeTest
    public void test(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://evermedtv.com/");
    }
    @Test(priority=1)
    public void login() throws InterruptedException {
        HomePageEvermed page = new HomePageEvermed(driver);
        page.logIn();
    }
    @Test(priority=2)
    public void getAll() throws InterruptedException {
        HomePageEvermed page = new HomePageEvermed(driver);
        page.getAllVideos();
    }
    @AfterTest
    public void close(){
        driver.close();
    }
}

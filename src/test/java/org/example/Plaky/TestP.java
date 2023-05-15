package org.example.Plaky;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestP {
    WebDriver driver;
    @BeforeTest
    public void test(){
//        driver=new FirefoxDriver();
//        WebDriverManager.firefoxdriver().setup();
        //Firefox sadrzi neki error koji developeri jos nisu sredili pa iskace gomila errora, ali radi prog.
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
//        WebDriverManager.edgedriver().setup();
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
    @AfterTest
    public void quit() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}

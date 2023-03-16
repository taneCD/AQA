package org.example.SrbijaVoz;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestVoz {
    WebDriver driver;
    @BeforeTest
    public void test(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver().setup();

        driver.get("https://webapi1.srbvoz.rs/ekarta/app/#!/home");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedTitle = "Srbija Voz a.d - Kupovina karata";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void izborVoza() throws InterruptedException {
        var page1 = new IzborVoza(driver);
        page1.izborVoza();
        var page2 = new Putnici(driver);
        page2.putnici();
        var page3 = new Prijava(driver);
        page3.prijava();
        Kupovina page4 = new Kupovina(driver);
        page4.kupiKarte();
    }
    @AfterTest
    public void shutDown(){
        driver.close();
    }
}

package org.example.YTLike;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestPage {
    WebDriver driver;
    @BeforeTest
    public void test() throws IOException {
//        EdgeOptions edgeOptions = new EdgeOptions();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/112.0");
        chromeOptions.addArguments("--user-agent=New User Agent");
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver().setup();
        Properties pr = new Properties();
        FileInputStream file = new FileInputStream("src/test/java/org/example/YTLike/setup.properties");
        pr.load(file);
        driver.get(pr.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedTitle = "eMTB - Fruska Gora #gopro11mini - YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void signIn(){
        HomePage page = new HomePage(driver);
        page.signIn();
    }
    @Test
    public void dajLike(){
        HomePage page = new HomePage(driver);
        page.lajkuj();
    }
    @Test
    public void komentar() throws IOException {
        HomePage page = new HomePage(driver);
        page.komentarisi();
    }
}

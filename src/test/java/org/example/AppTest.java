package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class AppTest {

    @Test
    public void homeWork(){
        WebDriver driver= new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        WebElement textBox= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        textBox.sendKeys("iflight nazgulf5d v2");
        textBox.sendKeys(Keys.ENTER);
        driver.navigate().back();
        driver.close();
    }
}

package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AutomationURLmaker {
    @Test
    public void tinyWebLink() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver().setup();
        driver.get("https://tinyurl.com/app/");

        WebElement link = driver.findElement(By.xpath("//input[contains(@id, 'long-url')]"));
        link.click();
        link.clear();
        link.sendKeys("https://github.com/");

        WebElement button = driver.findElement(By.xpath("//*[contains(text(),'Make TinyURL!')]"));
        button.click();
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.xpath("//div[@role='dialog']//input[@readonly=\"readonly\"][contains(@class,'text-t-green')][not(@id)]"));
        String value = result.getAttribute("value");
        var getUrl = driver.getCurrentUrl();
        System.out.println(getUrl);
        System.out.println(value);
//        File scrScrennshot=driver.findElement(By.xpath("//*[@alt='Ruined King: A League Of Legends Story']")).getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(scrScrennshot,new File(System.getProperty("user.dir")+"\\ss.jpg"));

        driver.quit();
    }
}

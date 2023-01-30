package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTestHome2 {
    @Test
    public void homeWork2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.ctshop.rs/");

        WebElement registration = driver.findElement(By.xpath("//a[contains(text(),'Otvori nalog')]"));
        var js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",registration);

        WebElement login = driver.findElement(By.id("form-validate")); //xpath - //*[@id='form-validate']
        WebElement name = login.findElement(By.id("firstname"));
        name.clear();
        name.sendKeys("Nebojsa");
        
        WebElement lastName = login.findElement(By.id("lastname"));
        lastName.clear();
        lastName.sendKeys("Tanasaki");
        WebElement eMail = login.findElement(By.id("email_address"));
        eMail.clear();
        eMail.sendKeys("tanasaki@yahoo.com");
        WebElement pass = login.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys("PaS123456789");
        WebElement passConfir = login.findElement(By.id("confirmation"));
        passConfir.clear();
        passConfir.sendKeys("PaS123456789");
        WebElement checkBox = login.findElement(By.id("is_subscribed"));
        boolean status;
        if(checkBox.isSelected()){
            status=true;
        } else {
            status = false;
        }
        if(true){
            checkBox.click();
        }
        System.out.println("Test is completed successfully!");

    }
}

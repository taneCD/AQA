package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HomeWork2 {

    @Test
    public void homeWork3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.ctshop.rs/");
        WebElement registration = driver.findElement(By.xpath("//a[contains(text(), 'Otvori nalog')]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",registration);

        WebElement login = driver.findElement(By.className("account-create"));
        WebElement name = login.findElement(By.name("firstname"));
        name.clear();
        name.sendKeys("Nbjsh");

        WebElement lastName = login.findElement(By.name("lastname"));
        lastName.clear();
        lastName.sendKeys("Tnsky");

        WebElement email = login.findElement(By.name("email"));
        email.clear();
        email.sendKeys("ttny@gmail.com");

        WebElement password = login.findElement(By.name("password"));
        password.clear();
        password.sendKeys("pAssword312");

        WebElement passwordConfirmation = login.findElement(By.name("password_confirmation"));
        passwordConfirmation.clear();
        passwordConfirmation.sendKeys("pAssword312");

        WebElement pravnoLice = login.findElement(By.id("pravnolice"));
        Select dropDown = new Select(pravnoLice);
        dropDown.selectByIndex(1);
        WebElement pib = login.findElement(By.name("pib"));
        pib.clear();
        pib.sendKeys("87524187");

        Thread.sleep(3000);
        WebElement posalji = login.findElement(By.xpath("//span[contains(text(), 'Pošalji')]"));
        posalji.click();

        WebElement povratnaPoruka = driver.findElement(By.xpath("//*[contains(text(),'PIB mora sadržati tačno 9 cifara!')]"));
        System.out.println(povratnaPoruka.getText());

        System.out.println("Test is completed successfully!");
    }
}

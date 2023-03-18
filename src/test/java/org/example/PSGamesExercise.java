package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class PSGamesExercise {

    @Test
    public void psGames() throws InterruptedException, IOException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(chromeOptions);

        WebDriverManager.chromedriver().setup();
        driver.get("https://en.psprices.com/region-us/collection/most-wanted-deals");
        driver.manage().window().maximize();

        List<WebElement> names1 = driver.findElements(By.xpath("//span[contains(@class, \"block mt-1 line-clamp-2\")]")); // nalazi sve naslove OK

        for (var el : names1) {
            System.out.println(el.getText() + ",");
        }
        System.out.println(names1.size() + " elements on 1st page");
        System.out.println("");

        Thread.sleep(3000);

        var nextPage1 = driver.findElement(By.xpath("//*[@href='/region-us/collection/most-wanted-deals?page=2'][@aria-label='Next']"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", nextPage1);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", nextPage1);

        Thread.sleep(3000);

        List<WebElement> names2 = driver.findElements(By.xpath("//span[contains(@class, \"block mt-1 line-clamp-2\")]")); // nalazi sve naslove na drugoj strani OK
        for (var el : names2) {
            System.out.println(el.getText() + ",");
        }
        System.out.println(names2.size() + " elements on 2nd page");
        System.out.println("");

        WebElement nextPage2 = driver.findElement(By.xpath("//*[.='3']"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", nextPage2);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextPage2); //caka da klikne i kad element nije vidljiv, cak i da ne scroluje, ne radi ako stranica ima zastitu protiv botova
        Thread.sleep(3000);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2200)");//skroluj dole zadnju stranicu za 2200px
        List<WebElement> names3 = driver.findElements(By.xpath("//span[contains(@class, \"block mt-1 line-clamp-2\")]")); //nalazi sve naslove na trecoj strani

        for (var el : names3) {
            System.out.println(el.getText() + ",");
        }
        System.out.println(names3.size() + " elements on 3rd page");
        System.out.println(names1.size()+" + "+names2.size()+" + "+names3.size()+" elements");
        System.out.print("Number of total elements: ");
        System.out.print(names1.size()+names2.size()+names3.size());

//        driver.close();
    }
}

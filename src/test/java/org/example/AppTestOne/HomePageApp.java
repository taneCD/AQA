package org.example.AppTestOne;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HomePageApp {
    WebDriver driver;

    public HomePageApp(WebDriver driver) {
        this.driver = driver;
    }
    By logInBtn = By.xpath("//*[@href='https://app.plaky.com/login'][@class='nav-link mr-3']");
    By logintWithGoggle = By.xpath("//span[.='Log in with Google']");
    By userName= By.xpath("//*[@autocomplete='username']");
    By userNameNextBtnx = By.xpath("//*[@id='identifierNext']");

    By pass = By.xpath("//*[@type='password']");
    By nextBtn= By.xpath("//div[@id='passwordNext']");

    //Page interaction
    By themePosition = By.xpath("//*[@src='https://plaky-downloads.s3.eu-central-1.amazonaws.com/templates/event-planning/file-1-dark-thumbnail.png']");
    By selectTheme= By.xpath("(//button[text()='Use in'])[2]");
    By confirmeTheme = By.xpath("//*[text()='Main workspace']");
    By skipBtn = By.xpath("//*[text()='Skip']");


    public void login() {
        try {
            driver.findElement(logInBtn).click();
            driver.findElement(logintWithGoggle).click();
            driver.findElement(userName).sendKeys("zatest404@gmail.com");
            driver.findElement(userNameNextBtnx).click();
            Thread.sleep(1000);
            driver.findElement(pass).sendKeys("testMeNow");
            driver.findElement(nextBtn).click();


        } catch (Exception e) {
            System.out.println("Ne mogu da se ulogujem");
        }
    }
    public void pageInteract(){
        try{
            Actions actions = new Actions(driver);
            WebElement target = driver.findElement(themePosition);
            Thread.sleep(2000);
            actions.moveToElement(target).perform();
            Thread.sleep(2000);
            driver.findElement(selectTheme).click();
            driver.findElement(confirmeTheme).click();
        } catch (Exception e){
            System.out.println("Nevidiljivo dugme");
        }
        driver.findElement(skipBtn).click();
        driver.findElement(skipBtn).click();

        var elements = driver.findElements(By.xpath("//td//a"));
        String ourText = "New office opening";
        boolean tacno=false;
        for(var el : elements){
            System.out.println(el.getText());
            if(el.getText().contains(ourText)){
                tacno=true;
            }
        }
        if(tacno){
            System.out.println("Sadrzi trazeni el!");
        }
    }
}

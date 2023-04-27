package org.example.YTLike;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By like = By.xpath("(//*[@animated-icon-type='LIKE'])[1]");
    private By comment = By.xpath("//*[@id='contenteditable-textarea']");
    private By signInBtn=By.xpath("//*[@aria-label='Sign in']");
    private By nameOrPhone= By.xpath("//*[@class='xyezD']");
    private By nextBtnx = By.xpath("//*[@name='action']");


    public void signIn(){
        driver.findElement(signInBtn).click();
        driver.findElement(nameOrPhone).sendKeys("justfortane@gmail.com");
        driver.findElement(nextBtnx).click();
    }
    public void lajkuj(){
        driver.findElement(like).click();
    }
    public void komentarisi() throws IOException {
        Properties pr = new Properties();
        FileInputStream file = new FileInputStream("src/test/java/org/example/YTLike/setup.properties");
        pr.load(file);
        driver.findElement(comment).sendKeys(pr.getProperty("textComment"));
    }
}

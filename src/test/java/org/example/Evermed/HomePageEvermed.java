package org.example.Evermed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageEvermed {
    WebDriver driver;
    public HomePageEvermed(WebDriver driver) {
        this.driver = driver;
    }
    By loginClick = By.xpath("//*[.=' Log in ']");
    //Login
    By email = By.xpath("//*[@ng-reflect-name='username']");
    By pass = By.xpath("//*[@formcontrolname='password']");
    By clickLogIn = By.xpath("//*[@class='form-control btn btn-primary text-uppercase']");
    //Page interaction
    By getAllVideos = By.xpath("//h4[@class='mb-2 d-flex justify-content-center align-items-center']");

    public void logIn() throws InterruptedException {
        driver.findElement(loginClick).click();
        driver.findElement(email).sendKeys("tane-86@hotmail.com");
        driver.findElement(pass).sendKeys("4bC+fe6Z-bCTfK^");
        driver.findElement(clickLogIn).click();
        Thread.sleep(2000);
    }
    public void getAllVideos() throws InterruptedException {
        EvermedDb db = new EvermedDb();
        db.aktivacija();
        var videos = driver.findElements(getAllVideos);
        EvermedDb.InsertRecords rec = new EvermedDb.InsertRecords();
        for(var el : videos){
            rec.insert(0, el.getText());
//            System.out.println(el.getText());
        }
        Thread.sleep(2000);
        //Citanje iz baze
        EvermedDb.SelectRecords sl = new EvermedDb.SelectRecords();
        sl.selectAll();
    }
}

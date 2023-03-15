package org.example.SrbijaVoz;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class Prijava {
    WebDriver driver;
    public Prijava(WebDriver driver) {
        this.driver = driver;
    }
    private By email = By.id("username");
    private By lozinka = By.id("password");
    private By prijavaBtn = By.xpath("//*[.='PRIJAVA']");
    private By errorText = By.xpath("//*[@class='help-block error ng-binding']");
    public void prijava(){
        driver.findElement(email).sendKeys("randommail@yahoo.com");
        driver.findElement(lozinka).sendKeys("sifra12345");
        driver.findElement(prijavaBtn).click();

        String expectedError = "Pogrešno korisničko ime ili lozinka. Molimo vas pokušajte ponovo.";

        String actualError = driver.findElement(errorText).getText();
        System.out.println(actualError);
        Assert.assertEquals(actualError, expectedError);
    }
}

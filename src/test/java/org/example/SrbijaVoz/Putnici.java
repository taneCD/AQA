package org.example.SrbijaVoz;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Putnici {
    WebDriver driver;
    public Putnici(WebDriver driver) {
        this.driver = driver;
    }
    //Putnik 1
    private By putnik1 = By.xpath("//*[.='1']/following-sibling::div//*[@placeholder='Ime i prezime']");
    //Datum rodjenja1
    private By dan1 = By.xpath("//*[.='1']/following-sibling::div//*[@ng-model='date']");
    private By mesec1 = By.xpath("//*[.='1']/following-sibling::div//*[@ng-model='month']");
    private By godina1 = By.xpath("//*[.='1']/following-sibling::div//*[@ng-model='year']");
    //Putnik 2
    private By putnik2 = By.xpath("//*[.='2']/following-sibling::div//*[@placeholder='Ime i prezime']");
    //Datum rodjenja2
    private By dan2 = By.xpath("//*[.='2']/following-sibling::div//*[@ng-model='date']");
    private By mesec2 = By.xpath("//*[.='2']/following-sibling::div//*[@ng-model='month']");
    private By godina2 = By.xpath("//*[.='2']/following-sibling::div//*[@ng-model='year']");
    //Dalje
    private By daljeBtn = By.xpath("//a[@class='btn btn-sv pull-right']");

    public void putnici(){
        //Putnik 1
        driver.findElement(putnik1).sendKeys("Milan Miric");
        driver.findElement(dan1).sendKeys("11");
        driver.findElement(mesec1).sendKeys("May");
        driver.findElement(godina1).sendKeys("1990");

        //Putnik 2
        driver.findElement(putnik2).sendKeys("Milana Miric");
        driver.findElement(dan2).sendKeys("3");
        driver.findElement(mesec2).sendKeys("Sep");
        driver.findElement(godina2).sendKeys("1999");

        driver.findElement(daljeBtn).click();
    }
}

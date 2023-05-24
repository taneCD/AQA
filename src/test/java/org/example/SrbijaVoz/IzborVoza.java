package org.example.SrbijaVoz;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class IzborVoza {
    WebDriver driver;

    public IzborVoza(WebDriver driver) {
        this.driver = driver;
    }
    //Home page
    private By stanicaOd = By.id("stanicaod");
    private By stanicaDo = By.id("stanicado");
    private By datumPolazak = By.xpath("//*[@ng-click='open()']//*[@class='glyphicon glyphicon-calendar']");
    private By datePicker = By.xpath("//div[@uib-datepicker]//table//th[@colspan]");
    private By dateNext = By.xpath("//*[@class='btn btn-default btn-sm pull-right uib-right']");
    private By dan = By.xpath("//*[text()='22']"); // datum dan
    private By razred = By.xpath("//*[@id='selectbasic'][@ng-model='razred']");
    private By brPutnika = By.xpath("//*[@name='brput']");
    private By traziBtn = By.id("btntrazi");
    private By izaberiBtn = By.xpath("(//td[contains(.,'16:00')]/following-sibling::td//*[@class='btn btn-sv btn-izaberip'])[1]");
    private By daljeBtn = By.xpath("//*[@class='voz-pregled hidden-xs']//*[contains(text(), 'DALJE')]");

    public void izborVoza() throws InterruptedException {
        driver.findElement(stanicaOd).sendKeys("Novi Sad" + Keys.ENTER);
        driver.findElement(stanicaDo).sendKeys("Beograd Centar" + Keys.ENTER);
        driver.findElement(datumPolazak).click();
        Thread.sleep(2000);
        String datePick = driver.findElement(datePicker).getText();
        String month = datePick.split(" ")[0];
        String year = datePick.split(" ")[1];

        while (!(month.equals("maj") && year.equals("2023"))) {
            driver.findElement(dateNext).click();

            datePick = driver.findElement(datePicker).getText();
            month = datePick.split(" ")[0];
            year = datePick.split(" ")[1];
        }
        driver.findElement(dan).click();
        //Razred
        WebElement raz = driver.findElement(razred);
        Select select = new Select(raz);
        select.selectByIndex(0);
        //Broj putnika
        driver.findElement(brPutnika).clear();
        driver.findElement(brPutnika).sendKeys("2");
        //Trazi
        driver.findElement(traziBtn).click();

        driver.findElement(izaberiBtn).click();
        driver.findElement(daljeBtn).click();
    }
}

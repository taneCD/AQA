package org.example.SrbijaVoz;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Kupovina {
    WebDriver driver;

    public Kupovina(WebDriver driver) {
        this.driver = driver;
    }
    private By usloviChckbox = By.xpath("//*[@ng-model='uslovi']");
    private By kupiKarteBtn = By.xpath("//*[.='Kupi karte']");
    private By cardInfoText = By.xpath("//*[contains(text(),'UNESITE PODATKE')]");
    private By errorText = By.xpath("//p");
    private By nemaMesta = By.xpath("//*[@class='col-md-12 alert alert-danger']");

    public void kupiKarte() throws InterruptedException {
        driver.findElement(usloviChckbox).click();
        Thread.sleep(3000); //Ako pauzi nije pristuna citace nas kao bot i program ne radi
        driver.findElement(kupiKarteBtn).click();

        String text1 = "";
        try {
            text1 = driver.findElement(cardInfoText).getText();
        } catch (Exception ignored) {
        }
        if (text1.equals("")) {
            try {
                text1 = driver.findElement(errorText).getText();
            } catch (Exception ignored) {
            }
        }
        if (text1.equals("")) {
            try {
                text1 = driver.findElement(nemaMesta).getText();
            } catch (Exception ignored) {
            }
        }

        if (text1.equals("UNESITE PODATKE O VLASNIKU KARTICE")) {
            System.out.println("Everything is working out, thank you for testing!");
        } else if (text1.equals("Unable to locate merchant URL for return, issuer ACS responds with an invalid PARes or system error")) {
            System.out.println("Error! System is bot protected! Try again slower!");
        } else if (text1.equals("Trenutno nema mesta za traženu relaciju")) {
            System.out.println("Nema slobodnog mesta u vozu.");
        } else {
            System.out.println("Please try again!");
        }
    }
}

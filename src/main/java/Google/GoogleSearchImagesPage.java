package Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class GoogleSearchImagesPage extends GoogleSearchPage{

    @FindBy(partialLinkText = "Im")
    WebElement imagenesLink;

    @FindBy(xpath = ".//*[@id=\'rg_s\']/div")
    List<WebElement> results;

    @FindBy (id = "irc_ra")
    WebElement navigateNextImage;

    @FindBy (id = "irc_la")
    WebElement navigatePreviousImage;

    @FindBy(linkText = "Visitar página")
    WebElement visitPage;

    public GoogleSearchImagesPage(WebDriver driver) {
        super(driver);
    }

    public void gotoImages(){
        imagenesLink.click();
    }

    public void clickOnNImagen(int imagePos){
        results.get(imagePos).click();
    }

    public void navigateNextImage(){
        navigateNextImage.click();
    }

    public void navigatePreviousImage(){
        navigatePreviousImage.click();
    }

    public void visitCurrentImagePage(){
        visitPage.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.stalenessOf(visitPage));
    }
}

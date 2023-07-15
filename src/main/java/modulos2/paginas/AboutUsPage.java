package modulos2.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class AboutUsPage {
    private WebDriverWait wait;
    private WebElement baseElement;
    private WebElement currentElement;

    public AboutUsPage(WebDriverWait wait, WebElement baseElement) {
        this.wait = wait;
        this.baseElement = baseElement;
    }

    public AboutUsPage executarPlayNoVideo(){
        try{
            WebElement btnPlay = this.baseElement.findElement(By.cssSelector(".vjs-big-play-button"));
            wait.until(ExpectedConditions.elementToBeClickable(btnPlay));
            btnPlay.click();
            this.currentElement = btnPlay;
        }catch (NoSuchElementException ex){
            return null;
        }

        return this;
    }

    public AboutUsPage executarPauseNoVideo(){
        try{
            WebElement btnPause = this.baseElement.findElement(By.cssSelector(".vjs-play-control.vjs-control.vjs-button"));
            wait.until(ExpectedConditions.elementToBeClickable(btnPause));
            btnPause.click();
            this.currentElement = btnPause;
        }catch (NoSuchElementException ex){
            return null;
        }

        return this;
    }
}

package modulos2.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InicialPage {
    private WebDriver browser;
    private WebDriverWait wait;

    public InicialPage(WebDriver browser, WebDriverWait wait) {
        this.browser = browser;
        this.wait = wait;
    }

    public LoginPage acessarPaginaLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        this.browser.findElement(By.id("login2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        WebElement modalLogin = this.browser.findElement(By.id("logInModal"));

        return new LoginPage(this.wait, modalLogin);
    }

    public AboutUsPage acessarPaginaSobreNos(){
        WebElement aboutUsLink = this.browser.findElement(By.linkText("About us"));
        wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink));
        aboutUsLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModal")));
        WebElement modalAboutUs = this.browser.findElement(By.id("videoModal"));

        return new AboutUsPage(this.wait, modalAboutUs);
    }
}


package modulos.paginas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class ContactPage {

    private WebDriver navegador;

    private WebDriverWait wait;

    public ContactPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public ContactPage abrirFormulario() throws AWTException {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement campoEmail = navegador.findElement(By.xpath("//input[@id='recipient-email']"));
        campoEmail.sendKeys("tste@teste.com");

        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement campoName = navegador.findElement(By.xpath("//input[@id='recipient-name']"));
        campoName.sendKeys("Vanessa Alves");

        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        WebElement campoMensagem = navegador.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[3]/textarea"));
        campoMensagem.sendKeys("Sucesso");

        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(99));
        navegador.findElement(By.cssSelector(" #exampleModal > div > div > div.modal-footer > button.btn.btn-primary")).click();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));

        try {
            WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = navegador.switchTo().alert();
            Assertions.assertEquals("Thanks for the message!!", alert.getText());
            alert.accept();
        } catch (Exception e) {
            //handle the exception
        }



        //Compra finalizada- botão OK
       // this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //this.navegador.findElement(By.cssSelector("html body.modal-open.stop-scrolling div.sweet-alert.showSweetAlert.visible div.sa-button-container div.sa-confirm-button-container button.confirm.btn.btn-lg.btn-primary")).click();


        return this;

    }
}

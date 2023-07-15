package modulos2.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriverWait wait;
    private WebElement baseElement;
    private WebElement currentElement;

    public LoginPage(WebDriverWait wait, WebElement baseElement) {
        this.wait = wait;
        this.baseElement = baseElement;
    }

    public LoginPage acessarCampoUsuario(){
        try {
            // Recupera o campo de usuario
            WebElement usuario = this.baseElement.findElement(By.id("loginusername"));
            // Aguarda o campo ser clicável
            wait.until(ExpectedConditions.elementToBeClickable(usuario));
            // Clica no campo de usuario
            usuario.click();
            this.currentElement = usuario;
        }catch (NoSuchElementException ex){
            // Deu timeout e o campo não foi encontrado, retorna nulo
            return null;
        }
        return this;
    }

    public LoginPage escreverNoCampoCorrente(String texto){
        // Somente consegue escrever caso elemento corrente exista
        if(this.currentElement != null){
            this.currentElement.sendKeys(texto);
        }else{
            // Retorna nulo caso não consiga escrever no elemento
            return null;
        }

        return this;
    }
}

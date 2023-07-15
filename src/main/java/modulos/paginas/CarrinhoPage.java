package modulos.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarrinhoPage {
    private WebDriver navegador;

    private WebDriverWait wait;

    public CarrinhoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public CarrinhoPage exlcuirDoCarrinho() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navegador.findElement(By.cssSelector("tr.success:nth-child(1) > td:nth-child(4) > a:nth-child(1)")).click();


        return this;

    }


}
package modulos.paginas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InicialPage {
    private WebDriver navegador;

    private WebDriverWait wait;

    public InicialPage(WebDriver navegador) {
        this.navegador = navegador;
        this.wait = new WebDriverWait(navegador, Duration.ofSeconds(30));
    }

    public InicialPage selecionarCategoriaPhones(){
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        navegador.findElement(By.linkText("Phones")).click();
        return this;
    }
    public InicialPage escolherPhones() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        navegador.findElement(By.linkText("Samsung galaxy s6")).click();

        return this;
    }
    public InicialPage selecionarCategoriaLaptops(){
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        navegador.findElement(By.linkText("Laptops")).click();
        return this;
    }
    public InicialPage escolherLaptops() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        navegador.findElement(By.linkText("Sony vaio i5")).click();

        return this;
    }

    public InicialPage selecionarCategoriaMonitors(){
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        navegador.findElement(By.linkText("Monitors")).click();
        return this;
    }
    public InicialPage escolherMonitors() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        navegador.findElement(By.linkText("Apple monitor 24")).click();

        return this;
    }

    public InicialPage addProdutoNoCarrinho() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navegador.findElement(By.linkText("Add to cart")).click();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        try {
            WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = navegador.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //handle the exception
        }

        return this;

    }
  public InicialPage voltarParaHomeDepoisDeAddProdutoNoCarrinho(){
            navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            navegador.findElement(By.xpath("/html/body/nav/div/div/ul/li[1]/a")).click();


        return this;
    }

    public InicialPage pagamentoProdutos() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navegador.findElement(By.linkText("Cart")).click();


        return this;

    }

    public InicialPage pagamentoButton() {
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        WebElement pagamentoButton = navegador.findElement(By.xpath("/html/body/div[6]/div/div[2]/button"));
        pagamentoButton.click();

        return this;

    }

    public InicialPage cadastroDePagamento(String name, String country, String city, String numCartaoDeCredito, String mes, String ano) {
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        WebElement elemName = this.navegador.findElement(By.xpath("//*[@id=\"name\"]"));
        elemName.sendKeys(name);
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement elemCountryName = this.navegador.findElement(By.xpath("//*[@id=\"country\"]"));
        elemCountryName.sendKeys(country);

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement elemCityName = this.navegador.findElement(By.xpath("//*[@id=\"city\"]"));
        elemCityName.sendKeys(city);

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement elemCredCardNum = this.navegador.findElement(By.xpath("//*[@id=\"card\"]"));
        elemCredCardNum.sendKeys(numCartaoDeCredito);

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement elemMes = this.navegador.findElement(By.xpath("//*[@id=\"month\"]"));
        elemMes.sendKeys(mes);

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement elemAno = this.navegador.findElement(By.xpath("//*[@id=\"year\"]"));
        elemAno.sendKeys(ano);

        return this;
    }

    public InicialPage finalizarCompra() {
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement elemPurchaseBtn = this.navegador.findElement(By.xpath("//html/body/div[3]/div/div/div[3]/button[2]"));
        elemPurchaseBtn.click();

        //Compra finalizada- botão OK
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.navegador.findElement(By.cssSelector("html body.modal-open.stop-scrolling div.sweet-alert.showSweetAlert.visible div.sa-button-container div.sa-confirm-button-container button.confirm.btn.btn-lg.btn-primary")).click();

        return this;
    }

    public InicialPage btnCancelar() {
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        this.navegador.findElement(By.cssSelector("html body.modal-open div#orderModal.modal.fade.show div.modal-dialog div.modal-content div.modal-footer button.btn.btn-secondary")).click();

        return this;
    }

    public InicialPage btnExcluir() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navegador.findElement(By.cssSelector("tr.success:nth-child(1) > td:nth-child(4) > a:nth-child(1)")).click();

        return this;

    }

    public CarrinhoPage acessarOCarrinho(){
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navegador.findElement(By.linkText("Cart")).click();

        return new CarrinhoPage(navegador);

    }

    public ContactPage acessarContato(){
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        navegador.findElement(By.xpath("/html/body/nav/div[1]/ul/li[2]/a")).click();

        return new ContactPage(navegador);

    }

   // public AboutUsPage acessarAboutUs(){
      //  navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // navegador.findElement(By.linkText("About us")).click();

       // return new AboutUsPage(navegador);
   // }



}


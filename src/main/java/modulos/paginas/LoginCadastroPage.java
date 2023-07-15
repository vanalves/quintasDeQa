package modulos.paginas;


import modulos.Contact.AboutUsPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.logging.Logger;


public class LoginCadastroPage {

    private WebDriver navegador;
    private WebDriverWait wait;

    //private static final Logger logger = LogManager.getLogManager().getLogger("compras");
    private static final Logger logger = Logger.getLogger(LoginCadastroPage.class.getName());


    public LoginCadastroPage(WebDriver navegador) {
        this.navegador = navegador;
        this.wait = new WebDriverWait(navegador, Duration.ofSeconds(30));

       //  Set<String> logEntries = navegador.manage().logs().getAvailableLogTypes();

       //  for (String logType : logEntries.addAll()) {

       //   System.out.println("Tipo de Log: testando log de entrada " + logType); }

      //  navegador.manage().logs().getAvailableLogTypes();


    }


    public LoginCadastroPage clicaAcesso() {
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.findElement(By.linkText("Sign up")).click();


        logger.info("Sign Up realizado com sucesso");
        logger.warning("Aviso: Sign up não está funcionando corretamente");
        logger.severe("Quebrou tudo");

        return this;
    }

    public LoginCadastroPage cadastroUsuario(String username, String password) throws AWTException {

       // logger.info("Comprando um telefone");

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-username")));
        WebElement elemUserName = this.navegador.findElement(By.id("sign-username"));
        elemUserName.sendKeys(username);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-password")));
        WebElement elemPassword = this.navegador.findElement(By.id("sign-password"));
        elemPassword.sendKeys(password);

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navegador.findElement(By.cssSelector("[onclick = 'register()']")).click();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        try {
            WebDriverWait wait = new WebDriverWait(navegador,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = navegador.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //handle the exception
        }


      //  logger.notifyAll();

       // logger.info("Terminando de fazer a Compra do telefone, testando mensagem de saida do log");
      //  logger.warning("Aviso: algo está errado, testando logs");
      //  logger.log(Level.SEVERE, "Erro ocorrido", exception);



        try {

        }

        catch (Exception e){

            throw new RuntimeException(e);

        }
        return this;
    }


    public LoginCadastroPage loginAcessoUsuario(){
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(99));
        navegador.findElement(By.linkText("Log in")).click();
        return this;
    }

    public inicialPage acessoUsuario(String usuario, String senha){
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(99));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
        WebElement elemUserName = this.navegador.findElement(By.id("loginusername"));
        elemUserName.sendKeys(usuario);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
        WebElement elemPassword = this.navegador.findElement(By.id("loginpassword"));
       elemPassword.sendKeys(senha);

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(99));
        navegador.findElement(By.cssSelector("[onclick= 'logIn()']")).click();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        try {
            WebDriverWait wait = new WebDriverWait(navegador,Duration.ofSeconds(99));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = navegador.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //handle the exception
        }

return new inicialPage(navegador);
    }

    public ContactPage acessarContato(){
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navegador.findElement(By.cssSelector("/html/body/nav/div[1]/ul/li[2]/a")).click();

        return new ContactPage(navegador);

    }

    public AboutUsPage acessarAboutUs() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navegador.findElement(By.linkText("About us")).click();
        return new AboutUsPage(navegador);
    }
}


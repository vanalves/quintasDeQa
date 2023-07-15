package modulos.Contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutUsPage {

    private WebDriver navegador;

    private WebDriverWait wait;

    public AboutUsPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public AboutUsPage  clicarnoBotaoAboutUs(){

        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(999));
        navegador.findElement(By.id("vjs-big-play-button")).click();

        ////*[@class='vjs-big-play-button']

       // boolean butnStatus = driver.findElement(By.xpath("//input[@id=’searchSubmit’]"))
             //   .isEnabled();

      //  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//*[@class='vjs-big-play-button']")));
      //  WebElement elemClick = this.navegador.findElement(By.xpath("//*[@class='vjs-big-play-button']"));
        //elemClick.click();







        //navegador.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/form/div/div/div[4]/button[1]/span[1]")).click();
       // navegador.findElement(By.cssSelector("#example-video > button")).click();


       // WebElement botaoPlay = navegador.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div/div/button/span[1]")); // Clicar no botão "play"
        //botaoPlay.click();

       // navegador.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div/div/button/span[1]")).click();

       // navegador.switchTo().frame(WebDriver )

       // Robot robot = new Robot();
       // int x = 0;
       // double y = 34.2;
       // robot.mouseMove(x, (int) y);


      //  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
       // robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        try {
            Thread.sleep(5000); // Espera por 5 segundos
             }
            catch(InterruptedException e){
                e.printStackTrace();

            }
        return this;
    }


    //public AboutUsPage botaoClose() {
       // this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // this.navegador.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/button")).click();

       // return this;
  //  }






}

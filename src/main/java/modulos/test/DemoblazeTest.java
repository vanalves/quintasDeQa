package modulos.test;

import modulos2.paginas.AboutUsPage;
import modulos2.paginas.InicialPage;
import modulos2.paginas.LoginPage;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@DisplayName("Teste Web do Modulo de Produtos")
public class DemoblazeTest {
    private WebDriver browser;
    private WebDriverWait wait;
    private static final Logger LOGGER = Logger.getLogger(DemoblazeTest.class);
    @BeforeEach
    public void beforeEach(){
        LOGGER.info("Before each para cada item");
        // Abrir navegador
        //System.setProperty("webdriver.chrome.driver","C:\\AutomaçaoTestesWeb\\chromedriver_win32\\chromedriver.exe");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .withLogOutput(System.out)
                .build();
        this.browser = new ChromeDriver(service);

        //Maximizar a tela
        this.browser.manage().window().maximize();

        //Definir espera de 5 segundos
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a pagina da lojinha Web
        this.browser.get("https://www.demoblaze.com/index.html");

        LOGGER.info("Criando componente de espera (WebDriverWait)");

        this.wait = new WebDriverWait(browser, Duration.ofSeconds(30));
    }

    @Test
    @DisplayName("Teste da Vanessa legalzão")
    public void TestLoginPage(){
        // Inicializa tela principal
        InicialPage inicialPage = new InicialPage(browser, wait);
        // Abre tela de login
        LoginPage loginPage = inicialPage.acessarPaginaLogin();
        // Chega no campo de usuario
        if(loginPage.acessarCampoUsuario() == null){
            Assertions.fail("Elemento usuário não localizado");
        }else{
            Assertions.assertNotNull(
                loginPage.escreverNoCampoCorrente("abobora"),
                "Elemento usuário não localizado"
            );
        }
    }

    @Test
    @DisplayName("Executar video de teste")
    public void TestAboutUsPage() throws InterruptedException {
        InicialPage inicialPage = new InicialPage(browser, wait);
        AboutUsPage aboutUsPage = inicialPage.acessarPaginaSobreNos();
        Assertions.assertNotNull(
            aboutUsPage.executarPlayNoVideo(),
            "Não conseguiu dar play no video"
        );
        Thread.sleep(3000);
        Assertions.assertNotNull(
                aboutUsPage.executarPauseNoVideo(),
                "Não conseguiu pausar o video"
        );

    }

    @AfterEach
    public void afterAll(){
        if(this.browser != null) {
            this.browser.quit();
        }
    }
}




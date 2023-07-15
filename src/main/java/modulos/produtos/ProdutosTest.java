package modulos.produtos;


import modulos.paginas.LoginCadastroPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;
import java.util.logging.Logger;

@DisplayName("Teste Web do Modulo de Produtos")
public class ProdutosTest {
    private WebDriver navegador;
    //private static final Logger logger = LogManager.getLogManager().getLogger("compras");
    private static Logger logger = Logger.getLogger(String.valueOf(ProdutosTest.class));
    @BeforeEach
    public void beforeEach(){
        // Abrir navegador
        System.setProperty("webdriver.chrome.driver","C:\\AutomaçaoTestesWeb\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Maximizar a tela
        this.navegador.manage().window().maximize();

        //Definir espera de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a pagina da lojinha Web
        this.navegador.get("https://www.demoblaze.com/index.html");
    }

    //public class Main {
        //public static void main(String[] args) {
            // Configurar os detalhes de conexão
          //  String url = "jdbc:mysql://localhost:3306/nome_do_banco";
          //  String user = "seu_usuario";
          //  String password = "sua_senha";

           // try {
                // Carregar o driver JDBC
              //  Class.forName("com.mysql.cj.jdbc.Driver");

                // Estabelecer a conexão com o MySQL
               // Connection connection = DriverManager.getConnection(url, user, password);

                // Use a conexão para executar operações no banco de dados

                // Fechar a conexão
              //  connection.close();
         //   } catch (ClassNotFoundException e) {
             //   e.printStackTrace();
         //   } catch (SQLException e) {
              //  e.printStackTrace();
        //    }
       // }
   // }

             // Teste efetuar uma comprar de celular e efetuar o pagamento
    @Test
    @DisplayName("Comprar telefones celular")
    public void testComprarTelefonesCelular() throws AWTException {
        // logger.info("Comprando um telefone");
        //fazer o login
        String vendasPhones = new LoginCadastroPage(navegador)
                .clicaAcesso()  // Abre a tela de usuario
                .cadastroUsuario("Renato de Oliveira 840", "123456") // Informa o username e password do usuário
                .loginAcessoUsuario()
                .acessoUsuario("Renato de Oliveira 840", "123456")
                .selecionarCategoriaPhones()
                .escolherPhones()
                .addProdutoNoCarrinho()
                .pagamentoProdutos()
                .pagamentoButton()
                .cadastroDePagamento("Renato De Oliveira ", " BRASIL", "São Paulo", "123456789111", "11", "2028")
                .finalizarCompra().toString();

        logger.info("Testando ");
    }

    /**
     * Teste para acessar o carrinho a cancelar uma compra
     * @throws AWTException
     */
    @Test
    @DisplayName("Cancelamento de compra")
    public void testCancelamentoCompra() throws AWTException {
        //fazer o login

        String cancelamentoCompra = new LoginCadastroPage(navegador)
                .clicaAcesso()  // Abre a tela de usuario
                .cadastroUsuario("Renato de Oliveira 302", "123456") // Informa o username e password do usuário
                .loginAcessoUsuario()
                .acessoUsuario("Renato de Oliveira 302", "123456")
                .selecionarCategoriaPhones()
                .escolherPhones()
                .addProdutoNoCarrinho()
                .pagamentoProdutos()
                .pagamentoButton()
                .cadastroDePagamento("Renato De Oliveira "," BRASIL","São Paulo","123456789111","11","2028")
                .btnCancelar().toString();
    }

    // Teste usuário compra o produto e vai no carrinho excluir o produto
    @Test
    @DisplayName("Deletar o produto do carrinho")
    public void testDeletarProdutodoCarrinhoNoPagamento() throws AWTException {
        //fazer o login
        String deletarProdutodoCarrinhoNoPagamento = new LoginCadastroPage(navegador)
                // .clicaAcesso()  // Abre a tela de usuario
                //.cadastroUsuario("Jack Silva teste77", "12345678") // Informa o username e password do usuário
                .loginAcessoUsuario()
                .acessoUsuario("Renato de Oliveira 100", "123456")
                .selecionarCategoriaPhones()
                .escolherPhones()
                .addProdutoNoCarrinho()
                .pagamentoProdutos()
                .pagamentoButton()
                .cadastroDePagamento("Renato De Oliveira "," BRASIL","São Paulo","123456789111","11","2028")
                //.btnCancelar().toString();
                .btnExcluir().toString();
    }
     @Test
    @DisplayName("Excluir Produtos Do Carrinho")
    public void testExcluirProdutosDoCarrinho() throws AWTException {
        //fazer o login
        String excluirProdutosDoCarrinho = new LoginCadastroPage(navegador)
                // .clicaAcesso()  // Abre a tela de usuario
                //.cadastroUsuario("Jack Silva teste77", "12345678") // Informa o username e password do usuário
                .loginAcessoUsuario()
                .acessoUsuario("Renato de Oliveira 120", "123456")
                //  .selecionarCategoriaPhones()
                .acessarOCarrinho()
                .exlcuirDoCarrinho().toString();

    }
    @Test
    @DisplayName("Comprar Laptops")
    public void testComprarLaptops() throws AWTException {
        //fazer o login

        String vendasLapTop = new LoginCadastroPage(navegador)
                .clicaAcesso()  // Abre a tela de usuario
                .cadastroUsuario("Renato de Oliveira 120", "123456") // Informa o username e password do usuário
                .loginAcessoUsuario()
                .acessoUsuario("Renato de Oliveira 120", "123456")
                .selecionarCategoriaLaptops()
                .escolherLaptops()
                .addProdutoNoCarrinho()
                .pagamentoProdutos()
                .pagamentoButton()
                .cadastroDePagamento("Renato De Oliveira "," BRASIL","São Paulo","123456789111","11","2028")
                .finalizarCompra().toString();

    }
    @Test
    @DisplayName("Comprar Monitores")
    public void testComprarMonitors() throws AWTException {
        //fazer o login

        String vendasMonitors = new LoginCadastroPage(navegador)
                .clicaAcesso()  // Abre a tela de usuario
                .cadastroUsuario("Renato de Oliveira 130", "123456") // Informa o username e password do usuário
                .loginAcessoUsuario()
                .acessoUsuario("Renato de Oliveira 130", "123456")
                .selecionarCategoriaMonitors()
                .escolherMonitors()
                .addProdutoNoCarrinho()
                .pagamentoProdutos()
                .pagamentoButton()
                .cadastroDePagamento("Renato De Oliveira "," BRASIL","São Paulo","123456789111","11","2028")
                .finalizarCompra().toString();

    }
    @Test
    @DisplayName("Comprar em todas as categorias")
    public void testComprarEmTodasAsCategorias() throws AWTException {
        //Comprar em todas a categorias: Phones, Laptops e Monitores

        String ComprarEmTodasAsCategorias = new LoginCadastroPage(navegador)
                .clicaAcesso()  // Abre a tela de usuario
                .cadastroUsuario("Renato de Oliveira 161", "123456") // Informa o username e password do usuário
                .loginAcessoUsuario()
                .acessoUsuario("Renato de Oliveira 161", "123456")
                .selecionarCategoriaPhones()
                .escolherPhones()
                .addProdutoNoCarrinho()
                .voltarParaHomeDepoisDeAddProdutoNoCarrinho()
                .selecionarCategoriaLaptops()
                .escolherLaptops()
                .addProdutoNoCarrinho()
                .voltarParaHomeDepoisDeAddProdutoNoCarrinho()
                .selecionarCategoriaMonitors()
                .escolherMonitors()
                .addProdutoNoCarrinho()
                .voltarParaHomeDepoisDeAddProdutoNoCarrinho()
                .pagamentoProdutos()
                .pagamentoButton()
                .cadastroDePagamento("Renato De Oliveira "," BRASIL","São Paulo","123456789111","11","2028")
                .finalizarCompra().toString();

    }

    @Test
    @DisplayName("Clicando no botão Contact")
    public void testClicandoNoBotaoContact() throws AWTException {
        //fazer o login

        String acessarFormulario = new LoginCadastroPage(navegador)

                .loginAcessoUsuario()
                .acessoUsuario("Renato de Oliveira 130", "123456")
                .acessarContato()
                .abrirFormulario().toString();
       // public String getMensagemPagamento() {
           // return "Pagamento finalizado com sucesso";
            //org.junit.jupiter.api.Assertions.assertEquals("Pagamento finalizado com sucesso", (acessarFormulario));
            //assertEquals("Pagamento finalizado com sucesso", acessarFormulario);
       // }


       // String modal = String.valueOf(navegador.equals());
       // Assertions.assertEquals("modal fade",modal);

      // Assertions.assertFalse("Thanks for the message!!".isEmpty(), acessarFormulario );
       // System.out.println(acessarFormulario);
    }

    //@AfterEach
    //public void afterEach(){
       // navegador.quit();
    //}

    @Test
    @DisplayName("Clicando no botão About us")
    public void testClicandoNoBotaoAboutUs() throws AWTException {
        //fazer o login

        String acessarAboutUs = new LoginCadastroPage(navegador)

                .acessarAboutUs()
                .clicarnoBotaoAboutUs().toString();


        //Assertions.assertEquals("Pagamento finalizado com sucesso",acessarAboutUs );

    }
}




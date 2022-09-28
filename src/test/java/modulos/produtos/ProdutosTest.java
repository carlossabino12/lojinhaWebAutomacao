package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.AdicionarProdutosPage;
import paginas.ListaDeProdutosPage;
import paginas.LoginpPage;

import java.time.Duration;

@DisplayName("Teste Web do modulo de Produtos")
public class ProdutosTest {

    // Crianda a variavel navegar
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){

        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_105\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Vou maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo padrão de espera de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a página da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoResgistrarProdutosComValorIgualAZero(){

        // Fazer login
        String toastMensagem = new LoginpPage(navegador)
                .informarOUsario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoNovoProduto()
                .informarNomeDoProduto("MacBook Pro")
                .informarProdutoValor("000")
                .informarProdutoCores("preto, vermelho")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        // Vou validar se a mesagem de erro foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", toastMensagem);

    }

    @Test
    @DisplayName("Não é permitido resgistrar um produto com valor maior que 7.000,00 mil")
    public void testNaoEPermitidoResgistrarProdutosComValorMaiorQueSeteMil(){

        // Fazer login
        String toastMensagem = new LoginpPage(navegador)
                .informarOUsario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoNovoProduto()
                .informarNomeDoProduto("PlayStation 4")
                .informarProdutoValor("700001")
                .informarProdutoCores("branco, azul")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        // Vou validar se a mesagem de erro foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", toastMensagem);

    }

    @Test
    @DisplayName("Posso adicionar produtos com valor de valor 0,01 centavo")
    public void possoAdicionarProdutosComValoreDeUmCentavo(){

        // Fazer login
        String toastMensagem = new LoginpPage(navegador)
                .informarOUsario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoNovoProduto()
                .informarNomeDoProduto("PlayStation 5")
                .informarProdutoValor("001")
                .informarProdutoCores("Roxo, Amarelo")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        // Vou validar se a mesagem de sucesso foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso", toastMensagem);

    }

    @Test
    @DisplayName("Posso adicionar produtos com valor de 7.000,00 mil")
    public void possoAdicionarProdutosComValoreDeSeteMil(){

        // Fazer login
        String toastMensagem = new LoginpPage(navegador)
                .informarOUsario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoNovoProduto()
                .informarNomeDoProduto("PlayStation 5")
                .informarProdutoValor("700000")
                .informarProdutoCores("Roxo, Amarelo")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        // Vou validar se a mesagem de sucesso foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso", toastMensagem);

    }


    @AfterEach
    public void afterEach(){

        // Vou fechar o navegador
        navegador.quit();

    }
}

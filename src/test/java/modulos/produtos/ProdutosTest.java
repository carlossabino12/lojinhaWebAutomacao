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
        new LoginpPage(navegador)
                .informarOUsario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoNovoProduto();

        // Vou preencher as informações do produto e o valor igual a zero
        navegador.findElement(By.id("produtonome")).sendKeys("MacBook Pro");
        navegador.findElement(By.name("produtovalor")).sendKeys("000");
        navegador.findElement(By.id("produtocores")).sendKeys("vermelho,preto");

        // Vou submeter o formulário
        navegador.findElement(By.cssSelector("button[class='btn waves-effect waves-light']")).click();

        // Vou validar se a mesagem de erro foi apresentada
        String toastMensage = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", toastMensage);

    }

    @AfterEach
    public void afterEach(){

        // Vou fechar o navegador
        navegador.quit();

    }
}

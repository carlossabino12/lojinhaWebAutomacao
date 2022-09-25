package modulos.produtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Teste Web do modulo de Produtos")
public class ProdutosTest {

    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoResgistrarProdutosComValorIgualAZero(){

        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_105\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Vou maximizar a tela
        navegador.manage().window().maximize();

        // Navegar para a página da Lojinha Web
        navegador.get("http://165.227.93.41/lojinha-web/v2/");

        // Fazer login

        // Vou para a tela de registrar produto

        // Vou preencher as informações do produto e o valor igual a zero

        // Vou submeter o formulário

        // Vou validar se a mesagem de erro foi apresentada


    }

}

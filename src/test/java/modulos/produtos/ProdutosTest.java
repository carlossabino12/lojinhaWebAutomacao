package modulos.produtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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

        // Vou definir um tempo padrão de espera de 5 segundos
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a página da Lojinha Web
        navegador.get("http://165.227.93.41/lojinha-web/v2/");

        // Fazer login
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys("admin");
        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys("admin");
        navegador.findElement(By.cssSelector("button[class='btn waves-effect waves-light']")).click();

        // Vou para a tela de registrar produto
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        // Vou preencher as informações do produto e o valor igual a zero
        navegador.findElement(By.id("produtonome")).sendKeys("MacBook Pro");
        navegador.findElement(By.name("produtovalor")).sendKeys("000");
        navegador.findElement(By.id("produtocores")).sendKeys("vermelho,preto");

        // Vou submeter o formulário
        navegador.findElement(By.cssSelector("button[class='btn waves-effect waves-light']")).click();

        // Vou validar se a mesagem de erro foi apresentada
        String toastMensage = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", toastMensage);

        // Vou fechar o navegador
        navegador.quit();


    }

}

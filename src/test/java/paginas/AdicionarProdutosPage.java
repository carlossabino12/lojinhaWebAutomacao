package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdicionarProdutosPage {

    private WebDriver navegador;

    // Construtor
    public AdicionarProdutosPage(WebDriver navegador){

        this.navegador = navegador;
    }

    public AdicionarProdutosPage informarNomeDoProduto(String produtoNome){

        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);

        return this;
    }

    public AdicionarProdutosPage informarProdutoValor(String produtoValor){

        navegador.findElement(By.name("produtovalor")).sendKeys(produtoValor);

        return this;
    }

    public AdicionarProdutosPage informarProdutoCores(String produtoCores){

        navegador.findElement(By.id("produtocores")).sendKeys(produtoCores);

        return this;

    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro(){

        navegador.findElement(By.cssSelector("button[class='btn waves-effect waves-light']")).click();

        return new ListaDeProdutosPage(navegador);
    }

}

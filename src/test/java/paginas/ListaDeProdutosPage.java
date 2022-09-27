package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {

    private WebDriver navegador;

    // Construtor
    public ListaDeProdutosPage(WebDriver navegador){

        this.navegador = navegador;

    }

    public AdicionarProdutosPage acessarFormularioDeAdicaoNovoProduto(){

        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new AdicionarProdutosPage(navegador);
    }

    public String capturarMensagemApresentada(){

        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}

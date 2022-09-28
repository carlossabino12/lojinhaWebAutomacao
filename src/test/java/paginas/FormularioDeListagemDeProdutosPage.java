package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeListagemDeProdutosPage {

    private WebDriver navegador;

    // Construtor

    public FormularioDeListagemDeProdutosPage(WebDriver navegador){

        this.navegador = navegador;

    }

    public String capturarMensagemApresentada(){

        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}

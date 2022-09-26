package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginpPage {

    private WebDriver navegador;

    // Construtor
    public LoginpPage(WebDriver navegador){

        this.navegador = navegador;
    }

    public LoginpPage informarOUsario(String usuario){

        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys(usuario);

        return this;
    }

    public LoginpPage informarASenha(String senha){

        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys(senha);

        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeLogin(){

        navegador.findElement(By.cssSelector("button[class='btn waves-effect waves-light']")).click();

        return new ListaDeProdutosPage(navegador);

    }


}

package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{

    private By searchBox = By.id("search");
    private By buscar = By.className("btn-default");
    private By searchResult = By.className("product-thumb");

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    public void escribirProducto(String producto) throws InterruptedException {
        this.sendText(producto, searchBox);
        Thread.sleep(500);
        this.sendKey(Keys.ENTER, searchBox);
    }

    public void clickBuscar() throws InterruptedException {
        this.clickear(buscar);
        Thread.sleep(500);
    }

    public String obtenerResultadoBusqueda() throws InterruptedException {
        String res = this.getText(searchResult);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

}

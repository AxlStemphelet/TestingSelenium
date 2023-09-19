package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPage extends BasePage {

    private By Product = By.xpath("//div[@class='product-thumb']//div[@class='image']");

    private By btnAdd = By.xpath("//button[@id='button-cart']");

    private By Exito = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    public AddPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickProduct() throws InterruptedException {
        this.clickear(this.Product);
    }

    public void clickAdd() throws InterruptedException {
        this.clickear(this.btnAdd);
    }

    public String exito() throws InterruptedException {
        String res = this.getText(this.Exito);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    public String getAddThis() {
        return this.getText(this.Exito);
    }
}

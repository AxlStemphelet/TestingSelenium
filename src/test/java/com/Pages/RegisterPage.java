package com.Pages;


import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class RegisterPage extends BasePage {
        private By nombre = By.id("input-firstname");
        private By apellido = By.id("input-lastname");
        private By email = By.id("input-email");
        private By Telephone = By.id("input-telephone");
        private By password = By.id("input-password");
        private By repassword = By.id("input-confirm");
        private By inputPrivacyPolicy = By.name("agree");
        private By btnRegistrarse = By.className("btn-primary");
        private By btnCrearCuenta = By.linkText("Register");
        private By exito = By.id("content");

        public RegisterPage(WebDriver driver, WebDriverWait wait) {
            super(driver, wait);
        }

        public void clickCrearCuenta() throws InterruptedException {
            this.clickear(this.btnCrearCuenta);
        }

        public void escribirNombre(String name) throws InterruptedException {
            this.sendText(name, this.nombre);
        }

        public void escribirApellido(String name) throws InterruptedException {
            this.sendText(name, this.apellido);
        }

        public void escribirCorreo(String mail) throws InterruptedException {
            this.sendText(mail, this.email);
        }

        public void escribirTelefono(String numb) throws InterruptedException {
            this.sendText("123456789", this.Telephone);
        }

        public void escribirContrasena(String pass) throws InterruptedException {
            this.sendText(pass, this.password);
        }

        public void escribirRepetirContrasena(String pass) throws InterruptedException {
            this.sendText(pass, this.repassword);
        }

        public void clickPoliticas() throws InterruptedException {
            this.clickear(this.inputPrivacyPolicy);
            Thread.sleep(1000L);
        }

        public void clickRegistrarse() throws InterruptedException {
            this.clickear(this.btnRegistrarse);
            Thread.sleep(1000L);
        }

    }


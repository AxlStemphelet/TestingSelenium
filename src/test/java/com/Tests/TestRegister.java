package com.Tests;


import com.Pages.RegisterPage;
import com.Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRegister {
    public WebDriver driver;
    public WebDriverWait wait;

    ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES.html");
    ExtentReports extent;


    @BeforeEach
    public void setUp() throws InterruptedException {
        this.extent = ExtentFactory.getInstance();
        this.extent.attachReporter(new ExtentObserver[]{this.info});
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofMillis(2000L));
        RegisterPage registerPage = new RegisterPage(this.driver, this.wait);
        registerPage.setup();
        registerPage.url("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("REGISTRO")
    public void RegistroExitoso() throws InterruptedException {
        ExtentTest test = this.extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(this.driver, this.wait);
        registerPage.clickCrearCuenta();
        registerPage.escribirNombre("Sergio");
        registerPage.escribirApellido("Pace");
        registerPage.escribirCorreo("prueba00004@gmail.com");
        registerPage.escribirTelefono("02020202020");
        registerPage.escribirContrasena("123456");
        registerPage.escribirRepetirContrasena("123456");
        registerPage.clickPoliticas();
        registerPage.clickRegistrarse();
    }
    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(this.driver, this.wait);
        registerPage.close();
        this.extent.flush();
    }

}

package com.Tests;
import com.Pages.SearchPage;
import com.Reportes.ExtentFactory;

import java.time.Duration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBusqueda {

    public WebDriver driver;
    public WebDriverWait wait;

    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_BUSQUEDA.html");
    static ExtentReports extent;

    @BeforeAll
    public static void setupReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.setup();
        searchPage.url("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("BUSQUEDA")
    @Tag("SMOKE")
    public void BusquedaExitosa() throws InterruptedException {
        ExtentTest test = extent.createTest("Busqueda Exitosa Iphone");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.escribirProducto("Iphone");
        searchPage.clickBuscar();
        test.log(Status.PASS, "Realiza Busqueda en Iphone");

        String mensajeCorrecto = searchPage.obtenerResultadoBusqueda();
        assertEquals("iPhone", mensajeCorrecto);
        test.log(Status.PASS, "Validación de Busqueda Exitosa - Iphone");
    }


    @AfterEach
    public void cerrar() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.close();
    }

    @AfterAll
    public static void createReport() {
        extent.flush();
    }
}


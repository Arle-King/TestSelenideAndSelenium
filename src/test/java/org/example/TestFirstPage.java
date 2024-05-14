package org.example;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class TestFirstPage {


    /*
    @DataProvider(name = "Name")
        public Object[][] NamesItem () {
            return new Object[][] {
                    {"add-to-cart-sauce-labs-backpack"},
                    {"add-to-cart-sauce-labs-bike-light"},
                    {"add-to-cart-sauce-labs-bolt-t-shirt"},
                    {"add-to-cart-sauce-labs-fleece-jacket"},
                    {"add-to-cart-sauce-labs-onesie"},
                    {"add-to-cart-test.allthethings()-t-shirt-(red)"},
            };
        }
    */

    public void ClickItems(String name) {
        $(By.name(name)).click();
    }


    @Test
    public void test1() {
        /*
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ArleKING\\IdeaProjects\\test_maven\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
         */

        String login = "standard_user";
        String password = "secret_sauce";
        //String nameItem = "add-to-cart-sauce-labs-backpack";

        TestLoginPage lp = new TestLoginPage();
        lp.openLoginPage(login, password); //логинимся с помощью selenide


        //Находим 1й элемент и тащим из атрибутов название, описание и цену
        //using selenium
        WebDriver driver = WebDriverRunner.getWebDriver(); // <- сам додумал, где в итернетах это вообще найти?

        WebElement FirstItem  = driver.findElement(By.xpath("//div[@class= 'inventory_item_name '][1]"));
        String Name = FirstItem.getAttribute("textContent");
        FirstItem  = driver.findElement(By.xpath("//div[@class= 'inventory_item_desc'][1]"));
        String Comment = FirstItem.getAttribute("textContent");
        FirstItem  = driver.findElement(By.xpath("//div[@class= 'inventory_item_price'][1]"));
        String Price = FirstItem.getAttribute("textContent");
        System.out.println("Selenium:");
        System.out.println(Name);
        System.out.println(Comment);
        System.out.println(Price);

        driver.findElement(By.id("item_4_title_link")).click();

        //Опять работаем с selenide
        String Name2 = $(By.className("inventory_details_name")).getAttribute("textContent");
        String Comment2 = $(By.className("inventory_details_desc")).getAttribute("textContent");
        String Price2 = $(By.className("inventory_details_price")).getAttribute("textContent");

        
        System.out.println("Selenide:");
        System.out.println(Name2);
        System.out.println(Comment2);
        System.out.println(Price2);

        closeWebDriver();

        if (!Objects.equals(Name, Name2) || !Objects.equals(Comment2, Comment) || !Objects.equals(Price, Price2)) {
            System.out.println("Название, описание или цена не совпадает");
        } else {
            System.out.println("Всё ок");
        }
            //$(By.name(nameItem)).click();
        sleep(2000);

    }


}

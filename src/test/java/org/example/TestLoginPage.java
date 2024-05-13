package org.example;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class TestLoginPage {

    @DataProvider(name = "LoginInput")
        public static Object[][] NamesItem () {
            return new Object[][] {
                    {"standard_user", "secret_sauce"},
                    {"locked_out_user", "secret_sauce"},
                    {"problem_user", "secret_sauce"},
                    {"performance_glitch_user", "secret_sauce"},
                    {"error_user", "secret_sauce"},
                    {"visual_user", "secret_sauce"},
            };
    }



    @Test (dataProvider = "LoginInput")
    public void openLoginPage(String login, String password) {

        open("https://www.saucedemo.com/");

        $(By.name("user-name")).setValue(login);
        $(By.name("password")).setValue(password);
        $(By.name("login-button")).click();
    }

}

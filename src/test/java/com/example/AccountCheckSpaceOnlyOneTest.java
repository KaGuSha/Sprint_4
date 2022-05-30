package com.example;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static java.lang.String.format;

@RunWith(Parameterized.class)
public class AccountCheckSpaceOnlyOneTest {
    private String name;
    private boolean expected;
    private Account account;

    public AccountCheckSpaceOnlyOneTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][]{
                {"Space Between", true},
                {" ", true},
                {" Start", true},
                {"End ", true},
                {"", false},
                {"Between  two", false},
                {"Between two space", false},
                {"   MoreThan1SpaceStart", false},
                {"MoreThan1SpaceEnd   ", false},
                {"More Than 1Space  Between", false},
        };
    }

    @Before
    public void setUp() {
        account = new Account(name);
    }

    @Test
    @DisplayName("Проверка метода checkSpaceOnlyOne()")
    @Description("Метод checkSpaceOnlyOne() возвращает true, если в поле есть только 1 пробел, в остальных случаях возвращает false. Ожидаемое значение передается в поле expected")
    public void checkSpaceOnlyOne() {
        boolean actual = account.checkSpaceOnlyOne(name);

        String message = format("Актуальное значение отличается от ожидаемого значения. %nАктуальное значение: %s %nОжидаемое значение:%s %nТестовая строка: \"%s\"%n", actual, expected, account.getName());
        Assert.assertEquals(message, expected, actual);
    }
}

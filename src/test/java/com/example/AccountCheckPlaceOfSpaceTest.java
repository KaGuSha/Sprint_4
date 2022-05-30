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
public class AccountCheckPlaceOfSpaceTest {
    private String name;
    private boolean expectedSpacePlace;
    private Account account;

    public AccountCheckPlaceOfSpaceTest(String name, boolean expectedSpacePlace) {
        this.name = name;
        this.expectedSpacePlace = expectedSpacePlace;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][]{
                {"WithoutSpace", true},
                {"Space Between", true},
                {"Between  two", true},
                {"More Than 1Space  Between", true},
                {" ", false},
                {"", true},
                {" Start", false},
                {"End ", false},
                {"   MoreThan1Space Start", false},
                {"MoreThan1Space End   ", false},
        };
    }

    @Before
    public void setUp() {
        account = new Account(name);
    }

    @Test
    @DisplayName("Проверка метода checkPlaceOfSpace()")
    @Description("Метод checkSpaceOnlyOne() возвращает true, если пробел находится не в начале или не в конце, в остальных случаях возвращает false. Ожидаемое значение передается в поле expectedSpacePlace")
    public void checkPlaceOfSpace() {
        boolean actual = account.checkPlaceOfSpace(name);

        String message = format("Актуальное значение отличается от ожидаемого значения. %nАктуальное значение: %s %nОжидаемое значение:%s %nТестовая строка: \"%s\"%n", actual, expectedSpacePlace, account.getName());
        Assert.assertEquals(message, expectedSpacePlace, actual);
    }
}

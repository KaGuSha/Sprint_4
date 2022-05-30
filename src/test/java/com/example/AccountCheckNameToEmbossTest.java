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
public class AccountCheckNameToEmbossTest {

    private final String name;
    private final boolean expected;
    private Account account;

    public AccountCheckNameToEmbossTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][]{
                {"Ю Я", true}, //
                {"Ю Ли", true},
                {"Александра Павлова", true},
                {"Девятнадцат символо", true},
                {"Эрих-МAРИЯ Ремарк", true},
                {"", false},
                {" ", false},
                {"    ", false},
                {"Лина", false},
                {"Ли", false},
                {" Девятнадцатьсимвол", false},
                {"Восемнадцатьсимвол", false},
                {"Александра Александрова", false},
                {"Двадцатьсимволов    ", false},
                {" Павел Александров", false},
                {"Павел Александров ", false},
                {" ПавелАлекcандров ", false},
                {"Ян  Ли", false},
                {"Эрих Мария Ремарк", false},
        };
    }

    @Before
    public void setUp() {
        account = new Account(name);
    }

    @Test
    @DisplayName("Проверка метода checkNameToEmboss()")
    @Description("Возвращается true, если у методов checkLengthName(),checkSpaceOnlyOne(), checkPlaceOfSpace() результат true.")
    public void checkNameToEmboss() {
        boolean actual = account.checkNameToEmboss();

        String message = format("Актуальное значение отличается от ожидаемого значения. %nАктуальное значение: %s %nОжидаемое значение:%s %nТестовая строка: \"%s\"%n", actual, expected, account.getName());
        Assert.assertEquals(message, expected, actual);
    }
}

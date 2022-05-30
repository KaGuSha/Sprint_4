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
public class AccountCheckNameLengthTest {
    private final String name;
    private final boolean expected;
    private Account account;


    public AccountCheckNameLengthTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {

        return new Object[][]{
                {"Сон", true},
                {"Девятнадцатьсимволо", true},
                {"Обычный текст", true},
                {"John Snow", true},
                {"Ли", false},
                {"Двадцать символов   ", false},
                {"Виктория Аделаида Мария Луиза Великобританская", false},
                {"", false},
        };
    }

    @Before
    public void setUp() {
        account = new Account(name);
    }

    @Test
    @DisplayName("Проверка метода checkNameLength()")
    @Description("Метод checkLengthName() возвращает true, если длина строки не меньше 3 символов и не больше 19 символов, в остальных случаях false.")
    public void checkNameToEmboss() {
        boolean actual = account.checkNameLength(name);

        String message = format("Актуальное значение отличается от ожидаемого значения. %nАктуальное значение: %s %nОжидаемое значение:%s %nТестовая строка: \"%s\"%n", actual, expected, account.getName());
        Assert.assertEquals(message, expected, actual);
    }
}

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
public class AccountTest {

    private final String name;
    private final boolean expectedLength;
    private final boolean expectedSpace1;
    private final boolean expectedSpacePlace;
    private final boolean expectedToEmboss;
    private Account account;

    public AccountTest(String name, boolean expectedLength, boolean expectedSpace1, boolean expectedSpacePlace, boolean expectedToEmboss) {
        this.name = name;
        this.expectedLength = expectedLength;
        this.expectedSpace1 = expectedSpace1;
        this.expectedSpacePlace = expectedSpacePlace;
        this.expectedToEmboss = expectedToEmboss;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][]{
                {"Ю Я", true, true, true, true},
                {"Ю Ли", true, true, true, true},
                {"Александра Павлова", true, true, true, true},
                {"Девятнадцат символо", true, true, true, true},
                {"Эрих-МAРИЯ Ремарк", true, true, true, true},
                {"Лина", true, false, true, false},
                {"Ли", false, false, true, false},
                {" Девятнадцатьсимвол", true, true, false, false},
                {"Восемнадцатьсимвол", true, false, true, false},
                {"Александра Александрова", false, true, true, false},
                {"", false, false, true, false},
                {" ", false, true, false, false},
                {"    ", true, false, false, false},
                {"Двадцатьсимволов    ", false, false, false, false},
                {" Павел Александров", true, false, false, false},
                {"Павел Александров ", true, false, false, false},
                {"Ян  Ли", true, false, true, false},
                {"Эрих Мария Ремарк", true, false, true, false},
        };
    }

    @Before
    public void setUp() {
        account = new Account(name);
    }

    @Test
    @DisplayName("Проверка метода checkLengthName()")
    @Description("Метод checkLengthName() возвращает true, если длина поля не меньше 3 и не больше 19 символов, в остальных случаях false. Ожидаемое значение передается в поле expectedLength")
    public void checkLengthName() {
        boolean actual = account.checkLengthName(name);

        String message = format("Актуальное значение отличается от ожидаемого значения. %nАктуальное значение: %s %nОжидаемое значение:%s %nТестовая строка: %s%n", actual, expectedLength, account.getName());
        Assert.assertEquals(message, expectedLength, actual);
    }

    @Test
    @DisplayName("Проверка метода checkSpaceOnlyOne()")
    @Description("Метод checkSpaceOnlyOne() возвращает true, если в поле есть только 1 пробел, в остальных случаях возвращает false. Ожидаемое значение передается в поле expectedSpace1")
    public void checkSpaceOnlyOne() {
        boolean actual = account.checkSpaceOnlyOne(name);

        String message = format("Актуальное значение отличается от ожидаемого значения. %nАктуальное значение: %s %nОжидаемое значение:%s %nТестовая строка: %s%n", actual, expectedSpace1, account.getName());
        Assert.assertEquals(message, expectedSpace1, actual);
    }

    @Test
    @DisplayName("Проверка метода checkPlaceOfSpace()")
    @Description("Метод checkSpaceOnlyOne() возвращает true, если пробел находится не в начале или не в конце, в остальных случаях возвращает false.Ожидаемое значение передается в поле expectedSpacePlace")
    public void checkPlaceOfSpace() {
        boolean actual = account.checkPlaceOfSpace(name);

        String message = format("Актуальное значение отличается от ожидаемого значения. %nАктуальное значение: %s %nОжидаемое значение:%s %nТестовая строка: %s%n", actual, expectedSpacePlace, account.getName());
        Assert.assertEquals(message, expectedSpacePlace, actual);
    }

    @Test
    @DisplayName("Проверка метода checkNameToEmboss()")
    @Description("Возвращается true, если у методов checkLengthName(),checkSpaceOnlyOne(), checkPlaceOfSpace() результат true. Ожидаемое значение передается в поле expectedToEmboss")
    public void checkNameToEmboss() {
        boolean actual = account.checkNameToEmboss();

        String message = format("Актуальное значение отличается от ожидаемого значения. %nАктуальное значение: %s %nОжидаемое значение:%s %nТестовая строка: %s%n", actual, expectedToEmboss, account.getName());
        Assert.assertEquals(message, expectedToEmboss, actual);
    }
}

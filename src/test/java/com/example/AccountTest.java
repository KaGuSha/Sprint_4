package com.example;

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
                {"Ю я", true, true, true, true},
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
    public void checkLengthName() {
        boolean actual = account.checkLengthName(name);

        Assert.assertEquals(format("Результат %s отличается от ожидаемого значения. Ожидаемое значение: %s", actual, expectedLength), expectedLength, actual);
    }

    @Test
    public void checkSpaceOnlyOne() {
        boolean actual = account.checkSpaceOnlyOne(name);

        Assert.assertEquals(format("Результат %s отличается от ожидаемого значения. Ожидаемое значение: %s", actual, expectedSpace1), expectedSpace1, actual);
    }

    @Test
    public void checkPlaceOfSpace() {
        boolean actual = account.checkPlaceOfSpace(name);

        Assert.assertEquals(format("Результат %s отличается от ожидаемого значения. Ожидаемое значение: %s", actual, expectedSpacePlace), expectedSpacePlace, actual);
    }

    @Test
    public void checkNameToEmboss() {
        boolean actual = account.checkNameToEmboss();

        Assert.assertEquals(format("Результат %s отличается от ожидаемого значения. Ожидаемое значение: %s", actual, expectedToEmboss), expectedToEmboss, actual);
    }

}

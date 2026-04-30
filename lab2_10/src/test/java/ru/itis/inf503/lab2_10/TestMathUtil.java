package ru.itis.inf503.lab2_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestMathUtil {

    @Test
    public void testSum() {
        Assertions.assertEquals(2, MathUtil.sum(1,1));
    }

    @ParameterizedTest
    // @CsvFileSource(files = "test_data.csv")
    @CsvSource({
            "5,    5,   10", // 1-й набор аргументов
            "1,    2,   3", // 2-й набор аргументов
            "49,  51, 100",  // 3-й набор аргументов
            "1,  100, 101"  // 4-й набор аргументов
    }) // порядок аргументов в сигнатуре должен соответсвовать набору данных
    public void testDivide(int expected, int a, int b) {
        Assertions.assertEquals(expected, MathUtil.divide(a,b));
    }
}

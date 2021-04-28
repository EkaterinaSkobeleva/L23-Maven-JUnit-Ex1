import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        /* подготавливаем данные: */
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 100_000_000;//1_000_000_60;
        boolean registered = false;
        long expected = 500; //оно и ожидается (10 000 получаем, которые меняем на 500)

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 50_000;//
        boolean registered = false;
        long expected = 5; //ожидается 5

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnRegisteredAndAmountHas4SignificantDigits() {
        //результат вычисления service.calculate(amount, registered)
        //- целое положительно число, округленное в меньшую сторону
        // при входном параметре amount, имеющим меньше 4 значащих цифры,
        // результат service.calculate(amount, registered) всегда будет 0,
        //в переменной long bonus будет лежать 0, т.к. правая часть выражения получится дробной

        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 5000;//
        boolean registered = false;
        long expected = 0; //ожидается 0

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndAmountHas4SignificantDigits() {
        //результат вычисления service.calculate(amount, registered)
        //- целое положительно число, округленное в меньшую сторону
        // при входном параметре amount, имеющим меньше 3 значащих цифр,
        // результат service.calculate(amount, registered) всегда будет 0,
        //в переменной long bonus будет лежать 0, т.к. правая часть выражения получится дробной

        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 499;//
        boolean registered = true;
        long expected = 0; //ожидается 0

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

}
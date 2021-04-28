public class Main {
    public static void main(String[] args) {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount =5000; //1000_60;
        boolean registered = false; //true;
        long expected = 5;//30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        System.out.println(actual);
        // производим проверку (сравниваем ожидаемый и фактический):
        // если true - то PASS
        // если false - то FAIL
        boolean passed = expected == actual;

        // выводим результат
        System.out.println(passed);
    }
}
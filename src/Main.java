import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        //  Функциональные интерфейсы и лямбда-выражения
        //  Задание 1  Написать Predicate, который проверяет, является ли число положительным.
        Predicate<Integer> isPositive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer > 0) return true;
                return false;
            }
        };

        Predicate<Integer> isPositiveLambda = integer -> integer > 0;

        System.out.println(isPositive.test(11) + " " + isPositiveLambda.test(-5));


        // Задание 2 Создать Consumer, который будет принимать на вход имя человека
        // и выводить в консоль его приветствие.
        Consumer<String> nameOut = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет " + s);
            }
        };

        Consumer<String> nameOutLambda = s -> System.out.println("Привет " + s);

        nameOut.accept("Петя");
        nameOutLambda.accept("Вася");


        //  Задание 3 Реализовать функциональный интерфейс Function,
        //  который принимает на вход вещественное число типа Double,
        //  а возвращает его округленный вариант типа Long.
        Function<Double, Long> doubleToLong = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        //Function<Double,Long> doubleToLongLambda = Math::round;   // idea предложила
        Function<Double, Long> doubleToLongLambda = x -> Math.round(x);

        System.out.println(doubleToLong.apply(12.12) + " " + doubleToLongLambda.apply(33.22));


        //  Задание 4 Написать Supplier, который будет возвращать случайное число от 0 до 100.
        Supplier<Integer> random100 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };

        Supplier<Integer> random100Lambda = () -> (int) (Math.random() * 100);

        System.out.println(random100.get() + " " + random100Lambda.get());

        //Задание 5
        // построим следующую комбинацию - дан предикат condition и две функции ifTrue и ifFalse.
        // Напишите метод ternaryOperator, который из них построит новую функцию,
        // возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.

        // Function <Integer, String> functionTrue = integer -> " число "+ integer + " положительное";  // idea предложила
        Function<Integer, String> functionTrue = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return " число " + integer + " положительное";
            }
        };

        //Function <Integer, String> functionFalse = integer -> " число "+ integer + " положительное"; // idea предложила
        Function<Integer, String> functionFalse = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return " число " + integer + " отрицательное";
            }
        };


        int positiveInt = 3;
        int negativeInt = -2;

        System.out.println(ternaryOperator(isPositive, functionTrue, functionFalse).apply(positiveInt));
        System.out.println(ternaryOperator(isPositive, functionTrue, functionFalse).apply(negativeInt));
    }


    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition,
                                                        Function<? super T, ? extends U> ifTrue,
                                                        Function<? super T, ? extends U> ifFalse) {

        // вариант лямбда
//    return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);

        // вариант без if
//        return new Function<T, U>() {
//            @Override
//            public U apply(T x) {
//                return condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
//            }
//        };

        // вариант c if
        final Function<T, U> ternaryResult = new Function<T, U>() {
            @Override
            public U apply(T negativeOrPositiveInt) {

                if (condition.test(negativeOrPositiveInt))
                    return ifTrue.apply(negativeOrPositiveInt);
                else return ifFalse.apply(negativeOrPositiveInt);
            }

        };

        return ternaryResult;
    }
}






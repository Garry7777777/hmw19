import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        // Задание 1
        Predicate<Integer> pos = new Predicate<Integer>() {
           @Override
            public boolean test(Integer integer) {
                if(integer> 0) return true;
                return false;
            }
        };


        Predicate<Integer> posi = integer -> {
            if(integer> 0) return true;
            return false;
        };

        System.out.println(pos.test(11) + " " + posi.test( -5));


        // Задание 2

        Consumer<String> name = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println( "Привет" + s);
            }
        };

        Consumer<String> nam = s -> System.out.println( "Привет" + s);

       nam.accept("Петя"); name.accept("Вася");

        //  Задание 3

        Function<Double,Long> dToL = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return  Math.round(aDouble);
            }
        };

        Function<Double,Long> dTooL = aDouble -> Math.round(aDouble);

        System.out.println(dToL.apply(12.12) + " " + dTooL.apply(33.22));
    }

    //  Задание 4

    Supplier<Integer> rand = new Supplier<Integer>() {
        @Override
        public Integer get() {
            return (Math.random()*100) ;
        }
    }
}
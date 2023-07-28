import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        example1Test();
//        example2Test();
//        example3Test();
//        example4Test();
        example5Test();

    }



    public static void example1Test(){
        Example1 example1 = new Example1();
        List<String> list = new ArrayList<>();
        list.add("Dima");
        list.add("Alex");
        list.add("Sasha");
        list.add("Dasha");
        list.add("Max");
        list.add("Peter");
        System.out.println(example1.returnStringNameFromList(list));
    }
    public static void example2Test(){
        Example2 example2 = new Example2();
        List<String> list = new ArrayList<>();
        list.add("Dima");
        list.add("Alex");
        list.add("Sasha");
        list.add("Dasha");
        list.add("Max");
        list.add("Peter");
        System.out.println(example2.sortedListByZToAMethod(list));
    }
    public static void example3Test(){
        Example3 example3 = new Example3();
        String[] arr = {"1, 2, 0", "4, 5"};
        System.out.println(example3.updateArray(arr));
    }
    public static void example4Test(){
        Example4 example4 = new Example4();

        example4.printStream();
    }
    private static void example5Test() {
        Example5 example5 = new Example5();

        Stream<String> stream1 = Stream.of("Dima","Dasha","Sasha","Denis");
        Stream<String> stream2 = Stream.of("Max","Peter","Jean","John");

        example5.zip(stream1,stream2).forEach(System.out::println);
    }
}
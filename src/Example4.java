import java.util.stream.Stream;

public class Example4 {
    private long a,c,m;

    public Example4(){
        this.a = 25214903917L;
        this.c = 11l;
        this.m = 2^48;
    }

    public void printStream(){

        Stream<Long> randStream = generateRandStream();

        randStream.limit(10).forEach(System.out::println);
    }
    private Stream<Long> generateRandStream(){
        long seed = System.currentTimeMillis();

        return Stream.iterate(seed,x -> (a * x + c) % m);
    }
}

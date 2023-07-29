import java.util.Iterator;
import java.util.stream.Stream;


public class Example5 {
    public <T> Stream<T> zip(Stream<T> first, Stream<T> second){

        Stream.Builder<T> builder = Stream.builder();

        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        while(firstIterator.hasNext() || secondIterator.hasNext()){
            if (firstIterator.hasNext()){
                builder.add(firstIterator.next());
            }
            if (secondIterator.hasNext()){
                builder.add(secondIterator.next());
            }
        }
        return builder.build();
    }
}

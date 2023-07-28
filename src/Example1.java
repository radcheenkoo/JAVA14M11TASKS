import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example1 {
    public String returnStringNameFromList(List<String> list){
        return IntStream.range(0, list.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + list.get(i))
                .collect(Collectors.joining(", "));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example3 {
    public String updateArray(String[] arr){

        String res = Arrays.stream(arr).flatMap(str -> Arrays.stream(str.split(",\\s*")))
                .mapToInt(Integer::parseInt)
                .sorted().mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        return res;
    }

}

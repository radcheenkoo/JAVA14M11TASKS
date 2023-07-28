import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


public class Example2 {
    public List<String> sortedListByZToAMethod(List<String> list){

        Stream<String> res = list.stream().map(str -> str.toUpperCase())
                .sorted(Collections.reverseOrder());

        return res.toList();
    }
}


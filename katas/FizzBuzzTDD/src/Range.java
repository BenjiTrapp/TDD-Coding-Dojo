package src;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Range {

    private static final int COMPENSATE_START_AT_ZERO = 1;

    public static List<Integer> range(int start, int end){
        assert start >= 1;
        assert end >= 1;

        return IntStream.range(start,end + COMPENSATE_START_AT_ZERO)
                        .boxed()
                        .collect(Collectors.toList());
    }
}

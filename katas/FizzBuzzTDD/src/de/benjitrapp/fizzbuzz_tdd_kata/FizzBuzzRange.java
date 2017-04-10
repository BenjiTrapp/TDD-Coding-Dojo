package de.benjitrapp.fizzbuzz_tdd_kata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FizzBuzzRange {

    private static final int COMPENSATE_START_AT_ZERO = 1;

    static List<Integer> range(int start, int end){
        assert start >= 1;
        assert end >= 1;

        return IntStream.range(start,end + COMPENSATE_START_AT_ZERO)
                        .boxed()
                        .collect(Collectors.toList());
    }
}

<<<<<<< Updated upstream:katas/FizzBuzzTDD/src/de/benjitrapp/fizzbuzz_tdd_kata/FizzBuzz.java
package de.benjitrapp.fizzbuzz_tdd_kata;

=======
>>>>>>> Stashed changes:katas/FizzBuzzTDD/src/FizzBuzz.java
import java.util.ArrayList;
import java.util.List;


public class FizzBuzz {

    private ArrayList<FizzBuzzFilter> filters = new ArrayList<>();

    public FizzBuzz addFilter(FizzBuzzFilter fizzBuzzFilter) {
        filters.add(fizzBuzzFilter);
        return this;
    }

    public List<String> filter(List<Integer> integers) {
        ArrayList<String> result = new ArrayList<>();

        integers.forEach(integer -> result.add(convert(integer)));

        return result;
    }

    private String convert(int integer) {
        assert integer  > 0;

        String converted = applyFilters(integer);

        return "".equals(converted) ? Integer.toString(integer) : converted;
    }

    private String applyFilters(int integer) {
        assert integer  > 0;

        StringBuilder converted = new StringBuilder();
        filters.forEach(fizzBuzzFilter -> converted.append(fizzBuzzFilter.filter(integer)));

        return converted.toString();
    }
}

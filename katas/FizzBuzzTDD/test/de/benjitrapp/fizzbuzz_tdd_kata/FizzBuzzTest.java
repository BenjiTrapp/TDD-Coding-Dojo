package de.benjitrapp.fizzbuzz_tdd_kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    private static final List<String> FIZZ_CHECK                = singletonList("Fizz");
    private static final List<String> BUZZ_CHECK                = singletonList("Buzz");
    private static final List<String> FIZZBUZZ_CHECK            = singletonList("FizzBuzz");
    private static final List<String> RANGE_FROM_2_TO_FIZZ      = asList("2", "Fizz");
    private static final List<String> RANGE_FROM_1_TO_2         = asList("1", "2");
    private static final List<String> FIZZ_7_8_FIZZ             = asList("Fizz", "7", "8", "Fizz");
    private static final List<String> FROM_FIZZBUZZ_TO_FIZZBUZZ = asList("FizzBuzz", "16", "17", "Fizz", "19",
                                                                              "Buzz", "Fizz", "22", "Fizz", "Fizz",
                                                                              "Buzz", "26", "Fizz", "28", "29",
                                                                              "FizzBuzz");
    private static final List<String> RANGE_FROM_30_TO_39       = asList("FizzBuzz", "Fizz", "Fizz", "Fizz",
                                                                              "Fizz", "FizzBuzz", "Fizz", "Fizz",
                                                                              "Fizz", "Fizz");
    private static final List<String> RANGE_FROM_50_TO_59       = asList("Buzz", "FizzBuzz", "Buzz", "FizzBuzz",
                                                                              "FizzBuzz", "Buzz", "Buzz", "FizzBuzz",
                                                                              "Buzz", "Buzz");
    private FizzBuzz fizzBuzz = new FizzBuzz();

    @BeforeEach
    void addFilters() {
        // given
        fizzBuzz.addFilter(integer -> (integer % 3 == 0) || Integer.toString(integer).contains("3") ? "Fizz" : "")
                .addFilter(integer -> (integer % 5 == 0) || Integer.toString(integer).contains("5") ? "Buzz" : "");
    }

    @Test
    void shouldReturn1And2AsNumbers() throws Exception {
        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(1, 2));

        // then
        assertArrayEquals(RANGE_FROM_1_TO_2.toArray(), result.toArray());
    }

    @Test
    void shouldConvertThreeToFizz() throws Exception {
        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(2, 3));

        // then
        assertArrayEquals(RANGE_FROM_2_TO_FIZZ.toArray(), result.toArray());
    }

    @Test
    void shouldConvert6And9ToFizz() throws Exception {
        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(6, 9));

        // then
        assertArrayEquals(FIZZ_7_8_FIZZ.toArray(), result.toArray());
    }

    @Test
    void shouldConvert9ToFizz() throws Exception {
        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(9, 9));

        // then
        assertArrayEquals(FIZZ_CHECK.toArray(), result.toArray());
    }

    @Test
    void shouldConvert5ToBuzz() throws Exception {
        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(5, 5));

        // then
        assertArrayEquals(BUZZ_CHECK.toArray(), result.toArray());
    }

    @Test
    void shouldConvert60ToFizzBuzz() throws Exception {
        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(60, 60));

        // then
        assertArrayEquals(FIZZBUZZ_CHECK.toArray(), result.toArray());
    }

    @Test
    void shouldConvert15To30Correctly() throws Exception {
        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(15, 30));

        // then
        assertArrayEquals(FROM_FIZZBUZZ_TO_FIZZBUZZ.toArray(), result.toArray());
    }

    @Test
    void shouldHaveCorrectCountsOfFizzBuzzAndFizzBuzzInRangeFrom1to100(){
        // given
        final int INIT_VALUE = 0;
        final int EXPECTED_FIZZ_CNT = 34;
        final int EXPECTED_BUZZ_CNT = 17;
        final int EXPECTED_FIZZBUZZ_CNT = 11;
        AtomicInteger fizz = new AtomicInteger(INIT_VALUE);
        AtomicInteger buzz = new AtomicInteger(INIT_VALUE);
        AtomicInteger fizzbuzz = new AtomicInteger(INIT_VALUE);

        // when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(1, 100));

        result.forEach(s -> {
            switch (s) {
                case "Fizz":     fizz.getAndIncrement();
                                 break;
                case "Buzz":     buzz.getAndIncrement();
                                 break;
                case "FizzBuzz": fizzbuzz.getAndIncrement();
                                 break;
            }});

        // then
        assertAll(
                () -> assertEquals(EXPECTED_FIZZ_CNT, fizz.get()),
                () -> assertEquals(EXPECTED_BUZZ_CNT, buzz.get()),
                () -> assertEquals(EXPECTED_FIZZBUZZ_CNT, fizzbuzz.get())
        );
    }
    @Test
    void shouldBeFizzBuzzInsteadOf53DueToBothORCasesInExtension() {
        // given
        String expected = "FizzBuzz";

        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(53, 53));

        // then
        assertTrue(result.size() == 1);
        assertEquals(expected, result.get(0));
    }

    @Test
    void shouldBeFizzOrFizzBuzzInRangeFrom30To39() {
        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(30, 39));

        // then
        assertArrayEquals(RANGE_FROM_30_TO_39.toArray(), result.toArray());
    }

    @Test
    void shouldBeBuzzOrFizzBuzzInRangeFrom50To59() {
        //when
        List<String> result = fizzBuzz.filter(FizzBuzzRange.range(50, 59));

        // then
        assertArrayEquals(RANGE_FROM_50_TO_59.toArray(), result.toArray());
    }
}
package test;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;
import static src.Range.*;

class RangeTest {

    @Test
    void shouldGiveCorrectRangeBackFrom1to10(){
        // given
        final int START = 1;
        final int END = 10;
        final int EXPECTED_AMOUNT = 10;

        // when
        List<Integer> result = range(START,END);

        // then
        assertEquals(EXPECTED_AMOUNT, result.size());
    }

    @Test
    void shouldGiveCorrectCountInRangeBack(){
        // given
        final int START = 5;
        final int END = 40;
        AtomicInteger expected = new AtomicInteger(START);
        // when
        List<Integer> result = range(START,END);

        // then
        result.forEach(integer -> assertEquals( Optional.of(expected.getAndIncrement()) , Optional.of(integer)));
    }

    @Test
    void shouldFailWhenStartIsNegative(){
        // given
        final int START = -1;
        final int END = 42;

        // when - then an AssertionException is assumed to appear
        assertThrows(AssertionError.class, () -> {range(START,END);});
    }

    @Test
    void shouldFailWhenStartIsZero(){
        // given
        final int START = 0;
        final int END = 42;

        // when - then an AssertionException is assumed to appear
        assertThrows(AssertionError.class, () -> {range(START,END);});
    }

    @Test
    void shouldFailWhenEndIsNegative(){
        // given
        final int START = 1;
        final int END = -42;

        // when - then an AssertionException is assumed to appear
        assertThrows(AssertionError.class, () -> {range(START,END);});
    }

    @Test
    void shouldFailWhenEndIsZero(){
        // given
        final int START = 1;
        final int END = 0;

        // when - then an AssertionException is assumed to appear
        assertThrows(AssertionError.class, () -> {range(START,END);});
    }

    @Test
    void shouldBeAbleToStartAndEndWith1(){
        // given
        // given
        final int START = 1;
        final int END = 1;

        // when
        List<Integer> result = range(START,END);

        // then
        assertEquals(result.size(), 1);
    }
}
package dev.effective.java.chapter2.item5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator{

    @Override
    public List<Integer> generate() {
        return IntStream.rangeClosed(0, 45).boxed().collect(Collectors.toList());
    }
}

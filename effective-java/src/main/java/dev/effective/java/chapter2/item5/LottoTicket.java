package dev.effective.java.chapter2.item5;

import java.util.ArrayList;
import java.util.List;
import lombok.ToString;

@ToString
public class LottoTicket {

    private List<Integer> numbers = new ArrayList<>();

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }
}

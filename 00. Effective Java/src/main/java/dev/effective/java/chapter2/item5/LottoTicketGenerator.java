package dev.effective.java.chapter2.item5;

import java.util.function.Supplier;

public class LottoTicketGenerator {
    // #1
//    private final NumberGenerator generator = new RandomNumberGenerator();
//
//    public LottoTicket generate() {
//        return new LottoTicket(generator.generate());
//    }

    // #2
//    private NumberGenerator generator = new RandomNumberGenerator();
//
//    public LottoTicket generate() {
//        return new LottoTicket(generator.generate());
//    }
//
//    public void changeGenerator(NumberGenerator generator) {
//        this.generator = generator;
//    }

    // #3
//    private final NumberGenerator generator;
//
//    public LottoTicketGenerator(final NumberGenerator generator) {
//        this.generator = Objects.requireNonNull(generator);
//    }
//
//    public LottoTicket generate() {
//        return new LottoTicket(generator.generate());
//    }

    private final NumberGenerator numberGenerator;

    public LottoTicketGenerator(Supplier<? extends NumberGenerator> numberGenerator) {
        this.numberGenerator = numberGenerator.get();
    }
}

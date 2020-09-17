package dev.effective.java.chapter1.item2;

public class Item2 {

    private final String name;
    private final String email;
    private final String option1;
    private final String option2;

    public static class Builder {

        private final String name;
        private final String email;
        private String option1 = "";
        private String option2 = "";

        public Builder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public Builder option1(String option1) {
            this.option1 = option1;
            return this;
        }

        public Builder option2(String option2) {
            this.option2 = option2;
            return this;
        }

        public Item2 build() {
            return new Item2(this);
        }
    }

    private Item2(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.option1 = builder.option1;
        this.option2 = builder.option2;
    }

    Item2 item2 = new Builder("henry", "henry@mail.com")
        .option1("option1")
        .option2("option2")
        .build();
}

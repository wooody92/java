package dev.effective.java.chapter2.item2;

public class TelescopingConstructor {

    private String name;
    private String email;
    private String option1;
    private String option2;

    public TelescopingConstructor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public TelescopingConstructor(String name, String email, String option1) {
        this.name = name;
        this.email = email;
        this.option1 = option1;
    }

    public TelescopingConstructor(String name, String email, String option1, String option2) {
        this.name = name;
        this.email = email;
        this.option1 = option1;
        this.option2 = option2;
    }
}

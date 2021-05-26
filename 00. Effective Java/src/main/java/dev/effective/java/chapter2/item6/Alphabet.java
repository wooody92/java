package dev.effective.java.chapter2.item6;

import java.util.regex.Pattern;

public class Alphabet {

    private static final Pattern ALPHABET = Pattern.compile("[a-zA-Z]*$");

    static boolean isAlphabet(String s) {
        return ALPHABET.matcher(s).matches();
    }
}

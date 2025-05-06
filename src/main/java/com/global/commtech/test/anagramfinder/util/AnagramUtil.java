package com.global.commtech.test.anagramfinder.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AnagramUtil {

    public String sortCharacters(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}

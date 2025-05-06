package com.global.commtech.test.anagramfinder.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AnagramUtil {

    public void printAnagramGroups(Map<String, List<String>> groups) {

        for (List<String> group : groups.values()) {
            System.out.println(String.join(",", group));
        }
    }

    public String sortCharacters(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}

package com.global.commtech.test.anagramfinder.util;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class OutputWriter {

    public void printAnagramGroups(Map<String, List<String>> groups) {

        for (List<String> group : groups.values()) {
            System.out.println(String.join(",", group));
        }
    }
}

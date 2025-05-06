package com.global.commtech.test.anagramfinder;


import com.global.commtech.test.anagramfinder.util.AnagramUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AnagramService {

    private final AnagramUtil util;

    public void processFileByWordLength(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Map<String, List<String>> groups = new LinkedHashMap<>();
            int currentLength = -1;

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                int length = line.length();
                if (currentLength != -1 && length != currentLength) {
                    util.printAnagramGroups(groups);
                    groups.clear();
                }

                String key = util.sortCharacters(line);
                groups.computeIfAbsent(key, k -> new ArrayList<>()).add(line);
                currentLength = length;
            }

            if (!groups.isEmpty()) {
                util.printAnagramGroups(groups);
            }
        }
    }


}


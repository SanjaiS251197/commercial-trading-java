package com.global.commtech.test.anagramfinder;


import com.global.commtech.test.anagramfinder.util.AnagramUtil;
import com.global.commtech.test.anagramfinder.util.OutputWriter;
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
    private final OutputWriter opWriter;

    public void processFileByWordLength(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Map<String, List<String>> groups = new LinkedHashMap<>();
            int currentLength = -1;

            String currentWord;
            while ((currentWord = reader.readLine()) != null) {
                currentWord = currentWord.trim();
                if (currentWord.isEmpty()) continue;

                int length = currentWord.length();
                if (currentLength != -1 && length != currentLength) {
                    opWriter.printAnagramGroups(groups);
                    groups.clear();
                }

                String key = util.sortCharacters(currentWord);
                groups.computeIfAbsent(key, k -> new ArrayList<>()).add(currentWord);
                currentLength = length;
            }

            if (!groups.isEmpty()) {
                opWriter.printAnagramGroups(groups);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


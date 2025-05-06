package com.global.commtech.test.anagramfinder;
import com.global.commtech.test.anagramfinder.util.AnagramUtil;
import com.global.commtech.test.anagramfinder.util.OutputWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class AnagramServiceTest {


    @Mock
    private AnagramUtil anagramUtil;

    @Mock
    private OutputWriter opWriter;

    @InjectMocks
    private AnagramService anagramService;

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessFileByWordLength() throws IOException {
        // Arrange
        File testFile = new File("sample.txt");

        // Act
        anagramService.processFileByWordLength(testFile);

        // Assert
        verify(opWriter, times(2)).printAnagramGroups(anyMap());
    }


    @Test
    void testProcessEmptyFile() throws IOException{
        //Arrange
        File testFile = new File("empty.txt");

        // Act
        anagramService.processFileByWordLength(testFile);

        // Assert
        verify(opWriter, never()).printAnagramGroups(anyMap());
    }

}
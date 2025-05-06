# Anagram Finder
This application reads a file containing one word per line and groups together words that are anagrams. Each group of anagrams is printed on a new line, with words separated by commas. It processes words by their length to support large files that may not fit entirely in memory.

## Software required to run this
* Java 17

## Building and Running the tests
```
./gradlew clean build
```

## Running the program
```
./gradlew bootRun --args="example2.txt" 
```
where example2.txt is the text file that we want to search for anagrams

## ⏱ Big O Analysis

**Time Complexity:**

- Sorting characters of a word: `O(n log n)`
- Processing `w` words of the same length: `O(w * n log n)`
- **Overall:** Efficient due to batch processing by word length

**Space Complexity:**

- `O(w)` per batch of words with the same length
- Memory usage remains bounded and does not depend on total file size

---

## Data Structures Used

- **LinkedHashMap<String, List<String>>**
  - Groups words by their sorted character sequence
  - Maintains insertion order for clearer output

- **List<String>**
  - Used to collect words of the same length before processing

---

## ⏳ If Given More Time

- Add logging using SLF4J
- Write results to an output file instead of stdout
- Improve test coverage for edge cases and error handling




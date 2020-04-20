package pl.sda.poznan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {
  private static final Pattern pattern = Pattern.compile("\\s|\\.|\\, |\\. ");

  // Rozwiazanie funkcyjne
  public Map<String, Long> calculateWordsInText(String path) {
    List<String> strings = readAllLines(path);
    return strings.stream()
        .flatMap(line -> Stream.of(line.split("\\s|\\.|\\, |\\. ")))
        .map(String::toLowerCase)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  // Pokazac co ze zwykla mapa, co z tree map
  public Map<String, Long> calcWords(String path) {
    Map<String, Long> result = new TreeMap<>();
    List<String> strings = readAllLines(path);

    for (String line : strings) {
      String[] split = pattern.split(line); //line.split("\\s|\\.|\\, |\\. ");
      for (String s : split) {
        s = s.toLowerCase();
        if (result.containsKey(s)) {
          long currentVal = result.get(s);
          result.put(s, ++currentVal);
        } else {
          result.put(s, 1L);
        }
      }
    }
    return result;
  }


  private List<String> readAllLines(String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }
}

package pl.sda.poznan;

import java.util.Map;
import java.util.Scanner;

public class WordCounterProgram {

  private static final Scanner scanner = new Scanner(System.in);
  private static final FileService fileService = new FileService();

  public static void main(String[] args) {
    System.out.println("Podaj sciezke do pliku: ");

    String pathToFile = scanner.next();

    Map<String, Long> stringLongMap = fileService.calcWords(pathToFile);
    stringLongMap.forEach((k, v) -> {
      System.out.println(String.format("%s = %d", k, v));
    });


  }
}

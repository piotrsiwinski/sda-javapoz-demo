package pl.sda.poznan;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaIntro {
  public static void main(String[] args) {

    List<String> names = Arrays.asList("Anna, Robert, Mikolaj");

    // implementacja interfejsu z 1 metodą - to lambda


    Comparator<String> porStringa = (s1, s2) -> {
      return Integer.compare(s1.length(), s2.length());
    };


    Collections.sort(names, porStringa);

    //
    Function<String, Integer> foo = String::length;
    Collections.sort(names);


    BiFunction<Integer, Integer, Integer> add = (integer, integer2) -> {
      return integer + integer2;
    };


    System.out.println(add.apply(2, 5));


  }
}

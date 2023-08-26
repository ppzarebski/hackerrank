package com.github.ppzarebski.hackerrank.problemsolving.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Strings {

  public static List<String> stripTokens(String input) {
    if (input == null) {
      return null;
    }
    var stripped = Arrays.stream(input.split("[^a-zA-Z]"))
        .filter(s -> s != null && !s.isBlank())
        .collect(Collectors.toList());
    stripped.add(0, String.valueOf(stripped.size()));
    return stripped;
  }
}

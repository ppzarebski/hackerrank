package com.github.ppzarebski.hackerrank.problemsolving.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {

  public static boolean isCorrectIp(String text) {

    var pattern = "^([0-9]{1,2}|25[0-5]|2[0-4][0-9]|[0-1][0-9]{1,2})[.]([0-9]{1,2}|25[0-5]|2[0-4][0-9]|[0-1][0-9]{1,2})[.]([0-9]{1,2}|25[0-5]|2[0-4][0-9]|[0-1][0-9]{1,2})[.]([0-9]{1,2}|25[0-5]|2[0-4][0-9]|[0-1][0-9]{1,2})$";
    return text.matches(pattern);
  }

  public static String cutDuplicatedWords(String line) {
    Pattern pattern = Pattern.compile("\\b(\\w+)(?:\\W+\\1\\b)+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(line);
    var result = line;
    while (matcher.find()) {
      result = matcher.replaceAll("$1");
    }
    return result;
  }
}

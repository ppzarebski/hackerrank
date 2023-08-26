package com.github.ppzarebski.hackerrank.problemsolving.medium;

import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BigNumbers {

  public static List<Pair<BigDecimal, String>> specificSort(List<String> unordered) {
    return unordered.stream()
        .map(u -> Pair.of(new BigDecimal(u), u))
        .sorted((v1, v2) -> v2.getLeft().compareTo(v1.getLeft()))
        .collect(Collectors.toList());
  }

  public static boolean isPrime(BigInteger number) {
    if (List.of(BigInteger.ZERO, BigInteger.ONE).contains(number)) {
      return false;
    } else if (number.equals(BigInteger.TWO)) {
      return true;
    }
    var string = number.toString();
    if (string.length() < 10) {
      int intNumber = Integer.parseInt(string);
      var numbersToBeChecked = IntStream.range(2, intNumber).mapToObj(i -> true).collect(Collectors.toList());
      for (var i = 2; i <= Double.valueOf(Math.floor(Math.sqrt(intNumber))).intValue(); i++) {
        var index = i - 2;
        if (numbersToBeChecked.get(index)) {
          for (var j = 2 * i; j < numbersToBeChecked.size(); j++) {
            numbersToBeChecked.set(i, true);
          }
        }
      }
      return IntStream.range(0, numbersToBeChecked.size() - 2)
          .mapToObj(i -> Pair.of(i + 2, numbersToBeChecked.get(i)))
          .filter(Pair::getRight)
          .noneMatch(p -> intNumber % p.getLeft() == 0);
    } else {
      return number.isProbablePrime(0);
    }
  }
}

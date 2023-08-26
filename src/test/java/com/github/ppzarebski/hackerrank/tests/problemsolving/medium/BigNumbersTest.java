package com.github.ppzarebski.hackerrank.tests.problemsolving.medium;

import com.github.ppzarebski.hackerrank.problemsolving.medium.BigNumbers;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

public class BigNumbersTest {

  @ParameterizedTest(name = "{0}")
  @MethodSource("provideSortingCases")
  void sortBigDecimalsTest(List<String> unordered, List<String> expected) {
    //given
    System.out.println(unordered);

    //when
    var sorted = BigNumbers.specificSort(unordered).stream().map(Pair::getRight).collect(Collectors.toList());
    System.out.println(sorted);

    //then
    for (var i = 0; i < sorted.size(); i++) {
      assertThat(sorted.get(i)).isEqualTo(expected.get(i));
    }
  }

  private static Stream<Arguments> provideSortingCases() {
    return Stream.of(
        Arguments.of(List.of("-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"),
            List.of("90", "56.6", "50", "02.34", "0.12", ".12", "0", "000.000", "-100")),
        Arguments.of(List.of("123", "45", "766", "324324", ".324", "0.325", "-234", "4546", "100", "0"),
            List.of("324324", "4546", "766", "123", "100", "45", "0.325", ".324", "0", "-234"))
    );
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("providePrimeCases")
  void primeNumbersTest(BigInteger number, boolean isPrime) {
    //when
    var prime = BigNumbers.isPrime(number);

    //then
    System.out.println(prime ? "prime" : "not prime");
    assertThat(prime).isEqualTo(isPrime);
  }

  private static Stream<Arguments> providePrimeCases() {
    return Stream.of(
        Arguments.of(BigInteger.valueOf(13), true),
        Arguments.of(BigInteger.valueOf(11), true),
        Arguments.of(BigInteger.valueOf(104729), true),
        Arguments.of(BigInteger.valueOf(997), true),
        Arguments.of(BigInteger.valueOf(7), true),
        Arguments.of(BigInteger.valueOf(2), true),
        Arguments.of(BigInteger.valueOf(1), false),
        Arguments.of(BigInteger.valueOf(0), false),
        Arguments.of(BigInteger.valueOf(15), false),
        Arguments.of(BigInteger.valueOf(17), true),
        Arguments.of(new BigInteger("1713111713", 10), true),
        Arguments.of(new BigInteger("1713111713123123", 10), true)
    );
  }
}

package com.github.ppzarebski.hackerrank.tests.problemsolving.medium;

import com.github.ppzarebski.hackerrank.problemsolving.medium.MyRegex;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

public class MyRegexTest {

  @ParameterizedTest(name = "{0}")
  @MethodSource("provideIpCases")
  void myRegexIpTest(String text, boolean expected) {
    //when
    var result = MyRegex.isCorrectIp(text);
    System.out.println(result);

    //then
    assertThat(result).isEqualTo(expected);
  }

  private static Stream<Arguments> provideIpCases() {
    return Stream.of(
        Arguments.of("000.12.12.034", true),
        Arguments.of("121.234.12.12", true),
        Arguments.of("23.45.12.56", true),
        Arguments.of("0.0.0.0", true),
        Arguments.of("00.00.00.00", true),
        Arguments.of("000.000.000.000", true),
        Arguments.of("199.199.199.199", true),
        Arguments.of("012.023.034.045", true),
        Arguments.of("255.255.255.255", true),
        Arguments.of("-00.12.123.12", false),
        Arguments.of("00.12.123.12-", false),
        Arguments.of("00.12.123.123123.123", false),
        Arguments.of("123.234.345", false),
        Arguments.of("12.23.34.45.", false),
        Arguments.of(".12.23.34.45", false),
        Arguments.of("256.1.2.3", false),
        Arguments.of("122.23", false),
        Arguments.of("i.am.not.ip", false)
    );
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("provideDuplicatesCases")
  void myRegexDuplicatesTest(String text, String expected) {
    //when
    var result = MyRegex.cutDuplicatedWords(text);
    System.out.println(result);

    //then
    assertThat(result).isEqualTo(expected);
  }

  private static Stream<Arguments> provideDuplicatesCases() {
    return Stream.of(
        Arguments.of("Goodbye bye bye world world world", "Goodbye bye world"),
        Arguments.of("Sam went went to to to his business", "Sam went to his business"),
        Arguments.of("Reya is is the the best player in eye eye game", "Reya is the best player in eye game"),
        Arguments.of("in inthe", "in inthe"),
        Arguments.of("Hello hello Ab aB", "Hello Ab")
    );
  }
}

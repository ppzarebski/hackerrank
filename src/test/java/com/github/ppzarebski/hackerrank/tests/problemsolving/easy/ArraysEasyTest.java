package com.github.ppzarebski.hackerrank.tests.problemsolving.easy;

import com.github.ppzarebski.hackerrank.problemsolving.easy.ArrayUtilsEasy;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

public class ArraysEasyTest {

  @ParameterizedTest(name = "queries count: {0}")
  @MethodSource("provideInsertDeleteCases")
  void transformArray(int queriesCount, List<Integer> arr, List<Pair<String, List<Integer>>> queries,
                      List<Integer> expected) {
    //when
    var result = ArrayUtilsEasy.transformArray(arr, queries);

    System.out.println(result);
    //then
    assertThat(result).containsExactlyElementsIn(expected);
  }

  private static Stream<Arguments> provideInsertDeleteCases() {
    return Stream.of(
        Arguments.of(2, List.of(12, 0, 1, 78, 12),
            List.of(Pair.of("Insert", List.of(5, 23)), Pair.of("Delete", List.of(0))),
            List.of(0, 1, 78, 12, 23))
    );
  }
}

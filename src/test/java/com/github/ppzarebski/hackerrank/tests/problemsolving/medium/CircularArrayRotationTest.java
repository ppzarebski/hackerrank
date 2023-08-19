package com.github.ppzarebski.hackerrank.tests.problemsolving.medium;

import com.github.ppzarebski.hackerrank.problemsolving.medium.CircularArrayRotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

public class CircularArrayRotationTest {

  @ParameterizedTest(name = "size: {0}")
  @MethodSource("provideCases")
  void circularArrayRotationTest(int size, List<Integer> array, int rotationsCount,
                                 List<Integer> queryIndexes, List<Integer> expected) {
    //when
    var result = CircularArrayRotation.circularArrayRotation(array, rotationsCount, queryIndexes);

    System.out.println(result);
    //then
    for (var i = 0; i < queryIndexes.size(); i++) {
      assertThat(result.get(i)).isEqualTo(expected.get(i));
    }
  }

  private static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(3, List.of(3, 4, 5), 2, List.of(1, 2), List.of(5, 3)),
        Arguments.of(3, List.of(2, 3, 4), 3, List.of(1, 2), List.of(3, 4)),
        Arguments.of(4, List.of(1, 2, 3), 2, List.of(1, 2), List.of(3, 1)),
        Arguments.of(5, List.of(1, 2, 3, 5, 7), 2, List.of(3, 4), List.of(2, 3)),
        Arguments.of(4, List.of(1, 2, 3, 4), 2, List.of(3, 2, 3), List.of(2, 1, 2)),
        Arguments.of(1, List.of(4), 2, List.of(0, 0), List.of(4, 4)),
        Arguments.of(3, List.of(1, 3, 4), 13, List.of(0, 1, 2), List.of(4, 1, 3))
    );
  }
}

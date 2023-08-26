package com.github.ppzarebski.hackerrank.tests.problemsolving.medium;

import com.github.ppzarebski.hackerrank.problemsolving.medium.ArrayUtilsMedium;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

public class ArraysMediumTest {

  @ParameterizedTest(name = "size: {0}")
  @MethodSource("provideCircularArrayRotationCases")
  void circularArrayRotationTest(int size, List<Integer> array, int rotationsCount,
                                 List<Integer> queryIndexes, List<Integer> expected) {
    //when
    var result = ArrayUtilsMedium.circularArrayRotation(array, rotationsCount, queryIndexes);

    System.out.println(result);
    //then
    for (var i = 0; i < queryIndexes.size(); i++) {
      assertThat(result.get(i)).isEqualTo(expected.get(i));
    }
  }

  private static Stream<Arguments> provideCircularArrayRotationCases() {
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

  @ParameterizedTest(name = "size:  {0}, leap: {1}")
  @MethodSource("provideArrayGameCases")
  void arrayGameTest(int size, int leap, List<Integer> arr, boolean expected) {
    //when
    var result = ArrayUtilsMedium.arrayGame(leap, arr);

    System.out.println(result);
    //then
    assertThat(result).isEqualTo(expected);
  }

  private static Stream<Arguments> provideArrayGameCases() {
    return Stream.of(
        Arguments.of(5, 3, List.of(0, 0, 0, 0, 0), true),
        Arguments.of(5, 3, List.of(0, 0, 1, 1, 0), true),
        Arguments.of(6, 5, List.of(0, 0, 0, 1, 1, 1), true),
        Arguments.of(2, 0, List.of(0, 0), true),
        Arguments.of(2, 1, List.of(0, 0), true),
        Arguments.of(2, 0, List.of(0, 1), false),
        Arguments.of(2, 1, List.of(0, 1), false),
        Arguments.of(3, 0, List.of(0, 0, 1), false),
        Arguments.of(3, 1, List.of(0, 0, 1), false),
        Arguments.of(6, 3, List.of(0, 0, 1, 1, 1, 0), false),
        Arguments.of(3, 1, List.of(0, 1, 0), false),
        Arguments.of(3, 0, List.of(0, 0, 1), false),
        Arguments.of(9, 2, List.of(0, 1, 0, 0, 0, 0, 1, 1, 1), false),
        Arguments.of(5, 3, List.of(0, 0, 1, 1, 1), false)
    );
  }

  @ParameterizedTest(name = "{0}: size:  {1}, leap: {2}")
  @MethodSource("provideArrayGameCasesFromFile")
  void arrayGameFromFileTest(int caseNo, int size, int leap, List<Integer> arr, String expected) {
    //when
    var result = ArrayUtilsMedium.arrayGame(leap, arr);

    System.out.println(result);
    //then
    assertThat(result ? "YES" : "NO").isEqualTo(expected);
  }

  private static Stream<Arguments> provideArrayGameCasesFromFile() {
    var cases = new ArrayList<Pair<Pair<Integer, Integer>, List<Integer>>>();
    var results = new ArrayList<String>();
    try {
      var casesPath = Paths.get("src/main/resources/testCases/arrays/case8.txt");
      var resultsPath = Paths.get("src/main/resources/testCases/arrays/case8results.txt");
      var casesFile = Files.readAllLines(casesPath.toAbsolutePath(), StandardCharsets.UTF_8);
      var resultsFile = Files.readAllLines(resultsPath.toAbsolutePath(), StandardCharsets.UTF_8);

      resultsFile.forEach(e -> results.add(e.trim()));
      for (var i = 0; i < casesFile.size(); i += 2) {
        var sizeLeap = casesFile.get(i).split(" ");
        var arr = Arrays.stream(casesFile.get(i + 1).split(" ")).map(Integer::parseInt).toList();
        cases.add(Pair.of(Pair.of(Integer.parseInt(sizeLeap[0]), Integer.parseInt(sizeLeap[1])), arr));
      }
    } catch (IOException ex) {
      throw new RuntimeException("Something went wrong", ex);
    }
    return IntStream.range(0, cases.size())
        .mapToObj(i -> {
          var singleCase = cases.get(i);
          return Arguments.of(i + 1, singleCase.getLeft().getLeft(), singleCase.getLeft().getRight(), singleCase.getRight(), results.get(i).trim());
        });
  }
}

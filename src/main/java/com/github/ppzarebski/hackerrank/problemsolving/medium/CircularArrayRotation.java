package com.github.ppzarebski.hackerrank.problemsolving.medium;

import java.util.List;

public class CircularArrayRotation {

  public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
    return queries.stream()
        .map(i -> {
          var shift = i - k;
          var distanceToEnd = Math.abs(shift) % a.size();
          return shift >= 0
              ? shift
              : (distanceToEnd == 0 ? 0 : a.size() - distanceToEnd);
        })
        .map(a::get)
        .toList();
  }
}

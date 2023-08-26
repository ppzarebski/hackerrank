package com.github.ppzarebski.hackerrank.problemsolving.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayUtilsMedium {

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

  public static boolean arrayGame(int leap, List<Integer> arr) {

    var game = new ArrayList<>(arr);
    var stack = new Stack<Integer>();
    stack.push(0);

    while (!stack.isEmpty()) {
      var position = stack.pop();

      if (position >= arr.size()) {
        return true;
      }
      if (position < 0 || !(game.get(position).equals(0))) {
        continue;
      }
      game.set(position, -1);
      stack.addAll(List.of(position + 1, position + leap, position - 1));
    }
    return false;
  }
}

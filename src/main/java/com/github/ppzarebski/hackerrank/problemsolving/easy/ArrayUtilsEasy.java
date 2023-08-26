package com.github.ppzarebski.hackerrank.problemsolving.easy;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtilsEasy {

  public static List<Integer> transformArray(List<Integer> arr, List<Pair<String, List<Integer>>> queries) {
    var result = new ArrayList<>(arr);
    for (var i = 0; i < queries.size(); i++) {
      var query = queries.get(i);
      insertDelete(result, query.getLeft(), query.getRight());
    }
    return result;
  }

  public static ArrayList<Integer> insertDelete(ArrayList<Integer> arr, String query, List<Integer> xY) {
    if (query.equals("Insert")) {
      arr.add(xY.get(0), xY.get(1));
    } else {
      arr.remove(xY.get(0).intValue());
    }
    return arr;
  }
}

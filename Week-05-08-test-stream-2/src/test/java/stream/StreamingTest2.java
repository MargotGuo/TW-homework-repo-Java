package stream;

import generics.KeyValuePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamingTest2 {

  @Test
  void should_calculate_sum_using_reduce() {
    List<Integer> numbers = new ArrayList<>();
    Stream
        .iterate(1, i -> i + 1)
        .limit(100)
        .forEach(numbers::add);

    // TODO: please modify the following code to pass the test
    // <--start
    Optional<Integer> reduced = numbers.stream().reduce(Integer::sum);
    // --end-->

    //noinspection ConstantConditions
    assertEquals(5050, reduced.get().intValue());
  }

  @Test
  void should_calculate_total_character_lengths() {
    List<String> words = Arrays.asList("The", "future", "is", "ours");

    // TODO: please calculate the total number of characters using `reduce`.
    // <--start
    Integer total = words.stream().map(String::length).reduce(0, Integer::sum);
    // --end-->

    assertEquals(15, total.intValue());
  }

  @Test
  void should_collect_result() {
    Stream<String> stream = Stream.of("Hello", "What", "is", "your", "name");

    // TODO: please implement toList collector using `stream.collect`. You cannot use existing `toList` collector.
    // can use collect(Supplier<R> supplier,
    //                  BiConsumer<R, ? super T> accumulator,
    //                  BiConsumer<R, R> combiner) method
    // <--start
    List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    // --end-->

    assertEquals(ArrayList.class, list.getClass());
    assertIterableEquals(
        Arrays.asList("Hello", "What", "is", "your", "name"),
        list
    );
  }

  @Test
  void should_collect_to_map() {
    Stream<KeyValuePair<String, Integer>> stream = Stream.of(
        new KeyValuePair<>("Harry", 2002),
        new KeyValuePair<>("Bob", 2014),
        new KeyValuePair<>("Harry", 2033)
    ).parallel();

    // TODO: please implement toMap collector using `stream.collect`. You cannot use existing `toMap` collector.
    // <--start
    HashMap<String, Integer> map = stream.collect(
        HashMap::new,
        (aMap, aKeyValuePair) -> aMap.put(aKeyValuePair.getKey(), aKeyValuePair.getValue()),
        HashMap::putAll);
    // --end-->

    assertEquals(2, map.size());
    assertTrue(map.containsKey("Harry"));
    assertEquals(2033, map.get("Harry").intValue());
    assertTrue(map.containsKey("Bob"));
    assertEquals(2014, map.get("Bob").intValue());
  }

  @Test
  void should_collect_to_group() {
    Stream<KeyValuePair<String, Integer>> stream = Stream.of(
        new KeyValuePair<>("Harry", 2002),
        new KeyValuePair<>("Bob", 2014),
        new KeyValuePair<>("Harry", 2033)
    ).parallel();

    // TODO: implement grouping collector using `stream.collect`. You cannot use existing `groupingBy` collector.
    // <--start
    HashMap<String, List<Integer>> map = stream.collect(
        HashMap::new,

        (stringListHashMap, pair) -> {
          Set<String> strings = stringListHashMap.keySet();
          String key = pair.getKey();
          if (strings.contains(key)) {
            stringListHashMap.get(key).add(pair.getValue());
          } else {
            stringListHashMap.put(pair.getKey(), Collections.singletonList(pair.getValue()));
          }
        },

        (map1, map2) -> {
          Set<String> keySet = map2.keySet();
          keySet.forEach(key -> {
            List<Integer> newValueList = new ArrayList<>();
            if (map1.containsKey(key)) {
              newValueList.addAll(map1.get(key));
            }
            newValueList.addAll(map2.get(key));
            map1.put(key, newValueList);
          });
        });
    // --end-->

    assertEquals(2, map.size());
    assertIterableEquals(Arrays.asList(2002, 2033), map.get("Harry"));
    assertIterableEquals(Collections.singletonList(2014), map.get("Bob"));
  }

  @Test
  void should_collect_to_group_continued() {
    Stream<KeyValuePair<String, Integer>> stream = Stream.of(
        new KeyValuePair<>("Harry", 2002),
        new KeyValuePair<>("Bob", 2014),
        new KeyValuePair<>("Harry", 2033)
    ).parallel();

    // TODO: implement grouping collector using `stream.collect`. This time please use `Collectors.groupingBy`
    // <--start
    Map<String, List<Integer>> map = stream.collect(
        Collectors.groupingBy(
            KeyValuePair::getKey,
            Collectors.mapping(KeyValuePair::getValue, Collectors.toList())
        ));
    // --end-->

    assertEquals(2, map.size());
    assertIterableEquals(Arrays.asList(2002, 2033), map.get("Harry"));
    assertIterableEquals(Collections.singletonList(2014), map.get("Bob"));
  }

  @SuppressWarnings({"unused", "ConstantConditions"})
  @Test
  void should_calculate_number_in_each_group() {
    Stream<KeyValuePair<String, Integer>> stream = Stream.of(
        new KeyValuePair<>("Harry", 2002),
        new KeyValuePair<>("Bob", 2014),
        new KeyValuePair<>("Harry", 2033)
    ).parallel();

    // TODO: implement grouping collector using `stream.collect`. You should use `Collectors.groupingBy` and
    // TODO: downstream collector.
    // <--start
    Map<String, Long> map = stream.collect(
        Collectors.groupingBy(KeyValuePair::getKey, Collectors.counting()));
    // --end-->

    assertEquals(2, map.size());
    assertEquals(2, map.get("Harry").longValue());
    assertEquals(1, map.get("Bob").longValue());
  }

  @Test
  void should_calculate_sum_of_each_group() {
    Stream<KeyValuePair<String, Integer>> stream = Stream.of(
        new KeyValuePair<>("Harry", 2002),
        new KeyValuePair<>("Bob", 2014),
        new KeyValuePair<>("Harry", 2033)
    ).parallel();

    // TODO: implement grouping collector using `stream.collect`. You should use `Collectors.groupingBy` and
    // TODO: downstream collector.
    Map<String, Integer> map = stream.collect(
        Collectors.groupingBy(
            KeyValuePair::getKey,
            Collectors.mapping(KeyValuePair::getValue, Collectors.reducing(0, Integer::sum))
        ));
    // --end-->

    assertEquals(2, map.size());
    assertEquals(4035, map.get("Harry").intValue());
    assertEquals(2014, map.get("Bob").intValue());
  }

}

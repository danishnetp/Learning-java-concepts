package com.learning.concepts.stream;

import java.util.List;
import java.util.stream.Stream;

public class FlatMapDemo1 {
   public static void main(String[] arg) {
        List<List<String>> list = List.of(
                List.of("Durga", "Ravi"),
                List.of("Shiva", "Pavan"),
                List.of("Suresh", "Anil")
        );

        Stream<String> streamList = list.stream()
                .flatMap((List<String> s) -> s.stream());

        System.out.println(streamList);
        streamList.forEach(System.out::println);

    }
}

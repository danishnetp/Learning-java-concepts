# Java 8 Interview Programming Questions

This file collects a **comprehensive set of Java 8 interview programming questions**.
The goal is to practice solving problems using:

- lambda expressions
- functional interfaces
- streams
- collectors
- `Optional`
- `java.time`
- `CompletableFuture`
- collection and map operations available in Java 8

## Practice rules

- Prefer **Java 8 compatible syntax only**.
- Avoid Java 9+ APIs such as `List.of()`, `Map.of()`, `Stream.ofNullable()`, and `Collectors.filtering()`.
- When solving, be ready to explain:
  - time complexity
  - space complexity
  - null handling
  - duplicate handling
  - ordering guarantees
  - mutable vs immutable results
  - sequential vs parallel stream considerations

## Recommended interview answer structure

For each problem, try to present:

1. brute-force idea
2. optimized idea
3. Java 8 solution using streams or lambdas where appropriate
4. edge cases
5. complexity analysis

---

## 1) String programming questions

1. Reverse a string using:
   - loop
   - `StringBuilder`
   - stream approach

2. Check whether a string is a palindrome.

3. Count the occurrence of each character in a string.

4. Count vowels, consonants, digits, and special characters in a string.

5. Find the first non-repeated character in a string.

6. Find the first repeated character in a string.

7. Find all duplicate characters in a string.

8. Remove duplicate characters from a string while preserving insertion order.

9. Sort characters in a string alphabetically.

10. Find the frequency of each word in a sentence.

11. Find the longest word in a sentence.

12. Find the shortest word in a sentence.

13. Capitalize the first letter of every word.

14. Count how many times a substring appears in a string.

15. Check whether two strings are anagrams.

16. Group a list of strings by anagram.

17. Find the first unique word in a sentence.

18. Remove all whitespace from a string.

19. Remove all non-alphanumeric characters from a string.

20. Convert a sentence into a map of word -> count using Java 8 streams.

21. Find the top 3 most frequent words in a paragraph.

22. Check whether two strings are rotations of each other.

23. Print all permutations of a string.

24. Print all substrings of a string.

25. Find the longest substring without repeating characters.

26. Find the longest common prefix among a list of strings.

27. Check if a string contains only digits.

28. Extract all numbers from an alphanumeric string.

29. Compress a string using character counts, for example `aaabbc -> a3b2c1`.

30. Decompress a compressed string such as `a3b2c1`.

---

## 2) Array and number programming questions

1. Find the maximum element in an array.

2. Find the minimum element in an array.

3. Find the second largest element in an array.

4. Find the second smallest element in an array.

5. Find the largest and smallest number in a single pass.

6. Sort an array in ascending order.

7. Sort an array in descending order.

8. Remove duplicates from an integer array.

9. Find duplicate elements in an array.

10. Count frequency of each element in an array.

11. Find missing number in an array containing values from `1` to `n`.

12. Find multiple missing numbers from an array.

13. Find all pairs with a given sum.

14. Find all triplets with a given sum.

15. Find the pair with the maximum product.

16. Find the pair with the minimum absolute difference.

17. Move all zeros to the end while maintaining order of non-zero elements.

18. Separate even and odd numbers.

19. Partition positive and negative numbers.

20. Rotate an array left by `k` positions.

21. Rotate an array right by `k` positions.

22. Reverse an array in place.

23. Merge two sorted arrays.

24. Find common elements between two arrays.

25. Find uncommon elements between two arrays.

26. Find the intersection of two lists using streams.

27. Find the union of two lists using streams.

28. Check whether an array is sorted.

29. Find the kth largest element.

30. Find the kth smallest element.

31. Compute prefix sums for an array.

32. Compute running average for a list of integers.

33. Find contiguous subarray with maximum sum.

34. Find contiguous subarray with minimum sum.

35. Find all subarrays with sum equal to a target.

36. Count inversions in an array.

37. Find majority element in an array.

38. Check if any number occurs more than `n / 2` times.

39. Print Fibonacci series using:
   - loop
   - recursion
   - stream style generation

40. Check whether a number is prime.

41. Print all prime numbers in a range.

42. Find factorial of a number.

43. Check whether a number is an Armstrong number.

44. Check whether a number is a palindrome number.

45. Reverse digits of a number.

46. Find the sum of digits of a number.

47. Find GCD and LCM of two numbers.

48. Swap two numbers without a temporary variable.

49. Find all perfect numbers in a range.

50. Generate Pascal's triangle.

---

## 3) List, Set, Map, and collection questions

1. Convert a list of strings to uppercase using streams.

2. Convert a list of strings to lowercase using streams.

3. Filter all even numbers from a list.

4. Filter all odd numbers from a list.

5. Remove null values from a list.

6. Remove empty strings from a list.

7. Find the count of elements in a list matching a predicate.

8. Partition a list into even and odd numbers.

9. Group a list of employees by department.

10. Group a list of employees by city.

11. Group strings by length.

12. Convert a list into a map using one field as key.

13. Convert a list into a map and handle duplicate keys.

14. Create a frequency map from a list of integers.

15. Sort a map by key.

16. Sort a map by value.

17. Find the key with the highest value in a map.

18. Find the key with the lowest value in a map.

19. Merge two maps.

20. Merge two maps and sum values for duplicate keys.

21. Find duplicate elements in a list using streams.

22. Remove duplicates from a list while preserving order.

23. Find the first element of a list.

24. Find the last element of a list.

25. Skip the first `n` elements and collect the rest.

26. Limit a stream to the first `n` elements.

27. Convert a list of objects to a comma-separated string.

28. Flatten `List<List<Integer>>` into a single list.

29. Flatten a map of lists into one combined list.

30. Split a list into batches of fixed size.

31. Find common elements among multiple lists.

32. Find whether two lists contain the same elements in the same order.

33. Find whether two lists contain the same elements ignoring order.

34. Find elements that appear exactly once in a list.

35. Find elements that appear more than once in a list.

---

## 4) Stream API programming questions

1. From a list of integers, filter even numbers, square them, and collect the results.

2. From a list of integers, find the sum of all numbers.

3. Find the average of numbers in a list.

4. Find the maximum and minimum number using stream operations.

5. Find the count of numbers greater than a given threshold.

6. Find the first element matching a condition.

7. Find whether any element matches a condition.

8. Find whether all elements match a condition.

9. Find whether no elements match a condition.

10. Sort a list of strings by length.

11. Sort a list of objects by one field.

12. Sort a list of objects by multiple fields.

13. Find the top `n` largest numbers from a list.

14. Find the top `n` smallest numbers from a list.

15. Find the distinct elements in a list.

16. Count duplicate elements using grouping.

17. Convert a list of strings into a single string joined by comma.

18. Join non-empty strings with a delimiter.

19. Convert a list of employees to a map of `id -> employee`.

20. Convert a list of employees to a map of `department -> list of employees`.

21. Find the employee with maximum salary.

22. Find the employee with minimum salary.

23. Find the second highest salary from a list of employees.

24. Find the nth highest salary from a list of employees.

25. Find duplicate names in a list of employees.

26. Group employees by department and count them.

27. Group employees by department and find average salary.

28. Group employees by department and find the highest-paid employee.

29. Partition employees into adults and minors.

30. Find all employees whose names start with a given prefix.

31. Find all employees hired after a given date.

32. Convert a list of strings to a map of string and its length.

33. Build a custom collector to collect elements into a `LinkedHashSet`.

34. Build a custom collector to concatenate strings with a custom delimiter.

35. Use `reduce()` to:
   - sum integers
   - multiply integers
   - find maximum value
   - find longest string

36. Use `flatMap()` to flatten nested objects such as `departments -> employees`.

37. Use `flatMap()` to find all unique skills from a list of employees.

38. Convert a stream of words into a frequency map.

39. Find the most frequent element in a list using streams.

40. Find the least frequent element in a list using streams.

41. Reverse-sort a list of objects by salary and then by name.

42. Generate a stream of random numbers and collect the first 10.

43. Generate a stream of integers in a range and filter primes.

44. Use `peek()` to debug a stream pipeline and explain why it should be used carefully.

45. Explain and demonstrate lazy evaluation in streams with a coding example.

46. Write a program that shows the difference between `map()` and `flatMap()`.

47. Write a program that shows the difference between `findFirst()` and `findAny()`.

48. Write a program demonstrating why a stream cannot be reused after a terminal operation.

49. Demonstrate side effects in streams and explain why they are risky.

50. Demonstrate when parallel streams can produce unexpected ordering.

---

## 5) Functional interface and lambda questions

1. Implement a custom functional interface and use it with a lambda expression.

2. Write examples using `Predicate<T>` for:
   - even number check
   - string length validation
   - employee salary filter

3. Chain multiple predicates using `and()`, `or()`, and `negate()`.

4. Write examples using `Function<T, R>` for transformation pipelines.

5. Compose functions using `andThen()` and `compose()`.

6. Write examples using `Consumer<T>` to print, log, and mutate objects.

7. Chain consumers using `andThen()`.

8. Write examples using `Supplier<T>` for lazy object creation.

9. Use `UnaryOperator<T>` to transform strings and integers.

10. Use `BinaryOperator<T>` to combine values.

11. Write a reusable method that accepts a `Predicate<Integer>` and filters numbers.

12. Write a reusable method that accepts a `Function<String, String>` and transforms strings.

13. Write a reusable method that accepts a `Consumer<Employee>` and applies an action.

14. Compare anonymous inner class vs lambda using code.

15. Show effectively final variable behavior inside lambdas.

16. Show method references for:
   - static method
   - instance method of a particular object
   - instance method of an arbitrary object of a particular type
   - constructor reference

17. Replace a traditional comparator class with a lambda-based comparator.

18. Sort employees by salary using a lambda.

19. Write a calculator using `BiFunction<Integer, Integer, Integer>`.

20. Write a validation engine using a list of predicates.

---

## 6) Optional programming questions

1. Create an `Optional` from a nullable value and print a default value when absent.

2. Convert nested null checks into an `Optional` chain.

3. Find an employee by id and return `Optional<Employee>`.

4. Use `map()` on `Optional` to transform an object.

5. Use `flatMap()` on `Optional` for nested optionals.

6. Demonstrate `orElse()` vs `orElseGet()` with a coding example.

7. Demonstrate `orElseThrow()` for mandatory values.

8. Filter an `Optional` based on a condition.

9. Convert `Optional<String>` to uppercase if present.

10. Parse an optional integer from a string and avoid `NumberFormatException` leaks.

11. Chain `Optional` lookups across `User -> Address -> City`.

12. Explain why `Optional` should generally not be used for fields or method parameters, and demonstrate better alternatives.

---

## 7) Date and time (`java.time`) programming questions

1. Print the current date, time, and date-time.

2. Parse a date from a string using `LocalDate`.

3. Format a `LocalDateTime` into a custom pattern.

4. Find the number of days between two dates.

5. Find the number of months or years between two dates.

6. Add 10 days to a given date.

7. Subtract 3 months from a given date.

8. Find the next Sunday from a given date.

9. Find all Mondays in a given month.

10. Check whether a year is a leap year.

11. Find the last day of a month.

12. Find the first day of the next month.

13. Convert date-time from one timezone to another.

14. Measure execution time of a method using `Instant` and `Duration`.

15. Calculate age from a date of birth using `Period`.

16. Find working days between two dates.

17. Exclude weekends and a set of holidays while counting working days.

18. Check if a meeting time overlaps with another meeting time.

19. Convert legacy `Date` to `LocalDateTime`.

20. Convert `LocalDateTime` to legacy `Date`.

---

## 8) Employee / object-based Java 8 interview questions

Use a class like:

```java
class Employee {
	private int id;
	private String name;
	private String department;
	private double salary;
	private int age;
	private String city;
	private List<String> skills;
}
```

1. Find all employees in a given department.

2. Find all employees whose salary is greater than a threshold.

3. Find names of all employees.

4. Find distinct departments.

5. Count employees in each department.

6. Find average salary by department.

7. Find maximum salary by department.

8. Find minimum salary by department.

9. Find the highest-paid employee overall.

10. Find the lowest-paid employee overall.

11. Find the second highest-paid employee.

12. Find top 3 highest-paid employees.

13. Sort employees by salary ascending.

14. Sort employees by salary descending.

15. Sort employees by department, then salary, then name.

16. Find employees whose name starts with `A`.

17. Find employees older than 30.

18. Group employees by city.

19. Group employees by age bracket.

20. Partition employees into salary >= 100000 and others.

21. Find employee names as a comma-separated string.

22. Find all unique skills across all employees.

23. Find employees who know a given skill.

24. Find the most common skill.

25. Find department with highest average salary.

26. Find department with maximum number of employees.

27. Find employees hired in the last 2 years.

28. Find duplicate employee names.

29. Convert employee list to `Map<Integer, Employee>`.

30. Convert employee list to `Map<String, List<Employee>>` by department.

31. Build nested grouping: `city -> department -> employees`.

32. Find employees with the same salary.

33. Find employees with no skills.

34. Find employees who know more than 3 skills.

35. Find the average age of employees by department.

---

## 9) Collector-focused interview questions

1. Collect integers into a `List`.

2. Collect integers into a `Set`.

3. Collect stream results into a `LinkedList`.

4. Join strings using `Collectors.joining()`.

5. Create a frequency map using `Collectors.groupingBy()` and `Collectors.counting()`.

6. Create a map using `Collectors.toMap()` and resolve duplicate keys.

7. Group employees by department using `groupingBy()`.

8. Group words by length.

9. Partition numbers into even and odd using `partitioningBy()`.

10. Summarize integers using `summarizingInt()`.

11. Summarize employee salaries using `summarizingDouble()`.

12. Find average salary using `averagingDouble()`.

13. Find total salary using `summingDouble()`.

14. Map employee names while grouping departments.

15. Use downstream collectors to count employees per department.

16. Use downstream collectors to collect only employee names per department.

17. Use downstream collectors to find the max salary employee per department.

18. Convert grouped results into sorted maps.

19. Build a custom collector for immutable-looking output in Java 8.

20. Explain collector supplier, accumulator, combiner, finisher, and characteristics with a coding example.

---

## 10) Parallel stream and performance questions

1. Convert a sequential stream to a parallel stream and compare results.

2. Find when parallel stream improves performance and when it does not.

3. Demonstrate why shared mutable state is dangerous in parallel streams.

4. Demonstrate ordering differences between `forEach()` and `forEachOrdered()`.

5. Demonstrate thread-safety issues when collecting into a non-thread-safe structure manually.

6. Measure sequential vs parallel sum of a large list.

7. Show why small datasets often do not benefit from parallel streams.

8. Show why blocking I/O inside parallel streams is problematic.

9. Demonstrate safe reduction in parallel streams.

10. Explain spliterator characteristics with practical examples.

---

## 11) `CompletableFuture` and async programming questions

1. Run a task asynchronously using `CompletableFuture.runAsync()`.

2. Supply a value asynchronously using `CompletableFuture.supplyAsync()`.

3. Transform the result using `thenApply()`.

4. Chain asynchronous stages using `thenCompose()`.

5. Combine two independent futures using `thenCombine()`.

6. Consume the result using `thenAccept()`.

7. Run two futures and wait for both using `allOf()`.

8. Return the first completed future using `anyOf()`.

9. Handle exceptions using `exceptionally()`.

10. Handle success and failure using `handle()`.

11. Attach a side-effect callback using `whenComplete()`.

12. Demonstrate the difference between `thenApply()` and `thenCompose()`.

13. Build an API aggregator that fetches user, orders, and payments in parallel.

14. Build a timeout-like wrapper even though Java 8 does not have `orTimeout()`.

15. Show how to use a custom `ExecutorService` with `CompletableFuture`.

16. Show thread starvation problems caused by poor executor sizing.

17. Retry an async operation a fixed number of times.

18. Merge results from multiple futures into a single DTO.

19. Cancel a future and handle cancellation.

20. Convert legacy `Future` style code into `CompletableFuture` style code.

---

## 12) Mini design / implementation questions frequently asked with Java 8

1. Implement an LRU cache.

2. Implement a simple in-memory key-value store with expiry.

3. Implement a rate limiter.

4. Implement a word counter for a text file using streams.

5. Implement a log analyzer that finds the most frequent error code.

6. Implement a CSV parser that groups rows by one column.

7. Implement a leaderboard that returns top `n` players.

8. Implement a transaction analyzer that finds total spend per user.

9. Implement an order summarizer that groups orders by status.

10. Implement a student report generator that computes ranks and averages.

11. Implement an inventory summary that finds low-stock products.

12. Implement a duplicate file-name detector.

13. Implement a tag-cloud generator from articles.

14. Implement a scheduler conflict detector using `java.time`.

15. Implement a single-flight request coalescing mechanism.

---

## 13) Output-based interview questions

These are frequently asked to test Java 8 understanding.

1. Predict the output of a stream pipeline with `filter()`, `map()`, and `findFirst()`.

2. Predict the output when `peek()` is placed before and after `filter()`.

3. Predict whether a lambda can modify a local variable.

4. Predict the output of `orElse()` vs `orElseGet()` when the optional already contains a value.

5. Predict the output of `findAny()` on a parallel stream.

6. Predict the behavior when a stream is reused after a terminal operation.

7. Predict the output of sorting strings with custom comparators.

8. Predict the grouping output of `Collectors.groupingBy()` on duplicate values.

9. Predict the output of `map()` vs `flatMap()` on nested lists.

10. Predict the order of results for `parallelStream().forEach()`.

---

## 14) Scenario-based coding questions

1. Given a list of transactions, find total amount spent by each customer.

2. Given a list of orders, find orders placed in the last 30 days and group by status.

3. Given a list of products, find top 5 most expensive products in stock.

4. Given application logs, find the top 10 most common error messages.

5. Given employee records, find all departments where average salary is above a threshold.

6. Given student marks, find toppers per class.

7. Given cricket scores, compute player-wise average score.

8. Given flights, find overlapping flight schedules.

9. Given strings, group them by length and sort each group alphabetically.

10. Given e-commerce cart items, find total payable amount after discount rules.

11. Given customer visits, find returning customers and visit counts.

12. Given API response times, compute min, max, average, and percentile-like summaries.

13. Given web sessions, find sessions inactive for more than 15 minutes.

14. Given chat messages, find most active users by hour.

15. Given book data, find authors with the highest average rating.

---

## 15) Follow-up questions interviewers usually ask after coding

After solving any of the above, be ready for these follow-ups:

1. Can you do it without streams?
2. Can you do it using streams?
3. Can you make it null-safe?
4. Can you preserve insertion order?
5. Can you make it case-insensitive?
6. Can you make it thread-safe?
7. Can you optimize for large input?
8. Can you support duplicate keys safely in `toMap()`?
9. Can you return `Optional` instead of `null`?
10. Can you write unit tests for this?
11. Can you make it work with parallel streams?
12. What are the trade-offs of streams vs loops here?
13. What happens if the input is empty?
14. What happens if the input contains null values?
15. How would you refactor this into reusable methods?

---

## 16) High-value must-practice Java 8 questions

If you have limited time, prioritize these:

1. first non-repeated character in a string
2. duplicate elements in a list
3. frequency map using streams
4. second highest salary from employee list
5. group employees by department
6. top `n` numbers from a list
7. `map()` vs `flatMap()`
8. `findFirst()` vs `findAny()`
9. `orElse()` vs `orElseGet()`
10. `thenApply()` vs `thenCompose()`
11. merge two maps with duplicate keys
12. remove duplicates while preserving order
13. working days between two dates
14. partition even and odd numbers
15. custom sorting using lambda comparator

---

## 17) Interview tip

In Java 8 interviews, the interviewer is usually checking whether you can:

- write correct logic
- use streams only where they improve clarity
- choose loops when they are simpler
- understand collector behavior
- avoid stream side effects
- use `Optional` correctly
- use `java.time` instead of old date APIs
- write readable lambda-based code
- reason about async composition with `CompletableFuture`

Focus on **clarity first, cleverness second**.


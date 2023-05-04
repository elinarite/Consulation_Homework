package Consultation_Homework;

import java.util.function.Predicate;
import java.util.stream.Stream;

// 1 уровень сложности: Given an input string s and a pattern p, implement regular expression matching with support for '.' and '' where:
//'.' Matches any single character.
//'' Matches zero or more of the preceding element.
//The matching should cover the entire input string (not partial).
//
//Example 1:
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
//
//Example 2:
//Input: s = "aa", p = "a"
//Output: true
//Explanation: '' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//
//Example 3:
//Input: s = "ab", p = "."
//Output: true
//Explanation: "." means "zero or more (*) of any character (.)".
//
//Попытайтесь реализовать обработку регулярного выражения вручную, без использования Pattern, Matcher и т.п.
public class Task3 {
    public static void main(String[] args) {
        String text = "abc";
        String p1 = "a";
        String p2 = ".";

        //Task1
        System.out.println(findText(p1).test(text));
        System.out.println(findText2(text, p1));
        //Task2
        System.out.println(findChar(text, p1));
        //Task3
        System.out.println(findElements(text, p2));

    }

    //Task 1 Variant A
    public static Predicate<String> findText(String findElement) {
        Predicate<String> isPredicate = x -> x.equalsIgnoreCase(findElement);
        return isPredicate;
    }

    // //Task 1 Variant B
    public static boolean findText2(String text, String findElement) {
        boolean isText = Stream.of(text)
                .anyMatch(x -> x.matches(findElement));
        return isText;
    }

    //Task 2
    public static boolean findChar(String text, String findElement) {
        Long a = Stream.of(text)
                .filter(x -> x.contains(findElement))
                .count();
        return a >= 1;
    }

    public static boolean findElements(String text, String p) {
        Long a = Stream.of(text)
                .filter(x -> x.contains(p))
                .count();
        return a >= 0;
    }
}
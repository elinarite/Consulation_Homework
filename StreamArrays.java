package Consultation_Homework;

import java.util.*;
import java.util.function.Predicate;
import java.util.Arrays;

public class StreamArrays {

    public static void main(String[] args) {

        //Task1:
        List<String> stringList = new ArrayList<>(Arrays.asList("Highload", "High", "Load", "Highload"));
        streamObject(stringList);
        //Task2:
        String inputString = "java";
        System.out.println(checkString(inputString));
        //Task3: Input: nums = [3,0,1] Output: 2
        int[] nums = new int[]{3, 0, 1};
        System.out.println(findMissingNumber(nums));

        //Task3: Input: nums = [0,1] Output: 2
        int[] nums2 = new int[]{0, 1};
        System.out.println(findMissingNumber(nums2));
    }

    /**
     * //1 уровень сложности: Task1:
     * //Допустим, у нас есть коллекция состоящая из строк.
     * // Arrays.asList(«Highload», «High», «Load», «Highload»).
     * // Посчитайте, сколько раз объект «High» встречается в коллекции.
     * // Используйте Stream API.
     */
    private static boolean checkString(String inputString) {
        Predicate <String> stringPredicate = str -> (str.toUpperCase().startsWith("J")
                || (str.toUpperCase().startsWith("N")
                && (str.toUpperCase().endsWith("A"))));
        return stringPredicate.test(inputString);
    }

    /**
     *    Написать программу, которая проверяет, что строка начинается буквой “J”или “N” и заканчивается “A”.
     *    Используем функциональный интерфейс Predicate.
     */
    private static void streamObject(List<String> stringList) {
        Long s = stringList.stream()
                .filter(el-> el.equals("High")).count();
        System.out.println(s);
    }

    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     */
    private static int findMissingNumber(int [] nums) {
        int result = 0;
        for (int a : nums) {
            result ^= a;
        }
        for (int i = 0; i < nums.length + 1; i++) {
            result ^= i;
        }
        return result;
    }
}
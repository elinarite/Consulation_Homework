package Consultation_Homework;

import java.util.*;

public class StringExample {

    public static void main(String[] args) {

        //Example 1: Input: s = "leetcode" Output: 0
        String a = "leetcode";
        System.out.println(firstUniqueElements(a));

        //Example 2: Input: s = "loveleetcode" Output: 2
        String b = "loveleetcode";
        System.out.println(firstUniqueElements(b));

        // Example 3: Input: s = "aabb" Output: -1
        String c = "aabb";
        System.out.println(firstUniqueElements(c));

        //Task3
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu feugiat tellus. Nam molestie diam sed libero egestas pellentesque. Nulla";
        numberOfOccurrencesCharacter(text);

    }

    /**
     * 1 уровень сложности: Task 1. Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     */
    private static int firstUniqueElements(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Task 2. Вывод будет 4. Так как использование слова new, мы создаем новый объект со своими hashcode.
     * И поэтому в  Set добавляются все 4 объекта, так как у каждого свой hashcode, и при добавлении в Set,
     * сравнение объектов происходит по hashcode. Если мы хотели добавить 4 строки, и 2 из них имели би одинаковое значение,
     * то результат был бы 3.
     */

    /**
     * Task 3. Дана строка. Вывести количество появлений каждого символа в этой строке. Например:
     * Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu feugiat tellus.
     * Nam molestie diam sed libero egestas pellentesque. Nulla.
     * <p>
     * <p>
     * Символ e встречается 20 раз.
     * Символ пробел/space встречается 19 раз.
     * Символ l встречается 11 раз.
     * Символ i встречается 11 раз.
     * Символ t встречается 11 раз.
     * Символ s встречается 10 раз.
     * Символ u встречается 7 раз.
     * Символ a встречается 7 раз.
     * Символ n встречается 6 раз.
     * Символ m встречается 6 раз.
     * Символ o встречается 6 раз.
     * Символ r встречается 5 раз.
     * Символ . встречается 4 раз.
     * Символ g встречается 4 раз.
     * Символ d встречается 4 раз.
     * Символ c встречается 3 раз.
     * Символ p встречается 3 раз.
     * Символ , встречается 1 раз.
     * Символ f встречается 1 раз.
     * Символ b встречается 1 раз.
     * Символ q встречается 1 раз.
     */
    private static void numberOfOccurrencesCharacter(String text) {
        char[] word = text.toCharArray();
        System.out.println(Arrays.toString(word));
        int a;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == ' ') {
                System.out.println("The character spase occurs " + entry.getValue() + " times.");
            } else {
                System.out.println("The character " + entry.getKey() + " occurs " + entry.getValue() + " times.");

            }
        }
    }
}
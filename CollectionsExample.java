package Consultation_Homework;

import java.util.Stack;

public class CollectionsExample {
    public static void main(String[] args) {

        //Task 1
        String[] operations = new String[]{"5", "2", "C", "D", "+"};
        System.out.println(sumBaseballScore(operations));

        //Tesk 2
        String[] operations2 = new String[]{"1", "C"};
        System.out.println(sumBaseballScore(operations2));

    }

    /*
    Вы ведете счет бейсбольного матча по странным правилам. В начале игры вы начинаете с пустой записи.
    Вам дан список строковых операций, где operation[i] — это i-я операция,
     которую вы должны применить к записи, и она является одной из следующих:
    Целое число x. Запишите новую оценку x.
    '+' - Запишите новую оценку, которая является суммой двух предыдущих оценок.
    'D' - Запишите новый счет, который в два раза больше предыдущего.
    'C' - аннулировать предыдущий счет, удаляя его из записи.
    Верните сумму всех баллов в записи после применения всех операций.
             */
    private static int sumBaseballScore(String[] operations) {
        int newScoreSumTwoPreviousScores;
        int accountTwicePreviousAccount;
        int sum = 0;
        Stack<Integer> baseballScore = new Stack<>();
        for (String value : operations) {
            if (value.equals("+")) {
                int lastElement = baseballScore.pop();
                int previusLastElement = baseballScore.pop();
                newScoreSumTwoPreviousScores = lastElement + previusLastElement;
                baseballScore.push(previusLastElement);
                baseballScore.push(lastElement);
                baseballScore.push(newScoreSumTwoPreviousScores);
            } else if (value.equals("D")) {
                accountTwicePreviousAccount = baseballScore.peek() * 2;
                baseballScore.push(accountTwicePreviousAccount);
            } else if (value.equals("C")) {
                baseballScore.pop();
            } else {
                baseballScore.push(Integer.parseInt(value));
            }
        }
        if (!baseballScore.empty())
            for (int value : baseballScore) {
                sum += value;

            }
        return sum;
    }
}
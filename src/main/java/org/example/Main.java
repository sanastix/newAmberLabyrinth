package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = scanner.nextInt();
        }

        int result = maxCoinsInLabyrinth(N, coins);
        System.out.println(result);

    }

    public static int maxCoinsInLabyrinth(int N, int[] coins) {

        // Створюємо масив для зберігання найкращого результату для кожної комірки
        int[] dp = new int[N + 1];

        // Ініціалізуємо перші дві комірки (з 0-ї і 1-ї)
        dp[0] = 0;
        dp[1] = coins[1];

        // Обчислюємо найкращий результат для кожної комірки від 2 до N
        for (int i = 2; i < N; i++) {
            dp[i] = coins[i] + Math.max(dp[i - 2], i >= 3 ? dp[i - 3] : 0);
        }

        // Остання комірка містить максимальну кількість монеток
        return Math.max(dp[N - 1], dp[N - 2]);
    }

}
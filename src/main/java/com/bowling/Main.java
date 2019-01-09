package com.bowling;

import com.bowling.Model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    private final static Integer DEFAULT_SKITTLE_COUNT = 10;

    public static void main(String[] args) throws IOException {
        System.out.println("Enter your name");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        Player player = new Player(name);
        playBowling(player);
    }

    private static void playBowling(Player player) throws IOException {
        welcomeMessage(player);
        gameProcess();
    }

    private static int randomSkittleCountForFirstThrow() {
        Random random = new Random();
        return random.nextInt(11);
    }

    private static int randomSkittleCountForSecondThrow(int skittleCount) {
        Random random = new Random();
        return random.nextInt(skittleCount + 1);
    }

    private static void welcomeMessage(Player player) {
        System.out.println("Welcome " + player.getName());
        System.out.println("Game start");
    }

    private static void gameProcess() throws IOException {
        Integer firstThrow;
        Integer secondThrow;
        Integer point = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter \"+\" for throw");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String startGameSymbol = reader.readLine();

            if (startGameSymbol.equals("+")) {
                firstThrow = randomSkittleCountForFirstThrow();
                if (firstThrow == 10) {
                    point += firstThrow;
                    System.out.println("Strike");
                } else {
                    secondThrow = randomSkittleCountForSecondThrow(DEFAULT_SKITTLE_COUNT - firstThrow);
                    point += firstThrow + secondThrow;
                    if (firstThrow + secondThrow == DEFAULT_SKITTLE_COUNT) {
                        System.out.println("Spare");
                    } else {
                        System.out.println("Nice try, you have " + point + " point");
                    }
                }
            } else {
                System.out.println("For start enter \"+\"");
            }
        }
        System.out.println("Game end, your point: " + point);
    }
}

package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Write the number of players");
        int numPlayers = myObj.nextInt();

        System.out.println("What size do you want for N?");
        int n = myObj.nextInt();

        System.out.println("What size do you want for P?");
        int p = myObj.nextInt();
        int[][]arreglo = new int[n][p];

        Resource resource = new Resource(0, false, arreglo, n, p);

        for (int i = 0; i <(n*p); i++) {
            new Reader(resource, (i % numPlayers)).start();
            new Player(resource, (i % numPlayers)).start();
        }

    }
}
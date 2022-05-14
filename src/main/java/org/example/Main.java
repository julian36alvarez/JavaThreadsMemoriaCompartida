package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        
        Resource resource = new Resource(2, false);

        for (int i = 0; i < 3; i++) {
            new Reader(resource, i).start();
        }
        for (int i = 0; i < 3; i++) {
            new Player(resource, i).start();
        }
    }
}
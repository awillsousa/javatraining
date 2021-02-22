package com.bootcamp.inter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// Generate a list of numbers and print it
        Random randomGen = new Random();
        List<Integer> numbers = new ArrayList<Integer>(20);

        for (int i=0;i<20;i++) {
            numbers.add(randomGen.nextInt(10000));
        }

        System.out.println(numbers.toString());


    }
}

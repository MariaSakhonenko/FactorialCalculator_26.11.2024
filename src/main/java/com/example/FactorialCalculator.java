package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FactorialCalculator
{

    public List<BigInteger> calculateFactorials(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("Input must be a natural number greater than zero.");
        }

        List<BigInteger> factorials = new ArrayList<>();
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= n; i++)
        {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            factorials.add(factorial);
        }

        return factorials;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number greater than zero: ");
        
        int n = 0;
        
        try 
        {
            n = Integer.parseInt(scanner.nextLine());
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Invalid input. Please enter a natural number greater than zero.");
            return;
        }

        try 
        {
            FactorialCalculator calculator = new FactorialCalculator();
            List<BigInteger> factorials = calculator.calculateFactorials(n);
            System.out.println("Factorials from 1 to " + n + ":");
            factorials.forEach(System.out::println);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println(e.getMessage());
        } 
        finally 
        {
            scanner.close();
        }
    }
}

package ru.vsu.cs.ivanov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = readDouble('x');
        int n = readInteger('n');
        double e = readDouble('e');

        double SumOfNMembersOfSequence = calculateSumOfNMembersOfSequence(x, n);
        printResult("sum of n members of sequence", SumOfNMembersOfSequence);

        double SumOfMembersGreaterThanE = calculateSumOfMembersGreaterThanE(x, n, e);
        printResult("sum of n members of sequence greater than e in absolute value", SumOfMembersGreaterThanE);

        double SumOfMembersGreaterThanEDividedTen = calculateSumOfMembersGreaterThanE(x, n, e / 10);
        printResult("sum of n members of sequence greater than e divided ten in absolute value", SumOfMembersGreaterThanEDividedTen);

        double functionValue = calculatedFunctionValue(x);
        printResult("function value", functionValue);
    }

    private static double readDouble(char name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("enter %s: ", name);
        return scanner.nextDouble();
    }

    private static int readInteger(char name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("enter %s: ", name);
        return scanner.nextInt();
    }

    private static void printResult(String phrase, double result) {
        System.out.printf("%s = %.3f%n", phrase, result);
    }

    private static double calculateSumOfNMembersOfSequence(double x, int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += getNMemberOfSequence(x, i);
        }
        return sum;
    }

    private static double calculateSumOfMembersGreaterThanE(double x, int n, double e) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            if (getNMemberOfSequence(x, i) > e) {
                sum += getNMemberOfSequence(x, i);
            }
        }
        return sum;
    }

    private static double calculatedFunctionValue(double x) {
        return Math.pow(Math.exp(1), x * (-1));
    }

    private static double getNMemberOfSequence(double x, int n) {
        return (Math.pow(-1, n) * Math.pow(x, n)) / getFactorial(n);
    }

    public static int getFactorial(int x) {
        int factorial = 1;
        for (int i = 1; i <= x; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

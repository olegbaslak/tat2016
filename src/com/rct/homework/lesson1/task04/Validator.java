package com.rct.homework.lesson1.task04;

/**
 * Validates String arguments
 *
 * @author Oleg Baslak
 * @version 1.1
 * @since 03-10-2016
 */

class Validator {

    private static final String PARSE_ERROR = "Can't parse command line argument to number.";


    /**
     * Parses arguments {@code String[]} and returns
     * parsed to {@code double[]} array of coefficients
     *
     * @param args arguments from command line to parse
     * @return parsed coefficients
     */
    static double[] parse(String[] args) {
        double[] parsedCoefficients = new double[Main.NUMBER_OF_ARGUMENTS];
        try {
            for (int i = 0; i < parsedCoefficients.length; i++) {
                parsedCoefficients[i] = Double.parseDouble(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println(PARSE_ERROR);
            System.exit(1);
        }
        return parsedCoefficients;
    }

    /**
     * Checks if {@code}double number on input == 0
     *
     * @param number number to check
     * @return {@code true} if {@code number} is zero
     * {@code false} otherwise
     */
    static boolean isZero(double number) {
        return Double.isInfinite(1. / number);
    }
}

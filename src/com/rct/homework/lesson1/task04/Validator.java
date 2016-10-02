package com.rct.homework.lesson1.task04;

/**
 * Validates String arguments
 *
 * @author Oleg Baslak
 * @version 1.0
 * @since 30-09-2016
 */

class Validator {

    static double[] parse(String[] args) {
        double[] parsedCoefficients = new double[Main.NUMBER_OF_ARGUMENTS];
        try {
            for (int i = 0; i < parsedCoefficients.length; i++) {
                parsedCoefficients[i] = Double.parseDouble(args[i]);
            }
        }catch (NumberFormatException e){
            e.getMessage();

            System.exit(1);
        }

        return parsedCoefficients;
    }

}

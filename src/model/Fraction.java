/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jorge A. Cano
 */
public class Fraction {

    private int numerator;
    private int denominator;
    private static final String FRACTIONAL_BAR = "/";
    private static final String BLANK_SPACE = " ";

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (!this.isZero(denominator)) {
            this.denominator = denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (!this.isZero(denominator)) {
            this.denominator = denominator;
        }
    }

    @Override
    public String toString() {
        String fraction;
        if (this.isProperFraction()) {
            fraction = this.numerator + Fraction.FRACTIONAL_BAR + this.denominator;
        } else if (this.isInteger()) {
            fraction = String.valueOf((int) this.numerator / this.denominator);
        } else {
            fraction = String.valueOf((int) this.numerator / this.denominator)
                    + Fraction.BLANK_SPACE + this.numerator % this.denominator + Fraction.FRACTIONAL_BAR + this.denominator;
        }
        return fraction;
    }

    private boolean isProperFraction() {
        return this.numerator <= this.denominator;
    }

    private boolean isInteger() {
        return (this.numerator % this.denominator) == 0;
    }

    private boolean isZero(int denominator) {
        return denominator == 0;
    }

}

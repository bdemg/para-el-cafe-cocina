/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * This class represents a fractionary number.
 * @author Jorge A. Cano
 */
public class Fraction {
    
    private static final String FRACTIONAL_BAR = "/";
    private static final String BLANK_SPACE = " ";

    private int numerator;
    private int denominator;
    

    public Fraction( int input_numerator, int input_denominator ) {
        
        this.numerator = input_numerator;
        
        if ( !this.isZero( input_denominator ) ) {
            this.denominator = input_denominator;
        }
    }

    
    public int getNumerator() {
        
        return numerator;
    }

    
    public int getDenominator() {
        
        return denominator;
    }

    
    public void setNumerator( int input_numerator ) {
        
        this.numerator = input_numerator;
    }

    
    public void setDenominator( int input_denominator ) {
        
        //only set the denominator if it is different to zero
        if ( !this.isZero( input_denominator ) ) {
            this.denominator = input_denominator;
        }
    }

    
    @Override
    public String toString() {
        
        String fractionRepresentation;
        
        //the fraction is represented differently, depending on wether it is a proper fraction, a
        //whole number or a mixed fraction
        if ( this.isProperFraction() ) {
            fractionRepresentation = this.numerator + Fraction.FRACTIONAL_BAR +
                    this.denominator;
            
        } else if ( this.isWholeNumber() ) {
            fractionRepresentation = String.valueOf( this.getWholeNumber() );
            
        } else {
            fractionRepresentation = this.getWholeNumber()  +
                    Fraction.BLANK_SPACE + this.reminderNumerator() +
                    Fraction.FRACTIONAL_BAR + this.denominator;
            
        }
        
        return fractionRepresentation;
    }

    
    private boolean isProperFraction() {
        
        return this.numerator < this.denominator;
    }

    
    private boolean isWholeNumber() {
        
        return (this.numerator % this.denominator) == 0;
    }

    
    private int getWholeNumber() {
        
         return this.numerator / this.denominator;
    }
    
    
    private int reminderNumerator() {
        
        return this.numerator % this.denominator;
    }
    
    
    private boolean isZero( int input_denominator ) {
        
        return input_denominator == 0;
    }
    
}

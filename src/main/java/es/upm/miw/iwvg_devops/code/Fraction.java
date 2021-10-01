package es.upm.miw.iwvg_devops.code;

import java.util.Objects;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper(){
        return this.getDenominator() > this.getNumerator();
    }

    public boolean isImproper()
    {
        return this.denominator < this.numerator;
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction(
                this.numerator * fraction.getNumerator(),
                this.denominator * fraction.getDenominator()
        );
    }

    public Fraction divide(Fraction fraction) {
        return new Fraction(
                this.numerator * fraction.getDenominator(),
                this.denominator * fraction.getNumerator()
        );
    }

    public boolean isEquivalent(Fraction fraction){
        return (this.numerator * fraction.denominator == this.denominator * fraction.numerator)
    }

    public Fraction sum(Fraction fraction){
        if(this.denominator != fraction.denominator){
            int leastCommonMultiple = this.leastCommonMultiple(fraction.denominator);
            return new Fraction(this.getNewFraction(leastCommonMultiple)
                    + fraction.getNewFraction(leastCommonMultiple),
                    leastCommonMultiple);
        }
        else return new Fraction(this.numerator + fraction.numerator, this.denominator);
    }

    private int leastCommonMultiple(int denominator){
        int highestNumber = Math.max(this.denominator, denominator);
        int minNumber = Math.min(this.denominator, denominator);
        return (highestNumber / this.leastCommonDivision(denominator))*minNumber;
    }

    private int leastCommonDivision(int denominator){
        int highestNumber = Math.max(this.denominator, denominator);
        int minNumber = Math.min(this.denominator, denominator);
        int result;
        do{
            result = minNumber;
            minNumber = highestNumber % minNumber;
            highestNumber = result;
        }while (minNumber != 0);
        return result;
    }

    private int getNewFraction(int leastCommonMultiple){
        int multiplyBy = leastCommonMultiple / this.denominator;
        return this.numerator* multiplyBy;
    }
    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}

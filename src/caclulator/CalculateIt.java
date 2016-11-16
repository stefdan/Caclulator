/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caclulator;

/**
 *
 * @author Gruenewald
 */
public class CalculateIt {
    private CalculateIt(){}
    
    /**
     * Ermittelt die Potenz zur Basis x mit dem exponenten y
     * Eine übergabe von 0 als Basis bei einem negativen Exponenten
     * bidingt eine Exception
     * @param x Basis der Potenz
     * @param y Exponent der Potenz
     * @return die potenz von x hoch y
     * @throws caclulator.CalculationException 
     */
    public static double getPower(int x, int y) throws CalculationException {
        if (y == 0) {
            return 1;
        }
        double result = x;
        //int loops = Math.abs(y);
        int loops = y;
        if(loops < 0) loops *= (-1);
        for (int i = 1; i < loops; i++) {
            result = result * x;
        }
        if (y < 0) {
            if(x==0) throw new CalculationException("Zero in base with negative exponent");
            result = 1.0 / result;
        }
        return result;
    }

    /**
     * Ermittelt ob der übergebene Parameter eine Primzahl ist
     * @param num zu überprüfende Zahl. Zahl muss größer als 1 sein
     * @return Boolscher Wert, true wenn Primzahl
     */
    public static boolean isPrimeNumber(int num) throws CalculationException
    {
        if(num < 2) throw new CalculationException("only positive natural numbers exclusive 0 and 1 are allowed");
        boolean retval = true;
        if(num % 2 == 0 && num != 2) return false;
        for (int i = 3; i <= num / 2; i+=2) {
            if(num % i == 0)
            {
                retval = false;
                break;
            }
        }
        return retval;  
    }
}

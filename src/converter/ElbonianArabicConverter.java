package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        number = number.trim();
        this.number = number;
        if (number.length() < 1){
            throw new MalformedNumberException("The String length is 0");
        }
        if (!(isArabic(number) || isElbonian(number))){
            throw new MalformedNumberException("The String is not Elbonian or Arabic");
        }
        if (!(withinRange(number))){
            throw new ValueOutOfBoundsException("The String is not within the range");
        }
        // TODO check to see if the number is valid, then set it equal to the string
        //
        // formatElbonian(number);




    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        if (isArabic(number)){
            return Integer.parseInt(number);
        }
        HashMap<Character, Integer> relValue = new HashMap<>();
        relValue.put('M', 1000);
        relValue.put('C', 100);
        relValue.put('D', 500);
        relValue.put('B', 400);
        relValue.put('X', 10);
        relValue.put('L', 50);
        relValue.put('K', 40);
        relValue.put('I', 1);
        relValue.put('V', 5);
        relValue.put('U', 4);
        relValue.put('m', 900);
        relValue.put('c', 90);
        relValue.put('x', 9);

        int value = 0;
        for (char c : number.toCharArray()){
            value += relValue.get(c);
        }
        return value;

    }

    public boolean isArabic(String number){
        for (char c : number.toCharArray()){
            if (!Character.isDigit(c) && c!= '-'){
                return false;
            }
        }
        return true;
    }

    // TODO make sure that 3999 is the largest number we can generate
    public boolean withinRange(String number){
        if (isArabic(number)){
            int realNum = Integer.parseInt(number);
            if (realNum > 3999 || realNum <=0){
                return false;
            }
            return true;
        }else{
            return true;
        }
    }

    public boolean isElbonian(String number){
        for (char c : number.toCharArray()){
            if (! (c == 'M'
                    || c == 'm'
                    || c == 'm'
                    || c == 'D'
                    || c == 'B'
                    || c == 'C'
                    || c == 'c'
                    || c == 'L'
                    || c == 'K'
                    || c == 'X'
                    || c == 'x'
                    || c == 'V'
                    || c == 'U'
                    || c == 'I'
            )){
                return false;
            }
        }
        HashMap<Character, Integer> characterCount = new HashMap<>();
        LinkedList<Character> repeatVals = new LinkedList<Character>(Arrays.asList('M', 'C', 'X', 'I'));
        for (char c : repeatVals){
            int count = number.length() - number.replaceAll("" + c, "").length();
            if (count > 3){
                return false;
            }
            if (count !=0){
                characterCount.put(c, count);
            }
        }

        LinkedList<Character> singleVals = new LinkedList<Character>(Arrays.asList('m', 'c', 'x', 'D', 'L', 'V', 'B', 'K', 'U'));
        for (char c : singleVals){
            int count = number.length() - number.replaceAll("" + c, "").length();
            if (count > 1){
                return false;
            }
            if (count != 0){
                characterCount.put(c, count);
            }
        }

        if (characterCount.containsKey('B') && characterCount.containsKey('C')){
            return false;
        }
        if (characterCount.containsKey('K') && characterCount.containsKey('X')){
            return false;
        }
        if (characterCount.containsKey('U') && characterCount.containsKey('I')){
            return false;
        }
        if (characterCount.containsKey('m') && characterCount.containsKey('D')){
            return false;
        }
        if (characterCount.containsKey('m') && characterCount.containsKey('B')){
            return false;
        }
        if (characterCount.containsKey('m') && characterCount.containsKey('C')){
            return false;
        }
        if (characterCount.containsKey('c') && characterCount.containsKey('L')){
            return false;
        }
        if (characterCount.containsKey('c') && characterCount.containsKey('K')){
            return false;
        }
        if (characterCount.containsKey('c') && characterCount.containsKey('X')){
            return false;
        }
        if (characterCount.containsKey('x') && characterCount.containsKey('V')){
            return false;
        }
        if (characterCount.containsKey('x') && characterCount.containsKey('U')){
            return false;
        }
        if (characterCount.containsKey('x') && characterCount.containsKey('I')){
            return false;
        }

        HashMap<Character, Integer> relValue = new HashMap<>();
        relValue.put('M', 1000);
        relValue.put('C', 100);
        relValue.put('D', 500);
        relValue.put('B', 400);
        relValue.put('X', 10);
        relValue.put('L', 50);
        relValue.put('K', 40);
        relValue.put('I', 1);
        relValue.put('V', 5);
        relValue.put('U', 4);
        relValue.put('m', 900);
        relValue.put('c', 90);
        relValue.put('x', 9);

        char prev = 0;
        for (char c : number.toCharArray()){
            if (prev == 0){
                prev = c;
                continue;
            }
            if (relValue.get(c) > relValue.get(prev)){
                return false;
                // TODO Might have to add another something inside this to be able to catch the 'K'
                // TODO The letter K would never appear before C, x, B or L but would appear before X
            }
            prev = c;
        }
        return true;
    }


    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        if (isElbonian(number)){
            return number;
        }

        int val = toArabic();
        StringBuilder ret = new StringBuilder();
        while (val > 0){
            if(val >= 1000){
                ret.append('M');
                val -= 1000;
            }
            else if(val >= 900){
                ret.append('m');
                val -= 900;
            }else if(val >= 500){
                ret.append('D');
                val -= 500;
            }else if(val >= 400){
                ret.append('B');
                val -= 400;
            }else if(val >= 100){
                ret.append('C');
                val -= 100;
            }else if(val >= 90){
                ret.append('c');
                val -= 90;
            }else if(val >= 50){
                ret.append('L');
                val -= 50;
            }else if(val >= 40){
                ret.append('K');
                val -= 40;
            }else if(val >= 10){
                ret.append('X');
                val -= 10;
            }else if(val >= 5){
                ret.append('x');
                val -= 5;
            }else if(val >=4){
                ret.append('U');
                val -= 4;
            }else if(val >= 1){
                ret.append('I');
                val -= 1;
            }
        }
        // TODO ask Eric about 'K' before 'x' and why we have to fix that
        String retString = ret.toString();
        return retString;
    }



    // TODO not using this method below
    public void formatElbonian(String number) throws MalformedNumberException {

        if(number.contains(" "))
        {
            throw new MalformedNumberException("Contains Spaces");
        }


        HashMap<Character, Character> invalidPairsLower = new HashMap<>();
        HashMap<Character, Character> invalidPairsUpper = new HashMap<>();
        char[] specialExceptions = new char[6];
        specialExceptions[0] = 'm';
        specialExceptions[1] = 'c';
        specialExceptions[2] = 'x';
        specialExceptions[3] = 'B';
        specialExceptions[4] = 'K';
        specialExceptions[5] = 'U';

        //contains invalid pairings
        invalidPairsLower.put('C', 'm');
        invalidPairsLower.put('B', 'm');
        invalidPairsLower.put('D', 'm');
        invalidPairsLower.put('L', 'c');
        invalidPairsLower.put('K', 'c');
        invalidPairsLower.put('X', 'c');
        invalidPairsLower.put('V', 'x');
        invalidPairsLower.put('U', 'x');
        invalidPairsLower.put('I', 'x');

        invalidPairsUpper.put('C', 'B');
        invalidPairsUpper.put('X', 'K');
        invalidPairsUpper.put('I', 'U');

        String resultString = "";
        String checkString = "mcxDLVBKU";
        char[] number_array = number.toCharArray();
        for(char index : number_array){
            if(resultString.contains(Character.toString(index))){
                throw new MalformedNumberException("Dupicate Char");
            }
            else if(checkString.contains(Character.toString(index))){
                resultString = resultString + Character.toString(index);
            }
        }
        for(char index : specialExceptions) {
            if(number.contains(Character.toString(index))) {
                for (char element : number_array) {
                    if(invalidPairsLower.containsKey(element)) {
                        if (invalidPairsLower.get(element).equals(index)) {
                            throw new MalformedNumberException("Invalid Combination of Characters (Lower)");
                        }
                    }
                    if(invalidPairsUpper.containsKey(element)){
                        if(invalidPairsUpper.get(element).equals(index)){
                            throw new MalformedNumberException("Invalid Combination of Characters (Upper)");
                        }
                    }
                }
            }
        }



    }






}

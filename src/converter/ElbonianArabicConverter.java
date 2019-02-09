package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;
import java.util.HashMap;

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

        // TODO check to see if the number is valid, then set it equal to the string
        number = number.trim();
        formatElbonian(number);



        this.number = number;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        try {
            return Integer.parseInt(this.number);
        }
        catch(NumberFormatException e){
            return 1;
        }

    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        return "I";
    }

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

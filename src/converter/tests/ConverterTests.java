package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberSpaces() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M M");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberB() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("BC");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberK() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("KX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberU() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("UI");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumbercL() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("cL");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumbercK() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("cK");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumbercX() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("cX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumbermD() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("mD");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumbermB() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("mB");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumbermC() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("mC");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberxV() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("xV");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberxU() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("xU");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberxI() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("xI");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberDoubleL() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LL");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumbertripleB() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("BBB");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberBaB() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("BaB");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberGtoL() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberGtoL2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MCIX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberGtoL3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Lm");
    }


    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }


    @Test
    public void AlreadyArabic() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("8");
        assertEquals(converter.toArabic(), 8);
    }

    @Test
    public void AlreadyArabicTrailing() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("5 ");
        assertEquals(converter.toArabic(), 5);
    }

    @Test
    public void AlreadyArabicLeading() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  7");
        assertEquals(converter.toArabic(), 7);
    }

}

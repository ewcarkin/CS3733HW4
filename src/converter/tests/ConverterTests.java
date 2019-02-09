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

    @Test
    public void ArabicToElbonianSampleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M");
        assertEquals(converter.toArabic(), 1000);
    }

    @Test
    public void ArabicToElbonianSampleTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MD");
        assertEquals(converter.toArabic(), 1500);
    }

    @Test
    public void ArabicToElbonianSampleTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DC");
        assertEquals(converter.toArabic(), 600);
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

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberSpaceInMiddle() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9 9");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumber3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Ma");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumber4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("BMC");
    }



    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("4000");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("8531");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-1");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
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

    @Test
    public void ArabicToElbow1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("7");
        assertEquals(converter.toElbonian(), "VII");
    }

    @Test
    public void ArabicToElbow2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3999");
        assertEquals(converter.toElbonian(), "MMMmcx");
    }

    @Test
    public void ArabicToElbow3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbow4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("903");
        assertEquals(converter.toElbonian(), "mIII");
    }

    @Test
    public void ArabicToElbow5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("407");
        assertEquals(converter.toElbonian(), "BVII");
    }

    @Test
    public void ElbowToArabic1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMDBcx");
        assertEquals(converter.toArabic(), 3999);
    }

    @Test
    public void ElbowToArabic2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MXXVII");
        assertEquals(converter.toArabic(), 1027);
    }

    @Test
    public void ElbowToArabic3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("V");
        assertEquals(converter.toArabic(), 5);
    }

    @Test(expected = MalformedNumberException.class)
    public void MultipleChar1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMM");
    }

    @Test(expected = MalformedNumberException.class)
    public void MultipleChar2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCC");
    }

    @Test(expected = MalformedNumberException.class)
    public void MultipleChar3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XXXX");
    }

    @Test(expected = MalformedNumberException.class)
    public void MultipleChar4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IIII");
    }

    @Test(expected = MalformedNumberException.class)
    public void MultipleChar5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCM");
    }

    @Test(expected = MalformedNumberException.class)
    public void SingleChar1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("xxIII");
    }
    @Test(expected = MalformedNumberException.class)
    public void SingleChar2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("mmx");
    }

    @Test(expected = MalformedNumberException.class)
    public void SingleChar3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("cc");
    }

    @Test(expected = MalformedNumberException.class)
    public void SingleChar4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DD");
    }

    @Test(expected = MalformedNumberException.class)
    public void SingleChar5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LL");
    }

    @Test(expected = MalformedNumberException.class)
    public void SingleChar6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VV");
    }

    @Test(expected = MalformedNumberException.class)
    public void SingleChar7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Bcc");
    }

    @Test(expected = MalformedNumberException.class)
    public void SingleChar8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("BB");
    }

    @Test(expected = MalformedNumberException.class)
    public void SingleChar9() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("KK");
    }

    @Test(expected = MalformedNumberException.class)
    public void SingleChar10() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("UU");
    }

    @Test(expected = MalformedNumberException.class)
    public void InvalidChar1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("a");
    }

    @Test(expected = MalformedNumberException.class)
    public void InvalidChar2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("F");
    }

    @Test(expected = MalformedNumberException.class)
    public void OrderCheck1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMcD");
    }

    @Test(expected = MalformedNumberException.class)
    public void OrderCheck2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("cD");
    }

    @Test(expected = MalformedNumberException.class)
    public void OrderCheck3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("UM");
    }

    @Test(expected = MalformedNumberException.class)
    public void OrderCheck4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("BIK");
    }

    @Test(expected = MalformedNumberException.class)
    public void OrderCheck5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VL");
    }

    @Test(expected = MalformedNumberException.class)
    public void OrderCheck6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IL");
    }





}



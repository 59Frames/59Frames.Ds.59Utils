package _59frames.Ds._59utils.validation;

import _59frames.Ds._59utils.RandomString;
import _59frames.Ds._59utils.math.Silvester;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @BeforeEach
    void setUp() {
        trueMails.add("info@danielseifert.ch");
        trueMails.add("daniel.seifert@seifert.ch");
        trueMails.add("florian.baumgartner@afs.ch.ch");
        trueMails.add("email@example.com");
        trueMails.add("firstname.lastname@example.com");
        trueMails.add("email@subdomain.example.com");
        trueMails.add("firstname+lastname@example.com");
        trueMails.add("email@123.123.123.123");
        trueMails.add("email@[123.123.123.123]");
        trueMails.add("\"email\"@example.com");
        trueMails.add("1234567890@example.com");
        trueMails.add("email@example-one.com");
        trueMails.add("_______@example.com");
        trueMails.add("email@example.name");
        trueMails.add("email@example.museum");

        for (int i = 0; i < 100; i++) {
            positiveNumbers.add(String.valueOf(Silvester.randomInt(1, 100)));
        }

        for (int i = 0; i < 100; i++) {
            negativeNumbers.add(String.valueOf(Silvester.randomInt(-100, -1)));
        }

        for (int i = 0; i < 100; i++) {
            trueNumbers.add(String.valueOf(Silvester.randomInt()));
        }

        trueDates.add("2000.06.04");
        trueDates.add("2000/06/04");
        trueDates.add("2000-06-04");

        trueDomains.add("daniel.seifert.ch");
        trueDomains.add("danielseifert.ch");
        trueDomains.add("google.com");
        trueDomains.add("abc.xyz");
        trueDomains.add("alphabet.xyz");

        trueHex.add("#000");
        trueHex.add("#FFF");
        trueHex.add("#F00");
        trueHex.add("#FF00FF");
        trueHex.add("#AABBCC");
        trueHex.add("#AAB0B0");
        trueHex.add("#F0F");

        trueIpv4.add("127.1.1.0");
        trueIpv4.add("8.8.8.8");
        trueIpv4.add("192.168.1.120");

        // trueIpv6.add("");

        falseMails.add("#@%^%#$@#$@#.com");
        falseMails.add("@example.com");
        falseMails.add("Joe Smith <email@example.com>");
        falseMails.add("email.example.com");
        falseMails.add("email@example@example.com");
        falseMails.add(".email@example.com");
        falseMails.add("email.@example.com");
        falseMails.add("email..email@example.com");
        falseMails.add("あいうえお@example.com");
        falseMails.add("email@example.com (Joe Smith)");
        falseMails.add("email@example");
        falseMails.add("email@-example.com");
        falseMails.add("email@example.web");
        falseMails.add("email@111.222.333.44444");
        falseMails.add("email@example..com");
        falseMails.add("Abc..123@example.com");

        for (int i = 0; i < 100; i++) {
            falseNumbers.add(new RandomString.Builder().withSymbols("ABCDEFGHIJKLMNOPQRSTUVWXYZ").build().nextString());
        }

        falseDates.add("04:06:20");
        falseDates.add("2000_06_04");
        falseDates.add("2000-31-02");

        falseDomains.add("google.c");
        falseDomains.add("@domain.ch");
        falseDomains.add("test domain.com");

        falseHex.add("#0G0");

        falseIpv4.add("1...");
        falseIpv4.add("192.168.1.xxx");

        //falseIpv6.add("");
    }

    @AfterEach
    void tearDown() {
        trueDates.clear();
        trueHex.clear();
        trueIpv4.clear();
        trueNumbers.clear();
        trueIpv6.clear();
        trueDomains.clear();
        trueMails.clear();

        positiveNumbers.clear();
        negativeNumbers.clear();

        falseDates.clear();
        falseIpv6.clear();
        falseHex.clear();
        falseIpv4.clear();
        falseDomains.clear();
        falseNumbers.clear();
        falseMails.clear();
    }


    private ArrayList<String> trueMails = new ArrayList<>();
    private ArrayList<String> falseMails = new ArrayList<>();
    @Test
    void isEmail() {
        boolean isTrueMails = false;
        boolean isFalseMails = false;

        for (String email : trueMails){
            isTrueMails = Validator.isEmail(email);
        }

        for (String email : falseMails){
            isFalseMails = Validator.isEmail(email);
        }

        assertTrue(isTrueMails);
        assertFalse(isFalseMails);

    }

    @Test
    void isPassword() {
        String validPw = "seife!1012";

        assertTrue(Validator.isPassword(validPw, 8, RegexRule.DIGIT, RegexRule.LOWERCASE));
    }

    @Test
    void isPassword1() {
    }

    @Test
    void isPassword2() {
    }

    @Test
    void matchesPasswordStrength() {
    }

    private ArrayList<String> positiveNumbers = new ArrayList<>();
    @Test
    void isPositiveNumber() {
        for (String s : positiveNumbers) {
            assertTrue(Validator.isPositiveNumber(s));
        }
    }

    private ArrayList<String> negativeNumbers = new ArrayList<>();
    @Test
    void isNegativeNumber() {
        for (String s : negativeNumbers) {
            assertTrue(Validator.isNegativeNumber(s));
        }
    }

    private ArrayList<String> trueNumbers = new ArrayList<>();
    private ArrayList<String> falseNumbers = new ArrayList<>();
    @Test
    void isNumber() {
        for (String s : trueNumbers) {
            assertTrue(Validator.isNumber(s));
        }

        for (String s : falseNumbers) {
            assertFalse(Validator.isNumber(s));
        }
    }

    private ArrayList<String> trueIpv4 = new ArrayList<>();
    private ArrayList<String> falseIpv4 = new ArrayList<>();
    @Test
    void isIpv4() {
        for (String s : trueIpv4) {
            assertTrue(Validator.isIpv4(s));
        }

        for (String s : falseIpv4) {
            assertFalse(Validator.isIpv4(s));
        }
    }

    @Test
    void isIPv6StdAddress() {
    }

    @Test
    void isIPv6HexCompressedAddress() {
    }

    private ArrayList<String> trueIpv6 = new ArrayList<>();
    private ArrayList<String> falseIpv6 = new ArrayList<>();
    @Test
    void isIpv6() {
    }

    @Test
    void isMMDDYYYYDate() {
    }

    @Test
    void isDDMMYYYYDate() {
    }

    private ArrayList<String> trueDates = new ArrayList<>();
    private ArrayList<String> falseDates = new ArrayList<>();
    @Test
    void isDate() {
        for (String s : trueDates) {
            assertTrue(Validator.isDate(s));
        }

        for (String s : falseDates) {
            assertFalse(Validator.isDate(s));
        }
    }

    private ArrayList<String> trueHex = new ArrayList<>();
    private ArrayList<String> falseHex = new ArrayList<>();
    @Test
    void isHexColor() {
        for (String s : trueHex) {
            assertTrue(Validator.isHexColor(s));
        }

        for (String s : falseHex) {
            assertFalse(Validator.isHexColor(s));
        }
    }

    private ArrayList<String> trueDomains = new ArrayList<>();
    private ArrayList<String> falseDomains = new ArrayList<>();
    @Test
    void isDomain() {
        for (String s : trueDomains) {
            assertTrue(Validator.isDomain(s));
        }

        for (String s : falseDomains) {
            assertFalse(Validator.isDomain(s));
        }
    }
}
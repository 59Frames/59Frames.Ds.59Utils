package _59frames.Ds._59utils.validation;

import _59frames.Ds._59utils.RandomString;
import _59frames.Ds._59utils.Stringlify;
import _59frames.Ds._59utils.math.Silvester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
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

        trueDates.add("");

        trueDomains.add("");

        trueHex.add("");

        trueIpv4.add("");

        trueIpv6.add("");

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
    }

    private ArrayList<String> trueHex = new ArrayList<>();
    private ArrayList<String> falseHex = new ArrayList<>();
    @Test
    void isHexColor() {
    }

    private ArrayList<String> trueDomains = new ArrayList<>();
    private ArrayList<String> falseDomains = new ArrayList<>();
    @Test
    void isDomain() {

    }
}
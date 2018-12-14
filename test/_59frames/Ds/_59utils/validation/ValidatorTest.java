package _59frames.Ds._59utils.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private ArrayList<String> trueMails = new ArrayList<>();
    private ArrayList<String> falseMails = new ArrayList<>();

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
    }

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

    @Test
    void isPositiveNumber() {
    }

    @Test
    void isNegativeNumber() {
    }

    @Test
    void isNumber() {
    }

    @Test
    void isIpv4() {
    }

    @Test
    void isIPv6StdAddress() {
    }

    @Test
    void isIPv6HexCompressedAddress() {
    }

    @Test
    void isIpv6() {
    }

    @Test
    void isMMDDYYYYDate() {
    }

    @Test
    void isDDMMYYYYDate() {
    }

    @Test
    void isDate() {
    }

    @Test
    void isHexColor() {
    }

    @Test
    void isDomain() {
    }
}
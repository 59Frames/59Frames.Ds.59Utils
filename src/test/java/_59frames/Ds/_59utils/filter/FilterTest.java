package _59frames.Ds._59utils.filter;

import _59frames.Ds._59utils.RandomString;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@link FilterTest}
 *
 * @author Daniel Seifert
 * @version 1.0.0
 * @since 1.0.0
 */
public class FilterTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testCriteria() {
        Collection<String> strings = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            strings.add(RandomString.randomString(2));
        }

        Collection<String> resultAnd = LogicCriterion.applyAnd(strings, new StringCriterion("aa"));
        Collection<String> resultOr = LogicCriterion.applyOr(strings, new StringCriterion("bb"), new StringCriterion("aa"));

        System.out.println(resultAnd);
        System.out.println(resultOr);
    }
}

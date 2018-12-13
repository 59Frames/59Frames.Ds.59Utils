import _59frames.Ds._59utils.filter.Criterion;
import _59frames.Ds._59utils.validation.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static _59frames.Ds._59utils.PromptHandler.print;
import static _59frames.Ds._59utils.validation.PasswordRule.*;

public class Test {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();

        strings.add("Daniel");
        strings.add("Max");
        strings.add("Justin");
        strings.add("Florian");
        strings.add("Cedi");

        StringCriterion criterion = new StringCriterion("e");

        print(criterion.meetCriteria(strings));

    }

    public static class StringCriterion implements Criterion<String> {

        private final String matcher;

        public StringCriterion(String matcher) {
            this.matcher = matcher;
        }

        @Override
        public Collection<String> meetCriteria(Collection<String> list) {
            HashSet<String> set = new HashSet<>();

            for (String str : list) {
                if (str.contains(matcher)) {
                    set.add(str);
                }
            }

            return new ArrayList<>(set);
        }
    }
}

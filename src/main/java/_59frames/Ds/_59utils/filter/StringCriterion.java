package _59frames.Ds._59utils.filter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@link StringCriterion}
 *
 * @author Daniel Seifert
 * @version 1.0.0
 * @since 1.0.0
 */
public class StringCriterion implements Criterion<String> {

    private final String filterFor;

    public StringCriterion(String filterFor) {
        this.filterFor = filterFor;
    }

    @Override
    public Collection<String> meetCriteria(Collection<String> list) {
        ArrayList<String> collection = new ArrayList<>();

        for (String s : list) {
            if (s.contains(filterFor)) {
                collection.add(s);
            }
        }

        return collection;
    }
}

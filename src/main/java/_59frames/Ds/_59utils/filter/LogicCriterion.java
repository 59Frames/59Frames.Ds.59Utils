package _59frames.Ds._59utils.filter;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@link LogicCriterion}
 *
 * @author Daniel Seifert
 * @version 1.0.0
 * @since 1.0.0
 */
public class LogicCriterion {

    private LogicCriterion(){

    }

    @SafeVarargs
    @NotNull
    public static <T> Collection<T> applyAnd(Collection<T> collection, @NotNull Criterion<T>... criteria) {
        Collection<T> ppl = new ArrayList<>(collection);

        for (Criterion<T> c : criteria)
            ppl = c.meetCriteria(ppl);

        return ppl;
    }

    @SafeVarargs
    @NotNull
    @Contract("_, _ -> new")
    public static <T> Collection<T> applyOr(Collection<T> collection, @NotNull Criterion<T>... criteria) {
        ArrayList<T> ppl = new ArrayList<>();

        for (Criterion<T> c : criteria)
            ppl.addAll(c.meetCriteria(collection));

        return new ArrayList<>(ppl);
    }
}

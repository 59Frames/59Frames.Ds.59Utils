package _59frames.Ds._59utils.filter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AndCriterion<T> implements Criterion<T> {

    private Criterion<T>[] criteria;

    @NotNull
    @SafeVarargs
    public AndCriterion(@NotNull Criterion<T>... criteria) {
        this.criteria = criteria;
    }

    @NotNull
    @Override
    public List<T> meetCriteria(@NotNull List<T> list) {
        List<T> ppl = new ArrayList<>(list);

        for (Criterion<T> c : criteria)
            ppl = c.meetCriteria(ppl);

        return ppl;
    }
}

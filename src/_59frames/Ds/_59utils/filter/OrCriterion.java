package _59frames.Ds._59utils.filter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OrCriterion<T> implements Criterion<T> {

    private Criterion<T>[] criteria;

    @NotNull
    @SafeVarargs
    public OrCriterion(@NotNull Criterion<T>... criteria) {
        this.criteria = criteria;
    }

    @NotNull
    @Override
    public List<T> meetCriteria(@NotNull List<T> list) {
        HashSet<T> ppl = new HashSet<>();

        for (Criterion<T> c : criteria)
            ppl.addAll(c.meetCriteria(list));

        return new ArrayList<>(ppl);
    }
}

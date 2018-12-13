package _59frames.Ds._59utils.filter;

import java.util.Collection;

@FunctionalInterface
public interface Criterion<T> {
    Collection<T> meetCriteria(Collection<T> list);
}

package _59frames.Ds._59utils.filter;

import java.util.List;

@FunctionalInterface
public interface Criterion<T> {
    List<T> meetCriteria(List<T> list);
}

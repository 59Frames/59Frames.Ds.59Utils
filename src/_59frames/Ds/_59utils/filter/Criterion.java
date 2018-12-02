package _59frames.Ds._59utils.filter;

import java.util.List;

public interface Criterion<T> {
    List<T> meetCriteria(List<T> list);
}

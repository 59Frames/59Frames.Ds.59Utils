import _59frames.Ds._59utils.filter.Criterion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenderCriterion<T extends Person> implements Criterion<T> {

    private Gender gender;

    public GenderCriterion(Gender gender) {
        this.gender = gender;
    }

    @Override
    public List<T> meetCriteria(List<T> list) {
        HashSet<T> set = new HashSet<>();
        for (T p :
                list) {
            if (p.getGender() == gender) {
                set.add(p);
            }
        }

        return new ArrayList<>(set);
    }
}

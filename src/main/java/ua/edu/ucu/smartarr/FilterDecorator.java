package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    public FilterDecorator(SmartArray sa, MyPredicate pr) {
        super(sa);
//        int count = 0;
//        Object[] ls = sa.toArray();
//        for (Object elem : ls) {
//            if (!pr.test(elem)) {
//                count += 1;
//            }
//        }
//        Integer[] new_elems = new Integer[sa.size() - count];
//        for (int i = 0, j = 0; i < sa.size(); i++) {
//            if (pr.test(ls[i])) {
//                new_elems[j] = (int) ls[i];
//                j++;
//            }
//        }
        ArrayList<Object> ls = new ArrayList<>();
        for (Object elem : sa.toArray()) {
            if (pr.test(elem)) {
                ls.add(elem);
            }
        }
        this.smartArray = new BaseArray(ls.toArray());
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

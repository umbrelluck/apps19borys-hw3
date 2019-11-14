package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    public MapDecorator(SmartArray sa, MyFunction func) {
        super(sa);

        Object[] ls = sa.toArray();
        Object[] new_elems = new Integer[sa.size()];
        for (int i = 0; i < sa.size(); i++) {
            new_elems[i] = func.apply(ls[i]);
        }
        this.smartArray = new BaseArray(new_elems);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Map every element to another object using MyFunction";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}

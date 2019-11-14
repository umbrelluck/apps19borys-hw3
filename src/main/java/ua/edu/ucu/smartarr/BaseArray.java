package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] objs;

    public BaseArray(Object[] objs) {
        this.objs = objs;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(objs, objs.length);
    }

    @Override
    public String operationDescription() {
        return "Base array";
    }

    @Override
    public int size() {
        return objs.length;
    }
}

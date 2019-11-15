package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.List;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        Object[] array = smartArray.toArray();
        ArrayList<Object> ls = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            boolean fl = true;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    fl = false;
                    break;
                }
            }
            if (fl) {
                ls.add(array[i]);
            }
        }
        ls.add(array[array.length - 1]);
        this.smartArray = new BaseArray(ls.toArray());
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Remove duplicates from "
                + "SmartArray. Use method equals() to compare objects";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}

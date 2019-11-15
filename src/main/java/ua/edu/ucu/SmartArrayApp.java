package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;


public class SmartArrayApp {

    public static Integer[]
    ftrPositiveIntegersSortAndMultiplyByTwo(Integer[] integers) {

        MyPredicate pr = t -> ((Integer) t) > 0;

        MyComparator cmp = (oA, oB) -> ((Integer) oA) - ((Integer) oB);

        MyFunction func = t -> 2 * ((Integer) t);

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFromSecondYearWithGPAgeFourAndOrderedBySurname(
            Student[] students) {
        SmartArray studentSmartArray = new BaseArray(students);
        MyPredicate pr =
                t -> ((Student) t).getGPA() >= 2 * 2
                        && ((Student) t).getYear() == 2;
        studentSmartArray = new FilterDecorator(studentSmartArray, pr);
        studentSmartArray = new DistinctDecorator(studentSmartArray);

        MyComparator cmp = (oA, oB) -> {
            String nmA = ((Student) oA).getSurname();
            String nmB = ((Student) oB).getSurname();
            int[] len = {nmA.length(), nmB.length(), Math.min(nmB.length()
                    , nmA.length())};

            for (int i = 0; i < len[2]; i++) {
                int strA = nmA.charAt(i);
                int strB = nmB.charAt(i);

                if (strA != strB) {
                    return strA - strB;
                }
            }
            if (len[0] != len[1]) {
                return len[0] - len[1];
            } else {
                return 0;
            }
        };
        studentSmartArray = new SortDecorator(studentSmartArray, cmp);
        // Hint: to convert Object[] to String[] - use the following code
        Object[] result = new Object[studentSmartArray.size()];
        int i = 0;
        for (Object student : studentSmartArray.toArray()) {
            result[i] =
                    ((Student) student).getSurname() + " "
                            + ((Student) student).getName();
            i++;
        }
        return Arrays.copyOf(result, result.length, String[].class);
    }
}

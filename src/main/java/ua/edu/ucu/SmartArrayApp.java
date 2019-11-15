package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;


public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = t -> ((Integer) t) > 0;

        MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);

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
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
            Student[] students) {
        SmartArray studentSmartArray = new BaseArray(students);
        MyPredicate pr =
                t -> ((Student) t).getGPA() >= 2 * 2
                        && ((Student) t).getYear() == 2;
        studentSmartArray = new FilterDecorator(studentSmartArray, pr);
        studentSmartArray = new DistinctDecorator(studentSmartArray);

        MyComparator cmp = (o1, o2) -> {
            String nm1 = ((Student) o1).getSurname();
            String nm2 = ((Student) o2).getSurname();
            Integer[] len = {nm1.length(), nm2.length(), Math.min(nm2.length()
                    , nm1.length())};

            for (int i = 0; i < len[2]; i++) {
                int str1_ch = nm1.charAt(i);
                int str2_ch = nm2.charAt(i);

                if (str1_ch != str2_ch) {
                    return str1_ch - str2_ch;
                }
            }
            if (!len[0].equals(len[1])) {
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

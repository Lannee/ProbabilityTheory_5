package values;

import java.util.Arrays;

public class Range {

    public static void printRange(double[] data) {
        Arrays.sort(data);
        System.out.println("Размах выборки: " + (data[data.length - 1] - data[0]) + "\n");
    }
}

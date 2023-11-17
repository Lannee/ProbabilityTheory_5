package values;

import java.util.Arrays;

public class VariationSeries {
    public static void printVariationSeries(double[] data) {
        Arrays.sort(data);
        System.out.println("Вариационный ряд: " + Arrays.toString(data) + "\n");
    }
}

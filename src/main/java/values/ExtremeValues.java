package values;

import java.util.Arrays;

public class ExtremeValues {

    public static void printExtremeValues(double[] data) {
        Arrays.sort(data);
        System.out.println("Экстремальные значения:  Минимум = " + data[0] + "    Максимум = " + data[data.length - 1]);
    }
}

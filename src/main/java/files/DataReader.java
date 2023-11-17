package files;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DataReader {
    private double[] data = new double[20];

    public DataReader(String fileName) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        assert inputStream != null;
        var fileReader = new InputStreamReader(inputStream);
        var scanner = new Scanner(fileReader);
        scanner.useLocale(Locale.ENGLISH);

        for (int i = 0; i < 20; i++) {
            data[i] = scanner.nextDouble();
        }
        scanner.close();
    }

    public double[] getData() {
        return data;
    }
}

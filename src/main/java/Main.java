import files.DataReader;

import values.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new DataReader("input.txt");

        double[] data = dataReader.getData();
        Arrays.sort(data);

        VariationSeries.printVariationSeries(data);

        ExtremeValues.printExtremeValues(data);

        Range.printRange(data);

        StatisticalSeries statisticalSeries = new StatisticalSeries(data);

        MathExpectation mathExpectation = new MathExpectation(statisticalSeries);
        mathExpectation.printMathExpectation();

        StandardDeviation standardDeviation = new StandardDeviation(statisticalSeries, mathExpectation);
        standardDeviation.printStandardDeviation();

        EmpiricFunction empiricFunction = new EmpiricFunction(statisticalSeries);
        empiricFunction.calculate();

        FrequencyPolygon frequencyPolygon = new FrequencyPolygon(statisticalSeries);
        frequencyPolygon.drawFrequencyPolygon();
        frequencyPolygon.drawHistogram();
    }
}

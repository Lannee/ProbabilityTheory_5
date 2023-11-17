package values;

import java.util.Map;

public class MathExpectation {

    private double mathExpectation = 0;

    public MathExpectation(StatisticalSeries series) {
        Map<Double, StatisticalSeries.Pair> seriesMap = series.getSeries();
        for(Double x : seriesMap.keySet()) {
            mathExpectation += x * seriesMap.get(x).getProbability();
        }
    }

    public void printMathExpectation() {
        System.out.printf("Оценка математического ожидания: %.2f\n", mathExpectation);
    }

    public double getMathExpectation() {
        return mathExpectation;
    }
}

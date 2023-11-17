package values;

import graphs.Chart;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class EmpiricFunction {

    private StatisticalSeries statisticalSeries;

    public EmpiricFunction(StatisticalSeries statisticalSeries) {
        this.statisticalSeries = statisticalSeries;
    }

    public void calculate() {
        TreeMap<Double, StatisticalSeries.Pair> series = (TreeMap<Double, StatisticalSeries.Pair>) statisticalSeries.getSeries();

        System.out.println("Эмпирическая Функция:");
        System.out.printf("%.2f\t, \t\t\tx\t<=\t%.2f\n", 0.0, series.firstKey());

        double h = series.firstEntry().getValue().getProbability(); // =  pi.get(0);
        var chart = new Chart("x", "f(X)", "Эмпирическая функция");
        chart.addChart("x <= " + series.firstKey(), series.firstKey() - 0.5, series.firstKey(), 0);

        Double[] arrSeries = series.keySet().toArray(new Double[0]);

        for(int i = 0; i < series.size() - 1; i++) {
            System.out.printf("%.2f\t, %.2f\t<\tx\t<=\t%.2f\n", h, arrSeries[i], arrSeries[i + 1]);
            chart.addChart(arrSeries[i] + " < x <= " + arrSeries[i + 1], arrSeries[i], arrSeries[i + 1], h);
            h += series.get(arrSeries[i + 1]).getProbability();
        }

        System.out.printf("%.2f\t, \t\t\tx\t>=\t%.2f\n\n", 1.0, series.lastKey());
        chart.addChart(series.lastKey() + " < x", series.lastKey(), series.lastKey() + 1, h);
        chart.plot("EmpiricFunction");
    }
}

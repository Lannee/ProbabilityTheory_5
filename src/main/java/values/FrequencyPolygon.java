package values;

import graphs.Chart;

import java.util.TreeMap;

public class FrequencyPolygon {

    private StatisticalSeries statisticalSeries;

    public FrequencyPolygon(StatisticalSeries statisticalSeries) {
        this.statisticalSeries = statisticalSeries;
    }

    public void drawFrequencyPolygon() {
        TreeMap<Double, StatisticalSeries.Pair> series = (TreeMap<Double, StatisticalSeries.Pair>) statisticalSeries.getSeries();

        System.out.println("Полигон частот:");
        Chart frequencyPolygon = new Chart("x", "p_i", "Полигон частот");

        double xStart = series.firstKey() - getH() / 2;
        for (int i = 0; i < getM(); i++) {
            int count = 0;
            for (double value : series.keySet()) {
                if (value >= xStart && value < (xStart + getH())) {
                    count++;
                }
            }

            frequencyPolygon.polygonalChart(xStart + getH() / 2, (double) count / statisticalSeries.getOriginDataLength());
            System.out.printf("%.2f\t, [\t%.2f\t;\t%.2f\t)\n", (double) count / statisticalSeries.getOriginDataLength(), xStart, xStart + getH());

            xStart += getH();
        }

        frequencyPolygon.plotPolygon("FrequencyPolygon");
    }

    public void drawHistogram() {
        TreeMap<Double, StatisticalSeries.Pair> series = (TreeMap<Double, StatisticalSeries.Pair>) statisticalSeries.getSeries();

        Chart chart = new Chart("x", "p_i / h", "Гистограмма частот");
        double xStart = series.firstKey() - getH() / 2;

        for (int i = 0; i < getM(); i++) {
            int s = 0;
            for (double value : series.keySet()) {
                if (value >= xStart && value < (xStart + getH())) {
                    s++;
                }
            }

            chart.addHistogram(
                    String.format("%.2f", xStart) + " : " + String.format("%.2f", xStart + getH()), xStart,
                    xStart + getH(),
                    ((double) s / 20) / getH()
            );

            xStart += getH();
        }
        chart.plot("Histogram");
    }

    public double getH() {
        TreeMap<Double, StatisticalSeries.Pair> series = (TreeMap<Double, StatisticalSeries.Pair>) statisticalSeries.getSeries();
        return (series.lastKey() - series.firstKey()) / (1 + ((Math.log(statisticalSeries.getOriginDataLength()) / Math.log(2))));
    }

    public int getM() {
        return (int) Math.ceil(1 + (Math.log(statisticalSeries.getOriginDataLength()) / Math.log(2)));
    }
}

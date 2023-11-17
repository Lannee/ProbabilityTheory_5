package values;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class StatisticalSeries {

    public static class Pair {
        private Integer quantity;
        private Double probability;

        public Pair() {
            this.quantity = 1;
            this.probability = 1d;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Double getProbability() {
            return probability;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public void setProbability(Double probability) {
            this.probability = probability;
        }
    }

    private Map<Double, Pair> series = new TreeMap<>();

    private int fromLength;

    public StatisticalSeries(double[] from) {
        fromLength = from.length;

        for(double element : from) {
            if(series.containsKey(element)) {
                Pair pair = series.get(element);
                pair.setQuantity(pair.getQuantity() + 1);
                series.put(element, pair);
            }
            else series.put(element, new Pair());
        }

        series.forEach((x, pair) -> {
            pair.setProbability(pair.getQuantity().doubleValue() / from.length);
        });
    }

    public Map<Double, Pair> getSeries() {
        return series;
    }

    public int getOriginDataLength() {
        return fromLength;
    }
}

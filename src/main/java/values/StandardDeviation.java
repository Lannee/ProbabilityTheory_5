package values;

public class StandardDeviation {

    private double disperancy = 0;
    private double standardDeviation = 0;

    public StandardDeviation(StatisticalSeries statisticalSeries, MathExpectation mathExpectation) {

        for(double x : statisticalSeries.getSeries().keySet()) {
            disperancy += Math.pow((x - mathExpectation.getMathExpectation()), 2) * statisticalSeries.getSeries().get(x).getQuantity();
        }

        disperancy *= 1.0 / statisticalSeries.getOriginDataLength();

        standardDeviation = Math.sqrt(disperancy);
    }

    public void printStandardDeviation() {
//        System.out.printf("Дисперсия: %.2f\n", disperancy);
        System.out.printf("Cреднеквадратическоe отклонение: %.2f\n\n", standardDeviation);
    }
}

package com.gorani.springplayground.java.stream.performance;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class StreamSlowSinLoopPerformance {

    public double getSlowSinByClassicForLoopAndArr(double[] arr) {
        double ret = Integer.MIN_VALUE;

        for (double num : arr) {
            ret = Math.max(ret, Math.sin(Math.sin(Math.sin(num))));
        }

        return ret;
    }

    public Double getSlowSinByClassicForLoopAndStream(List<Double> arr) {
        double ret = Double.MIN_VALUE;

        for (double num : arr) {
            ret = Math.max(ret, Math.sin(Math.sin(Math.sin(num))));
        }

        return ret;
    }

    public double getSlowSinByStreamLoop(List<Double>  arr) {
        Double ret = Double.MIN_VALUE;

        return arr.stream()
                .map(s -> Math.sin((Math.sin(Math.sin(s)))))
                .max(Comparator.naturalOrder())
                .orElse(ret);
    }
}

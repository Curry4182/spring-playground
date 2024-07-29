package com.gorani.springplayground.java.stream;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class StreamNormalLoopPerformance {

    public int getMaxNumByClassicForLoopAndArr(int[] arr) {
        int ret = Integer.MIN_VALUE;

        for (int num : arr) {
            ret = Math.max(num, ret);
        }

        return ret;
    }

    public Integer getMaxNumByClassicForLoopAndStream(List<Integer> arr) {
        Integer ret = Integer.MIN_VALUE;

        for (Integer num : arr) {
            ret = Math.max(num, ret);
        }

        return ret;
    }

    public Integer getMaxNumByStreamLoop(List<Integer> arr) {
        Integer ret = Integer.MIN_VALUE;

        return arr.stream()
                .max(Comparator.naturalOrder())
                .orElse(ret);
    }
}

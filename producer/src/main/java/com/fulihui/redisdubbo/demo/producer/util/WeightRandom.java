package com.fulihui.redisdubbo.demo.producer.util;

import javafx.util.Pair;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @param <K>
 * @param <V>
 * @author lz
 */
public class WeightRandom<K, V extends AwardWeightModel> {
    private TreeMap<Double, V> weightMap = new TreeMap<>();

    public WeightRandom(List<Pair<Double, V>> list) {
        checkNotNull(list, "list can not be null!");
        for (Pair<Double, V> pair : list) {
            if (pair.getKey() <= 0) {
                continue;
            }
            //统一转为double
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey();
            //权重累加
            this.weightMap.put(pair.getKey() + lastWeight, pair.getValue());
        }
    }

    public V random() {
        double random = Math.random();
        double randomWeight = this.weightMap.lastKey() * random;
        SortedMap<Double, V> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }

}

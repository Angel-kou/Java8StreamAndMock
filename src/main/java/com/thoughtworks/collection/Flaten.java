package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        Object[] temp = Arrays.stream(this.array).flatMap(x -> Arrays.stream(x)).toArray();
        List<Integer> res = new ArrayList<>();
        Arrays.stream(temp).forEach(x->res.add((Integer) x));
        return res;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> collect = transformToOneDimesional().stream().distinct().collect(Collectors.toList());
        return collect;
    }
}

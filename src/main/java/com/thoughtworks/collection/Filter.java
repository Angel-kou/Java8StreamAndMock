package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> res = this.array.stream().filter(x->x%2==0).collect(Collectors.toList());
        return res;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> res = this.array.stream().filter(x->x%3==0).collect(Collectors.toList());
        return res;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> res = firstList.stream().filter(x->secondList.contains(x)).collect(Collectors.toList());
        return res;
    }

    public List<Integer> getDifferentElements() {
        List<Integer> res = this.array.stream().distinct().collect(Collectors.toList());
        return res;
    }
}
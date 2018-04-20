package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> list = new ArrayList<>();
        if(left <= right){
            for (int i = left; i <= right; i++) {
                list.add(i);
            }
        }else{
            for (int i = left; i >= right; i--) {
                list.add(i);
            }
        }
        return list;
    }



    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> res = getListByInterval(left,right).stream().filter(x->x%2==0).collect(Collectors.toList());
        return res;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> temp = new ArrayList<>();
        Arrays.stream(array).forEach(x->temp.add(x));
        List<Integer> res = temp.stream().filter(x->x%2==0).collect(Collectors.toList());
        return res;
    }

    public int popLastElment(int[] array) {

        int[] res =Arrays.stream(array).filter(x->new Integer(x)==array[array.length-1]).toArray();
        return res[0];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> list1 = new ArrayList<>();
        Arrays.stream(firstArray).forEach(x->list1.add(x));
        List<Integer> list2 = new ArrayList<>();
        Arrays.stream(secondArray).forEach(x->list2.add(x));
        List<Integer> res = list1.stream().filter(t->list2.contains(t)).collect(Collectors.toList());
        return res;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> list1 = new ArrayList<>();
        Arrays.stream(firstArray).forEach(x->list1.add(x));
        List<Integer> list2 = new ArrayList<>();
        Arrays.stream(secondArray).forEach(x->list2.add(x));
        List<Integer> res = list2.stream().filter(t->!list1.contains(t)).collect(Collectors.toList());
        list1.addAll(res);
        return list1;
    }


}

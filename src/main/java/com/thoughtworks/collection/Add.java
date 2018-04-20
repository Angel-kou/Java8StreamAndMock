package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int res = addElementToList(leftBorder,rightBorder).stream().filter(i -> i%2==0).reduce(0,(sum,item)->sum+item);
        return res;
    }


    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int res = addElementToList(leftBorder,rightBorder).stream().filter(i->i%2!=0).reduce(0,(sum,item)->sum+item);
        return res;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int res = arrayList.stream().mapToInt(x->3*x+2).reduce(0,(sum,item)->sum+item);
        return res;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> res = arrayList.stream().map(x->x%2!=0?3*x+2:x).collect(Collectors.toList());
        return res;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int res = arrayList.stream().filter(x->x%2!=0).map(x->3*x+5).reduce(0,(sum,item)->sum+item);
        return res;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> list =  arrayList.stream().filter(x->x%2==0).collect(Collectors.toList());
        list.sort(Comparator.naturalOrder());
        double res = getMedian(list);
        return res;
    }



    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream().filter(x->x%2==0).collect(Collectors.toList());
        Optional<Double> res =
                Optional.ofNullable(
                        list.stream().reduce((sum, item) -> sum + item).map(x -> (double) x / list.size())
                ).orElse(Optional.of((Double) 0.0));
        return res.get();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        boolean isCluded = arrayList.stream().filter(x->x%2==0).collect(Collectors.toList()).contains(specialElment);
        return isCluded;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> res = arrayList.stream().filter(x->x%2==0).distinct().collect(Collectors.toList());
        return res;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> res = new ArrayList<>();
        res.addAll(arrayList.stream().filter(x->x%2==0).collect(Collectors.toList()));
        res.sort(Integer::compareTo);
        List<Integer> part = arrayList.stream().filter(x->x%2!=0).collect(Collectors.toList());
        part.sort((a,b)->(b.compareTo(a)));
//        part.stream().forEach(System.out::println);
        res.addAll(part);
        return res;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> res = arrayList.stream()
                .map(x->{
                    int mValue = getNewNumber(x, arrayList);
                    return mValue;
                })
                .filter(x->x!=-1)
                .collect(Collectors.toList());
        return res;
    }

    private int getNewNumber(int x,List<Integer> arrayList) {
        int y = arrayList.indexOf(x);
        if(y < arrayList.size()-1)
            return 3 * (x + arrayList.get(y + 1));
        else
            return  -1;
    }

    public List<Integer> addElementToList(int leftBorder,int rightBorder){
        List<Integer> list = new ArrayList<>();
        for(int i = Math.min(leftBorder,rightBorder) ; i <= Math.max(leftBorder,rightBorder);i++){
            list.add(i);
        }
        return list;
    }

    private double getMedian(List<Integer> list) {
        double median = 0.0;
        if(list.size()%2==0){
            median = (list.get(list.size()/2-1)+list.get(list.size()/2))/2;
        }else{
            median = list.get(list.size()/2);
        }
        return median;
    }
}

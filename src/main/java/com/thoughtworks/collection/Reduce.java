package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        int res = this.arrayList.stream().reduce(Integer::max).get();
        return res;
    }

    public double getMinimum() {
        int res = this.arrayList.stream().reduce(Integer::min).get();
        return res;
    }

    public double getAverage() {
        double res = this.arrayList.parallelStream().mapToInt(x->x.intValue()).average().getAsDouble();
        return res;
    }

    public double getOrderedMedian() {
        this.arrayList.sort(Comparator.naturalOrder());
        double res =this.arrayList.stream()
                .filter(x-> (this.arrayList.size() %2==0 && (this.arrayList.get(this.arrayList.size()/2-1)==x ||this.arrayList.get(this.arrayList.size()/2)==x))||
                        (this.arrayList.size() %2!=0 && this.arrayList.get(this.arrayList.size()/2)==x))
                .distinct()
                .collect(Collectors.toList())
                .stream()
                .mapToDouble(x->new Double(x))
                .average()
                .getAsDouble();
        return res;
    }

    public int getFirstEven() {
        int res =this.arrayList.stream().filter(x->x%2==0).findFirst().get();
        return res;
    }

    public int getIndexOfFirstEven() {
        int res = this.arrayList.indexOf(getFirstEven());
        return res;
    }

    public boolean isEqual(List<Integer> arrayList) {
        if(this.arrayList.size() != arrayList.size()){
            return false;
        }else{
            List<Integer> res = this.arrayList.stream()
                    .filter(x-> arrayList.get(this.arrayList.indexOf(x)) != x).collect(Collectors.toList());
            return res.size()==0?true:false;
        }
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {

        this.arrayList.stream().forEach(x->singleLink.addTailPointer(x));
        double res = 0;
        if(this.arrayList.size()%2==0){
            Integer x1 = (Integer) singleLink.getNode(this.arrayList.size()/2);
            Integer x2 = (Integer)singleLink.getNode(this.arrayList.size()/2+1);
            res = (x1.doubleValue()+x2.doubleValue())/2;
        }
        return res;
    }

    public int getLastOdd() {
        List<Integer> res =this.arrayList.stream().filter(x->x%2!=0).collect(Collectors.toList());
        return res.get(res.size()-1);
    }

    public int getIndexOfLastOdd() {
        return this.arrayList.indexOf(getLastOdd());
    }
}

package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> res = this.array.stream().map(x->3*x).collect(Collectors.toList());
        return res;
    }

    public List<String> mapLetter() {
        List<String> res =this.array.stream()
                .map(x->String.valueOf((char)(x.intValue()+96)))
                .collect(Collectors.toList());
        return res;
    }

    public List<String> mapLetters() {
        List<String> res = this.array.stream().map(x->{
            return getLetter(x);
        }).collect(Collectors.toList());
        return res;
    }




    public List<Integer> sortFromBig() {
        List<Integer> res= this.array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return res;
    }

    public List<Integer> sortFromSmall() {
        List<Integer> res = this.array.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return res;
    }


    private String getLetter(Integer x) {
        String res = "";
        int value = x.intValue();
        if(value/26==0 && value <=26){
            res += String.valueOf((char)(value+96));
        }else {
            if(value%26==0){
                res = res + String.valueOf((char) (value / 26-1 + 96)) + "z";
            }else{
                res = res + String.valueOf((char) (value / 26 + 96)) + String.valueOf((char) (value % 26 + 96));
            }
        }
        return res;
    }
}

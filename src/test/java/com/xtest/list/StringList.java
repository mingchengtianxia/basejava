package com.xtest.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringList {

    private static int defaultSize = 16;
    private static String[] array;
    private int size;

    public StringList() {
        array = new String[defaultSize];
    }

    public StringList(int size) {
        array = new String[size];
    }

    public void add(String str){
        if(size>=16)
            array = Arrays.copyOf(array,defaultSize<<1);
        array[size++] = str;
    }

    public String get(int index){
        if(index<0||index>size)
            throw new IllegalArgumentException("index 不在范围：index: "+index);
        return array[index];
    }


    public static void main(String[] args) {
        StringList stringList = new StringList();
        for(int i=0;i<15;i++){
            stringList.add("a"+i);
        }
        stringList.add("b");
        stringList.add("bc");
        stringList.add("bd");
        System.out.println(stringList.get(15));
        List<String> list = new ArrayList<>();
    }
}

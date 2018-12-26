package com.xtest.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {
        TreeSet<Integer> set1 = new TreeSet<>();
        set1.add(2);
        set1.add(19);
        set1.add(13);
        Iterator<Integer> iterator = set1.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(19);
        set2.add(13);
        Iterator<Integer> iterator1 = set2.iterator();
        while(iterator1.hasNext())
            System.out.println(iterator1.next());

    }
}

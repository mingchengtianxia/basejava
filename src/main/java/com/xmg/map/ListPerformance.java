package com.xmg.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformance {

    static Random rand = new Random();
    static int reps = 1000;
    static List<TestXmgList<List<Integer>>> tests = new ArrayList<>();
    static List<TestXmgList<LinkedList<Integer>>> qTests = new ArrayList<>();

    static{
        tests.add(new TestXmgList<List<Integer>>("add"){

            @Override
            protected int test(List<Integer> list, TestParm p) {
                int loops = p.loops;
                int listSize = p.size;
                for(int i=0;i<loops;i++){
                    list.clear();
                    for(int j=0;j<listSize;j++){
                        list.add(j);
                    }
                }
                return loops*listSize;
            }
        });
        tests.add(new TestXmgList<List<Integer>>("get") {
            @Override
            int test(List<Integer> containter, TestParm p) {
                return 0;
            }
        });
    }

    public static void main(String[] args) {
        Tester.defaultParams =TestParm.array(500,1000);
//        Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null,tests.subList(1,3)){
//
//            @Override
//            protected List<Integer> initialize(int size) {
//                //Integer[] ia = Generated.array(Integer.class,new )
//                return null;
//            }
//        };

        Tester.run(new ArrayList<Integer>(),tests);

    }
}

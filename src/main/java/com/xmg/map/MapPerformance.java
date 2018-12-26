package com.xmg.map;

import java.util.*;

public class MapPerformance {
    static List<TestXmgList<Map<Integer,Integer>>> tests = new ArrayList<>();

    static{
        tests.add(new TestXmgList<Map<Integer, Integer>>("put") {
            @Override
            int test(Map<Integer, Integer> containter, TestParm p) {
                int loops = p.loops;
                int size = p.size;
                for(int i=0;i<loops;i++) {
                    containter.clear();
                    for (int j = 0; j < size; j++)
                        containter.put(i, j);
                }
                return loops*size;
            }
        });
        tests.add(new TestXmgList<Map<Integer, Integer>>("get") {
            @Override
            int test(Map<Integer, Integer> containter, TestParm p) {
                int loops = p.loops;
                int span = p.size*2;
                for(int i=0;i<loops;i++) {
                    for (int j = 0; j < span; j++)
                        containter.get(j);
                }
                return loops*span;
            }
        });
        tests.add(new TestXmgList<Map<Integer, Integer>>("iterator") {
            @Override
            int test(Map<Integer, Integer> containter, TestParm p) {
                int loops = p.loops * 10;
                for(int i=0;i<loops;i++) {
                    Iterator it = containter.entrySet().iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops*containter.size();
            }
        });
    }


    public static void main(String[] args) {
        Tester.fieldWidth = 10;
        Tester.run(new TreeMap<Integer,Integer>(),tests);
        Tester.run(new HashMap<Integer,Integer>(),tests);
        Tester.run(new LinkedHashMap<Integer,Integer>(),tests);
        Tester.run(new IdentityHashMap<>(),tests);
        //Tester.run(new WeakHashMap<Integer,Integer>(),tests);
        Tester.run(new Hashtable<Integer,Integer>(),tests);
    }
}

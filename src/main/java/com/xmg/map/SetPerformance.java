package com.xmg.map;

import java.util.*;

public class SetPerformance {

    static List<TestXmgList<Set<Integer>>> tests = new ArrayList<>();
    static{
        tests.add(new TestXmgList<Set<Integer>>("add") {
            @Override
            int test(Set<Integer> set, TestParm p) {
                int loops = p.loops;
                int size = p.size;
                for(int i=0;i<loops;i++){
                    set.clear();
                    for(int j=0;j<size;j++)
                        set.add(j);
                }

                return loops*size;
            }
        });
        tests.add(new TestXmgList<Set<Integer>>("contains") {
            @Override
            int test(Set<Integer> set, TestParm p) {
                int loops = p.loops;
                int span = p.size * 2;
                for(int i=0;i<loops;i++){
                    for(int j=0;j<span;j++)
                        set.contains(j);
                }

                return loops*span;
            }
        });
        tests.add(new TestXmgList<Set<Integer>>("iterate") {
            @Override
            int test(Set<Integer> set, TestParm p) {
                int loops = p.loops * 10;
                for(int i=0;i<loops;i++){
                    Iterator<Integer> it = set.iterator();
                    while(it.hasNext())
                        it.next();
                }

                return loops*set.size();
            }
        });
    }


    public static void main(String[] args) {
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<Integer>(),tests);
        Tester.run(new HashSet<Integer>(),tests);
        Tester.run(new LinkedHashSet<Integer>(),tests);
    }

}

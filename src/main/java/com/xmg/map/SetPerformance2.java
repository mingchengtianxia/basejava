package com.xmg.map;

import com.xmg.util.CountingGenerator;
import com.xmg.util.Generator;

import java.util.*;

public class SetPerformance2 {

    static Generator<String> gen =
            new CountingGenerator.String();
    static Random rand = new Random();
    static List<TestXmgList<Set<String>>> tests = new ArrayList<>();
    static{
        tests.add(new TestXmgList<Set<String>>("add") {
            @Override
            int test(Set<String> set, TestParm p) {
                int loops = p.loops;
                int size = p.size;
                for(int i=0;i<loops;i++){
                    set.clear();
                    for(int j=0;j<size;j++)
                        set.add(gen.next());
                }

                return loops*size;
            }
        });
        tests.add(new TestXmgList<Set<String>>("contains") {
            @Override
            int test(Set<String> set, TestParm p) {
                Generator<String> gen =
                        new CountingGenerator.String(5);
                int loops = p.loops;
                int span = p.size * 2;
                for(int i=0;i<loops;i++){
                    for(int j=0;j<span;j++)
                        set.contains(gen.next());
                }

                return loops*span;
            }
        });
        tests.add(new TestXmgList<Set<String>>("iterate") {
            @Override
            int test(Set<String> set, TestParm p) {
                int loops = p.loops * 10;
                for(int i=0;i<loops;i++){
                    Iterator<String> it = set.iterator();
                    while(it.hasNext())
                        it.next();
                }

                return loops*set.size();
            }
        });
    }


    public static void main(String[] args) {
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<String>(),tests);
        Tester.run(new HashSet<String>(),tests);
        Tester.run(new LinkedHashSet<String>(),tests);
    }

}

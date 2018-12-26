package com.xmg.map;

import com.xmg.util.CollectionData;
import com.xmg.util.CountingGenerator;
import com.xmg.util.Generated;
import com.xmg.util.Generator;

import java.util.*;

public class ListPerformance2 {
    static Generator<String> gen =
            new CountingGenerator.String();
    static Random rand = new Random();
    static int reps = 1000;
    static List<TestXmgList<List<String>>> tests = new ArrayList<>();
    static List<TestXmgList<LinkedList<String>>> qTests = new ArrayList<>();

    static {
        tests.add(new TestXmgList<List<String>>("add") {
            @Override
            protected int test(List<String> list, TestParm p) {
                int loops = p.loops;
                int listSize = p.size;
                for (int i = 0; i < loops; i++) {
                    list = new ArrayList<>(list);
                    list.clear();
                    for (int j = 0; j < listSize; j++) {
                        list.add(gen.next());
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new TestXmgList<List<String>>("get") {
            @Override
            protected int test(List<String> list, TestParm p) {
                int loops = p.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.get(rand.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new TestXmgList<List<String>>("set") {
            @Override
            protected int test(List<String> list, TestParm p) {
                int loops = p.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.set(rand.nextInt(listSize), gen.next());
                }
                return loops;
            }
        });
        tests.add(new TestXmgList<List<String>>("iteradd") {
            @Override
            protected int test(List<String> list, TestParm p) {
                final int loops = 1000000;
                int half = list.size() / 2;
                ListIterator<String> it = list.listIterator(half);
                for (int i = 0; i < loops; i++) {
                    it.add("47");
                }
                return loops;
            }
        });
        tests.add(new TestXmgList<List<String>>("sort") {
            @Override
            protected int test(List<String> list, TestParm p) {
                list.clear();
                list.addAll(CollectionData.list(new CountingGenerator.String(),p.size));
                Collections.sort(list);
                return p.loops;
            }
        });
    }

    static class ListTester extends Tester<List<String>>{

        public ListTester(List<String> containter, List<TestXmgList<List<String>>> tests) {
            super(containter, tests);
        }

        @Override
        protected List<String> initialize(int size) {
            containter.clear();
            containter.addAll(CollectionData.list(new CountingGenerator.String(),size));
            return containter;
        }

        public static void run(List<String> list,List<TestXmgList<List<String>>> tests){
            new ListTester(list,tests).timedTest();
        }
    }


    public static void main(String[] args) {
        Tester.defaultParams = TestParm.array(10, 5000, 100, 5000, 1000,1000);
        Tester<List<String>> arrayTest = new Tester<List<String>>(null, tests.subList(1, 3)) {

            @Override
            protected List<String> initialize(int size) {
                String[] ia = Generated.array(String.class, new CountingGenerator.String(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        ListTester.run(new ArrayList<String>(), tests);
        ListTester.run(new LinkedList<String>(),tests);
    }
}

package com.xtest.list;

import com.xmg.map.TestXmgList;
import com.xmg.map.TestParm;
import com.xmg.map.Tester;

import java.util.ArrayList;
import java.util.List;

public class StringContainter {
    static final int LOOPS = 10000;
    static List<TestXmgList<List<String>>> alTests =
            new ArrayList<>();
    static List<TestXmgList<StringList>> scTests =
            new ArrayList<>();
    static List<TestXmgList<List<String>>> tests = new ArrayList<>();
    static {


//        alTests.add(new TestXmgList<List<String>>("addget") {
//            @Override
//            int test(List<String> list, TestParm p) {
//                for(int i = 0; i < LOOPS; i++) {
//                    list.add(Integer.toString(i));
//                    list.get(i);
//                }
//                return LOOPS;
//            }
//        });
//        scTests.add(new TestXmgList<StringList>("addget") {
//            int tests(StringList sc, TestParm tp) {
//                for(int i = 0; i < LOOPS; i++) {
//                    sc.add(Integer.toString(i));
//                    sc.get(i);
//                }
//                return LOOPS;
//            }
//        });
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParm.array(LOOPS, 1);
        Tester.run(new ArrayList<String>(LOOPS), alTests);
        Tester.run(new StringList(LOOPS), scTests);
    }
}

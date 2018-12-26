package com.xmg.map;

import java.util.ArrayList;
import java.util.List;

public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParm[] defaultParams = TestParm.array(10, 5000, 1000, 5000,5000, 5000, 10000, 500);

    protected C initialize(int size) {
        return containter;
    }

    protected C containter;
    private String headline = "";
    private List<TestXmgList<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" +sizeWidth + "s";
    private TestParm[] parmList = defaultParams;
    public Tester(C containter,List<TestXmgList<C>> tests){
        this.containter = containter;
        this.tests = tests;
        if(containter!=null){
            headline = containter.getClass().getSimpleName();
        }
    }

    public Tester(C containter, List<TestXmgList<C>> tests, TestParm[] parmList){
        this(containter,tests);
        this.parmList = parmList;
    }
    public void setHeadline(String newHeadline){
        headline = newHeadline;
    }
    public static <C> void run(C cntnc, List<TestXmgList<C>> tests){
        new Tester<C>(cntnc,tests).timedTest();
    }

    public static <C> void run(C cntnc, List<TestXmgList<C>> tests, TestParm[] parmList){
        new Tester<C>(cntnc,tests, parmList).timedTest();
    }
    private void displayHeader() {
        int width = fieldWidth * tests.size() +sizeWidth;
        int dashLength = width - headline.length() -1;
        StringBuilder head = new StringBuilder(width);
        for(int i=0;i<dashLength/2;i++){
            head.append('-');
        }
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for(int i=0;i<dashLength/2;i++){
            head.append('-');
        }
        System.out.println(head);
        System.out.format(sizeField,"size");
        for(TestXmgList test:tests){
            System.out.format(stringField(),test.name);
        }
        System.out.println();
    }

    public void timedTest() {
        displayHeader();
        for(TestParm param:parmList){
            System.out.format(sizeField,param.size);
            for(TestXmgList<C> testa:tests){
                C containers = initialize(param.size);
                long start = System.nanoTime();
                int reps = testa.test(containers,param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration/reps;
                System.out.format(numberField(),timePerRep);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        FieldTest<String> test1 = new FieldTest<String>("aaaaaaaa");
        FieldTest<String> test2 = new FieldTest<String>("ssb");
        FieldTest<String> test3 = new FieldTest<String>("c");
        List<TestXmgList<String>> lists = new ArrayList<>();
        lists.add(test1);
        lists.add(test2);
        lists.add(test3);
        Tester tester = new Tester("a",lists);
        tester.run("start",lists);
    }


}

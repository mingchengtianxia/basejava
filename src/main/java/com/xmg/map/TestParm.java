package com.xmg.map;

public class TestParm {

    public final int size;
    public final int loops;
    public TestParm(int size,int loops){
        this.size = size;
        this.loops = loops;
    }
    public static TestParm[] array(int... values){
        int size = values.length/2;
        TestParm[] parms = new TestParm[size];
        int n=0;
        for(int i=0;i<size;i++){
            parms[i] = new TestParm(values[n++],values[n++]);
        }
        return parms;
    }

    public static TestParm[] array(String... values){
        int[] vals = new int[values.length];
        for(int i=0;i<vals.length;i++)
            vals[i] = Integer.decode(values[i]);
        return array(vals);
    }
}

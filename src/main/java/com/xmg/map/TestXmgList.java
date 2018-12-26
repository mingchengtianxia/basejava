package com.xmg.map;

public abstract class TestXmgList<C> {
    String name;
    public TestXmgList(String name){ this.name = name;}
    abstract int test(C containter, TestParm p);
}

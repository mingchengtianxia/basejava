package com.xmg.map;

public class FieldTest<C> extends TestXmgList<C> {

    public FieldTest(String name) {
        super(name);
    }

    @Override
    protected int test(C containter, TestParm p) {
        return p.loops;
    }
}

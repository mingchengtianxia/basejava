package com.xmg.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleJava {
    public SimpleJava(String str) {
        this.s = str;
        created.add(s);
        for(String s2:created){
            if(s2.equals(s)){
                id++;
            }
        }
    }

    public static void main(String[] args) {
        String[] hellos = {"hello","hello"};
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());

        Map<SimpleJava,Integer> map = new HashMap<>();
        SimpleJava[] cs = new SimpleJava[5];
        for(int i=0;i<cs.length;i++){
            cs[i] = new SimpleJava("hi");
            map.put(cs[i],i);
        }
        for(SimpleJava sj:cs){
            System.out.println("looking up:"+sj);
        }

    }
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id =0;

    public String toString(){
        return "String:"+s+"id:"+id+"hashcode:"+hashCode();
    }



    public int hashCode(){
        int result = 17;
        result = 37*result + s.hashCode();
        result = 37*result + id;
        return result;
    }

    public boolean equals(Object o){
        return o instanceof SimpleJava && s.equals(((SimpleJava)o).s) && id == ((SimpleJava)o).id;
    }



}

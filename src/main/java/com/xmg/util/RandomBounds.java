package com.xmg.util;

/***
 * Math.Random的随机值
 * @author xuminggang
 */
public class RandomBounds {

    static void usage() {
        System.out.println("Usage:");
        System.out.println("\tRandomBounds lower");
        System.out.println("\tRandomBounds higher");
        System.exit(1);
    }

    public static void main(String[] args) {
        String arg = "lower";
        String arg1 = "higher";
        usage();
        if (arg.equals("lower")) {
            while (Math.random() != 0.0)
                ;
            System.out.println("Produced 0.0!");
        } else if (arg.equals("higher")){
            while (Math.random() != 1.0)
                ;
            System.out.println("Produced 1.0!");
        }else
            usage();
    }
}

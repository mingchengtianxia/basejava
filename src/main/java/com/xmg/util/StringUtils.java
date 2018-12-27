package com.xmg.util;

/**
 * 字符串工具类
 *
 * @author wenji.fan
 * @since 2013年8月5日
 *
 */
public class StringUtils {
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return true,字符串是空的;false,字符串不是空的
     */
    public static boolean isEmpty(String str) {
        if (str == null || (str.trim().length() == 0)) {
            return true;
        }
        return false;
    }

    public static String join(String[] value) {
        if(value == null){
            return "";
        }
        StringBuilder _sb = new StringBuilder();
        for(String a : value){
            _sb.append(a);
        }
        return _sb.toString();
    }

}

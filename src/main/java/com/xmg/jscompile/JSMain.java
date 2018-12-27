package com.xmg.jscompile;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.net.URL;

public class JSMain {

    /**
     * 服务器配置文件
     */
    private static String sgcfgPath = "sgserver.cfg.js";

    /**
     * 游戏服务器配置
     */
    private static SgConfig sgConfig;

    public static void main(String[] args) {

        sgConfig();
    }

    public static void scriptEval(){
        ScriptEngineManager factory = new ScriptEngineManager();
// create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.put("a", 4);
        engine.put("b", 6);
        try {
            Object maxNum = engine
                    .eval("function max_num(a,b){return (a>b)?a:b;}max_num(a,b);");
            System.out.println("max_num:" + maxNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sgConfig(){
        URL url = JSMain.class.getClassLoader().getResource(sgcfgPath);
        sgConfig = ConfigUtil.buildConfig(SgConfig.class, url);
        System.out.println(sgConfig.getMaxOnline());
    }

}

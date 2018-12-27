package com.xmg.jscompile;

import org.apache.commons.io.FileUtils;

import javax.script.*;
import java.io.File;
import java.util.Map;

/**
 * JS脚本引擎
 *
 * @author xuminggang
 */
public class JSScriptManagerImpl implements IScriptEngine {

    private final String charset;
    private final ScriptEngine engine;

    public JSScriptManagerImpl(String charset) {
        this.charset = charset;
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("JavaScript");
    }

    @Override
    public boolean doLogicEval(Map<String, Object> binding, String exp) {
        if (exp == null || exp.length() == 0) {
            throw new IllegalArgumentException("条件表达式不能为空");
        }
        Bindings bindings = new SimpleBindings(binding);
        try {
            Object ret = engine.eval(exp, bindings);
            if (ret instanceof Boolean) {
                return (Boolean) ret;
            } else {
                throw new RuntimeException("无效的逻辑运算表达式" + exp);
            }
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double doMathEval(Map<String, Object> binding, String exp) {
        if (exp == null || exp.length() == 0) {
            throw new IllegalArgumentException("条件表达式不能为空");
        }
        try {
            Bindings bindings = new SimpleBindings(binding);
            Object ret = engine.eval(exp, bindings);
            if (ret instanceof Number) {
                return ((Number) ret).doubleValue();
            } else {
                throw new RuntimeException("无效的逻辑运算表达式" + exp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getScriptContent(String scriptFile, String charset) {
        try {
            return FileUtils.readFileToString(new File(scriptFile), charset != null ? charset : this.charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object runScript(Map<String, Object> binding, String scriptContent) {
        try {
            if (binding == null || binding.isEmpty()) {
                return engine.eval(scriptContent);
            } else {
                Bindings bindings = new SimpleBindings(binding);
                return engine.eval(scriptContent, bindings);
            }
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object runScript(Map<String, Object> binding, String scriptFile, String charset) {
        String content = null;
        try {
            Bindings bindings = new SimpleBindings(binding);
            //FileUtils从Commons-io包来
            content = FileUtils.readFileToString(new File(scriptFile), charset != null ? charset : this.charset);
            return engine.eval(content, bindings);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

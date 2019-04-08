package com.lzg.crud.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Jackson响应通用封装
 */
public class ResultMsg {

    //响应code。100：成功；200：错误...
    private int code;
    //响应信息
    private String msg;
    //返回给客户端的数据
    private Map<String, Object> extend = new HashMap<String, Object>();


    public static ResultMsg success() {
        ResultMsg result = new ResultMsg();
        result.setCode(100);
        result.setMsg("操作成功！");
        return result;
    }

    public static ResultMsg fail() {
        ResultMsg result = new ResultMsg();
        result.setCode(200);
        result.setMsg("操作失败！");
        return result;
    }

    public ResultMsg add(String key, Object value) {
        this.extend.put(key, value);
        return this;
    }

    public ResultMsg() {
    }

    public ResultMsg(int code, String msg, Map<String, Object> extend) {
        this.code = code;
        this.msg = msg;
        this.extend = extend;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}

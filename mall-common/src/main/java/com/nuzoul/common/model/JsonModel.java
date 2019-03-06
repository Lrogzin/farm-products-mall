package com.nuzoul.common.model;

import com.github.pagehelper.util.StringUtil;

import java.util.HashMap;
import java.util.Map;


public class JsonModel {

    private long errCode;
    private long retCode;
    private String msg;
    private String dtag;
    private Map<String, Object> data = new HashMap<String, Object>();

    protected JsonModel(long errCode, long retCode, String msg, String dtag, Map<String, Object> data) {
        this.errCode = errCode;
        this.retCode = retCode;
        this.msg = msg;
        this.dtag = dtag;
        if (data != null) {
            this.data = data;
        }
    }

    /**
     * 创建代表成功的JsonModel
     * @param dtag
     * @return
     */
    public static JsonModel createSuc(long retCode, String dtag) {
        return new JsonModel(0, retCode, "success", dtag, null);
    }

    /**
     * 创建代表成功的JsonModel
     * @param
     * @return
     */
    public static JsonModel createSuc() {
        return new JsonModel(0, 0, "success", "", null);
    }
    
    /**
     * 创建代表失败的JsonModel
     * @param errCode
     * @param retCode
     * @param msg
     * @param dtag
     * @return
     */
    public static JsonModel createFail(long errCode, long retCode, String msg, String dtag) {
        return new JsonModel(errCode, retCode, msg, dtag, null);
    }

    /**
     * 创建代表失败的JsonModel
     * @param errCode
     * @param
     * @param msg
     * @param
     * @return
     */
    public static JsonModel createFail(long errCode, String msg) {
        return new JsonModel(errCode, 0, msg, "", null);
    }
    
    /**
     * 往固定Json结构中增加业务数据
     * @param key
     * @param value
     */
    public void addData(String key, Object value) {
        if (!StringUtil.isEmpty(key) && value != null) {
            data.put(key, value);
        }
    }

    /**
     * 往固定的Json结构中删除业务数据
     * @param key
     */
    public void removeData(String key) {
        if (!StringUtil.isEmpty(key) && data.containsKey(key)) {
            data.remove(key);
        }
    }

    public Map<String, Object> toMapModel() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("errCode", errCode);
        modelMap.put("msg", StringUtil.isEmpty(msg) ? "" : msg);
        modelMap.put("data", data == null ? "{}" : data);
        return modelMap;
    }

}

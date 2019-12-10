package com.juju.common.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "JujuResponse", description = "响应报文")
public class JujuResponse<T> implements Serializable {
    private static final long serialVersionUID = -557394405303497170L;
    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码", name = "result")
    private Integer result;
    /**
     * 错误信息
     */
    @ApiModelProperty(value = "错误信息", name = "msg")
    private String msg;
    /**
     * 请求ID
     */
    @ApiModelProperty(value = "请求ID", name = "requestId")
    private String requestId;
    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回body", name = "data")
    private T data;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String reqid) {
        this.requestId = reqid;
    }

    public static <T> JujuResponse<T> createRsp() {
        return new JujuResponse<>();
    }

    public static <T> JujuResponse<T> createRsp(Integer errorCode, String msg) {
        return new JujuResponse<>(errorCode, msg);
    }

    public static <T> JujuResponse<T> createRsp(T data, Integer errorCode, String msg) {
        return new JujuResponse<>(data, errorCode, msg);
    }

    public static <T> JujuResponse<T> createRsp(T data) {
        return new JujuResponse<>(data, 200, "success");
    }

    private JujuResponse(Integer errorCode, String msg) {
        this.result = errorCode;
        this.msg = msg;
    }

    private JujuResponse(T data, Integer errorCode, String msg) {
        this.result = errorCode;
        this.msg = msg;
        this.data = data;
    }

    public JujuResponse() {
        result = 200;
        msg = "success";
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isok() {
        return this.result == 200;
    }

    @JSONField(serialize = false)
    public T getDataObj(Class<T> clazz) {
        return JSON.parseObject(data.toString(), clazz);
    }

    @JSONField(serialize = false)
    public List<T> getDataListObj(Class<T> clazz) {
        return JSON.parseArray(data.toString(), clazz);
    }
}


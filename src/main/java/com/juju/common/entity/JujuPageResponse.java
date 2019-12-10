package com.juju.common.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "JujuPageResponse", description = "分页响应对象", parent = JujuResponse.class)
public class JujuPageResponse<T> extends JujuResponse<T> {
    private static final long serialVersionUID = 3723100238537009439L;
    private JujuPageObject pageResult;

    public void setPageResult(JujuPageObject pageObj) {
        pageResult = pageObj;
    }

    public JujuPageObject getPageResult() {
        return pageResult;
    }

    /**
     * 设置记录数和页数 如客户端页数太大，服务器端可以修改
     *
     * @param rowsNum
     * @param pageSize
     * @param pageIndex
     */
    public void setPageResult(long rowsNum, long pageSize, long pageIndex) {
        if (pageResult == null) {
            pageResult = new JujuPageObject();
        }
        pageResult.setPageResult(rowsNum, pageSize, pageIndex);
    }

    public static <T> JujuPageResponse<T> createRsp(JujuPageObject pageObj, T data) {
        JujuPageResponse<T> rsp = new JujuPageResponse<>();
        rsp.setPageResult(pageObj);
        rsp.setData(data);
        return rsp;
    }

    public static <T> JujuPageResponse<T> createRsp(T data, JujuPageObject pageObj) {
        JujuPageResponse<T> rsp = new JujuPageResponse<>();
        rsp.setPageResult(pageObj);
        rsp.setData(data);
        return rsp;
    }
}

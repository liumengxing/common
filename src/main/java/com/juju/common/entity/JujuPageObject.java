package com.juju.common.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.Map;

public class JujuPageObject {
    private static final long serialVersionUID = -6696548562252992137L;
    /**
     * 每页记录数
     */
    private long pageSize = 100;
    /**
     * 总页数
     */
    private long pageCount = 0;
    /**
     * 总记录数
     */
    private long rowCount = 0;
    /**
     * 当前页码
     */
    private long pageIndex = 1;
    /**
     * 是否有下一页
     */
    private Boolean hasNext;
    /**
     * 是否需要返回总记录数 ，true 不用
     * 默认需要返回记录数
     */
    private Boolean useHasNext;

    @JSONField(serialize = false)
    public Map<String, Object> getPageParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("startIndex", (this.pageIndex - 1) * this.pageSize);
        params.put("pageSize", this.pageSize);
        params.put("useHasNext", this.useHasNext);
        return params;
    }

    public void setResult(long rows) {
        hasNext = rows > pageSize * pageIndex;
        rowCount = rows;
        if (rows % pageSize == 0) {
            this.pageCount = rows / pageSize;
        } else {
            this.pageCount = rows / pageSize + 1;
        }
    }

    public void setPageResult(long rowsNum, long pageSize, long pageIndex) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        setResult(rowsNum);
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        if (pageSize > 2000) {
            pageSize = 2000;
        }
        this.pageSize = pageSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getRowCount() {
        return rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    public long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getUseHasNext() {
        return useHasNext;
    }

    public void setUseHasNext(Boolean useHasNext) {
        this.useHasNext = useHasNext;
    }
}

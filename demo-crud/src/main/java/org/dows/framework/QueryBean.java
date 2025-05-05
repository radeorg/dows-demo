package org.dows.framework;

import cn.hutool.db.sql.Query;

import java.util.List;

public class QueryBean<T> {
    private Query query;
    private int pageNum;
    private int pageSize;
    private long pageCount;
    private long itemCount;
    private List<T> results;

    public QueryBean() {
        super();
    }

    public QueryBean(Query query, int pageNum, int pageSize, long pageCount,
                     long itemCount, List<T> results) {
        super();
        this.query = query;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.itemCount = itemCount;
        this.results = results;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getItemCount() {
        return itemCount;
    }

    public void setItemCount(long itemCount) {
        this.itemCount = itemCount;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

}
package com.duopei.springmvc.model;

import java.util.List;

/**
 * Created by Administrator on 2016/12/23.
 */
public class RequestPageUtil {


    private Integer draw; //请求服务器端次数

    private Integer start;//第一条数据的起始位置，比如0代表第一条数据

    private Integer length;//告诉服务器每页显示的条数，这个数字会等于返回的 data集合的记录数，可能会大于因为服务器可能没有那么多数据。这个也可能是-1，代表需要返回全部数据(尽管这个和服务器处理的理念有点违背)

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    private Search search;//全局的搜索条件，条件会应用到每一列

    private List<Columns> columns;//
    private List<Order> order;//

    @Override
    public String toString() {
        return "RequestPageUtil{" +
                "draw=" + draw +
                ", start=" + start +
                ", length=" + length +
                ", search='" + search + '\'' +
                ", columns=" + columns +
                '}';
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Columns> getColumns() {
        return columns;
    }

    public void setColumns(List<Columns> columns) {
        this.columns = columns;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}

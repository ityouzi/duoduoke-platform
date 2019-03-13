package org.near.webmvcsupport.view;

import java.util.List;

import org.near.toolkit.model.ToString;

/**
 * 分页渲染对象
 * Created by Willard.Hu on 2016/5/9.
 */
public class PageView<T> extends ToString {
    private static final long serialVersionUID = -1964710990825517030L;
    /* 当前页 */
    private int               page             = 1;
    /* 每页显示行数 */
    private int               rows             = 10;
    /* 数据总数 */
    private int               totalSize;
    /* 总页数 */
    private int               totalPages;
    /* 数据集合 */
    private List<T>           values;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}

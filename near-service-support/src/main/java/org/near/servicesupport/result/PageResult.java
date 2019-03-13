package org.near.servicesupport.result;

/**
 * 
 * Created by willard on 16-2-29.
 */
public class PageResult extends BaseResult {
    private static final long serialVersionUID = 2636297680115392969L;

    /* 页码 */
    protected int             page;
    /* 总页数 */
    protected int             totalPage;
    /* 每页行数 */
    protected int             rows;
    /* 查询结果总行数 */
    protected int             totalRows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
}

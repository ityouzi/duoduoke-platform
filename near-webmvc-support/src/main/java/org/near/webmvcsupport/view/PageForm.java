package org.near.webmvcsupport.view;

import org.near.toolkit.model.ToString;

/**
 *
 * Created by Willard.Hu on 2016/5/20.
 */
public class PageForm extends ToString {
    private static final long serialVersionUID = 4926122193692891210L;
    private int               page             = 1;
    private int               rows             = 10;

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
}

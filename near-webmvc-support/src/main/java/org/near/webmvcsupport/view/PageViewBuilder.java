package org.near.webmvcsupport.view;

import java.util.List;

/**
 *
 * Created by Willard.Hu on 2016/5/9.
 */
public class PageViewBuilder {

    public static <T> PageView<T> build(List<T> values, int page, int rows, int totalSize) {
        int totalPage = totalSize % rows == 0 ? totalSize / rows : totalSize / rows + 1;
        totalPage = totalPage > 0 ? totalPage : 1;
        return build(values, page, rows, totalSize, totalPage);
    }

    public static <T> PageView<T> build(List<T> values, int page, int rows, int totalSize,
                                        int totalPage) {
        PageView<T> pageView = new PageView<>();
        if (page > 0) {
            pageView.setPage(page);
        }
        if (rows > 0) {
            pageView.setRows(rows);
        }
        pageView.setTotalSize(totalSize);
        pageView.setTotalPages(totalPage > 0 ? totalPage : 1);
        pageView.setValues(values);
        return pageView;
    }
}
package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result;

import java.util.List;

import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-9
 */
public class DuoGoodsPidResult extends DuoJsonResult {

    private static final long serialVersionUID = 8792517084849740241L;
    /**
     * p_id_query_response : {"p_id_list":[{"p_id":"81_1812886","create_time":1517724155},{"p_id":"81_1812888","create_time":1517916590},{"p_id":"81_1812889","create_time":1517916590},{"p_id":"81_1812890","create_time":1517916634},{"p_id":"81_1812891","create_time":1517916634},{"p_id":"81_1812892","create_time":1517917263},{"p_id":"81_1812893","create_time":1517917263},{"p_id":"81_1812894","create_time":1517917855},{"p_id":"81_1812895","create_time":1517917855},{"p_id":"81_1812896","create_time":1517917862}],"total_count":17}
     */

    private PIdQueryResponseBean p_id_query_response;

    public PIdQueryResponseBean getP_id_query_response() {
        return p_id_query_response;
    }

    public void setP_id_query_response(PIdQueryResponseBean p_id_query_response) {
        this.p_id_query_response = p_id_query_response;
    }

    public static class PIdQueryResponseBean extends ToString {
        private static final long serialVersionUID = -4414109411116489048L;
        /**
         * p_id_list : [{"p_id":"81_1812886","create_time":1517724155},{"p_id":"81_1812888","create_time":1517916590},{"p_id":"81_1812889","create_time":1517916590},{"p_id":"81_1812890","create_time":1517916634},{"p_id":"81_1812891","create_time":1517916634},{"p_id":"81_1812892","create_time":1517917263},{"p_id":"81_1812893","create_time":1517917263},{"p_id":"81_1812894","create_time":1517917855},{"p_id":"81_1812895","create_time":1517917855},{"p_id":"81_1812896","create_time":1517917862}]
         * total_count : 17
         */

        private int total_count;
        private List<PIdListBean> p_id_list;

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public List<PIdListBean> getP_id_list() {
            return p_id_list;
        }

        public void setP_id_list(List<PIdListBean> p_id_list) {
            this.p_id_list = p_id_list;
        }

        public static class PIdListBean extends ToString {
            private static final long serialVersionUID = -8744352365306873884L;
            /**
             * p_id : 81_1812886
             * create_time : 1517724155
             */

            private String p_id;
            private int create_time;

            public String getP_id() {
                return p_id;
            }

            public void setP_id(String p_id) {
                this.p_id = p_id;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }
        }
    }
}

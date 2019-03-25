package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-9
 */
@Data
public class DuoGoodsPidResult extends DuoJsonResult {

    private static final long serialVersionUID = 8792517084849740241L;
    /**
     * p_id_query_response : {"p_id_list":[{"p_id":"81_1812886","create_time":1517724155},{"p_id":"81_1812888","create_time":1517916590},{"p_id":"81_1812889","create_time":1517916590},{"p_id":"81_1812890","create_time":1517916634},{"p_id":"81_1812891","create_time":1517916634},{"p_id":"81_1812892","create_time":1517917263},{"p_id":"81_1812893","create_time":1517917263},{"p_id":"81_1812894","create_time":1517917855},{"p_id":"81_1812895","create_time":1517917855},{"p_id":"81_1812896","create_time":1517917862}],"total_count":17}
     */

    private PIdQueryResponseBean p_id_query_response;

    @Data
    public static class PIdQueryResponseBean extends ToString {
        private static final long serialVersionUID = -4414109411116489048L;
        /**
         * p_id_list : [{"p_id":"81_1812886","create_time":1517724155},{"p_id":"81_1812888","create_time":1517916590},{"p_id":"81_1812889","create_time":1517916590},{"p_id":"81_1812890","create_time":1517916634},{"p_id":"81_1812891","create_time":1517916634},{"p_id":"81_1812892","create_time":1517917263},{"p_id":"81_1812893","create_time":1517917263},{"p_id":"81_1812894","create_time":1517917855},{"p_id":"81_1812895","create_time":1517917855},{"p_id":"81_1812896","create_time":1517917862}]
         * total_count : 17
         */
        private int total_count;
        private List<PIdListBean> p_id_list;


        @Data
        public static class PIdListBean extends ToString {
            private static final long serialVersionUID = -8744352365306873884L;
            /**
             * p_id : 81_1812886
             * create_time : 1517724155
             */

            private String p_id;
            private int create_time;

        }
    }
}

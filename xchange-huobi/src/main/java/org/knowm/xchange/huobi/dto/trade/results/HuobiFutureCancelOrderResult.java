package org.knowm.xchange.huobi.dto.trade.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/3 11:33
 */
@Data
@NoArgsConstructor
public class HuobiFutureCancelOrderResult {
    private List<Errors> errors;

    private String successes;

    @Data
    @NoArgsConstructor
    public static class Errors {
        @JsonProperty("order_id")
        private String orderId;

        @JsonProperty("err_code")
        private int errCode;

        @JsonProperty("err_msg")
        private String errMsg;
    }
}

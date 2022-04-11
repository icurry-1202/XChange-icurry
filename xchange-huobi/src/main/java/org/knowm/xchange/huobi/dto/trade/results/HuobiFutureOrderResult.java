package org.knowm.xchange.huobi.dto.trade.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/4/3 11:13
 */
@Data
@NoArgsConstructor
public class HuobiFutureOrderResult {
    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("order_id_str")
    private String orderIdStr;

    @JsonProperty("client_order_id")
    private String clientOrderId;
}

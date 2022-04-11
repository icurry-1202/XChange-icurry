package org.knowm.xchange.huobi.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class HuobiFutureOrderRequest {
    private String symbol;

    private String pair;

    @JsonProperty("contract_type")
    private String contractType;

    @JsonProperty("contract_code")
    private String contractCode;

    @JsonProperty("client_order_id")
    private long clientOrderId;

    private BigDecimal price;

    private BigDecimal volume;

    private String direction;

    private String offset;

    @JsonProperty("lever_rate")
    private Integer leverRate;

    @JsonProperty("order_price_type")
    private String orderPriceType;

    @JsonProperty("reduce_only")
    private Integer reduceOnly;
}

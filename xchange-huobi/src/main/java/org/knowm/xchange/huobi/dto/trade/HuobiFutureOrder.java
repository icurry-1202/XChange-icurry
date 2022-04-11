package org.knowm.xchange.huobi.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/3 12:07
 */
@Data
@NoArgsConstructor
public class HuobiFutureOrder {
    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("contract_code")
    private String contractCode;

    @JsonProperty("contract_type")
    private String contractType;

    @JsonProperty("volume")
    private Integer volume;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("order_price_type")
    private String orderPriceType;

    @JsonProperty("order_type")
    private Integer orderType;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("offset")
    private String offset;

    @JsonProperty("lever_rate")
    private Integer leverRate;

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("client_order_id")
    private String clientOrderId;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("trade_volume")
    private Integer tradeVolume;

    @JsonProperty("trade_turnover")
    private Integer tradeTurnover;

    @JsonProperty("fee")
    private BigDecimal fee;

    @JsonProperty("trade_avg_price")
    private BigDecimal tradeAvgPrice;

    @JsonProperty("margin_frozen")
    private Integer marginFrozen;

    @JsonProperty("profit")
    private Integer profit;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("order_source")
    private String orderSource;

    @JsonProperty("order_id_str")
    private String orderIdStr;

    @JsonProperty("fee_asset")
    private String feeAsset;

    @JsonProperty("liquidation_type")
    private String liquidationType;

    @JsonProperty("canceled_at")
    private Integer canceledAt;

    @JsonProperty("is_tpsl")
    private Integer isTpsl;

    @JsonProperty("real_profit")
    private Integer realProfit;

    @JsonProperty("margin_asset")
    private String marginAsset;

    @JsonProperty("margin_mode")
    private String marginMode;

    @JsonProperty("margin_account")
    private String marginAccount;

    @JsonProperty("reduce_only")
    private Integer reduceOnly;

    @JsonProperty("update_time")
    private Long updateTime;
}

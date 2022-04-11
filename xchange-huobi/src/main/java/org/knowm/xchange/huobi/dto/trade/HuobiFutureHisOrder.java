package org.knowm.xchange.huobi.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/3 19:33
 */
@Data
@NoArgsConstructor
public class HuobiFutureHisOrder {
    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("contract_code")
    private String contractCode;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("lever_rate")
    private Integer leverRate;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("offset")
    private String offset;

    @JsonProperty("volume")
    private Integer volume;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("create_date")
    private Long createDate;

    @JsonProperty("update_time")
    private Long updateTime;

    @JsonProperty("order_source")
    private String orderSource;

    @JsonProperty("order_price_type")
    private Integer orderPriceType;

    @JsonProperty("order_type")
    private Integer orderType;

    @JsonProperty("margin_frozen")
    private Integer marginFrozen;

    @JsonProperty("profit")
    private Integer profit;

    @JsonProperty("contract_type")
    private String contractType;

    @JsonProperty("trade_volume")
    private Integer tradeVolume;

    @JsonProperty("trade_turnover")
    private Integer tradeTurnover;

    @JsonProperty("fee")
    private Integer fee;

    @JsonProperty("trade_avg_price")
    private Integer tradeAvgPrice;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("order_id_str")
    private String orderIdStr;

    @JsonProperty("fee_asset")
    private String feeAsset;

    @JsonProperty("liquidation_type")
    private String liquidationType;

    @JsonProperty("is_tpsl")
    private String isTpsl;

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

    @JsonProperty("pair")
    private String pair;

    @JsonProperty("business_type")
    private String businessType;
}

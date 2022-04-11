package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/2 11:33
 */
@Data
@NoArgsConstructor
public class HuobiContractInfo {
    private String symbol;

    @JsonProperty("contract_code")
    private String contractCode;

    @JsonProperty("contract_type")
    private String contractType;

    @JsonProperty("contract_size")
    private int contractSize;

    @JsonProperty("price_tick")
    private BigDecimal priceTick;

    @JsonProperty("delivery_date")
    private String deliveryDate;

    @JsonProperty("delivery_time")
    private String deliveryTime;

    @JsonProperty("create_date")
    private String createDate;

    @JsonProperty("contract_status")
    private int contractStatus;

    @JsonProperty("settlement_time")
    private String settlementTime;

    @JsonProperty("settlement_date")
    private String settlementDate;

    @JsonProperty("support_margin_mode")
    private String supportMarginMode;

    @JsonProperty("business_type")
    private String businessType;

    private String pair;
}

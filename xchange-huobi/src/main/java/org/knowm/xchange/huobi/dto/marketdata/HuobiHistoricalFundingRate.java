package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/3 19:05
 */
@Data
@NoArgsConstructor
public class HuobiHistoricalFundingRate {
    @JsonProperty("avg_premium_index")
    private BigDecimal avgPremiumIndex;

    @JsonProperty("funding_rate")
    private BigDecimal fundingRate;

    @JsonProperty("realized_rate")
    private BigDecimal realizedRate;

    @JsonProperty("funding_time")
    private Long fundingTime;

    @JsonProperty("contract_code")
    private String contractCode;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("fee_asset")
    private String feeAsset;
}

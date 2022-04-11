package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/4/3 19:05
 */
@Data
@NoArgsConstructor
public class HuobiFundingRate {
    @JsonProperty("estimated_rate")
    private String estimatedRate;

    @JsonProperty("funding_rate")
    private String fundingRate;

    @JsonProperty("contract_code")
    private String contractCode;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("fee_asset")
    private String feeAsset;

    @JsonProperty("funding_time")
    private String fundingTime;

    @JsonProperty("next_funding_time")
    private String nextFundingTime;
}

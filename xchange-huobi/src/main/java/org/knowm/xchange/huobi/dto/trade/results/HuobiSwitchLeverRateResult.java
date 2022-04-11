package org.knowm.xchange.huobi.dto.trade.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/4/3 11:51
 */
@Data
@NoArgsConstructor
public class HuobiSwitchLeverRateResult {
    private String symbol;

    @JsonProperty("contract_code")
    private String contractCode;

    @JsonProperty("lever_rate")
    private Integer leverRate;

    @JsonProperty("pair")
    private String pair;

    @JsonProperty("business_type")
    private String businessType;

    @JsonProperty("contract_type")
    private String contractType;

    @JsonProperty("margin_mode")
    private String marginMode;
}

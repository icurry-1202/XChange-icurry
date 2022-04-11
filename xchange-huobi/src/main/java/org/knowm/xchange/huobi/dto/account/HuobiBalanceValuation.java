package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/3 19:23
 */
@Data
@NoArgsConstructor
public class HuobiBalanceValuation {
    @JsonProperty("valuation_asset")
    private String valuationAsset;

    @JsonProperty("balance")
    private BigDecimal balance;
}

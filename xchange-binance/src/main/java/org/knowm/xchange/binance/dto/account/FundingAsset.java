package org.knowm.xchange.binance.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/1 17:10
 */
@Data
@NoArgsConstructor
public class FundingAsset {
    private String asset;
    private BigDecimal free;
    private BigDecimal locked;
    private BigDecimal freeze;
    private BigDecimal withdrawing;
    private BigDecimal btcValuation;
}

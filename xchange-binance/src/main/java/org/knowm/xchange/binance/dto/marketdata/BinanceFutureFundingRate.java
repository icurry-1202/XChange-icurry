package org.knowm.xchange.binance.dto.marketdata;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 */
@Data
@NoArgsConstructor
public class BinanceFutureFundingRate {
    private String symbol;
    private Long fundingTime;
    private BigDecimal fundingRate;
}

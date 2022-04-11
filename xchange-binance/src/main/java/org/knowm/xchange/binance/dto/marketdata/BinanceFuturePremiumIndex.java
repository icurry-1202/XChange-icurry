package org.knowm.xchange.binance.dto.marketdata;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class BinanceFuturePremiumIndex {
    private String symbol;
    private String pair;
    private BigDecimal markPrice;
    private BigDecimal indexPrice;
    private BigDecimal estimatedSettlePrice;
    private BigDecimal lastFundingRate;
    private BigDecimal interestRate;
    private long nextFundingTime;
    private long time;
}

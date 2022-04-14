package org.knowm.xchange.binance.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/1 14:40
 */
@Data
@NoArgsConstructor
public class BinanceFuturePositionRisk {
    private BigDecimal entryPrice;
    private String marginType;
    private Boolean isAutoAddMargin;
    private BigDecimal isolatedMargin;
    private BigDecimal leverage;
    private BigDecimal liquidationPrice;
    private BigDecimal markPrice;
    private BigDecimal maxNotionalValue;
    private BigDecimal positionAmt;
    private String symbol;
    private BigDecimal unRealizedProfit;
    private String positionSide;
    private long updateTime;
    private BigDecimal maxQty;
}

package org.knowm.xchange.binance.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/4/1 14:40
 */
@Data
@NoArgsConstructor
public class BinanceFuturePositionRisk {
    private String entryPrice;
    private String marginType;
    private String isAutoAddMargin;
    private String isolatedMargin;
    private String leverage;
    private String liquidationPrice;
    private String markPrice;
    private String maxNotionalValue;
    private String positionAmt;
    private String symbol;
    private String unRealizedProfit;
    private String positionSide;
    private long updateTime;
    private String maxQty;
}

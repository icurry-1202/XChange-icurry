package org.knowm.xchange.binance.dto.marketdata;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/1 17:18
 */
@Data
@NoArgsConstructor
public class BinanceTradeInfo {
    private Long id;
    private BigDecimal price;
    private BigDecimal qty;
    private Long time;
    private Boolean isBuyerMaker;
    private Boolean isBestMatch;
}

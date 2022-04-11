package org.knowm.xchange.binance.dto.marketdata;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/1 12:51
 */
@Data
@NoArgsConstructor
public class BinanceFutureTradeInfo {
    private Long id;
    private BigDecimal price;
    private BigDecimal qty;
    private BigDecimal quoteQty;
    private BigDecimal baseQty;
    private Long time;
    private Boolean isBuyerMaker;
}

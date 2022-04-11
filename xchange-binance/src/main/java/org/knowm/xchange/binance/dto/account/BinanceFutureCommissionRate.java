package org.knowm.xchange.binance.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/1 14:46
 */
@Data
@NoArgsConstructor
public class BinanceFutureCommissionRate {
    private String symbol;
    private BigDecimal makerCommissionRate;
    private BigDecimal takerCommissionRate;
}

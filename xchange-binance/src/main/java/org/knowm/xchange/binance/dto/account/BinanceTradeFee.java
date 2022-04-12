package org.knowm.xchange.binance.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/12 09:55
 */
@Data
@NoArgsConstructor
public class BinanceTradeFee {
    private BigDecimal makerCommission;
    private BigDecimal takerCommission;
}

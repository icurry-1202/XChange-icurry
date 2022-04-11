package org.knowm.xchange.binance.dto.trade;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/1 14:28
 */
@Data
@NoArgsConstructor
public class SetLeverageResult {
    private Integer leverage;
    private BigDecimal maxNotionalValue;
    private BigDecimal maxQty;
    private String symbol;
}

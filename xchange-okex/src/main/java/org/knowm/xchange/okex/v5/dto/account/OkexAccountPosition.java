package org.knowm.xchange.okex.v5.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/3/30 15:43
 */
@Data
@NoArgsConstructor
public class OkexAccountPosition {
    private String instId;
    private String instType;
    private String mgnMode;
    private String posId;
    private String posSide;
    private BigDecimal pos;
    private String ccy;
    private String posCcy;
    private BigDecimal availPos;
    private BigDecimal avgPx;
    private BigDecimal upl;
    private BigDecimal uplRatio;
    private BigDecimal lever;
    private BigDecimal liqPx;
    private BigDecimal imr;
    private BigDecimal margin;
    private BigDecimal mgnRatio;
    private BigDecimal mmr;
    private BigDecimal liab;
    private String liabCcy;
    private BigDecimal interest;
    private String tradeId;
    private BigDecimal optVal;
    private BigDecimal adl;
    private BigDecimal last;
    private long cTime;
    private long uTime;
}

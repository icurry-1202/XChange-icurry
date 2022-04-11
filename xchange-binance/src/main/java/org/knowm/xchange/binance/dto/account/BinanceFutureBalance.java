package org.knowm.xchange.binance.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class BinanceFutureBalance {
    private String accountAlias;
    private String asset;
    private BigDecimal balance;
    private BigDecimal withdrawAvailable;
    private BigDecimal crossWalletBalance;
    private BigDecimal crossUnPnl;
    private BigDecimal availableBalance;
    private BigDecimal maxWithdrawAmount;
    private Boolean marginAvailable;
    private Long updateTime;
}

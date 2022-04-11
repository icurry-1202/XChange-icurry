package org.knowm.xchange.binance.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/1 14:19
 */
@Data
@NoArgsConstructor
public class BinanceFutureAccount {
    private int feeTier;

    private boolean canTrade;

    private boolean canDeposit;

    private boolean canWithdraw;

    private int updateTime;

    private String totalInitialMargin;

    private String totalMaintMargin;

    private String totalWalletBalance;

    private String totalUnrealizedProfit;

    private String totalMarginBalance;

    private String totalPositionInitialMargin;

    private String totalOpenOrderInitialMargin;

    private String totalCrossWalletBalance;

    private String totalCrossUnPnl;

    private String availableBalance;

    private String maxWithdrawAmount;

    private List<Assets> assets;

    private List<Positions> positions;

    @Data
    @NoArgsConstructor
    public static class Assets {
        private String asset;

        private String walletBalance;

        private String unrealizedProfit;

        private String marginBalance;

        private String maintMargin;

        private String initialMargin;

        private String positionInitialMargin;

        private String openOrderInitialMargin;

        private String crossWalletBalance;

        private String crossUnPnl;

        private String availableBalance;

        private String maxWithdrawAmount;

        private boolean marginAvailable;

        private int updateTime;
    }

    @Data
    @NoArgsConstructor
    public static class Positions {
        private String symbol;

        private String initialMargin;

        private String maintMargin;

        private String unrealizedProfit;

        private String positionInitialMargin;

        private String openOrderInitialMargin;

        private String leverage;

        private boolean isolated;

        private String entryPrice;

        private String maxNotional;

        private String bidNotional;

        private String askNotional;

        private String positionSide;

        private String positionAmt;

        private int updateTime;

        private String maxQty;
    }
}

package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HuobiFuturePosition {

    private String symbol;
    private String contractCode;
    private String contractType;
    private BigDecimal volume;
    private BigDecimal available;
    private BigDecimal frozen;
    private BigDecimal costOpen;
    private BigDecimal costHold;
    private BigDecimal profitUnreal;
    private BigDecimal profitRate;
    private BigDecimal leverRate;
    private BigDecimal positionMargin;
    private String direction;
    private BigDecimal profit;
    private BigDecimal lastPrice;
    private String marginAsset;
    private String marginMode;
    private String marginAccount;
    private String pair;
    private String businessType;
    private String positionMode;

    public HuobiFuturePosition(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("contract_code") String contractCode,
            @JsonProperty("contract_type") String contractType,
            @JsonProperty("volume") BigDecimal volume,
            @JsonProperty("available") BigDecimal available,
            @JsonProperty("frozen") BigDecimal frozen,
            @JsonProperty("cost_open") BigDecimal costOpen,
            @JsonProperty("cost_hold") BigDecimal costHold,
            @JsonProperty("profit_unreal") BigDecimal profitUnreal,
            @JsonProperty("profit_rate") BigDecimal profitRate,
            @JsonProperty("lever_rate") BigDecimal leverRate,
            @JsonProperty("position_margin") BigDecimal positionMargin,
            @JsonProperty("direction") String direction,
            @JsonProperty("profit") BigDecimal profit,
            @JsonProperty("last_price") BigDecimal lastPrice,
            @JsonProperty("margin_asset") String marginAsset,
            @JsonProperty("margin_mode") String marginMode,
            @JsonProperty("margin_account") String marginAccount,
            @JsonProperty("pair") String pair,
            @JsonProperty("business_type") String businessType,
            @JsonProperty("position_mode") String positionMode) {
        this.symbol = symbol;
        this.contractCode = contractCode;
        this.contractType = contractType;
        this.volume = volume;
        this.available = available;
        this.frozen = frozen;
        this.costOpen = costOpen;
        this.costHold = costHold;
        this.profitUnreal = profitUnreal;
        this.profitRate = profitRate;
        this.leverRate = leverRate;
        this.positionMargin = positionMargin;
        this.direction = direction;
        this.profit = profit;
        this.lastPrice = lastPrice;
        this.marginAsset = marginAsset;
        this.marginMode = marginMode;
        this.marginAccount = marginAccount;
        this.pair = pair;
        this.businessType = businessType;
        this.positionMode = positionMode;
    }
}

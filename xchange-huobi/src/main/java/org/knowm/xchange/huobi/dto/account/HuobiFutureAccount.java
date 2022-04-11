package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author buxianguan
 */
@Data
@NoArgsConstructor
public class HuobiFutureAccount {
    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("margin_balance")
    private BigDecimal marginBalance;

    @JsonProperty("margin_position")
    private BigDecimal marginPosition;

    @JsonProperty("margin_frozen")
    private BigDecimal marginFrozen;

    @JsonProperty("margin_available")
    private BigDecimal marginAvailable;

    @JsonProperty("profit_real")
    private BigDecimal profitReal;

    @JsonProperty("profit_unreal")
    private BigDecimal profitUnreal;

    @JsonProperty("risk_rate")
    private BigDecimal riskRate;

    @JsonProperty("withdraw_available")
    private BigDecimal withdrawAvailable;

    @JsonProperty("liquidation_price")
    private BigDecimal liquidationPrice;

    @JsonProperty("lever_rate")
    private BigDecimal leverRate;

    @JsonProperty("adjust_factor")
    private BigDecimal adjustFactor;

    @JsonProperty("margin_static")
    private BigDecimal marginStatic;

    @JsonProperty("is_debit")
    private BigDecimal isDebit;

    @JsonProperty("contract_code")
    private String contractCode;

    @JsonProperty("margin_asset")
    private String marginAsset;

    @JsonProperty("margin_mode")
    private String marginMode;

    @JsonProperty("margin_account")
    private String marginAccount;

    @JsonProperty("position_mode")
    private String positionMode;

    @JsonProperty("Futures_contract_detail")
    private List<ContractDetail> futuresContractDetail;

    @JsonProperty("Contract_detail")
    private List<ContractDetail> contractDetail;

    @Data
    @NoArgsConstructor
    public static class ContractDetail {
        @JsonProperty("symbol")
        private String symbol;

        @JsonProperty("contract_code")
        private String contractCode;

        @JsonProperty("margin_position")
        private BigDecimal marginPosition;

        @JsonProperty("margin_frozen")
        private BigDecimal marginFrozen;

        @JsonProperty("margin_available")
        private BigDecimal marginAvailable;

        @JsonProperty("profit_unreal")
        private BigDecimal profitUnreal;

        @JsonProperty("liquidation_price")
        private String liquidationPrice;

        @JsonProperty("lever_rate")
        private Integer leverRate;

        @JsonProperty("adjust_factor")
        private BigDecimal adjustFactor;

        @JsonProperty("contract_type")
        private String contractType;

        @JsonProperty("pair")
        private String pair;

        @JsonProperty("business_type")
        private String businessType;
    }

}

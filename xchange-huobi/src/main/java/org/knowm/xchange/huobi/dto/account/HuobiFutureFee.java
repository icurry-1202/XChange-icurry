package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/3 10:51
 */
@Data
@NoArgsConstructor
public class HuobiFutureFee {
    private String symbol;

    @JsonProperty("contract_code")
    private BigDecimal contractCode;

    @JsonProperty("open_maker_fee")
    private BigDecimal openMakerFee;

    @JsonProperty("open_taker_fee")
    private BigDecimal openTakerFee;

    @JsonProperty("close_maker_fee")
    private BigDecimal closeMakerFee;

    @JsonProperty("close_taker_fee")
    private BigDecimal closeTakerFee;

    @JsonProperty("delivery_fee")
    private BigDecimal deliveryFee;

    @JsonProperty("fee_asset")
    private String feeAsset;

    @JsonProperty("business_type")
    private String businessType;

    @JsonProperty("contract_type")
    private String contractType;

    @JsonProperty("pair")
    private String pair;
}

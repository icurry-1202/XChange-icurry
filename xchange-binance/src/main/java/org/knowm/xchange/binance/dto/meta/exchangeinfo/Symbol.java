package org.knowm.xchange.binance.dto.meta.exchangeinfo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Symbol {

    private String quoteAsset;

    private String icebergAllowed;

    private String ocoAllowed;

    private String isMarginTradingAllowed;

    private String isSpotTradingAllowed;

    private String baseAsset;

    private String symbol;

    private String status;

    private String quotePrecision;

    private String quoteAssetPrecision;

    private String baseAssetPrecision;

    private String[] orderTypes;

    private Filter[] filters;

    private String[] permissions;

    private String liquidationFee;
    private String marketTakeBound;
    private String pair;
    private String contractType;
    private Long deliveryDate;
    private Long onboardDate;
    private String contractStatus;
    private Integer contractSize;
    private String marginAsset;
    private Integer pricePrecision;
    private Integer quantityPrecision;
    private Integer equalQtyPrecision;
    private String triggerProtect;
    private String maIntegerMarginPercent;
    private String requiredMarginPercent;
    private String underlyingType;
    private Long settlePlan;
}

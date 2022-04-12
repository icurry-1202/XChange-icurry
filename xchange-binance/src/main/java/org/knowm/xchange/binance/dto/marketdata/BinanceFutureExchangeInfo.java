//package org.knowm.xchange.binance.dto.marketdata;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author buxianguan
// * @Date 2022/3/31 18:48
// */
//@Data
//@NoArgsConstructor
//public class BinanceFutureExchangeInfo {
//    private String timezone;
//
//    private Long serverTime;
//
//    private List<RateLimit> rateLimits;
//
//    private List<Asset> assets;
//
//    private List<Symbol> symbols;
//
//    private List<String> exchangeFilters;
//
//    @Data
//    @NoArgsConstructor
//    public static class RateLimit {
//        private String rateLimitType;
//
//        private String interval;
//
//        private Long intervalNum;
//
//        private Long limit;
//    }
//
//    @Data
//    @NoArgsConstructor
//    public static class Asset {
//        private String asset;
//        private Boolean marginAvailable;
//        private BigDecimal autoAssetExchange;
//    }
//
//    @Data
//    @NoArgsConstructor
//    public static class Symbol {
//        private String symbol;
//        private String pair;
//        private String contractType;
//        private long deliveryDate;
//        private long onboardDate;
//        private String status;
//        private BigDecimal maintMarginPercent;
//        private BigDecimal requiredMarginPercent;
//        private String baseAsset;
//        private String quoteAsset;
//        private String marginAsset;
//        private int pricePrecision;
//        private int quantityPrecision;
//        private int baseAssetPrecision;
//        private int quotePrecision;
//        private String underlyingType;
//        private int settlePlan;
//        private BigDecimal triggerProtect;
//        private BigDecimal liquidationFee;
//        private BigDecimal marketTakeBound;
//        private List<String> underlyingSubType;
//        private List<String> OrderType;
//        private List<String> timeInForce;
//        private List<Map<String, String>> filters;
//    }
//}

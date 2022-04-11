package org.knowm.xchange.huobi.future.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.marketdata.HuobiContractInfo;
import org.knowm.xchange.huobi.dto.marketdata.HuobiFundingRate;
import org.knowm.xchange.huobi.dto.marketdata.results.HuobiHistoricalFundingRateResult;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;
import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/2 10:45
 */
public class HuobiFutureMarketDataService extends HuobiFutureBaseService implements MarketDataService {
    public HuobiFutureMarketDataService(Exchange exchange) {
        super(exchange);
    }

    public List<HuobiContractInfo> getContractInfo(String symbol,
                                                   String contractType,
                                                   String contractCode) throws IOException {
        HuobiResultV3<List<HuobiContractInfo>> contractInfo = huobi.getContractInfo(symbol, contractType, contractCode);
        return checkResult(contractInfo);
    }

    public List<HuobiContractInfo> getSwapContractInfo(String contractCode) throws IOException {
        HuobiResultV3<List<HuobiContractInfo>> contractInfo = huobi.getSwapContractInfo(contractCode);
        return checkResult(contractInfo);
    }

    public List<HuobiContractInfo> getLinearSwapContractInfo(String contractCode,
                                                             String contractType,
                                                             String supportMarginMode,
                                                             String pair,
                                                             String businessType) throws IOException {
        HuobiResultV3<List<HuobiContractInfo>> contractInfo =
                huobi.getLinearSwapContractInfo(contractCode, supportMarginMode, pair, contractType, businessType);
        return checkResult(contractInfo);
    }

    public HuobiFundingRate getSwapFundingRate(String contractCode) throws IOException {
        HuobiResultV3<HuobiFundingRate> fundingRate = huobi.getSwapFundingRate(contractCode);
        return checkResult(fundingRate);
    }

    public HuobiFundingRate getLinearSwapFundingRate(String contractCode) throws IOException {
        HuobiResultV3<HuobiFundingRate> fundingRate = huobi.getLinearSwapFundingRate(contractCode);
        return checkResult(fundingRate);
    }

    public HuobiHistoricalFundingRateResult getSwapHistoricalFundingRate(String contractCode,
                                                                         String pageIndex,
                                                                         String pageSize) throws IOException {
        HuobiResultV3<HuobiHistoricalFundingRateResult> fundingRate =
                huobi.getSwapHistoricalFundingRate(contractCode, pageIndex, pageSize);
        return checkResult(fundingRate);
    }

    public HuobiHistoricalFundingRateResult getLinearSwapHistoricalFundingRate(String contractCode,
                                                                               String pageIndex,
                                                                               String pageSize) throws IOException {
        HuobiResultV3<HuobiHistoricalFundingRateResult> fundingRate =
                huobi.getLinearSwapHistoricalFundingRate(contractCode, pageIndex, pageSize);
        return checkResult(fundingRate);
    }
}

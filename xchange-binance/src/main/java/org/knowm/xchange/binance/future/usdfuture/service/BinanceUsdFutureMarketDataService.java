package org.knowm.xchange.binance.future.usdfuture.service;

import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureFundingRate;
import org.knowm.xchange.binance.dto.marketdata.BinanceFuturePremiumIndex;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureTradeInfo;
import org.knowm.xchange.binance.dto.marketdata.BinancePrice;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeInfo;
import org.knowm.xchange.binance.future.usdfuture.BinanceUsdFutureAuthenticated;
import org.knowm.xchange.binance.future.usdfuture.BinanceUsdFutureExchange;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;
import java.util.List;

import static org.knowm.xchange.binance.BinanceResilience.REQUEST_WEIGHT_RATE_LIMITER;

public class BinanceUsdFutureMarketDataService extends BinanceUsdFutureBaseService implements MarketDataService {

    public BinanceUsdFutureMarketDataService(
            BinanceUsdFutureExchange exchange,
            BinanceUsdFutureAuthenticated binance,
            ResilienceRegistries resilienceRegistries) {
        super(exchange, binance, resilienceRegistries);
    }

    public BinanceExchangeInfo getExchangeInfo() throws IOException, BinanceException {
        return decorateApiCall(binance::getExchangeInfo)
                .withRetry(retry("usdFutureGetExchangeInfo"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public BinancePrice tickerPrice(String symbol) throws IOException, BinanceException {
        return decorateApiCall(() -> binance.tickerPrice(symbol))
                .withRetry(retry("usdFutureTickerPrice"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinanceFutureTradeInfo> getHistoricalTrades(String symbol, Integer limit, Long fromId) throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getHistoricalTrades(
                        symbol, limit, fromId))
                .withRetry(retry("usdFutureGetHistoricalTrades"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public BinanceFuturePremiumIndex getPremiumIndex(String symbol) throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getPremiumIndex(symbol))
                .withRetry(retry("usdFutureGetPremiumIndex"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinanceFutureFundingRate> getFundingRate(String symbol, Long startTime, Long endTime, Integer limit) throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getFundingRate(symbol, startTime, endTime, limit))
                .withRetry(retry("usdFutureGetFundingRate"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }


    protected int depthPermits(Integer limit) {
        if (limit == null || limit <= 100) {
            return 1;
        } else if (limit <= 500) {
            return 5;
        } else if (limit <= 1000) {
            return 10;
        }
        return 50;
    }

    protected int aggTradesPermits(Integer limit) {
        if (limit != null && limit > 500) {
            return 2;
        }
        return 1;
    }
}

package org.knowm.xchange.binance.future.coinfuture.service;

import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureFundingRate;
import org.knowm.xchange.binance.dto.marketdata.BinanceFuturePremiumIndex;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureTradeInfo;
import org.knowm.xchange.binance.dto.marketdata.BinancePrice;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeInfo;
import org.knowm.xchange.binance.future.coinfuture.BinanceCoinFutureAuthenticated;
import org.knowm.xchange.binance.future.coinfuture.BinanceCoinFutureExchange;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;
import java.util.List;

import static org.knowm.xchange.binance.BinanceResilience.REQUEST_WEIGHT_RATE_LIMITER;

public class BinanceCoinFutureMarketDataService extends BinanceCoinFutureBaseService implements MarketDataService {

    public BinanceCoinFutureMarketDataService(
            BinanceCoinFutureExchange exchange,
            BinanceCoinFutureAuthenticated binance,
            ResilienceRegistries resilienceRegistries) {
        super(exchange, binance, resilienceRegistries);
    }

    public BinanceExchangeInfo getExchangeInfo() throws IOException, BinanceException {
        return decorateApiCall(binance::getExchangeInfo)
                .withRetry(retry("coinFutureGetExchangeInfo"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinancePrice> tickerPrice(String symbol) throws IOException, BinanceException {
        return decorateApiCall(() -> binance.tickerPrice(symbol))
                .withRetry(retry("coinFutureTickerPrice"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinanceFutureTradeInfo> getHistoricalTrades(CurrencyPair pair, Integer limit, Long fromId) throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getHistoricalTrades(
                        BinanceAdapters.toSymbol(pair), limit, fromId))
                .withRetry(retry("coinFutureGetHistoricalTrades"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinanceFuturePremiumIndex> getPremiumIndex(String symbol, String pair) throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getPremiumIndex(symbol, pair))
                .withRetry(retry("coinFutureGetPremiumIndex"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinanceFutureFundingRate> getFundingRate(String symbol, Long startTime, Long endTime, Integer limit) throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getFundingRate(
                        symbol, startTime, endTime, limit))
                .withRetry(retry("coinFutureGetFundingRate"))
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

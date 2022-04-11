package org.knowm.xchange.binance.future.coinfuture.service;

import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.*;
import org.knowm.xchange.binance.future.coinfuture.BinanceCoinFutureAuthenticated;
import org.knowm.xchange.binance.future.coinfuture.BinanceCoinFutureExchange;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.account.AccountService;

import java.io.IOException;
import java.util.List;

import static org.knowm.xchange.binance.BinanceResilience.REQUEST_WEIGHT_RATE_LIMITER;
import static org.knowm.xchange.client.ResilienceRegistries.NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME;

public class BinanceCoinFutureAccountService extends BinanceCoinFutureBaseService implements AccountService {

    public BinanceCoinFutureAccountService(
            BinanceCoinFutureExchange exchange,
            BinanceCoinFutureAuthenticated binance,
            ResilienceRegistries resilienceRegistries) {
        super(exchange, binance, resilienceRegistries);
    }

    public List<BinanceFutureBalance> getAccountBalance()
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getAccountBalance(
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("coinFutureGetAccountBalance", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public BinanceFutureAccount getAccountDetail()
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getAccountDetail(
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("coinFutureGetAccountDetail", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public BinanceFuturePositionSide getPositionSideDual()
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getPositionSideDual(
                        getRecvWindow(),
                        getTimestampFactory(),
                        super.apiKey,
                        super.signatureCreator))
                .withRetry(retry("coinFutureGetPositionSideDual"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public String setPositionSideDual(String dualSidePosition)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.setPositionSideDual(
                        dualSidePosition,
                        getRecvWindow(),
                        getTimestampFactory(),
                        super.apiKey,
                        super.signatureCreator))
                .withRetry(retry("coinFutureSetPositionSideDual"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinanceFuturePositionRisk> getPositionRisk(String marginAsset, String pair)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getPositionRisk(
                        marginAsset,
                        pair,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("coinFutureGetPositionRisk", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public BinanceFutureCommissionRate getCommissionRate(CurrencyPair pair)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getCommissionRate(
                        BinanceAdapters.toSymbol(pair),
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("coinFutureGetCommissionRate", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }
}

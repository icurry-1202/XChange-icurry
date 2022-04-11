package org.knowm.xchange.binance.future.usdfuture.service;

import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.*;
import org.knowm.xchange.binance.dto.trade.MarginType;
import org.knowm.xchange.binance.dto.trade.SetLeverageResult;
import org.knowm.xchange.binance.future.usdfuture.BinanceUsdFutureAuthenticated;
import org.knowm.xchange.binance.future.usdfuture.BinanceUsdFutureExchange;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.service.account.AccountService;

import java.io.IOException;
import java.util.List;

import static org.knowm.xchange.binance.BinanceResilience.*;
import static org.knowm.xchange.client.ResilienceRegistries.NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME;

public class BinanceUsdFutureAccountService extends BinanceUsdFutureBaseService implements AccountService {

    public BinanceUsdFutureAccountService(
            BinanceUsdFutureExchange exchange,
            BinanceUsdFutureAuthenticated binance,
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
                .withRetry(retry("usdFutureGetAccountBalance", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
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
                .withRetry(retry("usdFutureGetAccountDetail", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
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
                .withRetry(retry("usdFutureGetPositionSideDual"))
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
                .withRetry(retry("usdFutureSetPositionSideDual"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinanceFuturePositionRisk> getPositionRisk(String symbol)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getPositionRisk(
                        symbol,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("usdFutureGetPositionRisk", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public BinanceFutureCommissionRate getCommissionRate(String symbol)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getCommissionRate(
                        symbol,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("usdFutureGetCommissionRate", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public SetLeverageResult setLeverage(String symbol, Integer leverage)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.setLeverage(
                        symbol,
                        leverage,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("usdFutureSetLeverage", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(ORDERS_PER_SECOND_RATE_LIMITER))
                .withRateLimiter(rateLimiter(ORDERS_PER_DAY_RATE_LIMITER))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public String setMarginType(String symbol, MarginType marginType)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.setMarginType(
                        symbol,
                        marginType,
                        getRecvWindow(),
                        getTimestampFactory(),
                        super.apiKey,
                        super.signatureCreator))
                .withRetry(retry("usdFutureSetMarginType"))
                .withRateLimiter(rateLimiter(ORDERS_PER_SECOND_RATE_LIMITER))
                .withRateLimiter(rateLimiter(ORDERS_PER_DAY_RATE_LIMITER))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }
}

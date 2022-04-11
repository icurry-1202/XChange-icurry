package org.knowm.xchange.binance.future.usdfuture.service;

import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.trade.*;
import org.knowm.xchange.binance.future.usdfuture.BinanceUsdFutureAuthenticated;
import org.knowm.xchange.binance.future.usdfuture.BinanceUsdFutureExchange;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.trade.TradeService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.knowm.xchange.binance.BinanceResilience.*;
import static org.knowm.xchange.client.ResilienceRegistries.NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME;

public class BinanceUsdFutureTradeService extends BinanceUsdFutureBaseService implements TradeService {

    public BinanceUsdFutureTradeService(
            BinanceUsdFutureExchange exchange,
            BinanceUsdFutureAuthenticated binance,
            ResilienceRegistries resilienceRegistries) {
        super(exchange, binance, resilienceRegistries);
    }

    public BinanceFutureOrder newOrder(String symbol,
                                       OrderSide side,
                                       PositionSide positionSide,
                                       OrderType type,
                                       Boolean reduceOnly,
                                       BigDecimal quantity,
                                       BigDecimal price,
                                       String newClientOrderId,
                                       BigDecimal stopPrice,
                                       String closePosition,
                                       BigDecimal activationPrice,
                                       BigDecimal callbackRate,
                                       TimeInForce timeInForce,
                                       WorkingType workingType,
                                       String priceProtect,
                                       NewOrderRespType newOrderRespType)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.newOrder(
                        symbol,
                        side,
                        positionSide,
                        type,
                        reduceOnly,
                        quantity,
                        price,
                        newClientOrderId,
                        stopPrice,
                        closePosition,
                        activationPrice,
                        callbackRate,
                        timeInForce,
                        workingType,
                        priceProtect,
                        newOrderRespType,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("usdFutureNewOrder", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(ORDERS_PER_SECOND_RATE_LIMITER))
                .withRateLimiter(rateLimiter(ORDERS_PER_DAY_RATE_LIMITER))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public BinanceFutureOrder orderDetail(String symbol, Long orderId, String origClientOrderId)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.orderDetail(
                        symbol,
                        orderId,
                        origClientOrderId,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("usdFutureOrderDetail", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public BinanceFutureOrder cancelOrder(String symbol, Long orderId, String origClientOrderId)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.cancelOrder(
                        symbol,
                        orderId,
                        origClientOrderId,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("usdFutureCancelOrder", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(ORDERS_PER_SECOND_RATE_LIMITER))
                .withRateLimiter(rateLimiter(ORDERS_PER_DAY_RATE_LIMITER))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public BinanceFutureOrder openOrderDetail(String symbol, Long orderId, String origClientOrderId)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.openOrderDetail(
                        symbol,
                        orderId,
                        origClientOrderId,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("usdFutureOpenOrderDetail", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinanceFutureOrder> getOpenOrders(String symbol)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getOpenOrders(
                        symbol,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("usdFutureGetOpenOrders", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    protected int openOrdersPermits(CurrencyPair pair) {
        return pair != null ? 1 : 40;
    }

    protected int myTradesPermits(Integer limit) {
        if (limit != null && limit > 500) {
            return 10;
        }
        return 5;
    }
}

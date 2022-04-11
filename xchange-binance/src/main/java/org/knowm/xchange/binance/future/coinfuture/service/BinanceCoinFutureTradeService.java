package org.knowm.xchange.binance.future.coinfuture.service;

import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.trade.*;
import org.knowm.xchange.binance.future.coinfuture.BinanceCoinFutureAuthenticated;
import org.knowm.xchange.binance.future.coinfuture.BinanceCoinFutureExchange;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.trade.TradeService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.knowm.xchange.binance.BinanceResilience.*;
import static org.knowm.xchange.client.ResilienceRegistries.NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME;

public class BinanceCoinFutureTradeService extends BinanceCoinFutureBaseService implements TradeService {

    public BinanceCoinFutureTradeService(
            BinanceCoinFutureExchange exchange,
            BinanceCoinFutureAuthenticated binance,
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
                .withRetry(retry("coinFutureNewOrder", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
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
                .withRetry(retry("coinFutureOrderDetail", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
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
                .withRetry(retry("coinFutureCancelOrder", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
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
                .withRetry(retry("coinFutureOpenOrderDetail", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public List<BinanceFutureOrder> getOpenOrders(String symbol, String pair)
            throws IOException, BinanceException {
        return decorateApiCall(
                () -> binance.getOpenOrders(
                        symbol,
                        pair,
                        getRecvWindow(),
                        getTimestampFactory(),
                        apiKey,
                        signatureCreator))
                .withRetry(retry("coinFutureGetOpenOrders", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
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
                .withRetry(retry("coinFutureSetLeverage", NON_IDEMPOTENT_CALLS_RETRY_CONFIG_NAME))
                .withRateLimiter(rateLimiter(ORDERS_PER_SECOND_RATE_LIMITER))
                .withRateLimiter(rateLimiter(ORDERS_PER_DAY_RATE_LIMITER))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }

    public String setMarginType(String symbol, MarginType marginType)
            throws IOException, BinanceException {
        return decorateApiCall(
                () ->
                        binance.setMarginType(
                                symbol,
                                marginType,
                                getRecvWindow(),
                                getTimestampFactory(),
                                super.apiKey,
                                super.signatureCreator))
                .withRetry(retry("coinFutureSetMarginType"))
                .withRateLimiter(rateLimiter(ORDERS_PER_SECOND_RATE_LIMITER))
                .withRateLimiter(rateLimiter(ORDERS_PER_DAY_RATE_LIMITER))
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

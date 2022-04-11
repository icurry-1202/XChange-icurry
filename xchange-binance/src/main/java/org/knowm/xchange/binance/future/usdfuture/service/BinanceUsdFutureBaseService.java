package org.knowm.xchange.binance.future.usdfuture.service;

import org.knowm.xchange.binance.future.usdfuture.BinanceUsdFutureAuthenticated;
import org.knowm.xchange.binance.future.usdfuture.BinanceUsdFutureExchange;
import org.knowm.xchange.binance.service.BinanceHmacDigest;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.service.BaseResilientExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

/**
 * @author buxianguan
 */
public class BinanceUsdFutureBaseService extends BaseResilientExchangeService<BinanceUsdFutureExchange> {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected final String apiKey;
    protected final BinanceUsdFutureAuthenticated binance;
    protected final ParamsDigest signatureCreator;

    protected BinanceUsdFutureBaseService(
            BinanceUsdFutureExchange exchange,
            BinanceUsdFutureAuthenticated binance,
            ResilienceRegistries resilienceRegistries) {

        super(exchange, resilienceRegistries);
        this.binance = binance;
        this.apiKey = exchange.getExchangeSpecification().getApiKey();
        this.signatureCreator =
                BinanceHmacDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
    }

    public Long getRecvWindow() {
        Object obj =
                exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            long value = ((Number) obj).longValue();
            if (value < 0 || value > 60000) {
                throw new IllegalArgumentException(
                        "Exchange-specific parameter \"recvWindow\" must be in the range [0, 60000].");
            }
            return value;
        }
        if (obj.getClass().equals(String.class)) {
            try {
                return Long.parseLong((String) obj, 10);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Exchange-specific parameter \"recvWindow\" could not be parsed.", e);
            }
        }
        throw new IllegalArgumentException(
                "Exchange-specific parameter \"recvWindow\" could not be parsed.");
    }

    public SynchronizedValueFactory<Long> getTimestampFactory() {
        return exchange.getTimestampFactory();
    }

    //public BinanceExchangeInfo getExchangeInfo() throws IOException {
    //    return decorateApiCall(binance::exchangeInfo)
    //            .withRetry(retry("exchangeInfo"))
    //            .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
    //            .call();
    //}
    //
    //public BinanceSystemStatus getSystemStatus() throws IOException {
    //    return decorateApiCall(binance::systemStatus).call();
    //}
}

package org.knowm.xchange.binance.future.coinfuture;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.binance.BinanceResilience;
import org.knowm.xchange.binance.future.coinfuture.service.BinanceCoinFutureAccountService;
import org.knowm.xchange.binance.future.coinfuture.service.BinanceCoinFutureMarketDataService;
import org.knowm.xchange.binance.future.coinfuture.service.BinanceCoinFutureTradeService;
import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.utils.AuthUtils;
import si.mazi.rescu.SynchronizedValueFactory;

/**
 * @author buxianguan
 * @Date 2022/3/31 18:03
 */
public class BinanceCoinFutureExchange extends BaseExchange {
    protected static ResilienceRegistries RESILIENCE_REGISTRIES;

    protected BinanceCoinFutureAuthenticated binance;
    protected SynchronizedValueFactory<Long> timestampFactory;

    @Override
    protected void initServices() {
        this.binance =
                ExchangeRestProxyBuilder.forInterface(
                                BinanceCoinFutureAuthenticated.class, getExchangeSpecification())
                        .build();
        this.timestampFactory =
                new BinanceCoinFutureTimestampFactory(
                        binance, getExchangeSpecification().getResilience(), getResilienceRegistries());
        this.marketDataService = new BinanceCoinFutureMarketDataService(this, binance, getResilienceRegistries());
        this.tradeService = new BinanceCoinFutureTradeService(this, binance, getResilienceRegistries());
        this.accountService = new BinanceCoinFutureAccountService(this, binance, getResilienceRegistries());
    }

    public SynchronizedValueFactory<Long> getTimestampFactory() {
        return timestampFactory;
    }

    @Override
    public SynchronizedValueFactory<Long> getNonceFactory() {
        throw new UnsupportedOperationException(
                "Binance uses timestamp/recvwindow rather than a nonce");
    }

    public static void resetResilienceRegistries() {
        RESILIENCE_REGISTRIES = null;
    }

    @Override
    public ResilienceRegistries getResilienceRegistries() {
        if (RESILIENCE_REGISTRIES == null) {
            RESILIENCE_REGISTRIES = BinanceResilience.createRegistries();
        }
        return RESILIENCE_REGISTRIES;
    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {
        ExchangeSpecification spec = new ExchangeSpecification(this.getClass());
        spec.setSslUri("https://dapi.binance.com");
        spec.setHost("www.binance.com");
        spec.setPort(80);
        spec.setExchangeName("Binance Coin Future");
        spec.setExchangeDescription("Binance Coin Future Exchange.");
        AuthUtils.setApiAndSecretKey(spec, "binanceCoinFuture");
        return spec;
    }

    @Override
    public void applySpecification(ExchangeSpecification exchangeSpecification) {
        super.applySpecification(exchangeSpecification);
    }

    @Override
    public void remoteInit() {
    }
}

package org.knowm.xchange.binance.future.usdfuture;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.binance.BinanceResilience;
import org.knowm.xchange.binance.future.usdfuture.service.BinanceUsdFutureAccountService;
import org.knowm.xchange.binance.future.usdfuture.service.BinanceUsdFutureMarketDataService;
import org.knowm.xchange.binance.future.usdfuture.service.BinanceUsdFutureTradeService;
import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.utils.AuthUtils;
import si.mazi.rescu.SynchronizedValueFactory;

/**
 * @author buxianguan
 * @Date 2022/3/31 18:03
 */
public class BinanceUsdFutureExchange extends BaseExchange {
    protected static ResilienceRegistries RESILIENCE_REGISTRIES;

    protected BinanceUsdFutureAuthenticated binance;
    protected SynchronizedValueFactory<Long> timestampFactory;

    @Override
    protected void initServices() {
        this.binance =
                ExchangeRestProxyBuilder.forInterface(
                                BinanceUsdFutureAuthenticated.class, getExchangeSpecification())
                        .build();
        this.timestampFactory =
                new BinanceUsdFutureTimestampFactory(
                        binance, getExchangeSpecification().getResilience(), getResilienceRegistries());
        this.marketDataService = new BinanceUsdFutureMarketDataService(this, binance, getResilienceRegistries());
        this.tradeService = new BinanceUsdFutureTradeService(this, binance, getResilienceRegistries());
        this.accountService = new BinanceUsdFutureAccountService(this, binance, getResilienceRegistries());
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
        spec.setSslUri("https://fapi.binance.com");
        spec.setHost("www.binance.com");
        spec.setPort(80);
        spec.setExchangeName("Binance USD Future");
        spec.setExchangeDescription("Binance USD Future Exchange.");
        AuthUtils.setApiAndSecretKey(spec, "binanceUsdFuture");
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

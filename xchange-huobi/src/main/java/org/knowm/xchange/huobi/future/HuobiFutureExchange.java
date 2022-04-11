package org.knowm.xchange.huobi.future;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.huobi.future.service.HuobiFutureMarketDataService;
import org.knowm.xchange.huobi.future.service.HuobiFutureTradeService;
import org.knowm.xchange.huobi.service.HuobiAccountService;

import java.io.IOException;

public class HuobiFutureExchange extends BaseExchange implements Exchange {

    @Override
    protected void initServices() {
        this.marketDataService = new HuobiFutureMarketDataService(this);
        this.tradeService = new HuobiFutureTradeService(this);
        this.accountService = new HuobiAccountService(this);
    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {
        ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass());
        exchangeSpecification.setSslUri("https://api.hbdm.com");
        exchangeSpecification.setHost("api.hbdm.com");
        exchangeSpecification.setPort(80);
        exchangeSpecification.setExchangeName("Huobi Future");
        exchangeSpecification.setExchangeDescription(
                "HuobiFuture is a Chinese digital currency trading platform and exchange based in Beijing");
        return exchangeSpecification;
    }

    @Override
    public void remoteInit() throws IOException, ExchangeException {
    }
}

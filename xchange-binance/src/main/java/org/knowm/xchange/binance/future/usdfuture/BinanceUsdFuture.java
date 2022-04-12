package org.knowm.xchange.binance.future.usdfuture;

import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureFundingRate;
import org.knowm.xchange.binance.dto.marketdata.BinanceFuturePremiumIndex;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureTradeInfo;
import org.knowm.xchange.binance.dto.marketdata.BinancePrice;
import org.knowm.xchange.binance.dto.meta.BinanceTime;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface BinanceUsdFuture {
    /**
     * Test connectivity to the Rest API.
     *
     * @return
     * @throws IOException
     */
    @GET
    @Path("fapi/v1/ping")
    Object ping() throws IOException;

    /**
     * Test connectivity to the Rest API and get the current server time.
     *
     * @return
     * @throws IOException
     */
    @GET
    @Path("fapi/v1/time")
    BinanceTime time() throws IOException;

    /**
     * Current exchange trading rules and symbol information.
     *
     * @return
     * @throws IOException
     */
    @GET
    @Path("fapi/v1/exchangeInfo")
    BinanceExchangeInfo getExchangeInfo() throws IOException;

    @GET
    @Path("fapi/v1/ticker/price")
    BinancePrice tickerPrice(@QueryParam("symbol") String symbol) throws IOException;

    @GET
    @Path("fapi/v1/historicalTrades")
    List<BinanceFutureTradeInfo> getHistoricalTrades(
            @QueryParam("symbol") String symbol,
            @QueryParam("limit") Integer limit,
            @QueryParam("fromId") Long fromId) throws IOException;

    @GET
    @Path("fapi/v1/premiumIndex")
    BinanceFuturePremiumIndex getPremiumIndex(
            @QueryParam("symbol") String symbol)
            throws IOException, BinanceException;

    @GET
    @Path("fapi/v1/fundingRate")
    List<BinanceFutureFundingRate> getFundingRate(
            @QueryParam("symbol") String symbol,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime,
            @QueryParam("limit") Integer limit)
            throws IOException, BinanceException;

}

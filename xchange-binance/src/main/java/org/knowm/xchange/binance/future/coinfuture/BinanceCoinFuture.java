package org.knowm.xchange.binance.future.coinfuture;

import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.marketdata.*;
import org.knowm.xchange.binance.dto.meta.BinanceTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface BinanceCoinFuture {
    /**
     * Test connectivity to the Rest API.
     *
     * @return
     * @throws IOException
     */
    @GET
    @Path("dapi/v1/ping")
    Object ping() throws IOException;

    /**
     * Test connectivity to the Rest API and get the current server time.
     *
     * @return
     * @throws IOException
     */
    @GET
    @Path("dapi/v1/time")
    BinanceTime time() throws IOException;

    /**
     * Current exchange trading rules and symbol information.
     *
     * @return
     * @throws IOException
     */
    @GET
    @Path("dapi/v1/exchangeInfo")
    BinanceFutureExchangeInfo getExchangeInfo() throws IOException;

    @GET
    @Path("fapi/v1/ticker/price")
    List<BinancePrice> tickerPrice(@QueryParam("symbol") String symbol) throws IOException;

    @GET
    @Path("dapi/v1/historicalTrades")
    List<BinanceFutureTradeInfo> getHistoricalTrades(
            @QueryParam("symbol") String symbol,
            @QueryParam("limit") Integer limit,
            @QueryParam("fromId") Long fromId) throws IOException;

    @GET
    @Path("dapi/v1/premiumIndex")
    List<BinanceFuturePremiumIndex> getPremiumIndex(
            @QueryParam("symbol") String symbol,
            @QueryParam("pair") String pair)
            throws IOException, BinanceException;

    @GET
    @Path("dapi/v1/fundingRate")
    List<BinanceFutureFundingRate> getFundingRate(
            @QueryParam("symbol") String symbol,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime,
            @QueryParam("limit") Integer limit)
            throws IOException, BinanceException;

}

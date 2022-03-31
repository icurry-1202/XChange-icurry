package org.knowm.xchange.okex.v5;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.knowm.xchange.okex.v5.dto.OkexException;
import org.knowm.xchange.okex.v5.dto.OkexResponse;
import org.knowm.xchange.okex.v5.dto.marketdata.*;

@Path("/api/v5")
@Produces(APPLICATION_JSON)
public interface Okex {
  String instrumentsPath = "/public/instruments"; // Stated as 20 req/2 sec
  String fundingRatePath = "/public/funding-rate"; // Stated as 20 req/2 sec
  String fundingRateHistoryPath = "/public/funding-rate-history"; // Stated as 20 req/2 sec

  // To avoid 429s, actual req/second may need to be lowered!
  Map<String, List<Integer>> publicPathRateLimits =
      new HashMap<String, List<Integer>>() {
        {
          put(instrumentsPath, Arrays.asList(20, 2));
          put(fundingRatePath, Arrays.asList(20, 2));
          put(fundingRateHistoryPath, Arrays.asList(10, 2));
        }
      };

  @GET
  @Path(instrumentsPath)
  OkexResponse<List<OkexInstrument>> getInstruments(
      @QueryParam("instType") String instrumentType,
      @QueryParam("uly") String underlying,
      @QueryParam("instId") String instrumentId,
      @HeaderParam("X-SIMULATED-TRADING") String simulatedTrading)
      throws OkexException, IOException;

  @GET
  @Path(fundingRatePath)
  OkexResponse<List<OkexFundingRate>> getFundingRate(
          @QueryParam("instId") String instrumentId,
          @HeaderParam("X-SIMULATED-TRADING") String simulatedTrading)
          throws OkexException, IOException;

  @GET
  @Path(fundingRateHistoryPath)
  OkexResponse<List<OkexFundingRateHistory>> getFundingRateHistory(
          @QueryParam("instId") String instrumentId,
          @QueryParam("before") String before,
          @QueryParam("after") String after,
          @QueryParam("limit") String limit,
          @HeaderParam("X-SIMULATED-TRADING") String simulatedTrading)
          throws OkexException, IOException;

  @GET
  @Path("/market/trades")
  @Consumes(MediaType.APPLICATION_JSON)
  OkexResponse<List<OkexTrade>> getTrades(
      @QueryParam("instId") String instrument,
      @QueryParam("limit") int limit,
      @HeaderParam("X-SIMULATED-TRADING") String simulatedTrading)
      throws IOException, OkexException;

  @GET
  @Path("/market/books")
  OkexResponse<List<OkexOrderbook>> getOrderbook(
      @QueryParam("instId") String instrument,
      @QueryParam("sz") int depth,
      @HeaderParam("X-SIMULATED-TRADING") String simulatedTrading)
      throws IOException, OkexException;

  @GET
  @Path("/market/history-candles")
  OkexResponse<List<OkexCandleStick>> getHistoryCandles(
      @QueryParam("instId") String instrument,
      @QueryParam("after") String after,
      @QueryParam("before") String before,
      @QueryParam("bar") String bar,
      @QueryParam("limit") String limit,
      @HeaderParam("X-SIMULATED-TRADING") String simulatedTrading)
      throws IOException, OkexException;

  @GET
  @Path("/market/ticker")
  OkexResponse<List<OkexTicker>> getMarketTicker(
      @QueryParam("instId") String instId,
      @HeaderParam("X-SIMULATED-TRADING") String simulatedTrading)
      throws IOException, OkexException;
}

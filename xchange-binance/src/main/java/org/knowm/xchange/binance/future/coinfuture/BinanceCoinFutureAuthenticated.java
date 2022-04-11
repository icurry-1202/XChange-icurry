package org.knowm.xchange.binance.future.coinfuture;

import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.*;
import org.knowm.xchange.binance.dto.trade.*;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface BinanceCoinFutureAuthenticated extends BinanceCoinFuture {

    String SIGNATURE = "signature";
    String X_MBX_APIKEY = "X-MBX-APIKEY";

    @GET
    @Path("dapi/v1/positionSide/dual")
    BinanceFuturePositionSide getPositionSideDual(
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @POST
    @Path("dapi/v1/positionSide/dual")
    String setPositionSideDual(
            @FormParam("dualSidePosition") String dualSidePosition,
            @FormParam("recvWindow") Long recvWindow,
            @FormParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @POST
    @Path("dapi/v1/order")
    BinanceFutureOrder newOrder(
            @FormParam("symbol") String symbol,
            @FormParam("side") OrderSide side,
            @FormParam("positionSide") PositionSide positionSide,
            @FormParam("type") OrderType type,
            @FormParam("reduceOnly") Boolean reduceOnly,
            @FormParam("quantity") BigDecimal quantity,
            @FormParam("price") BigDecimal price,
            @FormParam("newClientOrderId") String newClientOrderId,
            @FormParam("stopPrice") BigDecimal stopPrice,
            @FormParam("closePosition") String closePosition,
            @FormParam("activationPrice") BigDecimal activationPrice,
            @FormParam("callbackRate") BigDecimal callbackRate,
            @FormParam("timeInForce") TimeInForce timeInForce,
            @FormParam("workingType") WorkingType workingType,
            @FormParam("priceProtect") String priceProtect,
            @FormParam("newOrderRespType") NewOrderRespType newOrderRespType,
            @FormParam("recvWindow") Long recvWindow,
            @FormParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @GET
    @Path("dapi/v1/order")
    BinanceFutureOrder orderDetail(
            @QueryParam("symbol") String symbol,
            @QueryParam("orderId") Long orderId,
            @QueryParam("origClientOrderId") String origClientOrderId,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @DELETE
    @Path("dapi/v1/order")
    BinanceFutureOrder cancelOrder(
            @QueryParam("symbol") String symbol,
            @QueryParam("orderId") Long orderId,
            @QueryParam("origClientOrderId") String origClientOrderId,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @GET
    @Path("dapi/v1/openOrder")
    BinanceFutureOrder openOrderDetail(
            @QueryParam("symbol") String symbol,
            @QueryParam("orderId") Long orderId,
            @QueryParam("origClientOrderId") String origClientOrderId,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @GET
    @Path("dapi/v1/openOrders")
    List<BinanceFutureOrder> getOpenOrders(
            @QueryParam("symbol") String symbol,
            @QueryParam("pair") String pair,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @GET
    @Path("dapi/v1/balance")
    List<BinanceFutureBalance> getAccountBalance(
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @GET
    @Path("dapi/v1/account")
    BinanceFutureAccount getAccountDetail(
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @POST
    @Path("dapi/v1/leverage")
    SetLeverageResult setLeverage(
            @FormParam("symbol") String symbol,
            @FormParam("leverage") Integer leverage,
            @FormParam("recvWindow") Long recvWindow,
            @FormParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @POST
    @Path("dapi/v1/marginType")
    String setMarginType(
            @FormParam("symbol") String symbol,
            @FormParam("marginType") MarginType marginType,
            @FormParam("recvWindow") Long recvWindow,
            @FormParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @GET
    @Path("dapi/v1/positionRisk")
    List<BinanceFuturePositionRisk> getPositionRisk(
            @QueryParam("marginAsset") String marginAsset,
            @QueryParam("pair") String pair,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature) throws IOException, BinanceException;

    @GET
    @Path("dapi/v1/commissionRate")
    BinanceFutureCommissionRate getCommissionRate(
            @QueryParam("symbol") String symbol,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature) throws IOException, BinanceException;

}

package org.knowm.xchange.huobi.future;

import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.account.HuobiBalanceValuation;
import org.knowm.xchange.huobi.dto.account.HuobiFutureAccount;
import org.knowm.xchange.huobi.dto.account.HuobiFutureFee;
import org.knowm.xchange.huobi.dto.account.HuobiFuturePosition;
import org.knowm.xchange.huobi.dto.marketdata.HuobiContractInfo;
import org.knowm.xchange.huobi.dto.trade.HuobiFutureOrder;
import org.knowm.xchange.huobi.dto.trade.HuobiFutureOrderRequest;
import org.knowm.xchange.huobi.dto.trade.results.HuobiFutureCancelOrderResult;
import org.knowm.xchange.huobi.dto.trade.results.HuobiFutureHisOrderResult;
import org.knowm.xchange.huobi.dto.trade.results.HuobiFutureOrderResult;
import org.knowm.xchange.huobi.dto.trade.results.HuobiSwitchLeverRateResult;
import si.mazi.rescu.ParamsDigest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface HuobiFuture extends HuobiFutureSwap, HuobiFutureLinearSwap {
    @GET
    @Path("api/v1/contract_contract_info")
    HuobiResultV3<List<HuobiContractInfo>> getContractInfo(
            @QueryParam("symbol") String symbol,
            @QueryParam("contract_type") String contractType,
            @QueryParam("contract_code") String contractCode
    ) throws IOException;

    @POST
    @Path("api/v1/contract_account_info")
    HuobiResultV3<List<HuobiFutureAccount>> getContractAccountInfo(
            @QueryParam("symbol") String symbol,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

    @POST
    @Path("api/v1/contract_balance_valuation")
    HuobiResultV3<List<HuobiBalanceValuation>> getContractBalanceValuation(
            @QueryParam("valuation_asset") String valuationAsset,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

    @POST
    @Path("api/v1/contract_position_info")
    HuobiResultV3<List<HuobiFuturePosition>> getContractPositionInfo(
            @QueryParam("symbol") String symbol,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

    @POST
    @Path("api/v1/contract_position_info")
    HuobiResultV3<List<HuobiFutureFee>> getContractFee(
            @QueryParam("symbol") String symbol,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

    @POST
    @Path("api/v1/contract_order")
    @Consumes(MediaType.APPLICATION_JSON)
    HuobiResultV3<HuobiFutureOrderResult> createContractOrder(
            HuobiFutureOrderRequest request,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

    @POST
    @Path("api/v1/contract_cancel")
    @Consumes(MediaType.APPLICATION_JSON)
    HuobiResultV3<HuobiFutureCancelOrderResult> cancelContractOrder(
            @QueryParam("order_id") String orderId,
            @QueryParam("client_order_id") String clientOrderId,
            @QueryParam("symbol") String symbol,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

    @POST
    @Path("api/v1/contract_switch_lever_rate")
    @Consumes(MediaType.APPLICATION_JSON)
    HuobiResultV3<HuobiSwitchLeverRateResult> contractSwitchLeverRate(
            @QueryParam("symbol") String symbol,
            @QueryParam("lever_rate") Integer leverRate,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

    @POST
    @Path("api/v1/contract_order_info")
    @Consumes(MediaType.APPLICATION_JSON)
    HuobiResultV3<List<HuobiFutureOrder>> getContractOrderInfo(
            @QueryParam("symbol") String symbol,
            @QueryParam("order_id") String orderId,
            @QueryParam("client_order_id") String clientOrderId,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

    @POST
    @Path("api/v1/contract_openorders")
    @Consumes(MediaType.APPLICATION_JSON)
    HuobiResultV3<List<HuobiFutureOrder>> getContractOpenOrders(
            @QueryParam("symbol") String symbol,
            @QueryParam("page_index") Integer pageIndex,
            @QueryParam("page_size") Integer pageSize,
            @QueryParam("sort_by") String sortBy,
            @QueryParam("trade_type") Integer tradeType,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

    @POST
    @Path("api/v1/contract_hisorders")
    @Consumes(MediaType.APPLICATION_JSON)
    HuobiResultV3<HuobiFutureHisOrderResult> getContractHisOrders(
            @QueryParam("symbol") String symbol,
            @QueryParam("trade_type") Integer tradeType,
            @QueryParam("type") Integer type,
            @QueryParam("status") String status,
            @QueryParam("create_date") Integer createDate,
            @QueryParam("page_index") Integer pageIndex,
            @QueryParam("page_size") Integer pageSize,
            @QueryParam("contract_code") String contractCode,
            @QueryParam("order_type") String orderType,
            @QueryParam("sort_by") String sortBy,
            @QueryParam("AccessKeyId") String apiKey,
            @QueryParam("SignatureMethod") String signatureMethod,
            @QueryParam("SignatureVersion") int SignatureVersion,
            @QueryParam("Timestamp") String nonce,
            @QueryParam("Signature") ParamsDigest signature)
            throws IOException;

}

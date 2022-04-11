//package org.knowm.xchange.huobi.future;
//
//import org.knowm.xchange.huobi.dto.HuobiResultV3;
//import org.knowm.xchange.huobi.dto.account.HuobiFutureAccount;
//import org.knowm.xchange.huobi.dto.account.HuobiFutureFee;
//import org.knowm.xchange.huobi.dto.account.HuobiFuturePosition;
//import org.knowm.xchange.huobi.dto.marketdata.HuobiContractInfo;
//import org.knowm.xchange.huobi.dto.trade.HuobiFutureOrder;
//import org.knowm.xchange.huobi.dto.trade.HuobiFutureOrderRequest;
//import org.knowm.xchange.huobi.dto.trade.results.HuobiFutureCancelOrderResult;
//import org.knowm.xchange.huobi.dto.trade.results.HuobiFutureOrderResult;
//import org.knowm.xchange.huobi.dto.trade.results.HuobiSwitchLeverRateResult;
//import si.mazi.rescu.ParamsDigest;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import java.io.IOException;
//import java.util.List;
//
//@Path("/")
//@Produces(MediaType.APPLICATION_JSON)
//public interface HuobiFutureBack {
//
//    @GET
//    @Path("api/v1/contract_contract_info")
//    HuobiResultV3<List<HuobiContractInfo>> getContractInfo(
//            @QueryParam("symbol") String symbol,
//            @QueryParam("contract_type") String contractType,
//            @QueryParam("contract_code") String contractCode
//    ) throws IOException;
//
//    @GET
//    @Path("swap-api/v1/swap_contract_info")
//    HuobiResultV3<List<HuobiContractInfo>> getSwapContractInfo(
//            @QueryParam("contract_code") String contractCode
//    ) throws IOException;
//
//    @GET
//    @Path("linear-swap-api/v1/swap_contract_info")
//    HuobiResultV3<List<HuobiContractInfo>> getLinearSwapContractInfo(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("support_margin_mode") String supportMarginMode,
//            @QueryParam("pair") String pair,
//            @QueryParam("contract_type") String contractType,
//            @QueryParam("business_type") String businessType
//    ) throws IOException;
//
//    @POST
//    @Path("api/v1/contract_account_info")
//    HuobiResultV3<List<HuobiFutureAccount>> getContractAccountInfo(
//            @QueryParam("symbol") String symbol,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("swap-api/v1/swap_account_info")
//    HuobiResultV3<List<HuobiFutureAccount>> getSwapAccountInfo(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("linear-swap-api/v1/swap_account_info")
//    HuobiResultV3<List<HuobiFutureAccount>> getLinearSwapAccountInfo(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("api/v1/contract_position_info")
//    HuobiResultV3<List<HuobiFuturePosition>> getContractPositionInfo(
//            @QueryParam("symbol") String symbol,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("swap-api/v1/swap_position_info")
//    HuobiResultV3<List<HuobiFuturePosition>> getSwapPositionInfo(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("linear-swap-api/v1/swap_position_info")
//    HuobiResultV3<List<HuobiFuturePosition>> getLinearSwapPositionInfo(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("api/v1/contract_position_info")
//    HuobiResultV3<List<HuobiFutureFee>> getContractFee(
//            @QueryParam("symbol") String symbol,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("swap-api/v1/swap_fee")
//    HuobiResultV3<List<HuobiFutureFee>> getSwapFee(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("linear-swap-api/v1/swap_fee")
//    HuobiResultV3<List<HuobiFutureFee>> getLinearSwapFee(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("pair") String pair,
//            @QueryParam("contract_type") String contractType,
//            @QueryParam("business_type") String businessType,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("api/v1/contract_order")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiFutureOrderResult> createContractOrder(
//            HuobiFutureOrderRequest request,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("swap-api/v1/swap_order")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiFutureOrderResult> createSwapOrder(
//            HuobiFutureOrderRequest request,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    /**
//     * U本位合约-逐仓合约下单
//     *
//     * @param request
//     * @param apiKey
//     * @param signatureMethod
//     * @param SignatureVersion
//     * @param nonce
//     * @param signature
//     * @return
//     * @throws IOException
//     */
//    @POST
//    @Path("linear-swap-api/v1/swap_order")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiFutureOrderResult> createLinearSwapOrder(
//            HuobiFutureOrderRequest request,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    /**
//     * U本位合约-全仓合约下单
//     *
//     * @param request
//     * @param apiKey
//     * @param signatureMethod
//     * @param SignatureVersion
//     * @param nonce
//     * @param signature
//     * @return
//     * @throws IOException
//     */
//    @POST
//    @Path("linear-swap-api/v1/swap_cross_order")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiFutureOrderResult> createLinearSwapCrossOrder(
//            HuobiFutureOrderRequest request,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("api/v1/contract_cancel")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiFutureCancelOrderResult> cancelContractOrder(
//            @QueryParam("order_id") String orderId,
//            @QueryParam("client_order_id") String clientOrderId,
//            @QueryParam("symbol") String symbol,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("swap-api/v1/swap_cancel")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiFutureCancelOrderResult> cancelSwapOrder(
//            @QueryParam("order_id") String orderId,
//            @QueryParam("client_order_id") String clientOrderId,
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    /**
//     * U本位合约-逐仓合约撤单
//     *
//     * @param orderId
//     * @param clientOrderId
//     * @param contractCode
//     * @param apiKey
//     * @param signatureMethod
//     * @param SignatureVersion
//     * @param nonce
//     * @param signature
//     * @return
//     * @throws IOException
//     */
//    @POST
//    @Path("linear-swap-api/v1/swap_cancel")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiFutureCancelOrderResult> cancelLinearSwapOrder(
//            @QueryParam("order_id") String orderId,
//            @QueryParam("client_order_id") String clientOrderId,
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    /**
//     * U本位合约-全仓合约撤单
//     *
//     * @param orderId
//     * @param clientOrderId
//     * @param contractCode
//     * @param pair
//     * @param contractType
//     * @param apiKey
//     * @param signatureMethod
//     * @param SignatureVersion
//     * @param nonce
//     * @param signature
//     * @return
//     * @throws IOException
//     */
//    @POST
//    @Path("linear-swap-api/v1/swap_cross_cancel")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiFutureCancelOrderResult> cancelLinearSwapCrossOrder(
//            @QueryParam("order_id") String orderId,
//            @QueryParam("client_order_id") String clientOrderId,
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("pair") String pair,
//            @QueryParam("contract_type") String contractType,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("api/v1/contract_switch_lever_rate")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiSwitchLeverRateResult> contractSwitchLeverRate(
//            @QueryParam("symbol") String symbol,
//            @QueryParam("lever_rate") Integer leverRate,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("swap-api/v1/swap_switch_lever_rate")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiSwitchLeverRateResult> swapSwitchLeverRate(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("lever_rate") Integer leverRate,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    /**
//     * U本位合约-逐仓切换杠杆
//     *
//     * @param contractCode
//     * @param leverRate
//     * @param apiKey
//     * @param signatureMethod
//     * @param SignatureVersion
//     * @param nonce
//     * @param signature
//     * @return
//     * @throws IOException
//     */
//    @POST
//    @Path("linear-swap-api/v1/swap_switch_lever_rate")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiSwitchLeverRateResult> linearSwapSwitchLeverRate(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("lever_rate") Integer leverRate,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    /**
//     * U本位合约-全仓切换杠杆
//     *
//     * @param contractCode
//     * @param pair
//     * @param contractType
//     * @param leverRate
//     * @param apiKey
//     * @param signatureMethod
//     * @param SignatureVersion
//     * @param nonce
//     * @param signature
//     * @return
//     * @throws IOException
//     */
//    @POST
//    @Path("linear-swap-api/v1/swap_cross_switch_lever_rate")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<HuobiSwitchLeverRateResult> linearSwapCrossSwitchLeverRate(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("pair") String pair,
//            @QueryParam("contract_type") String contractType,
//            @QueryParam("lever_rate") Integer leverRate,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("api/v1/contract_order_info")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<List<HuobiFutureOrder>> getContractOrderInfo(
//            @QueryParam("symbol") String symbol,
//            @QueryParam("order_id") String orderId,
//            @QueryParam("client_order_id") String clientOrderId,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("swap-api/v1/swap_order_info")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<List<HuobiFutureOrder>> getSwapOrderInfo(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("order_id") String orderId,
//            @QueryParam("client_order_id") String clientOrderId,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("linear-swap-api/v1/swap_order_info")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<List<HuobiFutureOrder>> getLinearSwapOrderInfo(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("order_id") String orderId,
//            @QueryParam("client_order_id") String clientOrderId,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("linear-swap-api/v1/swap_cross_order_info")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<List<HuobiFutureOrder>> getLinearSwapCrossOrderInfo(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("pair") String pair,
//            @QueryParam("order_id") String orderId,
//            @QueryParam("client_order_id") String clientOrderId,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("api/v1/contract_openorders")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<List<HuobiFutureOrder>> getContractOpenOrders(
//            @QueryParam("symbol") String symbol,
//            @QueryParam("page_index") Integer pageIndex,
//            @QueryParam("page_size") Integer pageSize,
//            @QueryParam("sort_by") String sortBy,
//            @QueryParam("trade_type") Integer tradeType,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("swap-api/v1/swap_openorders")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<List<HuobiFutureOrder>> getSwapOpenOrders(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("page_index") Integer pageIndex,
//            @QueryParam("page_size") Integer pageSize,
//            @QueryParam("sort_by") String sortBy,
//            @QueryParam("trade_type") Integer tradeType,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//
//    @POST
//    @Path("linear-swap-api/v1/swap_openorders")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<List<HuobiFutureOrder>> getLinearSwapOpenOrders(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("page_index") Integer pageIndex,
//            @QueryParam("page_size") Integer pageSize,
//            @QueryParam("sort_by") String sortBy,
//            @QueryParam("trade_type") Integer tradeType,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//
//    @POST
//    @Path("linear-swap-api/v1/swap_cross_openorders")
//    @Consumes(MediaType.APPLICATION_JSON)
//    HuobiResultV3<List<HuobiFutureOrder>> getLinearSwapCrossOpenOrders(
//            @QueryParam("contract_code") String contractCode,
//            @QueryParam("pair") String pair,
//            @QueryParam("page_index") Integer pageIndex,
//            @QueryParam("page_size") Integer pageSize,
//            @QueryParam("sort_by") String sortBy,
//            @QueryParam("trade_type") Integer tradeType,
//            @QueryParam("AccessKeyId") String apiKey,
//            @QueryParam("SignatureMethod") String signatureMethod,
//            @QueryParam("SignatureVersion") int SignatureVersion,
//            @QueryParam("Timestamp") String nonce,
//            @QueryParam("Signature") ParamsDigest signature)
//            throws IOException;
//}

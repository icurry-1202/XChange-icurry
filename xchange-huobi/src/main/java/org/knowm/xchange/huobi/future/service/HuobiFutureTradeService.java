package org.knowm.xchange.huobi.future.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.huobi.HuobiDigest;
import org.knowm.xchange.huobi.HuobiUtils;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.trade.HuobiFutureOrder;
import org.knowm.xchange.huobi.dto.trade.HuobiFutureOrderRequest;
import org.knowm.xchange.huobi.dto.trade.results.HuobiFutureCancelOrderResult;
import org.knowm.xchange.huobi.dto.trade.results.HuobiFutureHisOrderResult;
import org.knowm.xchange.huobi.dto.trade.results.HuobiFutureOrderResult;
import org.knowm.xchange.huobi.dto.trade.results.HuobiSwitchLeverRateResult;
import org.knowm.xchange.service.trade.TradeService;

import java.io.IOException;
import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/2 10:45
 */
public class HuobiFutureTradeService extends HuobiFutureBaseService implements TradeService {
    public HuobiFutureTradeService(Exchange exchange) {
        super(exchange);
    }

    public HuobiFutureOrderResult createContractOrder(HuobiFutureOrderRequest request) throws IOException {
        HuobiResultV3<HuobiFutureOrderResult> result = huobi.createContractOrder(
                request,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureOrderResult createSwapOrder(HuobiFutureOrderRequest request) throws IOException {
        HuobiResultV3<HuobiFutureOrderResult> result = huobi.createSwapOrder(
                request,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureOrderResult createLinearSwapOrder(HuobiFutureOrderRequest request) throws IOException {
        HuobiResultV3<HuobiFutureOrderResult> result = huobi.createLinearSwapOrder(
                request,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureOrderResult createLinearSwapCrossOrder(HuobiFutureOrderRequest request) throws IOException {
        HuobiResultV3<HuobiFutureOrderResult> result = huobi.createLinearSwapCrossOrder(
                request,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureCancelOrderResult cancelContractOrder(String orderId,
                                                            String clientOrderId,
                                                            String symbol) throws IOException {
        HuobiResultV3<HuobiFutureCancelOrderResult> result = huobi.cancelContractOrder(
                orderId,
                clientOrderId,
                symbol,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureCancelOrderResult cancelSwapOrder(String orderId,
                                                        String clientOrderId,
                                                        String contractCode) throws IOException {
        HuobiResultV3<HuobiFutureCancelOrderResult> result = huobi.cancelSwapOrder(
                orderId,
                clientOrderId,
                contractCode,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureCancelOrderResult cancelLinearSwapOrder(String orderId,
                                                              String clientOrderId,
                                                              String contractCode) throws IOException {
        HuobiResultV3<HuobiFutureCancelOrderResult> result = huobi.cancelLinearSwapOrder(
                orderId,
                clientOrderId,
                contractCode,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureCancelOrderResult cancelLinearSwapCrossOrder(String orderId,
                                                                   String clientOrderId,
                                                                   String contractCode,
                                                                   String pair,
                                                                   String contractType) throws IOException {
        HuobiResultV3<HuobiFutureCancelOrderResult> result = huobi.cancelLinearSwapCrossOrder(
                orderId,
                clientOrderId,
                contractCode,
                pair,
                contractType,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiSwitchLeverRateResult contractSwitchLeverRate(String symbol,
                                                              Integer leverRate) throws IOException {
        HuobiResultV3<HuobiSwitchLeverRateResult> result = huobi.contractSwitchLeverRate(
                symbol,
                leverRate,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiSwitchLeverRateResult swapSwitchLeverRate(String contractCode,
                                                          Integer leverRate) throws IOException {
        HuobiResultV3<HuobiSwitchLeverRateResult> result = huobi.swapSwitchLeverRate(
                contractCode,
                leverRate,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiSwitchLeverRateResult linearSwapSwitchLeverRate(String contractCode,
                                                                Integer leverRate) throws IOException {
        HuobiResultV3<HuobiSwitchLeverRateResult> result = huobi.linearSwapSwitchLeverRate(
                contractCode,
                leverRate,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiSwitchLeverRateResult linearSwapCrossSwitchLeverRate(String contractCode,
                                                                     String pair,
                                                                     String contractType,
                                                                     Integer leverRate) throws IOException {
        HuobiResultV3<HuobiSwitchLeverRateResult> result = huobi.linearSwapCrossSwitchLeverRate(
                contractCode,
                pair,
                contractType,
                leverRate,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureOrder> getContractOrderInfo(String symbol,
                                                       String orderId,
                                                       String clientOrderId) throws IOException {
        HuobiResultV3<List<HuobiFutureOrder>> result = huobi.getContractOrderInfo(
                symbol,
                orderId,
                clientOrderId,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureOrder> getSwapOrderInfo(String contractCode,
                                                   String orderId,
                                                   String clientOrderId) throws IOException {
        HuobiResultV3<List<HuobiFutureOrder>> result = huobi.getSwapOrderInfo(
                contractCode,
                orderId,
                clientOrderId,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureOrder> getLinearSwapOrderInfo(String contractCode,
                                                         String orderId,
                                                         String clientOrderId) throws IOException {
        HuobiResultV3<List<HuobiFutureOrder>> result = huobi.getLinearSwapOrderInfo(
                contractCode,
                orderId,
                clientOrderId,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureOrder> getLinearSwapCrossOrderInfo(String contractCode,
                                                              String pair,
                                                              String orderId,
                                                              String clientOrderId) throws IOException {
        HuobiResultV3<List<HuobiFutureOrder>> result = huobi.getLinearSwapCrossOrderInfo(
                contractCode,
                pair,
                orderId,
                clientOrderId,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureOrder> getContractOpenOrders(String symbol,
                                                        Integer pageIndex,
                                                        Integer pageSize,
                                                        String sortBy,
                                                        Integer tradeType) throws IOException {
        HuobiResultV3<List<HuobiFutureOrder>> result = huobi.getContractOpenOrders(
                symbol,
                pageIndex,
                pageSize,
                sortBy,
                tradeType,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureOrder> getSwapOpenOrders(String contractCode,
                                                    Integer pageIndex,
                                                    Integer pageSize,
                                                    String sortBy,
                                                    Integer tradeType) throws IOException {
        HuobiResultV3<List<HuobiFutureOrder>> result = huobi.getSwapOpenOrders(
                contractCode,
                pageIndex,
                pageSize,
                sortBy,
                tradeType,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureOrder> getLinearSwapOpenOrders(String contractCode,
                                                          Integer pageIndex,
                                                          Integer pageSize,
                                                          String sortBy,
                                                          Integer tradeType) throws IOException {
        HuobiResultV3<List<HuobiFutureOrder>> result = huobi.getLinearSwapOpenOrders(
                contractCode,
                pageIndex,
                pageSize,
                sortBy,
                tradeType,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureOrder> getLinearSwapCrossOpenOrders(String contractCode,
                                                               String pair,
                                                               Integer pageIndex,
                                                               Integer pageSize,
                                                               String sortBy,
                                                               Integer tradeType) throws IOException {
        HuobiResultV3<List<HuobiFutureOrder>> result = huobi.getLinearSwapCrossOpenOrders(
                contractCode,
                pair,
                pageIndex,
                pageSize,
                sortBy,
                tradeType,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureHisOrderResult getContractHisOrders(String symbol,
                                                          Integer tradeType,
                                                          Integer type,
                                                          String status,
                                                          Integer createDate,
                                                          Integer pageIndex,
                                                          Integer pageSize,
                                                          String contractCode,
                                                          String orderType,
                                                          String sortBy) throws IOException {
        HuobiResultV3<HuobiFutureHisOrderResult> result = huobi.getContractHisOrders(
                symbol,
                tradeType,
                type,
                status,
                createDate,
                pageIndex,
                pageSize,
                contractCode,
                orderType,
                sortBy,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureHisOrderResult getSwapHisOrders(String contractCode,
                                                      Integer tradeType,
                                                      Integer type,
                                                      String status,
                                                      Integer createDate,
                                                      Integer pageIndex,
                                                      Integer pageSize,
                                                      String sortBy) throws IOException {
        HuobiResultV3<HuobiFutureHisOrderResult> result = huobi.getSwapHisOrders(
                contractCode,
                tradeType,
                type,
                status,
                createDate,
                pageIndex,
                pageSize,
                sortBy,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureHisOrderResult getLinearSwapHisOrders(String contractCode,
                                                            Integer tradeType,
                                                            Integer type,
                                                            String status,
                                                            Integer createDate,
                                                            Integer pageIndex,
                                                            Integer pageSize,
                                                            String sortBy) throws IOException {
        HuobiResultV3<HuobiFutureHisOrderResult> result = huobi.getLinearSwapHisOrders(
                contractCode,
                tradeType,
                type,
                status,
                createDate,
                pageIndex,
                pageSize,
                sortBy,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public HuobiFutureHisOrderResult getLinearSwapCrossHisOrders(String contractCode,
                                                                 String pair,
                                                                 Integer tradeType,
                                                                 Integer type,
                                                                 String status,
                                                                 Integer createDate,
                                                                 Integer pageIndex,
                                                                 Integer pageSize,
                                                                 String sortBy) throws IOException {
        HuobiResultV3<HuobiFutureHisOrderResult> result = huobi.getLinearSwapCrossHisOrders(
                contractCode,
                pair,
                tradeType,
                type,
                status,
                createDate,
                pageIndex,
                pageSize,
                sortBy,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }
}

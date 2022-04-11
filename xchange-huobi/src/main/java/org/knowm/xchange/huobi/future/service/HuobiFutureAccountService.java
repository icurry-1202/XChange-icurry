package org.knowm.xchange.huobi.future.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.huobi.HuobiDigest;
import org.knowm.xchange.huobi.HuobiUtils;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.account.HuobiBalanceValuation;
import org.knowm.xchange.huobi.dto.account.HuobiFutureAccount;
import org.knowm.xchange.huobi.dto.account.HuobiFutureFee;
import org.knowm.xchange.huobi.dto.account.HuobiFuturePosition;
import org.knowm.xchange.service.account.AccountService;

import java.io.IOException;
import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/2 10:45
 */
public class HuobiFutureAccountService extends HuobiFutureBaseService implements AccountService {
    public HuobiFutureAccountService(Exchange exchange) {
        super(exchange);
    }

    public List<HuobiBalanceValuation> getContractBalanceValuation(String valuationAsset) throws IOException {
        HuobiResultV3<List<HuobiBalanceValuation>> result = huobi.getContractBalanceValuation(
                valuationAsset,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiBalanceValuation> getSwapBalanceValuation(String valuationAsset) throws IOException {
        HuobiResultV3<List<HuobiBalanceValuation>> result = huobi.getSwapBalanceValuation(
                valuationAsset,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiBalanceValuation> getLinearSwapBalanceValuation(String valuationAsset) throws IOException {
        HuobiResultV3<List<HuobiBalanceValuation>> result = huobi.getLinearSwapBalanceValuation(
                valuationAsset,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureAccount> getFutureContractAccountInfo(String symbol) throws IOException {
        HuobiResultV3<List<HuobiFutureAccount>> result = huobi.getContractAccountInfo(
                symbol,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureAccount> getSwapAccountInfo(String contractCode) throws IOException {
        HuobiResultV3<List<HuobiFutureAccount>> result = huobi.getSwapAccountInfo(
                contractCode,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureAccount> getLinearSwapAccountInfo(String contractCode) throws IOException {
        HuobiResultV3<List<HuobiFutureAccount>> result = huobi.getLinearSwapAccountInfo(
                contractCode,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureAccount> getLinearSwapCrossAccountInfo(String contractCode) throws IOException {
        HuobiResultV3<List<HuobiFutureAccount>> result = huobi.getLinearSwapCrossAccountInfo(
                contractCode,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFuturePosition> getContractPositionInfo(String symbol) throws IOException {
        HuobiResultV3<List<HuobiFuturePosition>> result = huobi.getContractPositionInfo(
                symbol,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFuturePosition> getSwapPositionInfo(String contractCode) throws IOException {
        HuobiResultV3<List<HuobiFuturePosition>> result = huobi.getSwapPositionInfo(
                contractCode,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFuturePosition> getLinearSwapPositionInfo(String contractCode) throws IOException {
        HuobiResultV3<List<HuobiFuturePosition>> result = huobi.getLinearSwapPositionInfo(
                contractCode,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFuturePosition> getLinearSwapCrossPositionInfo(String contractCode,
                                                                    String pair,
                                                                    String contractType) throws IOException {
        HuobiResultV3<List<HuobiFuturePosition>> result = huobi.getLinearSwapCrossPositionInfo(
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

    public List<HuobiFutureFee> getContractFee(String symbol) throws IOException {
        HuobiResultV3<List<HuobiFutureFee>> result = huobi.getContractFee(
                symbol,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureFee> getSwapFee(String contractCode) throws IOException {
        HuobiResultV3<List<HuobiFutureFee>> result = huobi.getSwapFee(
                contractCode,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }

    public List<HuobiFutureFee> getLinearSwapFee(String contractCode,
                                                 String pair,
                                                 String contractType,
                                                 String businessType) throws IOException {
        HuobiResultV3<List<HuobiFutureFee>> result = huobi.getLinearSwapFee(
                contractCode,
                pair,
                contractType,
                businessType,
                exchange.getExchangeSpecification().getApiKey(),
                HuobiDigest.HMAC_SHA_256,
                2,
                HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                signatureCreator);
        return checkResult(result);
    }
}

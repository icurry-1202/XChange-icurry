package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author buxianguan
 * @Date 2022/4/1 16:00
 */
public enum NewOrderRespType {
    ACK,
    RESULT;

    @JsonCreator
    public static NewOrderRespType getNewOrderRespType(String s) {
        try {
            return NewOrderRespType.valueOf(s);
        } catch (Exception e) {
            throw new RuntimeException("Unknown newOrderRespType " + s + ".");
        }
    }
}

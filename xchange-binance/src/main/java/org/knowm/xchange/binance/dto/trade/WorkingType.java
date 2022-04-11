package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author buxianguan
 * @Date 2022/4/1 15:59
 */
public enum WorkingType {
    MARK_PRICE,
    CONTRACT_PRICE;

    @JsonCreator
    public static WorkingType getWorkingType(String s) {
        try {
            return WorkingType.valueOf(s);
        } catch (Exception e) {
            throw new RuntimeException("Unknown working type " + s + ".");
        }
    }
}

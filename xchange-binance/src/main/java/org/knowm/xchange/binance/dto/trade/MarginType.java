package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author buxianguan
 * @Date 2022/4/1 14:32
 */
public enum MarginType {
    ISOLATED,
    CROSSED;

    @JsonCreator
    public static MarginType getMarginType(String s) {
        try {
            return MarginType.valueOf(s);
        } catch (Exception e) {
            throw new RuntimeException("Unknown margin type " + s + ".");
        }
    }
}

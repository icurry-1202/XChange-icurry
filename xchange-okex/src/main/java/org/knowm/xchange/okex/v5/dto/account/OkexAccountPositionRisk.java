package org.knowm.xchange.okex.v5.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/3/30 15:58
 */
@Data
@NoArgsConstructor
public class OkexAccountPositionRisk {
    private String adjEq;
    private List<BalData> balData;
    private List<PosData> posData;
    private String ts;

    @Data
    @NoArgsConstructor
    public static class BalData {
        private String ccy;
        private String disEq;
        private String eq;
    }

    @Data
    @NoArgsConstructor
    public static class PosData {
        private String baseBal;
        private String ccy;
        private String instId;
        private String instType;
        private String mgnMode;
        private String notionalCcy;
        private String notionalUsd;
        private String pos;
        private String posCcy;
        private String posId;
        private String posSide;
        private String quoteBal;
    }
}

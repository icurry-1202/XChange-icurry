package org.knowm.xchange.okex.v5.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/3/30 16:22
 */
@Data
@NoArgsConstructor
public class OkexAccountInterestLimit {
    private String debt;
    private String interest;
    private String nextDiscountTime;
    private String nextInterestTime;
    private List<Records> records;

    @Data
    @NoArgsConstructor
    public static class Records {
        private String availLoan;
        private String ccy;
        private String interest;
        private String loanQuota;
        private String posLoan;
        private String rate;
        private String surplusLmt;
        private String usedLmt;
        private String usedLoan;
    }
}

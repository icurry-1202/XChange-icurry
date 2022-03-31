package org.knowm.xchange.okex.v5.dto.marketdata;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/3/31 11:56
 */
@Data
@NoArgsConstructor
public class OkexFundingRateHistory {
    private String instType;
    private String instId;
    private String fundingRate;
    private String realizedRate;
    private String fundingTime;
}

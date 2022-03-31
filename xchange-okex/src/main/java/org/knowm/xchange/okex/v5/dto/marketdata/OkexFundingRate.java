package org.knowm.xchange.okex.v5.dto.marketdata;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/3/31 11:50
 */
@Data
@NoArgsConstructor
public class OkexFundingRate {
    private String fundingRate;
    private String fundingTime;
    private String instId;
    private String instType;
    private String nextFundingRate;
    private String nextFundingTime;
}

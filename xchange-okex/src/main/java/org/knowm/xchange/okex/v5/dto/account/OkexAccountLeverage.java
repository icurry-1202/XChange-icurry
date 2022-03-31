package org.knowm.xchange.okex.v5.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/3/30 17:12
 */
@Data
@NoArgsConstructor
public class OkexAccountLeverage {
    private String instId;
    private String lever;
    private String mgnMode;
    private String posSide;
    private String ccy;
}

package org.knowm.xchange.okex.v5.dto.marketdata;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/3/31 11:00
 */
@Data
@NoArgsConstructor
public class OkexTicker {
    private String instType;
    private String instId;
    private String last;
    private String lastSz;
    private String askPx;
    private String askSz;
    private String bidPx;
    private String bidSz;
    private String open24h;
    private String high24h;
    private String low24h;
    private String volCcy24h;
    private String vol24h;
    private String ts;
    private String sodUtc0;
    private String sodUtc8;
}

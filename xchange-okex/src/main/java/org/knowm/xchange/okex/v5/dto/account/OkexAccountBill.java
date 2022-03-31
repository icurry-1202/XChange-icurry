package org.knowm.xchange.okex.v5.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/3/30 16:10
 */
@Data
@NoArgsConstructor
public class OkexAccountBill {
    private String bal;
    private String balChg;
    private String billId;
    private String ccy;
    private String execType;
    private String fee;
    private String from;
    private String instId;
    private String instType;
    private String mgnMode;
    private String notes;
    private String ordId;
    private String pnl;
    private String posBal;
    private String posBalChg;
    private String subType;
    private String sz;
    private String to;
    private String ts;
    private String type;
}

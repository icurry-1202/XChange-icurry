package org.knowm.xchange.okex.v5.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/3/30 17:36
 */
@Data
@NoArgsConstructor
public class OkexFundTransferResponse {
    /**
     * 划转 ID
     */
    private String transId;
    /**
     * 币种
     */
    private String ccy;
    /**
     * 划转数量
     */
    private String amt;
    /**
     * 转出账户
     * 1：币币账户 3：交割合约 5：币币杠杆账户 6：资金账户 9：永续合约账户 12：期权合约 18：统一账户
     */
    private String from;
    /**
     * 转入账户
     * 1：币币账户 3：交割合约 5：币币杠杆账户 6：资金账户 9：永续合约账户 12：期权合约 18：统一账户
     */
    private String to;
}

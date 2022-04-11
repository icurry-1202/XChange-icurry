package org.knowm.xchange.okex.v5.dto.account;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/3/30 17:36
 */
@Data
@Builder
public class OkexFundTransferRequest {
    /**
     * 币种
     */
    private String ccy;
    /**
     * 划转数量
     */
    private String amt;
    /**
     * 0：账户内划转
     * 1：母账户转子账户
     * 2：子账户转母账户
     */
    private String type;
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
    /**
     * 子账户名称，type 为1或2：subAcct 为必填项
     */
    private String subAcct;
    /**
     * 币币杠杆转出币对（如 BTC-USDT）或者转出合约的 underlying（如 BTC-USD）
     */
    private String instId;
    /**
     * 币币杠杆转入币对（如 BTC-USDT）或者转入合约的 underlying（如 BTC-USD）
     */
    private String toInstId;
}

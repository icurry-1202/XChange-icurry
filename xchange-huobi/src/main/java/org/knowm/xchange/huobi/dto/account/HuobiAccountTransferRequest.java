package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author buxianguan
 * @Date 2022/4/7 10:01
 */
@Data
@Builder
public class HuobiAccountTransferRequest {
    @JsonProperty("from-user")
    private Long fromUser;

    @JsonProperty("from-account-type")
    private String fromAccountType;

    @JsonProperty("from-account")
    private Long fromAccount;

    @JsonProperty("to-user")
    private Long toUser;

    @JsonProperty("to-account-type")
    private String toAccountType;

    @JsonProperty("to-account")
    private Long toAccount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("amount")
    private BigDecimal amount;

}

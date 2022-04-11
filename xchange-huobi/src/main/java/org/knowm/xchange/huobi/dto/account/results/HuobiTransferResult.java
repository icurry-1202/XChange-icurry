package org.knowm.xchange.huobi.dto.account.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buxianguan
 * @Date 2022/4/7 10:05
 */
@Data
@NoArgsConstructor
public class HuobiTransferResult {
    @JsonProperty("transact-id")
    private Integer transactId;

    @JsonProperty("transact-time")
    private Long transactTime;

}

package org.knowm.xchange.huobi.dto.trade.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.knowm.xchange.huobi.dto.trade.HuobiFutureHisOrder;

import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/3 19:35
 */
@Data
@NoArgsConstructor
public class HuobiFutureHisOrderResult {
    @JsonProperty("total_page")
    private int totalPage;

    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("total_size")
    private int totalSize;

    @JsonProperty("orders")
    private List<HuobiFutureHisOrder> orders;
}

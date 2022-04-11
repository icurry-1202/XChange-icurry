package org.knowm.xchange.huobi.dto.marketdata.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.knowm.xchange.huobi.dto.marketdata.HuobiHistoricalFundingRate;

import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/3 19:11
 */
@Data
@NoArgsConstructor
public class HuobiHistoricalFundingRateResult {
    @JsonProperty("total_page")
    private int totalPage;

    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("total_size")
    private int totalSize;

    @JsonProperty("data")
    private List<HuobiHistoricalFundingRate> data;
}

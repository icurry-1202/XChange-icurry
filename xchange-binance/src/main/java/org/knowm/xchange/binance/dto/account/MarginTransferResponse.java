package org.knowm.xchange.binance.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/1 17:34
 */
@Data
@NoArgsConstructor
public class MarginTransferResponse {
    private List<MarginTransfer> rows;
    private int total;

    @Data
    @NoArgsConstructor
    public static class MarginTransfer {
        private String amount;
        private String asset;
        private String status;
        private Long timestamp;
        private Long txId;
        private String type;
    }
}

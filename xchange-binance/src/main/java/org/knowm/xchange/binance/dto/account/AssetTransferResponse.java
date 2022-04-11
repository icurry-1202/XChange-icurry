package org.knowm.xchange.binance.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/1 16:58
 */
@Data
@NoArgsConstructor
public class AssetTransferResponse {
    private int total;
    private List<AssetTransfer> rows;

    @Data
    @NoArgsConstructor
    public static class AssetTransfer {
        private String asset;
        private String amount;
        private String type;
        private String status;
        private long tranId;
        private long timestamp;
    }
}

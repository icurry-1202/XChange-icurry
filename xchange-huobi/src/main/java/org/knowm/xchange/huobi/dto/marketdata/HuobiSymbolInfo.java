package org.knowm.xchange.huobi.dto.marketdata;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author buxianguan
 * @Date 2022/4/3 20:00
 */
@Data
@NoArgsConstructor
public class HuobiSymbolInfo {
    private String tags;
    private String state;
    private String wr;
    private String sc;
    private List<Partition> p;
    private String bcdn;
    private String qcdn;
    private String elr;
    private Integer tpp;
    private Integer tap;
    private Integer fp;
    private String smlr;
    private String flr;
    private Boolean whe;
    private Boolean cd;
    private Boolean te;
    private String sp;
    private String d;
    private String bc;
    private String qc;
    private Long toa;
    private Integer ttp;
    private Long w;
    private Integer lr;
    private String dn;

    @Data
    @NoArgsConstructor
    public static class Partition {
        private Integer id;
        private String name;
        private Integer weight;
    }
}

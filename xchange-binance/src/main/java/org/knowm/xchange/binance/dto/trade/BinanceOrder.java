package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;

public final class BinanceOrder {

  public final String symbol;
  public final Long orderId;
  public final String clientOrderId;
  public final BigDecimal price;
  public final BigDecimal origQty;
  public final BigDecimal executedQty;
  public final BigDecimal cummulativeQuoteQty;
  public final OrderStatus status;
  public final TimeInForce timeInForce;
  public final OrderType type;
  public final OrderSide side;
  public final BigDecimal stopPrice;
  public final BigDecimal icebergQty;
  public final Long time;
  public final Boolean isWorking;
  public final Boolean isIsolated;
  public final Long updateTime;


  public BinanceOrder(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("orderId") Long orderId,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("price") BigDecimal price,
      @JsonProperty("origQty") BigDecimal origQty,
      @JsonProperty("executedQty") BigDecimal executedQty,
      @JsonProperty("cummulativeQuoteQty") BigDecimal cummulativeQuoteQty,
      @JsonProperty("status") OrderStatus status,
      @JsonProperty("timeInForce") TimeInForce timeInForce,
      @JsonProperty("type") OrderType type,
      @JsonProperty("side") OrderSide side,
      @JsonProperty("stopPrice") BigDecimal stopPrice,
      @JsonProperty("icebergQty") BigDecimal icebergQty,
      @JsonProperty("time") Long time,
      @JsonProperty("isWorking") Boolean isWorking,
      @JsonProperty("isIsolated") Boolean isIsolated,
      @JsonProperty("updateTime") Long updateTime) {
    this.symbol = symbol;
    this.orderId = orderId;
    this.clientOrderId = clientOrderId;
    this.price = price;
    this.origQty = origQty;
    this.executedQty = executedQty;
    this.cummulativeQuoteQty = cummulativeQuoteQty;
    this.status = status;
    this.timeInForce = timeInForce;
    this.type = type;
    this.side = side;
    this.stopPrice = stopPrice;
    this.icebergQty = icebergQty;
    this.time = time;
    this.isWorking = isWorking;
    this.isIsolated = isIsolated;
    this.updateTime = updateTime;
  }

  public Date getTime() {
    return new Date(time);
  }
}

package com.endriu.bookstore.model;

import java.net.URI;
import java.util.Objects;
import com.endriu.bookstore.model.OrderItemModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderModel
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-23T20:38:24.048672300+02:00[Europe/Warsaw]")
public class OrderModel {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("price")
  private String price;

  @JsonProperty("timestampCreated")
  private String timestampCreated;

  @JsonProperty("orderItemModels")
  @Valid
  private List<OrderItemModel> orderItemModels = null;

  public OrderModel id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * id of order
   * @return id
  */
  
  @Schema(name = "id", description = "id of order", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrderModel price(String price) {
    this.price = price;
    return this;
  }

  /**
   * price of order
   * @return price
  */
  
  @Schema(name = "price", description = "price of order", required = false)
  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public OrderModel timestampCreated(String timestampCreated) {
    this.timestampCreated = timestampCreated;
    return this;
  }

  /**
   * timestamp of order
   * @return timestampCreated
  */
  
  @Schema(name = "timestampCreated", description = "timestamp of order", required = false)
  public String getTimestampCreated() {
    return timestampCreated;
  }

  public void setTimestampCreated(String timestampCreated) {
    this.timestampCreated = timestampCreated;
  }

  public OrderModel orderItemModels(List<OrderItemModel> orderItemModels) {
    this.orderItemModels = orderItemModels;
    return this;
  }

  public OrderModel addOrderItemModelsItem(OrderItemModel orderItemModelsItem) {
    if (this.orderItemModels == null) {
      this.orderItemModels = new ArrayList<>();
    }
    this.orderItemModels.add(orderItemModelsItem);
    return this;
  }

  /**
   * Get orderItemModels
   * @return orderItemModels
  */
  @Valid 
  @Schema(name = "orderItemModels", required = false)
  public List<OrderItemModel> getOrderItemModels() {
    return orderItemModels;
  }

  public void setOrderItemModels(List<OrderItemModel> orderItemModels) {
    this.orderItemModels = orderItemModels;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderModel orderModel = (OrderModel) o;
    return Objects.equals(this.id, orderModel.id) &&
        Objects.equals(this.price, orderModel.price) &&
        Objects.equals(this.timestampCreated, orderModel.timestampCreated) &&
        Objects.equals(this.orderItemModels, orderModel.orderItemModels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, price, timestampCreated, orderItemModels);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderModel {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    timestampCreated: ").append(toIndentedString(timestampCreated)).append("\n");
    sb.append("    orderItemModels: ").append(toIndentedString(orderItemModels)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


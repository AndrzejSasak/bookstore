package com.endriu.bookstore.model;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * CartModel
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-23T20:38:24.048672300+02:00[Europe/Warsaw]")
public class ShoppingCartModel {

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("orderItemModels")
  @Valid
  private List<OrderItemModel> orderItemModels = null;

  public ShoppingCartModel price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * price of cart
   * @return price
  */
  
  @Schema(name = "price", description = "price of cart", required = false)
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public ShoppingCartModel orderItemModels(List<OrderItemModel> orderItemModels) {
    this.orderItemModels = orderItemModels;
    return this;
  }

  public ShoppingCartModel addOrderItemModelsItem(OrderItemModel orderItemModelsItem) {
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
    ShoppingCartModel shoppingCartModel = (ShoppingCartModel) o;
    return Objects.equals(this.price, shoppingCartModel.price) &&
        Objects.equals(this.orderItemModels, shoppingCartModel.orderItemModels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, orderItemModels);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartModel {\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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


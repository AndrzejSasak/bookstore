package com.endriu.bookstore.model;

import java.net.URI;
import java.util.Objects;
import com.endriu.bookstore.model.BookModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderItemModel
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-23T20:38:24.048672300+02:00[Europe/Warsaw]")
public class OrderItemModel {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("bookModel")
  private BookModel bookModel;

  @JsonProperty("amount")
  private String amount;

  @JsonProperty("price")
  private String price;

  public OrderItemModel id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * ID of orderItem
   * @return id
  */
  
  @Schema(name = "id", description = "ID of orderItem", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrderItemModel bookModel(BookModel bookModel) {
    this.bookModel = bookModel;
    return this;
  }

  /**
   * Get bookModel
   * @return bookModel
  */
  @Valid 
  @Schema(name = "bookModel", required = false)
  public BookModel getBookModel() {
    return bookModel;
  }

  public void setBookModel(BookModel bookModel) {
    this.bookModel = bookModel;
  }

  public OrderItemModel amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * amount of orderItem
   * @return amount
  */
  
  @Schema(name = "amount", description = "amount of orderItem", required = false)
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public OrderItemModel price(String price) {
    this.price = price;
    return this;
  }

  /**
   * price of orderItem
   * @return price
  */
  
  @Schema(name = "price", description = "price of orderItem", required = false)
  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItemModel orderItemModel = (OrderItemModel) o;
    return Objects.equals(this.id, orderItemModel.id) &&
        Objects.equals(this.bookModel, orderItemModel.bookModel) &&
        Objects.equals(this.amount, orderItemModel.amount) &&
        Objects.equals(this.price, orderItemModel.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, bookModel, amount, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItemModel {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    bookModel: ").append(toIndentedString(bookModel)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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


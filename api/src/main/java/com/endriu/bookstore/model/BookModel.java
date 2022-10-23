package com.endriu.bookstore.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * BookModel
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-23T20:38:24.048672300+02:00[Europe/Warsaw]")
public class BookModel {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("author")
  private String author;

  @JsonProperty("description")
  private String description;

  @JsonProperty("genre")
  private String genre;

  @JsonProperty("isbn10")
  private String isbn10;

  @JsonProperty("isbn13")
  private String isbn13;

  @JsonProperty("price")
  private BigDecimal price;

  public BookModel id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * ID of book
   * @return id
  */
  
  @Schema(name = "id", description = "ID of book", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BookModel title(String title) {
    this.title = title;
    return this;
  }

  /**
   * title of book
   * @return title
  */
  
  @Schema(name = "title", description = "title of book", required = false)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BookModel author(String author) {
    this.author = author;
    return this;
  }

  /**
   * author of book
   * @return author
  */
  
  @Schema(name = "author", description = "author of book", required = false)
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public BookModel description(String description) {
    this.description = description;
    return this;
  }

  /**
   * description of book
   * @return description
  */
  
  @Schema(name = "description", description = "description of book", required = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BookModel genre(String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * genre of book
   * @return genre
  */
  
  @Schema(name = "genre", description = "genre of book", required = false)
  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public BookModel isbn10(String isbn10) {
    this.isbn10 = isbn10;
    return this;
  }

  /**
   * ISBN10 number of the book
   * @return isbn10
  */
  
  @Schema(name = "isbn10", description = "ISBN10 number of the book", required = false)
  public String getIsbn10() {
    return isbn10;
  }

  public void setIsbn10(String isbn10) {
    this.isbn10 = isbn10;
  }

  public BookModel isbn13(String isbn13) {
    this.isbn13 = isbn13;
    return this;
  }

  /**
   * ISBN13 number of the book
   * @return isbn13
  */
  
  @Schema(name = "isbn13", description = "ISBN13 number of the book", required = false)
  public String getIsbn13() {
    return isbn13;
  }

  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
  }

  public BookModel price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * price of the book
   * @return price
  */
  @Valid 
  @Schema(name = "price", description = "price of the book", required = false)
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
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
    BookModel bookModel = (BookModel) o;
    return Objects.equals(this.id, bookModel.id) &&
        Objects.equals(this.title, bookModel.title) &&
        Objects.equals(this.author, bookModel.author) &&
        Objects.equals(this.description, bookModel.description) &&
        Objects.equals(this.genre, bookModel.genre) &&
        Objects.equals(this.isbn10, bookModel.isbn10) &&
        Objects.equals(this.isbn13, bookModel.isbn13) &&
        Objects.equals(this.price, bookModel.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, description, genre, isbn10, isbn13, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookModel {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    isbn10: ").append(toIndentedString(isbn10)).append("\n");
    sb.append("    isbn13: ").append(toIndentedString(isbn13)).append("\n");
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


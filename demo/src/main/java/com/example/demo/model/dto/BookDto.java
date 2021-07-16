package com.example.demo.model.dto;

import com.example.demo.model.po.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookDto extends BaseEntityDto {

    private String name;

    private Integer stock;

    private String author;

    private String publisher;

    public BookDto(Book entity) {
        super(entity);
        this.name = entity.getName();
        this.stock = entity.getStock();
        this.author = entity.getAuthor();
        this.publisher = entity.getPublisher();
    }

    public Book toEntity() {
        Book entity = new Book();
        setProperties(entity);
        entity.setName(this.name);
        entity.setStock(this.stock);
        entity.setAuthor(this.author);
        entity.setPublisher(this.publisher);
        return entity;
    }
}

package com.example.demo.model.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "t_book")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {

    @Column
    private String name;

    @Column
    private Integer stock;

    @Column
    private String author;

    @Column
    private String publisher;

    @ManyToMany
    @JoinTable(name = "t_book_user")
    @Builder.Default
    private Set<User> user = new HashSet<>();

    @PreRemove
    public void preRemove() {
        user.forEach(e -> e.getBook().remove(this));
    }
}

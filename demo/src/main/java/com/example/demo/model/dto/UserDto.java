package com.example.demo.model.dto;

import com.example.demo.model.po.User;

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
public class UserDto extends BaseEntityDto {

    private String name;

    private Integer phone;

    public UserDto(User entity) {
        super(entity);
        this.name = entity.getName();
        this.phone = entity.getPhone();
    }

    public User toEntity() {
        User entity = new User();
        setProperties(entity);
        entity.setName(this.name);
        entity.setPhone(this.phone);
        return entity;
    }
}

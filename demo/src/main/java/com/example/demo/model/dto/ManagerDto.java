package com.example.demo.model.dto;

import com.example.demo.model.po.Manager;

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
public class ManagerDto extends BaseEntityDto {
    private String name;

    private Integer phone;

    private String email;

    public ManagerDto(Manager entity) {
        super(entity);
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
    }

    public Manager toEntity() {
        Manager entity = new Manager();
        setProperties(entity);
        entity.setName(this.name);
        entity.setPhone(this.phone);
        entity.setEmail(this.email);
        return entity;
    }
}

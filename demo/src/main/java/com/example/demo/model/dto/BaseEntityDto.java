package com.example.demo.model.dto;

import java.util.Date;

import com.example.demo.model.po.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntityDto {

    private Long id;
    private Date createTime;
    private Date updateTime;

    public BaseEntityDto(BaseEntity entity) {
        this.id = entity.getId();
        this.createTime = entity.getCreateTime();
        this.updateTime = entity.getUpdateTime();
    }

    public void setProperties(BaseEntity entity) {
        entity.setId(this.id);
        entity.setCreateTime(this.createTime);
        entity.setUpdateTime(this.updateTime);
    }

}

package com.example.demo.model.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "t_manager")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Manager extends BaseEntity{
    
    @Column
    private String name;

    @Column
    private Integer phone;

    @Column
    private String email;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "manager",cascade = CascadeType.ALL)
    @Builder.Default
    private Set<User> user = new HashSet();
}

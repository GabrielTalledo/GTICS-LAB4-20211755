package com.example.lab4_20211755.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "regions")
public class Region {
    @Id
    @Column(name = "region_id")
    private BigDecimal regionId;

    @Column(name = "region_name")
    private String regionName;

}

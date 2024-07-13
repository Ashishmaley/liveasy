package com.myapp.loads.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@Entity
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID shipperId;

    @OneToMany(mappedBy = "shipperId", cascade = CascadeType.ALL)
    private List<Load> loads = new ArrayList<>();
}
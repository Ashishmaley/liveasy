package com.myapp.loads.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private int weight;
    private String comment;
    private UUID shipperId;
    private String date;
}

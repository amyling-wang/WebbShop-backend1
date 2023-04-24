package com.example.webbshopbackend1.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private int name;
    private int price;

    public Item(int name, int price){
        this.name = name;
        this.price = price;
    }


}

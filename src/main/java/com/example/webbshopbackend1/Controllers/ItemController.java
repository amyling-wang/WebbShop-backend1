package com.example.webbshopbackend1.Controllers;

import com.example.webbshopbackend1.Models.Item;
import com.example.webbshopbackend1.Repos.ItemRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemRepo itemRepo;

    public ItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @RequestMapping("items")
    public List<Item> getItems(){
        return itemRepo.findAll();
    }
    @RequestMapping("items/{id}")
    public Item getItems(@PathVariable Long id){
        return itemRepo.findById(id).get();
    }

    @RequestMapping("items/add/{name}/{price}")
    public List<Item> addItem(@PathVariable String name, @PathVariable int price){
        Item item = new Item(name, price);
        itemRepo.save(item);
        return itemRepo.findAll();
        //return "Item added! " + name + " " + price + " SEK"; //Om vi vill returnera en sträng
    }
}
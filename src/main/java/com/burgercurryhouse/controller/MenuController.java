package com.burgercurryhouse.controller;

import com.burgercurryhouse.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MenuController {

    @GetMapping
    public String index(Model model) {
        List<MenuItem> menuItems = getMenuItems();
        model.addAttribute("menuItems", menuItems);
        return "index";
    }

    @PostMapping("/order")
    public String placeOrder(@RequestParam("itemId") int itemId,
                            @RequestParam("quantity") int quantity,
                            Model model) {
        MenuItem item = getMenuItemById(itemId);
        if (item != null) {
            OrderItem orderItem = new OrderItem(item, quantity);
            model.addAttribute("orderItem", orderItem);
            model.addAttribute("isRiceDiscount", item instanceof Rice && quantity >= 3);
            return "order-confirmation";
        }
        return "redirect:/";
    }

    @GetMapping("/menu")
    @ResponseBody
    public List<MenuItem> getMenu() {
        return getMenuItems();
    }

    private List<MenuItem> getMenuItems() {
        List<MenuItem> items = new ArrayList<>();
        items.add(new Burger());
        items.add(new Curry());
        items.add(new Fries());
        items.add(new Rice());
        return items;
    }

    private MenuItem getMenuItemById(int id) {
        switch (id) {
            case 1: return new Burger();
            case 2: return new Curry();
            case 3: return new Fries();
            case 4: return new Rice();
            default: return null;
        }
    }
}
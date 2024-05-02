package com.workintech.s18d1.controller;


import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/burgers")
public class BurgerController {
    private BurgerDaoImpl burgerDaoImpl;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImpl) {
        this.burgerDaoImpl = burgerDaoImpl;
    }

    @GetMapping()
    public List<Burger> findAll(){
        return burgerDaoImpl.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable Long id){
        BurgerValidation.checkId(id);
        return burgerDaoImpl.findById(id);
    }


    @PostMapping()
    public Burger save(@RequestBody Burger burger){
        //BurgerValidation.checkBreadType(burger.getBreadType());
        return burgerDaoImpl.save(burger);
    }

    @PutMapping("/{id}")
    public Burger update(@RequestBody Burger burger,@PathVariable Long id){
        BurgerValidation.checkId(id);
        burgerDaoImpl.update(burger);
        return burger;
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable Long id){
        BurgerValidation.checkId(id);
        return  burgerDaoImpl.remove(id);
    }

    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable Double price){
        BurgerValidation.checkPrice(price);
        return burgerDaoImpl.findByPrice(price);
    }

    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType){
        BurgerValidation.checkBreadType(breadType);
        return burgerDaoImpl.findByBreadType(breadType);
    }

    @GetMapping("/findByContent/{contents}")
    public List<Burger> findByContent(@PathVariable String contents){
        return burgerDaoImpl.findByContent(contents);
    }
}





















package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkId(Long id){
        if(id==null || id<0){
            throw new BurgerException("id can not be less than 0 or null:"+id, HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkPrice(Double price){
        if(price<0 || price==null){
            throw new BurgerException("price can not be less than 0 or null:"+price,HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkBreadType(BreadType breadType){
        if(breadType != BreadType.WRAP && breadType != BreadType.BURGER && breadType != BreadType.DOUBLE) {
            throw new BurgerException("breadType should be WRAP, BURGER, or DOUBLE: " + breadType, HttpStatus.BAD_REQUEST);
        }
    }
}
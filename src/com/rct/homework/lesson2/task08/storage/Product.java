package com.rct.homework.lesson2.task08.storage;

import com.rct.homework.lesson2.task08.Validator;
import com.rct.homework.lesson2.task08.exceptions.ProductException;

import java.math.BigDecimal;

/**
 * Class that represents product at the storage.
 * If user inputs empty string "" as type or product
 * name, they will be manually changed to "no type" and
 * "no name".
 *
 * @author Oleg Baslak
 * @version 1.0
 * @since 08.10.2016
 */
public class Product {

    private static final String defaultType = "no type";
    private static final String defaultName = "no name";

    private String type;
    private String name;
    private BigDecimal price;

    public Product(String _type, String _name, BigDecimal _price) throws ProductException {
        if (!Validator.isValidPrice(_price.toString())) {
            throw new ProductException("");
        }
        price = _price;
        price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        if ("".equals(_type)) {
            _type = defaultType;
        }
        if ("".equals(_name)) {
            _name = defaultName;
        }
        type = _type.toLowerCase();
        name = _name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + "[type: " + getType() + "]" + ", price: " + getPrice();
    }
}

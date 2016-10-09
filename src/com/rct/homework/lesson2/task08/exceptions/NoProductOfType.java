package com.rct.homework.lesson2.task08.exceptions;

/**
 * Thrown if storage doesn't has any products of
 * chosen type.
 *
 * @author Oleg Baslak
 * @version 1.0
 * @since 08.10.2016
 */
public class NoProductOfType extends Exception {

    public NoProductOfType(){
        super("There is no products of that type at the storage");
    }
}
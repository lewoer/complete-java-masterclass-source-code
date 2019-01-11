package com.shile;

/**
 * @Author: ShiLe
 * @Description: subclass不能override equals()
 * @Date: Created in 17:40 2019/1/2
 */
public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Dog) {
            String objName = ((Dog) obj).getName();  // cast
            return this.name.equals(objName);
        }
        return false;
    }
}

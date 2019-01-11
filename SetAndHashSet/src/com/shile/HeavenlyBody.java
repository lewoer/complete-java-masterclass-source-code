package com.shile;


import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ShiLe
 * @Description: 1. 当set集合出现copy，重写equals()，hashCode() method ，两个对象equals相同，hashcode相同
 *               2. String对象创立的时候，hashCode就会调用，如果遇到两个对象相同，调用equals method。
 *               3. immutable class : https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
 * @Date: Created in 21:42 2019/1/1
 */
public  abstract class HeavenlyBody {  // mutable
    private final Key key;
    private final double orbitalPeriod; // 公转周期
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        /*enum type自动为static*/
        STAR,
        PLANET,
        DWARF_PLANET,  // 矮行星
        MOON,
        COMET,  // 彗星
        ASTEROID  // 小行星

    }


    public HeavenlyBody(String name, double orbintalPeriod, BodyTypes bodyType) {
        this.key = new Key(name,bodyType);
        this.orbitalPeriod = orbintalPeriod;
        this.satellites = new HashSet<>();
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {

        // 为了安全，创建一个copy
        return new HashSet<>(this.satellites);
    }


    /*为了使set不出现重复值需要对hashcode() equals()同时进行override
    * 只要两个对象的hashcode相同，那么两个对象就相同*/

    @Override
    public final boolean equals(Object obj) {
        // Object 换位HeavenlyBody 会变成overload而非override
        // final是为了不让子类equals()重写
        if (this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        // look up in map object
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return "\t" + this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        public Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }


        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}

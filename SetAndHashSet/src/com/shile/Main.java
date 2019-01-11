package com.shile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem;
    private static Set<HeavenlyBody> planets;

    static {
        solarSystem = new HashMap<>();
        planets = new HashSet<>();
    }

    public static void main(String[] args) {

        HeavenlyBody temp = new Planet("Mercury",88);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Venus",255);  // 金星
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Earth",365);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon",27);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars",687);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos",1.3);  // 火卫二
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos",0.3);  // 火卫一
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter",4332);  // 木星
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("IO",1.8);  // 木卫1
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa",3.5);  // 木卫2
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede",7.1);  // 木星3
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto",16.7);  // 木星4
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn",10759);  // 土星
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Uranus",30660);  // 天王星
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Neptune",165);  // 海王星
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Pluto",248);  // 冥王星
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            // 遍历set，set没有copy
            System.out.println("\t" + planet.getKey());  // \t为tab
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " + body.getKey());
        for (HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBody moon : moons ) {
            System.out.println("\t" + moon.getKey());
        }

        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        planets.add(pluto);

        for (HeavenlyBody planet : planets) {
            // 出现两个pluto的原因是set认为是两个对象
//            System.out.println(planet.getKey() + ": " + planet.getOrbitalPeriod());
            System.out.println(planet);  // auto invoke toString()
        }

        HeavenlyBody earth1 = new Planet("Earth",365);
        HeavenlyBody earth2 = new Planet("Earth",365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.equals(pluto));
        System.out.println(pluto.equals(earth1));


        solarSystem.put(pluto.getKey(),pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));

        System.out.println();
        System.out.println("solar system contains: ");
        for (HeavenlyBody heavenlyBody : solarSystem.values()) {
            System.out.println(heavenlyBody);
        }


    }
}

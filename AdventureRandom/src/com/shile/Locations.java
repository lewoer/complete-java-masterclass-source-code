package com.shile;

import java.io.*;
import java.util.*;

/**
 * @Author: ShiLe
 * @Description: 1. try-with-resource
 * 2. EOFException 一般用在input中
 * 3. DataOutStream：一个数据输出流允许应用将java primitive data写进底层输出流。之后应用可以使用数据输入流
 * 读取数据。
 * 4. BufferedOutputStream：这个类实现了buffer输出流，。通过这样输出流，一个应用能够将字节写进底层输出流，
 * 而不用为每一个字节write调用一次底层系统。
 * 5.
 * @Date: Created in 22:43 2019/1/4
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        try (RandomAccessFile ran = new RandomAccessFile("location_rand.dat","rwd") ) {


            ran.writeInt(locations.size());
            // 每一个index record包含3个integers：location ID, location的偏移量，location record的长度。所以*3
            int indexSize = locations.size() * 3 * Integer.BYTES;

            int locationStart = (int) (indexSize + ran.getFilePointer() + Integer.BYTES);
            ran.writeInt(locationStart);
            }
        }


    static {
        // read byte file
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                Location location = (Location) locFile.readObject();
                System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                System.out.println("Found " + location.getExits().size() + " exits");

                locations.put(location.getLocationID(), location);
            }
        } catch (InvalidClassException e) {
            System.out.println("InvalidClassException" + e.getMessage());
        } catch (IOException io) {
            System.out.println("IO exception" + io.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}

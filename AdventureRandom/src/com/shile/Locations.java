package com.shile;

import java.io.*;
import java.util.*;

/**
 * @Author: ShiLe
 * @Description: 1.file-pointer 开始于0.
 * @Date: Created in 22:43 2019/1/4
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ran;

    public static void main(String[] args) throws IOException {

        try (RandomAccessFile ran = new RandomAccessFile("location_rand.dat", "rwd")) {
            ran.writeInt(locations.size());
            // 每一个index record包含3个integers：location ID, location的偏移量，location record的长度。
            // 因为索引需要存储3项,所以乘3
            int indexSize = locations.size() * 3 * Integer.BYTES;

            // file-pointer是一个long value
            // 写下所有的location，将index作为一个整体--当我们write location在内存中创建index,比较高效.

            int locationStart = (int) (indexSize + ran.getFilePointer() + Integer.BYTES);
            ran.writeInt(locationStart);
            long indexStart = ran.getFilePointer();

            int startPointer = locationStart;
            // 设置file-pointe偏移，从文件开始进行测量，当read(),write()方法发生时候。
            // pos：偏移的位置，从文件的开始以byte测量，在这个点设置file-pointer
            ran.seek(startPointer);

            for (Location location : locations.values()) {
                ran.writeInt(location.getLocationID());
                ran.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                ran.writeUTF(builder.toString());
                // 现在内存中创建index
                IndexRecord record = new IndexRecord(startPointer, (int) (ran.getFilePointer() - startPointer));

                index.put(location.getLocationID(), record);

                startPointer = (int) ran.getFilePointer();
            }
            ran.seek(indexStart);
            for (Integer locationID : index.keySet()) {
                ran.writeInt(locationID);
                ran.writeInt(index.get(locationID).getStartByte());
                ran.writeInt(index.get(locationID).getLength());
            }
        }
    }

    static {
        // read index from file
        // 当player移动到location,我们要从randomaccessfile调用location
        try {
            ran = new RandomAccessFile("location_rand.dat", "rwd");
            int numLocation = ran.readInt();  // 保留location长度有好处
            long locationStartPoint = ran.readInt();

            while (ran.getFilePointer() < locationStartPoint) {
                int locationid = ran.readInt();
                int locationStart = ran.readInt();
                int locationLength = ran.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationid, record);
            }

        } catch (IOException ioe) {
            System.out.println("IOException in static initializer: " + ioe.getMessage());
        }
    }
    // grab location from randomAccessFile
    public Location getLocation(int locationid) throws IOException {
        IndexRecord record = index.get(locationid);
        ran.seek(record.getStartByte());
        int id = ran.readInt();
        String description = ran.readUTF();
        String exits = ran.readUTF();
        String[] exitPart = exits.split(",");
        Location location = new Location(locationid, description, null); //exits为null,相当于新建一个exits

        if (locationid != 0) {
            for (int i = 0; i < exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i + 1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;
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

    // 当player退出时,关闭randomaccessfile
    public void close() throws IOException {
        ran.close();
    }
}

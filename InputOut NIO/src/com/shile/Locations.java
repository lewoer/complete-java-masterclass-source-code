package com.shile;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * 1. newBufferedWriter: 打开或创建一个writing的file,返回一个BufferedWriter将文本以高效的方式写进文件.
 * 文本用UTF-8编码为byte
 * 2.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        // write object将Files.newOutputStream包装进去即可.
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try(ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }

        }
//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
//             BufferedWriter dicFile = Files.newBufferedWriter(dirPath)) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("Q")) {
//                        dicFile.write(location.getLocationID() + "," + direction + "," +
//                                location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//
//        } catch (IOException ioe) {
//            System.out.println("IOEcception: " + ioe.getMessage());
//        }
    }

    static {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(),location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        }catch (InvalidClassException ice) {
            System.out.println("InvalidClassException: " +ice.getMessage());
        }catch (IOException ioe) {
            System.out.println("IOException: " +ioe.getMessage());
        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException: " + cnfe.getMessage());
        }
//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//        try (Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + " : " + description);
//                locations.put(loc, new Location(loc, description, null));
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//
//        try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
//            String input;
//            while ((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
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

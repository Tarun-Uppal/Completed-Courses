package com.tarun;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    // it is counted a map and not a class because it implements Map
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }

    static {
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream
                (new FileInputStream("locations.dat")))){
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read Location" + location.getLocationID()
                            + " : " + location.getDescription());
                    System.out.println("Exits " + location.getExits().size() + " : "
                            + location.getExits() + " found.");
                    locations.put(location.getLocationID(), location);
                } catch (ClassNotFoundException | IOException e) {
                    eof = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found Exception");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

        @Override
        public int size () {
            return locations.size();
        }

        @Override
        public boolean isEmpty () {
            return locations.isEmpty();
        }

        @Override
        public boolean containsKey (Object key){
            return locations.containsKey(key);
        }

        @Override
        public boolean containsValue (Object value){
            return locations.containsValue(value);
        }

        @Override
        public Location get (Object key){
            return locations.get(key);
        }

        @Override
        public Location put (Integer key, Location value){
            return locations.put(key, value);
        }

        @Override
        public Location remove (Object key){
            return locations.remove(key);
        }

        @Override
        public void putAll (Map < ? extends Integer, ? extends Location > m){

        }

        @Override
        public void clear () {
            locations.clear();

        }

        @Override
        public Set<Integer> keySet () {
            return locations.keySet();
        }

        @Override
        public Collection<Location> values () {
            return locations.values();
        }

        @Override
        public Set<Entry<Integer, Location>> entrySet () {
            return locations.entrySet();
        }
}

package com.tarun;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    // it is counted a map and not a class because it implements Map
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    private static Map<Integer,IndexRecords> index = new LinkedHashMap<Integer, IndexRecords>();
    private static RandomAccessFile ra;

        public static void main(String[] args) throws IOException {

        try (RandomAccessFile rao = new RandomAccessFile("Locations_rand.dat","rwd")) {
        rao.writeInt(locations.size());
        int indexSize = locations.size() * 3 * Integer.BYTES;
        int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
        rao.writeInt(locationStart);
        long indexStart = rao.getFilePointer();
        int startPointer = locationStart;
        rao.seek(startPointer);

        for (Location location : locations.values()){
            rao.writeInt(location.getLocationID());
            rao.writeUTF(location.getDescription());
            StringBuilder builder = new StringBuilder();
            for (String direction : location.getExits().keySet()){
                if (!direction.equalsIgnoreCase("Q")){
                    builder.append(direction);
                    builder.append(",");
                    builder.append(location.getExits().get(direction));
                    builder.append(",");
                }
            }
            rao.writeUTF(builder.toString());
            IndexRecords records = new IndexRecords(startPointer,(int)rao.getFilePointer()-startPointer);
            index.put(location.getLocationID(),records);

            startPointer = (int) rao.getFilePointer();
        }
        rao.seek(indexStart);
        for (Integer locationID : index.keySet()){
            rao.writeInt(locationID);
            rao.writeInt(index.get(locationID).getStartByte());
            rao.writeInt(index.get(locationID).getLength());
        }
        }
    }
        static {
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while(ra.getFilePointer() < locationStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecords record = new IndexRecords(locationStart, locationLength);
                index.put(locationId, record);
            }

        } catch(IOException e) {
            System.out.println("IOException in static initializer: " + e.getMessage());
        }
    }

    public void close()throws IOException{
        ra.close();
    }

    public Location getLocation(int locationId) throws IOException {
                IndexRecords records = index.get(locationId);
        ra.seek(records.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();

        String[] exitPart = exits.split(",");

        Location location = new Location(locationId,description,null);

        if (locationId!=0){
            for (int i=0;i<exitPart.length;i++){
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction,destination);
            }
        }
        return location;
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




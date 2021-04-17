package com.company;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Main {

    public static void main(String[] args) {

        try{
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                        for (int i = 0;i<10;i++){
                            String currentTime = "The time is " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while(buffer.hasRemaining()){
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0;i<10;i++){
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader thread: " + new String(timeString));
                            Thread.sleep(100);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();

        }catch (IOException e){
            System.out.println("IOException");
        }
//        try (FileOutputStream binFile = new FileOutputStream("data.dat");
//             FileChannel binChannel = binFile.getChannel()){
//
//            ByteBuffer buffer = ByteBuffer.allocate(100);
////            byte[] outputBytes = "Hello World!".getBytes();
////            byte[] outputBytes2 = "Nice to meet you".getBytes();
////            buffer.put(outputBytes).putInt(245).putInt(-12324556).put(outputBytes2).putInt(1000);
////            buffer.flip();
//
//            byte[] outputBytes = "Hello World!".getBytes();
//            buffer.put(outputBytes);
//            long int1Pos = outputBytes.length;
//            buffer.putInt(245);
//            long int2Pos = int1Pos + Integer.BYTES;
//            buffer.putInt(-9876543);
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes2);
//            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
//            buffer.putInt(1000);
//            buffer.flip();
//
//            binChannel.write(buffer);
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
//            FileChannel channel = ra.getChannel();
//
//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(int3Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 3 = " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int2Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 2 = " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int1Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 1 = " + readBuffer.getInt());
//
//            RandomAccessFile copyFile = new RandomAccessFile("dataCopy.dat","rw");
//            FileChannel copyChannel = copyFile.getChannel();
////            channel.position(0);
////            long numTransferred = copyChannel.transferFrom(channel,0,channel.size());
//            long numTransferred = channel.transferTo(0,channel.size(),copyChannel);
//            System.out.println("Num transferred = " + numTransferred);
//
//            channel.close();
//            ra.close();
//
//            byte[] outputString = "Hello World!".getBytes();
//            long str1Pos = 0;
//            long newInt1Pos = outputString.length;
//            long newInt2Pos = newInt1Pos + Integer.BYTES;
//            byte[] outputString2 = "Nice to meet you".getBytes();
//            long str2Pos = newInt2Pos + Integer.BYTES;
//            long newInt3Pos = str2Pos + outputString2.length;
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            binChannel.position(newInt1Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(-9874);
//            intBuffer.flip();
//            binChannel.position(newInt2Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(1000);
//            intBuffer.flip();
//            binChannel.position(newInt3Pos);
//            binChannel.write(intBuffer);
//
//            binChannel.position(str1Pos);
//            binChannel.write(ByteBuffer.wrap(outputString));
//            binChannel.position(str2Pos);
//            binChannel.write(ByteBuffer.wrap(outputString2));
//
//
////            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
////            FileChannel channel = ra.getChannel();
////            ByteBuffer readBuffer = ByteBuffer.allocate(100);
////            channel.read(readBuffer);
////            readBuffer.flip();
////
////            byte[] inputString = new byte[outputBytes.length];
////            readBuffer.get(inputString);
////            System.out.println("Input String = " + new String(inputString));
////            System.out.println("int 1 = " + readBuffer.getInt());
////            System.out.println("int 2 = " + readBuffer.getInt());
////
////            byte[] inputString1 = new byte[outputBytes2.length];
////            readBuffer.get(inputString1);
////            System.out.println("Input String = " + new String(inputString1));
////            System.out.println("int 3 = " + readBuffer.getInt());
//
////            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
////            buffer.put(outputBytes);
////
////            int numBytes = binChannel.write(buffer);
////            System.out.println("Numbytes written " + numBytes);
////
////            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
////            intBuffer.putInt(245);
////            intBuffer.flip();
////            numBytes = binChannel.write(intBuffer);
////            System.out.println("IntBuffer written " + numBytes);
////
////            intBuffer.flip();
////            intBuffer.putInt(-19181);
////            intBuffer.flip();
////            numBytes = binChannel.write(intBuffer);
////            System.out.println("IntBuffer written " + numBytes);
////
////            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
////            FileChannel channel = ra.getChannel();
////            outputBytes[0] = 'a';
////            outputBytes[1] = 'b';
////            buffer.flip();
////            long numBytesRead = channel.read(buffer);
////
////            if (buffer.hasArray()){
//////                System.out.println("byte Buffer " +new String(buffer.array()));
////                System.out.println("byte buffer = " + new String(outputBytes));
////            }
////
////            //RELATIVE READ
//////            intBuffer.flip();
//////            numBytesRead = channel.read(intBuffer);
//////            intBuffer.flip();
//////            System.out.println("numb bytes read " + intBuffer.getInt());
//////            intBuffer.flip();
//////            numBytesRead = channel.read(intBuffer);
//////            intBuffer.flip();
//////            System.out.println("numb bytes read " + intBuffer.getInt());
////
////            //ABSOLUTE READ
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            System.out.println("numb bytes read " + intBuffer.getInt(0));
////            numBytesRead = channel.read(intBuffer);
////            System.out.println("numb bytes read " + intBuffer.getInt(0));
////            System.out.println(intBuffer.getInt());
////
////
////            ra.close();
////            channel.close();
//////            System.out.println("output bytes " + new String(outputBytes));
////
//////            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
//////            byte[] b = new byte[outputBytes.length];
//////            ra.read(b);
//////
//////            System.out.println(new String(b));
//////
//////            long int1 = ra.readInt();
//////            System.out.println(int1);
//////            int1= ra.readInt();
//////            System.out.println(int1);
////
//////            Path dataPath = FileSystems.getDefault().getPath("Data.txt");
//////            Files.write(dataPath,"\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
//////            List<String> lines = Files.readAllLines(dataPath);
//////            for (String line : lines){
//////                System.out.println(line);
//////            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}

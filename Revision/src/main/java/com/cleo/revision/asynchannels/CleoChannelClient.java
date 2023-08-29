package com.cleo.revision.asynchannels;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;

public class CleoChannelClient {

    public static void main(String[] args) throws Exception{

        var names = List.of("Deven","Anchit","Aanchal","ShutDown");

        InetSocketAddress cleoClient = new InetSocketAddress("localhost",5000);

        //  selectable channel for stream-oriented connecting sockets

        SocketChannel channel = SocketChannel.open(cleoClient);

        for(var name: names){
            ByteBuffer buffer =  ByteBuffer.wrap(name.getBytes());
            channel.write(buffer);
            System.out.println("Sending: " + name);

            buffer.clear();
            Thread.sleep(2000);
        }
        channel.close();

    }
}

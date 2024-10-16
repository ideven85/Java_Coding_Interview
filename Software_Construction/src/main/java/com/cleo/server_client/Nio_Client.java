package com.cleo.server_client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;

public class Nio_Client {

    public static void main(String[] args) {
        try{
            var host = new InetSocketAddress("localhost",5000);
            var client = SocketChannel.open(host);
            var names = List.of("Deven","Anchit","Aanchal","Mom","Close");
            for(var name:names){
                //todo Wrap with new String
                var buffer = ByteBuffer.wrap(name.getBytes());//Why new String?
                client.write(buffer);
                System.out.println("Sending: " + name);
                buffer.clear();//Ok line 17 new String because we are deleting the buffer


                Thread.sleep(5000);


            }
            client.close();

        }catch (IOException ie){
            System.out.println(ie.getMessage());

        }catch (InterruptedException ie){
            System.out.println(ie.getMessage());

        }
    }
}

package com.cleo.server_client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

public class Server {

    @SuppressWarnings("unused")

    public static void main(String[] args) {

        try{
            // Selector: A multiplexer of SelectableChannel objects.
            // A selector may be created by invoking the open method of this class, which will use the system's default
            // selector provider to create a new selector.
            // A selector may also be created by invoking the openSelector method of a custom selector provider.
            // A selector remains open until it is closed via its close method.

            Selector selector = Selector.open();
            ServerSocketChannel nioSocket = ServerSocketChannel.open();

            InetSocketAddress server = new InetSocketAddress("localhost",5000);

            nioSocket.bind(server);

            nioSocket.configureBlocking(false);//Async

            int ops = nioSocket.validOps();

            // SelectionKey: A token representing the registration of a SelectableChannel with a Selector.
            // A selection key is created each time a channel is registered with a selector.
            // A key remains valid until it is cancelled by invoking its cancel method, by closing its channel,
            // or by closing its selector.

            SelectionKey key = nioSocket.register(selector,ops,null);


            while(true){
                System.out.println("Started listening on port 5000");

                selector.select();            // Selects a set of keys whose corresponding channels are ready for I/O operations
              //  System.out.println(selector.selectedKeys());
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
              //  List<SelectionKey> selectionKeys = new ArrayList<> (selector.selectedKeys());
               // ListIterator<SelectionKey> list_iterator = selectionKeys.listIterator();
                while (iterator.hasNext()){
               //while(list_iterator.hasNext())
                //for(var selection_key:selectionKeys){
                   // SelectionKey selection_key = iterator.next();
                    // Tests whether this key's channel is ready to accept a new socket connection
                 //   var my_key =  list_iterator.next();
                    SelectionKey my_key = iterator.next();
                    if(my_key.isAcceptable()){
                           SocketChannel client = nioSocket.accept();//Check client for the difference

                            client.configureBlocking(false);

                            client.register(selector,SelectionKey.OP_READ);

                        System.out.println("Connection from " + client.getLocalAddress());
                    }
                    else if(my_key.isReadable()){
                            var client = (SocketChannel) my_key.channel();
                        System.out.println(client.isConnected());
                            var buffer = ByteBuffer.allocate(256);
                            client.read(buffer);
                            String output = new String(buffer.array()).trim();
                        System.out.println("Message received " + output);

                        if(output.equalsIgnoreCase("close")){
                            client.close();
                            System.out.println("Closing... Restart the client ");
                        }
                    }
                   iterator.remove();

                }



            }







        }catch (IOException ie){
            System.out.println(ie.getMessage());
        }
    }
}

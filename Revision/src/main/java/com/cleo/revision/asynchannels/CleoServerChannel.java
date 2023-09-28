package com.cleo.revision.asynchannels;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Set;


public class CleoServerChannel {



    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception{

        /**
         * Selector: A multiplexer of SelectableChannel objects.
         A selector may be created by invoking the open method of this class,
         which will use the system's default selector provider to create a new selector.
         A selector may also be created by invoking the openSelector method of a custom selector provider.
         A selector remains open until it is closed via its close method.
        */
         Selector serverSelector = Selector.open();

        /**
         *    // ServerSocketChannel: A selectable channel for stream-oriented listening sockets.
         *         // A server-socket channel is created by invoking the open method of this class.
         *         // It is not possible to create a channel for an arbitrary, pre-existing ServerSocket.
         */
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        /**
         * InetSocketAddress: This class implements an IP Socket Address (IP address + port number) It can also be a
         * pair (hostname + port number),
         *         // in which case an attempt will be made to resolve the hostname.
         *         // If resolution fails then the address is said to be unresolved but can still be used on some circumstances like
         *         connecting through a proxy.
         */

        InetSocketAddress serverSocket = new InetSocketAddress("localhost",5000);

        // Binds the channel's socket to a local address and configures the socket to listen for connections

        serverSocketChannel.bind(serverSocket);

        //Configure Blocking set to false... Who has sent the message?

        serverSocketChannel.configureBlocking(false);

        int ops = serverSocketChannel.validOps();

        // SelectionKey: A token representing the registration of a SelectableChannel with a Selector.
        // A selection key is created each time a channel is registered with a selector.
        // A key remains valid until it is cancelled by invoking its cancel method, by closing its channel,
        // or by closing its selector.

        SelectionKey key = serverSocketChannel.register(serverSelector,ops,null);
        boolean flag=true;
        while(flag){
            System.out.println("Waiting for connection..");
            // Selects a set of keys whose corresponding channels are ready for I/O operations

           int key1 =  serverSelector.select();
            // token representing the registration of a SelectableChannel with a Selector
            Set<SelectionKey> serverKeys = serverSelector.selectedKeys();

            var serverKeysIterator = serverKeys.iterator();
            while(serverKeysIterator.hasNext()) {
                SelectionKey cleoKey = serverKeysIterator.next();
                if (cleoKey.isAcceptable()) {
                    SocketChannel cleoClient = serverSocketChannel.accept();
                    cleoClient.configureBlocking(false);

                    // Operation-set bit for read operations

                    cleoClient.register(serverSelector, SelectionKey.OP_READ);
                    System.out.println("Connection accepted:" + cleoClient.getLocalAddress());
                } else if (cleoKey.isReadable()) {

                    SocketChannel cleoClient = (SocketChannel) cleoKey.channel();

                    // ByteBuffer: A byte buffer.
                    // This class defines six categories of operations upon byte buffers:
                    // Absolute and relative get and put methods that read and write single bytes;
                    // Absolute and relative bulk get methods that transfer contiguous sequences of bytes
                    // from this buffer into an array;

                    ByteBuffer cleoBuffer = ByteBuffer.allocate(256);
                    cleoClient.read(cleoBuffer);

                    String result = new String(cleoBuffer.array()).trim();

                    System.out.println("Message Recievied:" + result + " by " + cleoClient.getLocalAddress());

                    if (result.equalsIgnoreCase("ShutDown")) {
                        System.out.println("Got shut down key");
                        cleoClient.close();
                        flag=false;
                    }

                }

            }
            System.out.println(serverKeys.size());


                serverKeysIterator.remove();
            }

        }






}

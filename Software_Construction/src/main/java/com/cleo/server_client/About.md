# High Performance with NIO

* Create  Server.java which opens connection on port 5000
* use isAcceptable() to check if channel is ready to accept a new socket connection
    * If yes – connect it
* use isReadable() to check if channel is ready for reading
    * if yes – read from buffer and print on Eclipse console
* Once you get last company name “close”
    * close connection
      Step-2
* Create Client.java which tries to connect to server on port 5000
* Create ArrayList with 5 company names
* Iterate through ArrayList and send each companyName to server
* Close connection after task finish

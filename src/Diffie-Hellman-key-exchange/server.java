/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Math.pow;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hp
 */
public class Server {
    
    public static void main(String[] args) throws IOException {
        int port = 8088;
        int server_private=5;
        
        

double c_P , c_generator , c_Public,B, Kab;
String Bstr;



ServerSocket serverSocket = new ServerSocket(port);
System.out.println("waiting for client ....." + serverSocket.getLocalPort() + ".....");
Socket server = serverSocket.accept();
System.out.println("connected to" + server.getRemoteSocketAddress());


//Server`s private key
System.out.println("From Server ( Private key) = " +server_private);
//Accept the data from client 
DataInputStream in = new DataInputStream(server.getInputStream());

c_P = Integer.parseInt(in.readUTF()); 
System.out.println("From Client ( P )= "+c_P);

c_generator = Integer.parseInt(in.readUTF());
System.out.println("From Client ( G )= "+c_generator);

c_Public = Double.parseDouble(in.readUTF()); 
System.out.println("From Client (Public key )= " + c_Public);

B = ((pow(c_generator, server_private)) % c_P);
Bstr = Double.toString(server_private);
OutputStream outToolient = server.getOutputStream();
DataOutputStream out = new DataOutputStream(outToolient);
out.writeUTF(Bstr);


Kab = ((pow(c_Public , server_private)) %c_P);
System.out.println("Secret key to perform symmetric Encryption = " + Kab);
server.close();
 
        // TODO code application logic here
    }
    
}

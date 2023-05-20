package server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import static java.lang.Math.pow;
import java.net.Socket;

public class client_d {
    public static void main(String[] args)
    {
     try{  
String p_TOstring ,g_TOstring , A_TOstring;
String serverName = "Localhost";
int port= 8088;


int p=23;
int generator =11;
int a =6;
double kab , serverB;
System.out.println("Connecting to " + serverName + "on port : " + port);
Socket client = new Socket(serverName , port);
System.out.println("Host connected to " + client.getRemoteSocketAddress());
OutputStream outToServer = client.getOutputStream();
DataOutputStream out = new DataOutputStream (outToServer);

p_TOstring = Integer.toString(p);
out.writeUTF(p_TOstring);

g_TOstring=Integer.toString(generator);
out.writeUTF(g_TOstring);


double A = ((pow(generator,a)) %p);
A_TOstring = Double.toString(A);
out.writeUTF(A_TOstring);
//h
System.out.println("From client (Private Key) = " + a);
DataInputStream in = new DataInputStream(client.getInputStream());
serverB = Double.parseDouble(in.readUTF());
System.out.println("From server  (Public Key) = " + serverB);
kab = ((pow(serverB , a)) % p);
System.out.println("secret ket to perform symmetric encryption = " + kab);
client.close();
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
    
}
}
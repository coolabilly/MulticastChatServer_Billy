import java.net.*;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args)
        throws Exception {
        int portnumber = 50000;
        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[50000]);
        }

        MulticastSocket serverMulticastSocket =
                new MulticastSocket(portnumber);
        System.out.println("MulticastSocket is created at port " + portnumber);

        InetAdress group =
                InetAdress.getByName("222.4.5.6");

        serverMulticastSocket.joinGroup(group);
        System.out.println("joinGroup method is called...");
        boolean infinite true;

        while (infinite) {
            byte buf[] = new byte[1024];
            DatagramPacket data =
                    new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data);
            String msg =
                    new String(data.getData()).trim();
            System.out.println("Message received from client = " + msg);
        }
        serverMulticastSocket.close();
    }
    }





    }

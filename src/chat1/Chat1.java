
package chat1;

import java.io.DataInputStream;
import java.io.IOException;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Chat1 {

   public static int bucle=1;
   public static String text;
   public static String leer;
    
    public static void main(String[] args) throws InterruptedException, IOException {
       
        
       
       
       try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket("localhost",5555);
            System.out.println("Estableciendo la conexion");
            DataInputStream is = new DataInputStream(clienteSocket.getInputStream());
            PrintStream os = new PrintStream(clienteSocket.getOutputStream());
            
            
            text = JOptionPane.showInputDialog("(C)Escribe un mensaje");
           
            System.out.println(text);
                        
            
            
            }catch (IOException e) {
                    e.printStackTrace();
            }
       
   
       
       
	}
}	
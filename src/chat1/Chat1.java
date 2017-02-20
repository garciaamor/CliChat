
package chat1;

import java.io.DataInputStream;
import java.io.IOException;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Chat1 {

   
    
    public static void main(String[] args) throws InterruptedException, IOException {
       
        
       
       
       try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket("localhost",5555);
            System.out.println("Estableciendo la conexion");
            DataInputStream is = new DataInputStream(clienteSocket.getInputStream());
            PrintStream os = new PrintStream(clienteSocket.getOutputStream());
            
            
            
            String mensaje = JOptionPane.showInputDialog("(CL)Introduce el mensaje");
            
            System.out.println("Mensaje del cliente "+mensaje);
            os.println(mensaje);
            os.flush();
            
            String entradaServ;
            
            while ((entradaServ=is.readLine())!=null){
                System.out.println("Mensaje del servidor : "+entradaServ);
                mensaje = JOptionPane.showInputDialog("Introduzca el mensaje del Cliente");
                os.println(mensaje);
                System.out.println("Mensaje del cliente: "+mensaje);
                os.flush();
            
            
                if (mensaje.equals("cerrar")){
                    break;
                }
            }            
            os.close();
            is.close();
            clienteSocket.close();
            
            }catch (IOException e) {
                    e.printStackTrace();
            }
       
   
       
       
	}
}	
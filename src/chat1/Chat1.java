
package chat1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Chat1 {

    
    public static void main(String[] args) throws InterruptedException, IOException {
       String text;
        
       
       
       try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket("localhost",5555);
            System.out.println("Estableciendo la conexion");
            BufferedReader is = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            BufferedWriter os = new BufferedWriter(new OutputStreamWriter(clienteSocket.getOutputStream()));
            /*int numCompr=0;
            while (numCompr==0){
             
           
            }*/
            System.out.println("Enviando mensaje");
            
            text = JOptionPane.showInputDialog("(C)Escribe un mensaje");
           
            System.out.println(text);
            
            
            os.write(text);
            os.flush();
            
              
       
            clienteSocket.close();
            

            }catch (IOException e) {
                    e.printStackTrace();
            }
       
   
       
       
	}
}	
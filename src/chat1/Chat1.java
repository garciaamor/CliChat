
package chat1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Chat1 {

    public static void main(String[] args) throws InterruptedException, IOException {
        
       try{
           /*
           Se crea el socket del cliente llamado clienteSocket con direccion "localhost" y puerto 5555
           Cambiamos los flujos de lectura y escritura a PrintStream(escritura) y DataInputStream(lectura)
           De esta forma el cliente permanecerá abierto con el bucle que explicaremos más adelante y no se cerrará al escribir el mensaje
           */
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket("localhost",5555);
            System.out.println("Estableciendo la conexion");
            DataInputStream is = new DataInputStream(clienteSocket.getInputStream());
            PrintStream os = new PrintStream(clienteSocket.getOutputStream());
            /*
            Creamos una variable llamada mensajeCli y le asignamos el texto que introduciremos por JOptionPane
            Mostramos el mensaje que escribimos por consola y realizamos un flush para vaciar el flujo
            */
            String mensajeCli = JOptionPane.showInputDialog("(CL)Introduce el mensaje");
            System.out.println("Mensaje del cliente "+mensajeCli);
            os.println(mensajeCli);
            os.flush();
            
            /*
            Creamos una variable String llamada mensServidor que recogerá el mensaje que nos envió el cliente
            Si el mensaje es distinto de null, es decir, si hay algo escrito, entrará en el bucle while y nos imprimira por pantalla el mensaje del servidor
            A continuacion nos sale otro JOptionPane con el mensaje que escribirá el cliente, este JOptionPane será el que se repita ya que está dentro del bucle
            Enviamos el mensaje, nos lo muestra por consola y realizamos un flush
            Entramos al segundo bucle (if), en este bucle solo entra si el texto del cliente es igual a "cerrar", lo que cerrará la aplicacion
            */
            String mensServidor;
            
            while ((mensServidor=is.readLine())!=null){
                System.out.println("Mensaje del servidor : "+mensServidor);
                mensajeCli = JOptionPane.showInputDialog("(CL)Introduce el mensaje");
                os.println(mensajeCli);
                System.out.println("Mensaje del cliente: "+mensajeCli);
                os.flush();
            
                if (mensajeCli.equals("cerrar")){
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
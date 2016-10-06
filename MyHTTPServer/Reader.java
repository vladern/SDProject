package Server;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Reader
{
	public String leerTXT(String ruta) throws FileNotFoundException, IOException
	{
		String cadena;
        String aux="";
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
        //    System.out.println(cadena);
            aux=aux+cadena;
        }
        b.close();
        return aux;
	}
	public String leerJPG()
	{
		return "";
	}
}
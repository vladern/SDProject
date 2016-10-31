package HTTPServer;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.nio.file.*;
//import java.util.Base64;

public class Reader
{
	public String leerTXT(String ruta) throws FileNotFoundException, IOException
	{
		try
		{
			String cadena;
	        String aux="";
	        FileReader f = new FileReader(ruta);
	        BufferedReader b = new BufferedReader(f);
	        while((cadena = b.readLine())!=null) 
	        {
	        //  System.out.println(cadena);
		        aux=aux+cadena+"\n";
        	}
        	b.close();
		    return aux;	
		}catch(FileNotFoundException e)
		{
			try
			{
				return this.leerTXT("HTML/error404.html");
			}catch(FileNotFoundException x)
			{
				return null;
			}catch(IOException x)
			{
				return null;
			}
		}catch(IOException e)
		{
			return null;
		}
	}
}
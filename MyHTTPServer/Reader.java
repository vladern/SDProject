package MyHTTPServer;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

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
		        aux=aux+cadena;
        	}
        	b.close();
		    return aux;	
		}catch(FileNotFoundException e)
		{
			return"";
		}catch(IOException e)
		{
			return"";
		}

        
	}
	public String leerJPG()
	{
		return "";
	}
}
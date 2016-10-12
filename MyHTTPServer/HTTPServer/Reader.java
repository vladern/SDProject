package HTTPServer;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.nio.file.*;
import java.util.Base64;

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
			return"";
		}catch(IOException e)
		{
			return"";
		}
	}
	public String leerJPG(String ruta)throws IOException
	{
		try
		{
			Path path = Paths.get(ruta);
			byte[] data = Files.readAllBytes(path);
			String str = Base64.getEncoder().encodeToString(data);
			return str;
		}catch(IOException e)
		{
			return null;
		}

	}
}
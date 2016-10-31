	package com.autentia.rmi;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.nio.file.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
		        aux=aux+cadena+"@";
        	}
        	b.close();
		    return aux;	
		}catch(FileNotFoundException e)
		{
			return "<h1>NO ENCONTRADO EL ARCHIVO DE LA SONDA CONTACTE CON EL ADMINISTRADOR </h1>@<h1>NO ENCONTRADO EL ARCHIVO DE LA SONDA CONTACTE CON EL ADMINISTRADOR </h1>@<h1>NO ENCONTRADO EL ARCHIVO DE LA SONDA CONTACTE CON EL ADMINISTRADOR </h1>@";
		}catch(IOException e)
		{
			return null;
		}
	}
	public boolean escribirTXT(String aEscribir)
	{
		try
		{
			String[] datos = leerTXT("../../TextoEsclavo/info.txt").split("@");
			if(datos[0].toUpperCase().contains("ADMINISTRADOR".toUpperCase()))
			{
				return false;
			}
			PrintWriter writer = new PrintWriter("../../TextoEsclavo/info.txt", "UTF-8");
			writer.println(datos[0]);
			writer.println(getDateTime());
			writer.println(aEscribir);
			writer.close();
			return true;			
		}catch(FileNotFoundException e)
		{
			return false;
		}catch(IOException e)
		{
			return false;
		}

	}
	private String getDateTime() 
	{
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
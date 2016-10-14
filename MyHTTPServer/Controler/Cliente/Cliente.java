import java.io.*;
import java.rmi.*;
public class Cliente
{
	public static void main(String[] args)
	{
		try
		{
			String host = args[1];
			String port = args[2];
			System.setSecurityManager(new RMISecurityManager());            	
			InterfazRemoto objetoRemoto=null;
			String servidor = "rmi://" +host+ ":" +port+ "/ObjetoRemoro";
			objetoRemoto =(InterfazRemoto) Naming.lookup(servidor);
			System.out.println("La suma de 2+3 es:");
			System.out.println(objetoRemoto.suma(2,3));
		}catch(Exception e)
		{

		}
	}
}
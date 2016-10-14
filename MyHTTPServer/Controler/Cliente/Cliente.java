import java.io.*;
import java.rmi.*;
public class Cliente
{
	public static void main(String[] args)
	{
		try
		{
			String host = "localhost";
			String port = "1099";
			System.setSecurityManager(new RMISecurityManager());            	
			//InterfazRemoto objetoRemoto=null;
			String servidor = "rmi://"+host+":"+port+"/ObjetoRemoto";
			InterfazRemoto tuTia = (InterfazRemoto)Naming.lookup(servidor);
			System.out.println("La suma de 2+3 es:");
			System.out.println(tuTia.suma(2,3));
		}catch(Exception e)
		{
			System.out.println("Exception "+e.getMessage());
		}
	}
}
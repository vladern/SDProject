import java.rmi.*;
public class Registro 
{
	public static void main (String args[])
	{
		String URLRegistro;
		try
		{
			System.setSecurityManager(new RMISecurityManager());
			ObjetoRemoto objetoRemoto = new ObjetoRemoto();
			URLRegistro = "/ObjetoRemoto";
			Naming.rebind (URLRegistro, objetoRemoto);
			System.out.println("Servidor de objeto preparado.");
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}
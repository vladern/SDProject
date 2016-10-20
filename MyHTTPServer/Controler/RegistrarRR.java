import java.rmi.*;
public class RegistrarRR 
{
	public static void main (String args[])
	{
		String URLRegistro;
		try
		{
			System.setSecurityManager(new RMISecurityManager());
			IRegistradorRemoto registrador = new IRegistradorRemoto();
			URLRegistro = "registradorRemoto1";
			Naming.rebind(URLRegistro,registrar);
			System.out.println("El registrador remoto ha sido registrado :)");
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}

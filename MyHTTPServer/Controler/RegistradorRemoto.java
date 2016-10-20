import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.*;

public class RegistradorRemoto extends UnicastRemoteObject implements IRegistradorRemoto, Serializable
{
	public IRegistradorRemoto()throws RemoteException
	{
		super();
	}
	public void registrarSonda(IEsclavo esclavo)throws RemoteException
	{
		String URLRegistro;
		try
		{
			System.setSecurityManager(new RMISecurityManager());
			URLRegistro = esclavo.getNombre();//a cada nueva sonda se le dara un nombre 
			Naming.rebind(URLRegistro,esclavo);
			System.out.println("El esclavo"+URLRegistro+"se ha registrado en el Espacio de Nombres");
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	
}

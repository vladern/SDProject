import java.io.Serializable;
import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.*;
public class Esclavo extends UnicastRemoteObject implements IEsclavo, Serializable
{
	private String nombre;
	public Esclavo()throws RemoteException
	{
		super();
	}
	public Esclavo(String nombre) throws RemoteException
	{
		super();
		this.nombre=nombre;
	}
	public String getNombre()throws RemoteException
	{
		return nombre;
	}
	public String HolaMundo()throws RemoteException
	{
		return "Hola mundo , soy el esclavo :( , me ejecuto desde otra maquina :)";
	}

}

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRegistradorRemoto extends Remote
{
	public void registrarSonda(IEsclavo esclavo)throws RemoteException;
}

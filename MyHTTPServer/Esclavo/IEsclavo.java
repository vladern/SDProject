import java.rmi.Remote;
public interface IEsclavo extends Remote
{
	public String HolaMundo()throws java.rmi.RemoteException;
	public String getNombre()throws java.rmi.RemoteException;
}

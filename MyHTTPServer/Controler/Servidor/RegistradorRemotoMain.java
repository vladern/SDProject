import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RegistradorRemotoMain
{
	public static void main(String[] args) throws Exception
	{
		final Registry registry = LocateRegistry.getRegistry("192.168.1.85",1099);
		RegistradorRemoto registrador = new RegistradorRemoto(registry);
		registry.rebind("1",registrador);
		System.out.println("Registrado el registrador remoto");
	}
}
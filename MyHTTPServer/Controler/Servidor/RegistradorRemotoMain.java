import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RegistradorRemotoMain
{
	public static void main(String[] args) throws Exception
	{
		final Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
		RegistradorRemoto registrador = new RegistradorRemoto(registry);
		registry.rebind(registrador.RMI_NAME, registrador);
		System.out.println("Registrado el registrador remoto");
	}
}
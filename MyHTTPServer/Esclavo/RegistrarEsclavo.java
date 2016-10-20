import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistrarEsclavo
{
	public static void main(String[] args) throws Exception 
	{
		final String remoteHost = args[0];
		final Registry registry = LocateRegistry.getRegistry(remoteHost, Registry.REGISTRY_PORT);
		Object obj = registry.lookup("registroRemoto1");
		final IRegistradorRemoto registrador = (IRegistradorRemoto)obj;
		registrador.registrarEsclavo(new Esclavo("esclavo1"));	
	}
}

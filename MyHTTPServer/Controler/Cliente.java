import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Cliente 
{
	public static void main(String[] args) throws Exception 
	{
		final String remoteHost = "localhost";
		final Registry registry = LocateRegistry.getRegistry(remoteHost, Registry.REGISTRY_PORT);
		Object obj = registry.lookup("esclavo1");
		System.out.println("Llamando al esclavo para realizar la acción");
		final ISonda esclavo = (ISonda)obj;
		System.out.println(esclavo.HolaMundo());
	}
}

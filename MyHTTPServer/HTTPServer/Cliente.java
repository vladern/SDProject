package HTTPServer;
import java.io.*;
import java.net.*;


class Cliente
{
	private String controlerHost;
	public Cliente(String controlerHost)
	{
		this.controlerHost=controlerHost;
	}
	public String getInfo(String sol)
	{
		try
		{
			int port=8081;
			System.out.println("Contacto con el controlador con la ip:"+controlerHost);

			Socket skCliente = new Socket(controlerHost,port);
			OutputStream aux = skCliente.getOutputStream();
			DataOutputStream flujo= new DataOutputStream(aux);
			flujo.writeUTF(sol);
			InputStream aux1 = skCliente.getInputStream();
			DataInputStream flujo1 = new DataInputStream(aux1);
			String respuesta=flujo1.readUTF();
			skCliente.close();
			aux.close();
			aux1.close();
			flujo.close();
			flujo1.close();
			return respuesta;
		}catch(IOException e)
		{
			return null;
		}
	}
}
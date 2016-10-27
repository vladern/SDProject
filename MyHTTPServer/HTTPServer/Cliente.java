package HTTPServer;
import java.io.*;
import java.net.*;


class Cliente
{
	private String controlerHost;
	private int controlerPort;
	public Cliente(String controlerHost,int controlerPort)
	{
		this.controlerHost=controlerHost;
		this.controlerPort=controlerPort;
	}
	public String getInfo(String sol)
	{
		try
		{
			System.out.println("Contacto con el controlador con la ip:"+controlerHost);

			Socket skCliente = new Socket(controlerHost,controlerPort);
			OutputStream aux = skCliente.getOutputStream();
			DataOutputStream flujo= new DataOutputStream(aux);
			flujo.writeUTF(sol);
			InputStream aux1 = skCliente.getInputStream();
			DataInputStream flujo1 = new DataInputStream(aux1);
			String respuesta=flujo1.readUTF();
			System.out.println("la respuesta es:"+respuesta);

			skCliente.close();
			aux.close();
			aux1.close();
			flujo.close();
			flujo1.close();
			return respuesta;
		}catch(IOException e)
		{
			return "<body><br><br><h1 style=\"text-aling:center\">Error 409</body>";
		}
	}
}
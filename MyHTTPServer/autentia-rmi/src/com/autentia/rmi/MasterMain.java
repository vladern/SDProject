package com.autentia.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MasterMain {

	public static void main(String[] args) throws Exception {
		final Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
		Master master = new Master(registry);
		registry.rebind(Master.RMI_NAME, master);

		System.out.println("Esperando a alguien  para que se regisrte :) ");
		MasterMain masterMain = new MasterMain();
		synchronized (masterMain) {
			try {
				masterMain.wait();
			} catch (InterruptedException e) {
				// Me han despertado, tengo que terminar la ejecución.
			}
		}
	}
}

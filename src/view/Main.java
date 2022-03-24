package view;

import java.util.concurrent.Semaphore;

import controller.aeroporto;


public class Main {

	public static void main(String[] args) {
		int aviao = 12;
		Semaphore semaforo = new Semaphore(1);
		Semaphore a_pista = new Semaphore (2);
		
		for (int i = 0; i < aviao; i++) {
			new aeroporto(i, semaforo, a_pista).start();

		}
	}

}

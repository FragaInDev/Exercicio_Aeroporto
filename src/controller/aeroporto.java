package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class aeroporto extends Thread {
	private int aviao;
	private Semaphore semaforo;
	private Semaphore a_pista;

	public aeroporto(int _aviao, Semaphore smf, Semaphore ap) {
		aviao = _aviao;
		semaforo = smf;
		a_pista = ap;

	}

	@Override
	public void run() {
		int pista = (int) ((Math.random()*2)+1);
		try {
			a_pista.acquire();
			switch (pista) {
			case 1:
				try {
					semaforo.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
				manobra();
				taxiar();
				decolar();
				afastamento();
				System.out.println("O avi�o "+ aviao + " al�ou voo da pista norte.");
				break;
			
			case 2:
				try {
					semaforo.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
				manobra();
				taxiar();
				decolar();
				afastamento();
				System.out.println("O avi�o "+ aviao + " al�ou voo da pista sul.");
				break;
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			a_pista.release();
		}
	}
	// aviao faz manobra que dura de 3 a 7 segundos
	private void manobra() {
		int timeManobra = new Random().nextInt(7000) + 3000;
		int tempo = timeManobra / 1000;
		
		try {
			System.out.println("O avi�o " + aviao + " est� manobrando.....");
			sleep(timeManobra);
			System.out.println("O avi�o " + aviao + " manobrou em " + tempo + " segundos.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// taxiar de 5 a 10 segundos
	private void taxiar() {
		int timeTaxiar = new Random().nextInt(10000) + 5000;
		int tempo = timeTaxiar / 1000;
		
		try {
			System.out.println("O avi�o " + aviao + " est� taxiando.....");
			sleep(timeTaxiar);
			System.out.println("O avi�o " + aviao + " taxiou em " + tempo +" segundos.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// decolar de 1 a 4 seg
	private void decolar() {
		int timeDecolar = new Random().nextInt(4000) + 1000;
		int tempo = timeDecolar / 1000;
		
		try {
			System.out.println("O avi�o " + aviao + " est� decolando.....");
			sleep(timeDecolar);
			System.out.println("O avi�o " + aviao + " decolou em " + tempo + " segundos.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// afastamento de 3 a 8 segundos
	private void afastamento() {
		int timeAfasta = new Random().nextInt(8000) + 3000;
		int tempo = timeAfasta / 1000;

		try {
			System.out.println("O avi�o " + aviao + " est� al�ando voo.....");
			sleep(timeAfasta);
			System.out.println("O avi�o " + aviao + " al�ou voo em " + tempo + " segundos.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
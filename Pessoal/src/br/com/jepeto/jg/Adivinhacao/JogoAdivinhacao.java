package br.com.jepeto.jg.Adivinhacao;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {

	private Scanner sc = new Scanner(System.in);
	private int tentativas, numeros;
	
	public void iniciarAdivinhacao() {
		SelectNivel();
		Adivinha();
	}

	public JogoAdivinhacao() {}

	public JogoAdivinhacao(int tentativas, int numeros) {
		this.tentativas = tentativas;
		this.numeros = numeros;
	}
	
	private void SelectNivel () {
		boolean validacao; int nivel;
		System.out.print("Em qual nível deseja jogar? " 
				+ "\n1 => Fácil" 
				+ "\n2 => Médio" 
				+ "\n3 => Difícil");
		
		do {
			System.out.print("\nDigite um nível: ");
			nivel = sc.nextInt();
			
			if (nivel == 1) {
				tentativas =10;
				numeros = 64;
				validacao = true;
				
			} else if (nivel  == 2) {
				tentativas = 6;
				numeros = 80;
				validacao = true;
				
			} else if (nivel == 3) {
				tentativas = 5;
				numeros = 100;
				validacao = true;
				
			} else {
				System.out.print("Digite um numero valido!!");
				validacao = false;
			}
			
		}while(validacao == false);
	}

	private void Adivinha() {
		Random rd = new Random();
		int resposta = 0;

		System.out.print("\nVocê tem " + tentativas + " tentativas\n" + "para acertar o número aleatório\n"
				+ "entre 1 e " + numeros);

		int numAleatorio = rd.nextInt(numeros);
		for (int i = tentativas; i > 0; i--) {
			System.out.print("\nDigite um número: ");
			resposta = sc.nextInt();

			if (resposta > 0 && resposta < numeros) {
				if (resposta == numAleatorio) {
					break;

				} else if (resposta > numAleatorio) {
					System.out.println("Dê um chute mais baixo...\nRestam " + (i - 1) + " tentativas");

				} else {
					System.out.println("Dê um chute mais alto...\nRestam " + (i - 1) + " tentativas");
				}

			} else {
				System.out.println("Digite um número entre 1 e " + numeros + "\nRestam " + (i - 1) + " tentativas");

			}

		}
		if (resposta == numAleatorio) {
			System.out.println("Parabéns, você acertou!!!");
		} else {
			System.out.println("\nVocê perdeu :( \nTente novamente!");
		}
	}
	

}

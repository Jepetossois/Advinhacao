package br.com.jepeto.jg.Adivinhacao;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {

	int tentativas;
	int numeros;

	public JogoAdivinhacao(int tentativas, int numeros) {
		this.tentativas = tentativas;
		this.numeros = numeros;
	}

	String Adivinha() {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		String situacao = "";
		int resposta = 0;

		System.out.print("\nVocê tem " + tentativas + " tentativas\n" + "para acertar o número aleatório\n"
				+ "entre 1 e " + numeros);

		int numAleatorio = rd.nextInt(numeros);
		for (int i = tentativas; i > 0; i--) {
			System.out.print("\nDigite um número: ");
			resposta = sc.nextInt();

			if (resposta > 0 && resposta < numeros) {
				if (resposta == numAleatorio) {
					situacao = "Parabéns você acertou o número!!!";
					break;

				} else if (resposta > numAleatorio) {
					situacao = "Dê um chute mais baixo...\nRestam " + (i - 1) + " tentativas";
					System.out.println(situacao);

				} else {
					situacao = "Dê um chute mais alto...\nRestam " + (i - 1) + " tentativas";
					System.out.println(situacao);
				}

			} else {
				System.out.println("Digite um número entre 1 e " + numeros + "\nRestam " + (i - 1) + " tentativas");

			}
		}

		sc.close();
		if (resposta == numAleatorio) {
			return situacao;
		} else {
			return "Você perdeu :( \nTente novamente";
		}
	}
}

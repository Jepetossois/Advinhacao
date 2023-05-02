package br.com.jepeto.jg.Adivinhacao;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		JogoAdivinhacao jogo;
		boolean validacao;

		System.out.print("Em qual nível deseja jogar? " + "\n1 => Fácil" + "\n2 => Médio" + "\n3 => Difícil");

		// Selecionando o nível
		do {

			System.out.print("\n\nDigite um nível: ");
			Integer nivel = sc.nextInt();

			if (nivel > 0 && nivel < 2) {
				jogo = new JogoAdivinhacao(10, 64);
				validacao = true;

				System.out.println(jogo.Adivinha());

			} else if (nivel == 2) {
				jogo = new JogoAdivinhacao(6, 81);
				validacao = true;

				System.out.println(jogo.Adivinha());

			} else if (nivel > 2 && nivel < 4) {
				jogo = new JogoAdivinhacao(5, 100);
				validacao = true;

				System.out.println(jogo.Adivinha());

			} else {
				System.out.println("Selecione um nível válido!!");
				validacao = false;
			}
		} while (validacao == false);

		sc.close();
	}

}

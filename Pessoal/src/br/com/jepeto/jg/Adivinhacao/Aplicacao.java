package br.com.jepeto.jg.Adivinhacao;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JogoAdivinhacao adivinhacao = new JogoAdivinhacao();
		JogoForca forca = new JogoForca();
		boolean validacao = false;
		int jogo;
		
		System.out.print("Escolha um jogo ↴"
				+ "\n1 => Jogo da adivinhação"
				+ "\n2 => Jogo da forca\n");

		do {
			System.out.print("\nDigite um número: ");
			jogo = sc.nextInt();
			
			if (jogo == 1) {
				adivinhacao.iniciarAdivinhacao();
				validacao = true;
			} else if (jogo == 2) {
				forca.iniciarForca();
				validacao = true;
			} else {
				System.out.print("Digite um jogo válido!!\n");
			}
			
		}while (validacao == false);
		
		sc.close();
	}
}

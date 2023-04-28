package Advinhacao;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Jogo jogo;
		boolean validacao;

		System.out.print("Em qual nível deseja jogar? " 
				+ "\n1 => Fácil" 
				+ "\n2 => Médio" 
				+ "\n3 => Difícil");
		
		// Selecionando o nível
		do {
			
			System.out.print("\n\nDigite um nível: ");
			Integer nivel = sc.nextInt();

			if (nivel > 0 && nivel < 2) {
				jogo = new Jogo(10, 64);
				validacao = true;
				
				System.out.println(jogo.Adivinha());

			} else if (nivel == 2) {
				jogo = new Jogo(6, 81);
				validacao = true;
				
				System.out.println(jogo.Adivinha());

			} else if (nivel > 2 && nivel < 4) {
				jogo = new Jogo(5, 100);
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

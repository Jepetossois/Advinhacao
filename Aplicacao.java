package Advinhacao;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		JogoAdvinhacao Advinhacao;
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
				Advinhacao = new JogoAdvinhacao(10, 64);
				validacao = true;
				
				System.out.println(Advinhacao.Adivinha());

			} else if (nivel == 2) {
				Advinhacao = new JogoAdvinhacao(6, 81);
				validacao = true;
				
				System.out.println(Advinhacao.Adivinha());

			} else if (nivel > 2 && nivel < 4) {
				Advinhacao = new JogoAdvinhacao(5, 100);
				validacao = true;

				System.out.println(Advinhacao.Adivinha());
				
			} else {
				System.out.println("Selecione um nível válido!!");
				validacao = false;
			}
		} while (validacao == false);
		

		
		
		sc.close();
	}

}

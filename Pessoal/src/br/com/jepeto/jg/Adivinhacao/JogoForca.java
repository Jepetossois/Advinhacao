package br.com.jepeto.jg.Adivinhacao;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoForca {
	private Scanner sc = new Scanner(System.in);
	private List<String> palavras;
	private String palavraSelecionada;
	private char[] letras;
	private char[] letrasExibidas;
	
	public JogoForca() {}

	public void iniciarForca() {
		selectNivel();
		palavraSelecionada();
		jogo();
		
	}
	
	private void selectNivel () {
		boolean validacao; 
		int nivel;		
		System.out.print("\nSelecione um nível de palavras ↴"
				+ "\n1 => Palavras fáceis"
				+ "\n2 => Palavras médias"
				+ "\n3 => Palavras difíceis");
		
		do {
			System.out.print("\n\nDigite um nível: ");
			nivel = sc.nextInt();
			
			if (nivel == 1) {
				palavras = Arrays.asList(
						"amarelo", "amiga", "amor", "ave", "aviao", "avo", "balao", "bebe", "bolo", "branco");
				validacao = true;
				
			} else if (nivel == 2) {
				palavras = Arrays.asList(
						"acender", "afilhado", "agnostico", "ardiloso", "aspero", "assombraçao", "asterisco", "balaustre", "basquete", "caminho");
				validacao = true;
				
			} else if (nivel == 3) {
				palavras = Arrays.asList(
						"absonancia", "açodamento", "alvissaras", "astenia", "babugem", "beneplacito", "binesia", "duidade", "encomio", "empedernido");
				validacao = true;
				
			} else {
				System.out.print("Digite um nível válido!!");
				validacao = false;
			}
		}while (validacao == false);
		
	}
	
	private void palavraSelecionada() {
		Random rd = new Random();
		palavraSelecionada = palavras.get(rd.nextInt(palavras.size()));

		letras = new char[palavraSelecionada.length()];
		for (int i = 0; i < palavraSelecionada.length(); i++) {
			letras[i] = palavraSelecionada.charAt(i);
		}

		letrasExibidas = new char[palavraSelecionada.length()];
		for (int i = 0; i < palavraSelecionada.length(); i++) {
			letrasExibidas[i] = '_';
		}

	}
	
	private void jogo() {
		int contador = 0;
		int tentativas;

		for (tentativas = 6; tentativas > 0; tentativas--) {

			boolean validacao = false;
			System.out.print("\nDigite uma letra: ");
			char resposta = sc.next().charAt(0);

			for (int j = 0; j <= palavraSelecionada.length() - 1; j++) {

				if (contador == palavraSelecionada.length()) {
					break;
				} else if (resposta == letras[j] && resposta != letrasExibidas[j]) {
					letrasExibidas[j] = resposta;
					contador++;
					validacao = true;
				}

			}

			System.out.println();

			if (contador == palavraSelecionada.length()) {

				System.out.print("A palavra é: " + palavraSelecionada 
							+ "\nParabéns, você acertou a palavra!!");

			} else if (tentativas == 1) {

				System.out.print("A palavra era: " + palavraSelecionada 
							+ "\nVocê perdeu!\nTente Novamente!");
				
			} else {

				for (char le : letrasExibidas) {
					System.out.print(le + " ");
				}

				if (validacao == true) {
					System.out.print("\nRestam " + tentativas + " tentativas\n");
					tentativas++;
				} else {
					System.out.print("\nRestam " + (tentativas - 1) + " tentativas\n");
				}
			}
		}
	}
}

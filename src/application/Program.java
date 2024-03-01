package application;

import java.util.Locale;
import java.util.Scanner;

import Boardgame.Game;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner teclado = new Scanner(System.in);
		char option = ' ';
		int contEmpate = 0;
		int victoryX = 0;
		int victoryO = 0;

		do {
			Game game = new Game();

			do {
				game.showBoard();
				System.out.println("É a vez do Jogador " + game.getPlayer());
				System.out.println("Digite a linha e coluna que deseja jogar: 1 a 3");
				int line = teclado.nextInt() - 1;
				int column = teclado.nextInt() - 1;

				if (game.MakeMove(line, column)) {
					if (game.victory()) {
						game.showBoard();

						System.out.println("Jogador " + game.getPlayer() + " venceu!");
						if (game.getPlayer() == 'x') {
							victoryX++;

						} else if (game.getPlayer() == 'o') {
							victoryO++;
						}
						break;

					} else if (game.fullBoard()) {
						game.showBoard();

						System.out.println("Empate");
						game.showBoard();
						contEmpate = contEmpate + 1;
						break;

					} else {
						game.replacePlayer();
					}
				} else {
					System.out.println("Jogada inválida! Tente novamente.");
					game.showBoard();

				}
			} while (true);
			System.out.println("Deseja jogar mais uma ? S/N ");
			option = teclado.next().charAt(0);
			teclado.nextLine();

		} while (option != 'n' && option != 'N');

		System.out.println("Vitórias do X: " + victoryX);
		System.out.println("Vitórias do O: " + victoryO);

		System.out.println("Numero de empates: " + contEmpate);

		if (victoryX > victoryO) {
			System.out.println("Parabéns ao jogador X");
		} else if (victoryO > victoryX) {
			System.out.println("Parabéns ao jogador O");
		} else {

			System.out.println("Até a proxima");
		}
	}

}

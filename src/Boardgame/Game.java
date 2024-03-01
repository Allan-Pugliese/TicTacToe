package Boardgame;

import java.util.Scanner;

public class Game {

	Scanner teclado = new Scanner(System.in);

	private char[][] board;
	private char player;

	public Game() {
		board = new char[3][3];
		player = 'x';

		StartBoard();
	}

	public char getPlayer() {
		return player;
	}

	public void StartBoard() {

		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				board[l][c] = ' ';
			}
		}

	}

	public void showBoard() {
		System.out.println("  1 2 3");
		for (int l = 0; l < 3; l++) {
			System.out.print((l + 1) + " ");
			for (int c = 0; c < 3; c++) {
				char symbol = (board[l][c] == ' ') ? '-' : board[l][c];
				System.out.print(symbol + " ");
			}
			System.out.println();
		}
	}

	public boolean MakeMove(int line, int column) {
		while (true) {
			if (line >= 0 && line < 3 && column >= 0 && column < 3 && board[line][column] == ' ') {
				board[line][column] = player;
				return true;
			} else {
				System.out.println("Jogada inválida! Tente novamente.");
				System.out.println("Digite a linha e coluna que deseja jogar (1 a 3): ");
				line = teclado.nextInt() - 1;
				column = teclado.nextInt() - 1;
			}
		}
	}

	public boolean fullBoard() {
		for (int l = 0; l < 3; l++) {
			System.out.print(l + " ");
			for (int c = 0; c < 3; c++) {
				if (board[l][c] == ' ') {
					return false;
				}
			}
		}
		return true;

	}

	public boolean victory() {
		for (int l = 0; l < 3; l++) {
			if (board[l][0] == board[l][1] && board[l][1] == board[l][2] && board[l][0] != ' ') {
				return true;
			}
		}
		for (int c = 0; c < 3; c++) {
			if (board[0][c] == board[1][c] && board[1][c] == board[2][c] && board[0][c] != ' ') {
				return true;
			}
		}
		if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
				|| (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
			return true;
		}
		return false;
	}

	public void replacePlayer() {

		player = (player == 'x') ? 'o' : 'x';
	}

}

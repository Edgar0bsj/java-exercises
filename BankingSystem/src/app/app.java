package app;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		// Instanciando dependências
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Variáveis
		int number;
		String name;
		double valorInicial = 0.0;
		// ========================================

		// Inicialização do sistema
		System.out.print("Digite o número da conta: ");
		number = sc.nextInt();
		sc.nextLine();
		System.out.print("Insira o titular da conta: ");
		name = sc.nextLine();
		// ========================================

		// Verificar se deseja por saldo inicial
		System.out.print("Existe um depósito inicial (S/N)? ");
		String resposta = sc.nextLine().trim().toLowerCase();
		if (resposta.equals("s")) {
			System.out.print("Insira o valor do depósito inicial: ");
			valorInicial = sc.nextDouble();
			sc.nextLine();
		} else if (resposta.equals("n")) {
			System.out.println("Saldo inicial de R$0.00");
		} else {
			System.out.println("Erro! -> apenas 'n' ou 'y' ");
		}

		// ========================================
		BankSystem bank = new BankSystem(number, name, valorInicial);
		// ========================================

		clearConsole();
		while (true) {
			System.out.println("========= Menu ======");
			System.out.println("(1) Visualizar Informações");
			System.out.println("(2) Deposito Bancário");
			System.out.println("(3) Saque Bancário");
			System.out.println("(4) Sair da Conta");
			int menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) {
				bank.exibirDados();
				System.out.print("Pressione enter para continuar...");
				sc.nextLine();
				clearConsole();

			} else if (menu == 2) {
				System.out.print("Valor do depósito: ");
				double valor = sc.nextDouble();
				sc.nextLine();
				bank.deposito(valor);
				System.out.print("Pressione enter para continuar...");
				sc.nextLine();
				clearConsole();

			} else if (menu == 3) {
				System.out.print("Valor do Saque: ");
				double valor = sc.nextDouble();
				sc.nextLine();
				bank.saque(valor);
				System.out.print("Pressione enter para continuar...");
				sc.nextLine();
				clearConsole();

			} else if (menu == 4) {
				System.out.println("Saindo da operação");
				clearConsole();
				break;
			}
		}
		System.out.println("Operação encerrada!");

		sc.close();
	}

	public static void clearConsole() {
		{
			try {
				if (System.getProperty("os.name").contains("Windows")) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} else {
					System.out.print("\033[H\033[2J");
					System.out.flush();
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

package app;

public class BankSystem {
	private int numberConta;
	private String name;
	private double valorInicial;
	private double saldo;

	public BankSystem(int numberConta, String name, double saldoInicial) {

		this.numberConta = numberConta;
		this.name = name;
		this.valorInicial = saldoInicial;
		this.saldo = saldoInicial;

	}

	// ========= Gets e Sets ==========
	public double getNumberConta() {
		return numberConta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValorInicial() {
		return valorInicial;
	}

	public double getSaldo() {
		return saldo;
	}
	
	
	// =========== Métodos =============
	public void exibirDados() {
		System.out.println("Número da conta: " + this.numberConta);
		System.out.println("Nome: " + this.name);
		System.out.printf("Saldo Atual: R$%.2f %n", this.saldo);
	}

	public void deposito(double valor) {
		this.saldo += valor;
		System.out.printf("Valor de R$%.2f depositado com sucesso! %n", valor);
	}

	public void saque(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			System.out.printf("Saque de R$%.2f realizado com sucesso! %n", valor);
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

}

package Agencia_Bancaria;

import Utilitarios.Uteis;

public class Conta {
	
	private static int contador_contas = 1; 
	
	private int numeroConta; 
	private Cliente cliente; 
	private double saldo = 0.0;
	
	public Conta(Cliente cliente) {
		this.numeroConta = contador_contas;
		this.cliente = cliente;
		contador_contas = contador_contas + 1; 
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	} 
	
	public String toString( ) {
		return "\nNúmero da conta: " + this.getNumeroConta() + 
				"\nNome: " + this.cliente.getNome() + 
				"\nCPF: " + this.cliente.getCpf() + 
				"\nEmail: " + this.cliente.getEmail() + 
				"\nSaldo: " + Uteis.doubleToString(this.getSaldo()) + "\n"; 		
	}
	
	public void depositar(double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor); 
			System.out.println("\nDepósito realizado com sucesso!"); 
		} else {
			System.out.println("Não foi possível realizar o depósito!"); 
		}
	}
	
	public void sacar(double valor) {
		if((valor > 0) && (this.getSaldo() >= valor)) {
			setSaldo(getSaldo() - valor); 
			System.out.println("\nSaque realizado com sucesso!"); 
		} else {
			System.out.println("\nNão foi possível realizar o saque!"); 
		}
	}
	
	public void transferir(Conta conta_para_deposito, double valor) {
		if((valor > 0 ) && (this.getSaldo() >= valor)) {
			setSaldo(getSaldo() - valor); 
			
			conta_para_deposito.saldo = conta_para_deposito.getSaldo() + valor; 
			System.out.println("\nTransferência realizada com sucesso!"); 
		} else {
			System.out.println("\nNão foi possível realizar a transferência!"); 
		}
	}
}
package Agencia_Bancaria;

import java.util.Scanner; 
import java.util.ArrayList; 

public class main {

	static Scanner entrada = new Scanner(System.in); 
	
	static ArrayList<Conta> contas_bancarias; 
	
	public static void main(String[] args) {
		
		contas_bancarias = new ArrayList<Conta>(); 
		operacoes(); 
	}
	
	public static void operacoes() {
		
		int operacao = 0; 
		
		while((operacao < 1) || (operacao > 6)) {
		
			System.out.println("\n------------------------"); 
			System.out.println("|   AGÊNCIA BANCÁRIA   |"); 
			System.out.println("|                      |"); 
			System.out.println("| 1 - Criar conta      |");  
			System.out.println("| 2 - Depositar        |"); 
			System.out.println("| 3 - Sacar            |"); 
			System.out.println("| 4 - Transferir       |"); 
			System.out.println("| 5 - Listar           |"); 
			System.out.println("| 6 - Sair             |"); 
			System.out.println("|                      |"); 
			System.out.println("------------------------"); 
			System.out.println("Insira uma operação: "); 
			operacao = entrada.nextInt(); 
			
			switch(operacao) {
			
				case 1: 
					criarConta(); 
					break; 
				case 2: 
					depositar();
					break; 
				case 3: 
					sacar(); 
					break; 
				case 4: 
					transferir(); 
					break; 
				case 5: 
					listar(); 
					break; 
				case 6: 
					System.out.println("\nSistema finalizado!"); 
					System.exit(0);
				default: 
					System.out.println("\nOpção inválida!"); 
			}
		}
	}
	
	public static void criarConta() {
		
		String nome; 
		String cpf; 
		String email; 
		
		System.out.print("Primeiro nome: "); 
		nome = entrada.next(); 
		
		System.out.print("CPF: "); 
		cpf = entrada.next(); 
		
		System.out.print("Email: ");
		email = entrada.next(); 
		
		Cliente cliente = new Cliente(nome, cpf, email); 
		
		Conta conta = new Conta(cliente); 
		
		contas_bancarias.add(conta); 
	
		System.out.println("\nConta criada com sucesso!"); 
		operacoes(); 
	}
	
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null; 
		
		if(contas_bancarias.size() > 0) {
			for(Conta c: contas_bancarias) {
				if (c.getNumeroConta() == numeroConta) {
					conta = c; 
				}
			}
		}
		return conta; 
	}
	
	public static void depositar() {
		
		int numero_conta; 
		double valor_deposito; 
		
		System.out.print("Número da conta: "); 
		numero_conta = entrada.nextInt(); 
		
		Conta conta = encontrarConta(numero_conta); 
		
		if(conta != null) {
			System.out.print("Valor para depósito: R$"); 
			valor_deposito = entrada.nextDouble(); 
			conta.depositar(valor_deposito);
			System.out.println("\nValor depositado com sucesso!"); 
		} else {
			System.out.println("\nConta não encontrada!"); 
		}
		operacoes(); 
	}
	
	public static void sacar() {
		
		int numero_conta; 
		double valor_saque; 
		
		System.out.print("Número da conta: "); 
		numero_conta = entrada.nextInt(); 
		
		Conta conta = encontrarConta(numero_conta); 
		
		if(conta != null) {
			System.out.print("Valor para sacar: R$"); 
			valor_saque = entrada.nextDouble(); 
			conta.sacar(valor_saque);
			System.out.println("\nValor sacado com sucesso!"); 
		} else {
			System.out.println("\nConta não encontrada!"); 
		}
		operacoes(); 
	
	}
 
	public static void transferir() {
		
		int conta_remetente;
		int conta_destinataria; 
		double valor; 
		
		System.out.print("Conta remetente:  "); 
		conta_remetente = entrada.nextInt(); 
		
		Conta contaRemetente = encontrarConta(conta_remetente); 
		
		if(contaRemetente != null) {
			System.out.print("Conta destinatária:  "); 
			conta_destinataria = entrada.nextInt();
			
			
			Conta contaDestinatario = encontrarConta(conta_destinataria); 
			
			if(contaDestinatario != null) {
				System.out.print("Valor da transferência: R$"); 
				valor = entrada.nextDouble(); 
				
				contaRemetente.transferir(contaDestinatario, valor);
			} else {
				System.out.println("\nConta não encontrada!"); 
			}
		}
		operacoes(); 	
	}
	
	public static void listar() {
		if (contas_bancarias.size() > 0) {
			for(Conta conta: contas_bancarias) {
				System.out.println(conta); 
			} 
		} else {
				System.out.println("Não há contas cadastradas!"); 
		}
		operacoes(); 	
	}
}
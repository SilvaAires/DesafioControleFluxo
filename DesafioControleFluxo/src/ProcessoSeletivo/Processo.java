package ProcessoSeletivo;

import java.util.*;

public class Processo {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		String nome[] = new String[3];
		int salario[] = new int[3];
		System.out.println("--------Processo seletivo!--------");
		for(int i = 0; i < salario.length; i ++) {
			e = new Scanner(System.in);
			System.out.println("Digite seu nome: ");
			nome[i] = e.nextLine();
			e = new Scanner(System.in);
			System.out.println("Digite sua pretenção de salario: ");
			salario[i] = e.nextInt();
			System.out.println("----------------------");
		}
		for(int i = 0; i < salario.length; i ++) {
			System.out.println("Nome: " + nome[i]);
			System.out.println("Salario: "+ salario[i]);
			analisarCandidato(salario[i]);
			System.out.println("----------------------");
		}
	}
	
	public static void analisarCandidato(double salario) {
		double salarioBase = 2000;
		if(salarioBase > salario) {
			System.out.println("Ligar para o candidato!");
		}else {
			if(salario == salarioBase) {
				System.out.println("Ligar para o candidato com contra proposta!");
			}else {
				System.out.println("Aguardando o resultado dos demais candidatos!");
			}
		}
	}
}

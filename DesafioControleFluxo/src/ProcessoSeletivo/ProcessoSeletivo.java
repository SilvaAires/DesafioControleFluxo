package ProcessoSeletivo;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	static String cand[] = new String[5];
	
	public static void main(String[] args) {
		selecaoCandidatos();
		
		System.out.println();
		for(String aux : cand) {
			if (aux == null || aux.equals("")) {
	            break;
	        }
			entrandoEmContato(aux);
		}
	}
	
	public static void selecaoCandidatos() {
		String candidatos[] = {"Felipe", "Felca", "Maria", "Ana", "Agusto", "Paulo", "Julio", "Cesar", "Helena", "Circe"};
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000;
		
		System.out.println("--------Processo seletivo!--------");
		System.out.println("----------------------------------");
		while((candidatosSelecionados < 5) && (candidatoAtual < candidatos.length)) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			System.out.println("O candidato " + candidato + " solicitou " + salarioPretendido);
			if(salarioBase>=salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado!");
				cand[candidatosSelecionados] = candidato;
				candidatosSelecionados++;
				analisarCandidato(salarioPretendido);
			}
			candidatoAtual++;
			System.out.println("----------------------");
		}
		System.out.println("");
		imprimirSelecionados();
	}
	
	public static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	public static void imprimirSelecionados() {
		System.out.println("Lista de Candidatos Selecionados!");
		for(int i = 0; i < cand.length;i++) {
			if (cand[i] == null || cand[i].equals("")) {
	            break;
	        }
			System.out.println("O candidato de nº " + (i+1) + " nome " + cand[i]);
		}
		System.out.println("----------------------");
		for(String aux : cand) {
			if (aux == null || aux.equals("")) {
	            break;
	        }
			System.out.println(aux);
		}
	}
	
	public static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTetando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTetando = !atendeu;
			if(continuarTetando) {
				tentativasRealizadas ++;
			}else {
				System.out.println("Contato realizado com sucesso!");
			}
		}while(continuarTetando && tentativasRealizadas < 3);
		if(atendeu) {
			System.out.println("Conseguimos contato com " + candidato + " na tentativa" + tentativasRealizadas);
		}else {
			System.out.println("Não conseguimos contato com "+ candidato);
		}
		System.out.println("----------------------");
	}
	
	public static boolean atender() {
		return new Random().nextInt(3)==1;
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

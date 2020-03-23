package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import response.BatalhaResponse;
import response.TurnoResponse;

public class MainCliente {
	
	private TurnoResponse t;
	private ConsumidorServico c;
	private int[] order = new int[] {0,1};
	private String nome;
	private String monstro;
	
	public static void main(String[] args) throws Exception {
		MainCliente m = new MainCliente();
		m.run();
	}
	
	public String selecionaClasse() throws Exception {		
		String classe = "";
		
		System.out.println("Qual classe você quer utilizar?");
		System.out.println("1. Guerreiro");
		System.out.println("2. Barbaro");
		System.out.println("3. Paladino");
		int classeInt = Integer.parseInt(readLine());
		
		switch(classeInt) {
		case 1:
			classe = "Guerreiro";
			break;
		case 2:
			classe = "Barbaro";
			break;
		case 3:
			classe = "Paladino";
			break;
		default:
			throw new Exception("");
		}
		return classe;
	}
	
	public String readLine() throws IOException {
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}
	
	public void waitInput() throws IOException {
		System.out.println("Aperte enter para continuar...");
		readLine();
	}
	
	

	public void run() throws Exception {
			
			System.out.println("Qual o seu nome?");
		               
			nome = readLine();
			
			long score = 0;
			
			boolean jogar = true;
			
			while(jogar) {
			
				c = new ConsumidorServico();
				
				BatalhaResponse b = criarBatalha();
				
				score += JogarBatalha(c, nome, b);
				
				System.out.println("Deseja jogar novamente?(Use S para Sim ou N para Não)");
				
				Boolean resp = null;
				
				while(resp == null) {
					String resposta = readLine();
					if(resposta.toLowerCase().startsWith("n")) {
						resp = false;
					} else if (resposta.toLowerCase().startsWith("s")) {
						resp = true;
					} else {
						System.out.println("Deseja jogar novamente?(Por favor, use S para Sim ou N para Não)");
					}
				}
				
				jogar = resp;
			}
			
			System.out.println("Obrigado por jogar conosco!");
			
	}

	private int JogarBatalha(ConsumidorServico c, String nome, BatalhaResponse b) throws Exception {
		monstro =  b.getParticipantes()[1].getNome();
		
		System.out.println("Você enfrenta o "+ monstro + "!");
		
		System.out.println("A batalha se inicia com " + nome + " tendo " + b.getParticipantes()[0].getPdv() + " de vida,");
		System.out.println("e com " + monstro + " tendo " + b.getParticipantes()[1].getPdv() + " de vida.");
		
		
		String[] nomes = new String[] {nome, monstro};
		t = null;
		do {
			rolarTurno(b.getId(), nomes);
		} while(t.getPdvFinal()[0] > 0 && t.getPdvFinal()[1] > 0);
		
		b = c.recuperaBatalha(b.getId());
		
		return b.getRanking();
	}

	private void rolarTurno(long id, String[] nomes) throws Exception {
		t = c.criaTurno(Entity.entity(new CreateTurnRequest(), MediaType.APPLICATION_JSON), id);
		if(t.getIniciativas()[0] < t.getIniciativas()[1]) {
			order = new int[] {1,0}; 
		} else {
			order = new int[] {0,1};
		}
		
		waitInput();
		for(int i = 0; i < 2; i++) {
			int index = order[i];
			System.out.println(nomes[index] + " ataca!");
			waitInput();
			int dano = t.getDanos()[index];
			if(dano == 0) {
				System.out.println(nomes[1-index] + " se esquiva do ataque!");
			} else {
				System.out.println(nomes[1-index] + " perde " + dano + " pontos de vida!");
			}
			waitInput();
		}
		if(t.getPdvFinal()[0] > 0) {
			System.out.println("O turno termina com " + nome + " tendo " + t.getPdvFinal()[0] + " de vida,");
		} else {
			System.out.println("O turno termina com " + nome + " morto,");
		}
		if(t.getPdvFinal()[1] > 0) {
			System.out.println("e com " + monstro + " tendo " + t.getPdvFinal()[1] + " de vida.");
		} else {
			System.out.println("e com " + monstro + " morto!");
		}
		
	}

	private BatalhaResponse criarBatalha() throws Exception {
		String classe = null;
		while(classe == null) {
			try {
				classe = selecionaClasse();
			} catch(Exception e) {
				System.out.println("Por favor selecione um número entre os apresentados");
			}
		}
	
		
		return c.criaBatalha(Entity.entity(new CreateBattleRequest(nome, classe), MediaType.APPLICATION_JSON));
	}

}

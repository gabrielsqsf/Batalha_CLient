package response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import personagem.Personagem;

public class BatalhaResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private long id;
	@JsonProperty("nickname")
	private String nickname;
	@JsonProperty("participantes")
	private Personagem[] participantes;
	@JsonProperty("turnos")
	private TurnoResponse[] turnos;
	@JsonProperty("terminada")
	private boolean terminada;
	@JsonProperty("ranking")
	private int ranking;
	
	public BatalhaResponse() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Personagem[] getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Personagem[] participantes) {
		this.participantes = participantes;
	}

	public TurnoResponse[] getTurnos() {
		return turnos;
	}

	public void setTurnos(TurnoResponse[] turnos) {
		this.turnos = turnos;
	}

	public boolean isTerminada() {
		return terminada;
	}

	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	
}

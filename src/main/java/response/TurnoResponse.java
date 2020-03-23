package response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TurnoResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("index")
	private int index;
	@JsonProperty("iniciativas")
	private int[] iniciativas;
	@JsonProperty("ataques")
	private int[] ataques;
	@JsonProperty("defesas")
	private int[] defesas;
	@JsonProperty("danos")
	private int[] danos;
	@JsonProperty("pdvInicial")
	private int[] pdvInicial;
	@JsonProperty("pdvFinal")
	private int[] pdvFinal;
	
	public TurnoResponse() {
		
	}
	
	public TurnoResponse(int index, int[] iniciativas, int[] ataques, int[] defesas, int[] danos, int[] pdvInicial,
			int[] pdvFinal) {
		super();
		this.index = index;
		this.iniciativas = iniciativas;
		this.ataques = ataques;
		this.defesas = defesas;
		this.danos = danos;
		this.pdvInicial = pdvInicial;
		this.pdvFinal = pdvFinal;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int[] getIniciativas() {
		return iniciativas;
	}

	public void setIniciativas(int[] iniciativas) {
		this.iniciativas = iniciativas;
	}

	public int[] getAtaques() {
		return ataques;
	}

	public void setAtaques(int[] ataques) {
		this.ataques = ataques;
	}

	public int[] getDefesas() {
		return defesas;
	}

	public void setDefesas(int[] defesas) {
		this.defesas = defesas;
	}

	public int[] getDanos() {
		return danos;
	}

	public void setDanos(int[] danos) {
		this.danos = danos;
	}

	public int[] getPdvInicial() {
		return pdvInicial;
	}

	public int[] getPdvFinal() {
		return pdvFinal;
	}

	public void setPdvFinal(int[] pdvFinal) {
		this.pdvFinal = pdvFinal;
	}
}

package cliente;

import java.io.Serializable;

public class CreateBattleRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nickname;
	String classe;
		
	public CreateBattleRequest(String nickname, String classe) {
		super();
		this.nickname = nickname;
		this.classe = classe;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
}

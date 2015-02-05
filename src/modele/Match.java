package modele;

public class Match {
	
	private Equipe eq1;
	private Equipe eq2;
	private int scoreEq1;
	private int scoreEq2;
	
	public Match(Equipe eq1, Equipe eq2) {
		super();
		this.eq1 = eq1;
		this.eq2 = eq2;
	}

	public Equipe getEq1() {
		return eq1;
	}
	public void setEq1(Equipe eq1) {
		this.eq1 = eq1;
	}
	public Equipe getEq2() {
		return eq2;
	}
	public void setEq2(Equipe eq2) {
		this.eq2 = eq2;
	}
	public int getScoreEq1() {
		return scoreEq1;
	}
	public void setScoreEq1(int scoreEq1) {
		this.scoreEq1 = scoreEq1;
	}
	public int getScoreEq2() {
		return scoreEq2;
	}
	public void setScoreEq2(int scoreEq2) {
		this.scoreEq2 = scoreEq2;
	}
	public String getNomEq1(){
		return eq1.getNom();		
	}
	public String getNomEq2(){
		return eq2.getNom();
	}
	public Equipe getWinner() {
		if(!eq1.isElimine()) {
			return eq1;
		}
		else if (!eq2.isElimine()) {
			return eq2;
		}
		else {
			return null;
		}
	}

	

}

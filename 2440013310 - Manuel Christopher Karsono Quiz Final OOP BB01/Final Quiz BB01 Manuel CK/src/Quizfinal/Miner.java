package Quizfinal;

public class Miner extends Worker{
		private int ore;
	public int getOre() {
			return ore;
		}
		public void setOre(int ore) {
			this.ore = ore;
		}
	public Miner(String name, String job, String ID, int ore) {
		super(name, job, ID);
		this.ore = ore;
	}
	
}

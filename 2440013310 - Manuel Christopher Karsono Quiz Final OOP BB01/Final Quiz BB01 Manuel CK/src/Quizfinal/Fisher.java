package Quizfinal;

public class Fisher extends Worker{
		private int Fish;
	public int getFish() {
			return Fish;
		}
		public void setFish(int fish) {
			Fish = fish;
		}
	public Fisher(String name, String job, String ID, int Fish) {
		super(name, job, ID);
		this.Fish = Fish;
		
	}

}

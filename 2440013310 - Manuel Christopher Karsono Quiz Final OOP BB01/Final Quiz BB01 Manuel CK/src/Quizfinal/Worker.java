package Quizfinal;

public  class Worker {
		protected String name;
		protected String job;
		protected String ID;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public Worker(String name, String job, String ID) {
			super();
			this.name = name;
			this.job = job;
			this.ID = ID;
		}
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		
		
}

package Wod;

public class Movement {
	private String name; // Movement 이름
	private int rep; // 반복 횟수
	private int weight; // 무게
	private double score; // rep*weight


	public Movement() {} // 기본 생성자
	
	
	
	public Movement(String Name,int Rep,int Weight, double Score) {
		this.name = Name;
		this.rep = Rep;
		this.weight = Weight;
		set_score();
	}
	
	
	public void set_name(int index) {
		Data_Movement data = new Data_Movement();
		if(range(0,index,data.get_Data_length())) {
			this.name = data.get_movement(index);
		}
		
		// index가 movement의 내용을 넘었을 경우
		else {}
	}
	
	
	public void set_rep(int input) {
		this.rep = input;
		set_score();
	}
	
	public void set_weight(int input) {
		this.weight = input;
		set_score();
		
	}
	
	public void set_score() {
		
		if(this.weight == 0)
			this.score = rep;
		else
			this.score = this.rep*this.weight;
	}
	
	
	public String output_name() {
		return this.name;
		
	}
	
	public int output_rep() {
		return this.rep;
		
	}
	public int output_weight() {
		return this.weight;
		
	}
	public double output_score() {
		return this.score;
		
	}
	

	public boolean range(int Min, int input,int Max) {
		if(input <= Max) {
			if(input >= Min) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}

package project;

public class Movement {
    private String movementname;
    private  int movementnum;
    private  int weight;
    private  int difficultscore;

    public Movement(String a,int b,int c,int d){ //
    	setMovementname(a);
    	setMovementnum(b);        
        setDifficultscore(c);
        setWeight(d);
    }
    
    public Movement(String a,int move_weight,int Reps){ //
    	setMovementname(a);
    	setMovementnum(Reps);
    	setDifficultscore(move_weight);
    	setWeight(move_weight); 
    	
    }

    public Movement(){
        setDifficultscore(0);
        setMovementname("Test");
        setDifficultscore(0);
        setWeight(0);

    }





    public void setDifficultscore(int difficultscore) {
        this.difficultscore = difficultscore;
    }

    public void setMovementname(String movementname) {
        this.movementname = movementname;
    }

    public void setMovementnum(int movementnum) {
        this.movementnum = movementnum;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMovementnum() {
        return movementnum;
    }

    public String getMovementname() {
        return movementname;
    }

    public int getDifficultscore() {
        return difficultscore;
    }

    public int getWeight() {
        return weight;
    }
}



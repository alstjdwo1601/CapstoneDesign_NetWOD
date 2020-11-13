package com.example.netwod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class WOD{
    private String WODname;//ex) FRAN,고성주의 와드
    private String WODlevel;
    private String WODtype; //포타임, 암랩 등등
    //데드21,월볼21 + 데드15,월볼15 와드 예시
    private ArrayList<String> movement;//{데드,월볼,데드,월볼,데드,월볼}
    private ArrayList<String> movementnum;//={21,21,21,15,15,15};
    private ArrayList<String> weightlist;//각각 무게
    private ArrayList<String> equipment;// 사용한 기구
    private Wod_function wodData;

    public WOD(){
        wodData = new Wod_function();  // 기존에 만들어 놓은 wod 형식
        this.movement=wodData.getMovement();
        this.movementnum=wodData.getMovementnum();
        this.weightlist=wodData.getWeightlist();
        this.equipment=wodData.getEquipment();
    }

    // 이름 받을 떄
    public WOD(String name){
        this.WODname = name;
        wodData = new Wod_function();  // 기존에 만들어 놓은 wod 형식
        this.movement=wodData.getMovement();
        this.movementnum=wodData.getMovementnum();
        this.weightlist=wodData.getWeightlist();
        this.equipment=wodData.getEquipment();
    }
    public WOD(UserInfo info) {
        wodData = new Wod_function(info);


        this.movement=wodData.getMovement();
        this.movementnum=wodData.getMovementnum();
        this.weightlist=wodData.getWeightlist();
        this.equipment=wodData.getEquipment();
    }


    public WOD(UserInfo info,String type) {
        wodData = new Wod_function(info,type);

        this.setWODtype(type);
        this.movement=wodData.getMovement();
        this.movementnum=wodData.getMovementnum();
        this.weightlist=wodData.getWeightlist();
        this.equipment=wodData.getEquipment();
    }


    // 이름 레벨
    public WOD(String name,String level){
        this.WODname =name;
        wodData = new Wod_function();  // 기존에 만들어 놓은 wod 형식
        this.movement=wodData.getMovement();
        this.movementnum=wodData.getMovementnum();
        this.weightlist=wodData.getWeightlist();
        this.equipment=wodData.getEquipment();
    }





    public String getWODlevel() {
        return WODlevel;
    }

    public void setWODlevel(String WODlevel) {
        this.WODlevel = WODlevel;
    }

    public String getWODname() {
        return WODname;
    }

    public void setWODname(String WODname) {
        this.WODname = WODname;
    }

    public String getWODtype() {
        return WODtype;
    }

    public void setWODtype(String WODtype) {
        this.WODtype = WODtype;
    }

    public ArrayList<String> getMovement() {
        return movement;
    }

    public void setMovement(ArrayList<String> movement) {
        this.movement = movement;
    }

    public ArrayList<String> getMovementnum() {
        return movementnum;
    }

    public void setMovementnum(ArrayList<String> movementnum) {
        this.movementnum = movementnum;
    }

    public ArrayList<String> getWeightlist() {
        return weightlist;
    }

    public void setWeightlist(ArrayList<String> weightlist) {
        this.weightlist = weightlist;
    }

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipment = equipment;
    }



}


































class WODrecord{
    public ArrayList<WOD> wodlist; //{프란,신디,민성재,김정훈}
    public ArrayList<String> scorelist; //{"70","80","75","60"}
    public ArrayList<String> recordlist; //{"4:32","3:53","2:10","6:34"}


    public WODrecord(){
        wodlist=new ArrayList<WOD>();
        scorelist=new ArrayList<String>();
        recordlist=new ArrayList<String>();

    }

    public ArrayList<WOD> getWodlist() {
        return wodlist;
    }

    public void setWodlist(ArrayList<WOD> wodlist) {
        this.wodlist = wodlist;
    }

    public ArrayList<String> getScorelist() {
        return scorelist;
    }

    public void setScorelist(ArrayList<String> scorelist) {
        this.scorelist = scorelist;
    }

    public ArrayList<String> getRecordlist() {
        return recordlist;
    }

    public void setRecordlist(ArrayList<String> recordlist) {
        this.recordlist = recordlist;
    }


}


















class UserInfo {

    public WODrecord wodrecord; //템플릿에 있는 개인이 실제로 한 기록
    public ArrayList<WOD> userwodlist; //와드 선택할때 리스트(뭐 할지 고를지)

    private String UserName;
    private String UserAge;
    private String UserWeight;
    private String UserHeight;
    private String User_NumOfTraining;

    public int getCurrentwodindex() {
        return currentwodindex;
    }

    public void setCurrentwodindex(int currentwodindex) {
        this.currentwodindex = currentwodindex;
    }

    private int currentwodindex=0;
    public UserInfo(){
        this.wodrecord=new WODrecord(); //템플릿에 있는 개인이 실제로 한 기록
        this.userwodlist=new ArrayList<WOD>(); //와드 선택할때 리스트(뭐 할지 고를지)

    }


    //운동 기구가 있는지 없는지
    private boolean Dumbbell;
    private boolean Body;
    private boolean Kettlebell;
    private boolean Barbell;
    private boolean WallBall;
    private boolean Box;
    private boolean Jumprope;
    private boolean PullUpBar;


    //개인 평균 스코어
    private String avg_WODlevel;
    private String avg_round_reps;
    private String avg_time;
    private String avg_score;
    private String avg_time_amrep;

    public String getAvg_time_amrep() {
        return avg_time_amrep;
    }

    public void setAvg_time_amrep(String avg_time_amrep) {
        this.avg_time_amrep = avg_time_amrep;
    }

    public String getAvg_WODlevel() { return avg_WODlevel; }

    public void setAvg_WODlevel(String avg_WODlevel) { this.avg_WODlevel = avg_WODlevel; }

    public String getAvg_round_reps() { return avg_round_reps; }

    public void setAvg_round_reps(String avg_round_reps) { this.avg_round_reps = avg_round_reps; }

    public String getAvg_time() { return avg_time; }

    public void setAvg_time(String avg_time) { this.avg_time = avg_time; }

    public String getAvg_score() { return avg_score; }

    public void setAvg_score(String avg_score) { this.avg_score = avg_score; }



    public WODrecord getWodrecord() {
        return wodrecord;
    }

    public void setWodrecord(WODrecord wodrecord) {
        this.wodrecord = wodrecord;
    }

    public ArrayList<WOD> getUserwodlist() {
        return userwodlist;
    }

    public void setUserwodlist(ArrayList<WOD> userwodlist) {
        this.userwodlist = userwodlist;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserAge() {
        return UserAge;
    }

    public void setUserAge(String userAge) {
        UserAge = userAge;
    }

    public String getUserWeight() {
        return UserWeight;
    }

    public void setUserWeight(String userWeight) {
        UserWeight = userWeight;
    }

    public String getUserHeight() {
        return UserHeight;
    }

    public void setUserHeight(String userHeight) {
        UserHeight = userHeight;
    }

    public String getUser_NumOfTraining() {
        return User_NumOfTraining;
    }

    public void setUser_NumOfTraining(String user_NumOfTraining) {
        User_NumOfTraining = user_NumOfTraining;
    }

    public boolean isDumbbell() {
        return Dumbbell;
    }

    public void setDumbbell(boolean dumbbell) {
        Dumbbell = dumbbell;
    }

    public boolean isBody() {
        return Body;
    }

    public void setBody(boolean body) {
        Body = body;
    }

    public boolean isKettlebell() {
        return Kettlebell;
    }

    public void setKettlebell(boolean kettlebell) {
        Kettlebell = kettlebell;
    }

    public boolean isBarbell() {
        return Barbell;
    }

    public void setBarbell(boolean barbell) {
        Barbell = barbell;
    }

    public boolean isWallBall() {
        return WallBall;
    }

    public void setWallBall(boolean wallBall) {
        WallBall = wallBall;
    }

    public boolean isBox() {
        return Box;
    }

    public void setBox(boolean box) {
        Box = box;
    }

    public boolean isJumprope() {
        return Jumprope;
    }

    public void setJumprope(boolean jumprope) {
        Jumprope = jumprope;
    }

    public boolean isPullUpBar() {
        return PullUpBar;
    }

    public void setPullUpBar(boolean pullUpBar) {
        PullUpBar = pullUpBar;
    }

}





























class Wod_manager{
    private Wod_function wod;
    private int basic_time = 0;


    //수정 할 wod 를 받는 부분
    public Wod_manager(Wod_function wod) {
        this.wod = wod;
    }


    //여기 날려도 뭐 달라질껀 없을듯.

    public ArrayList<String> stimulation() {
        Wod_Algorithm algorithm = new Wod_Algorithm();
        return algorithm.stimulation();
    }

    // algorithm FORTIME 생성 , {movement의 개수 , 각 rep을 반복}
    public void FORTIME(ArrayList<String> movements) {
        Data_Wod wod_data = new Data_Wod();
        Data_Movement movement_data = new Data_Movement();
        int[] algorithm = wod_data.Data_type("FORTIME", movements.size());
        for(int j =0 ; j < algorithm.length -1; j++) {
            for(int i = 0; i < algorithm[0]; i++) {
                int index = movement_data.get_index(movements.get(i));
                Movement movement = new Movement(index);
                movement.set_rep((int)(movement.get_rep()*algorithm[1+j]/15));
                this.wod.set_movement_add(movement);
            }
        }
    }





    // AMRAP 생성 {movement의 개수 , 각 rep , time}  time 값은 wod.manager.get_time()
    public void AMRAP(ArrayList<String> movements) {
        Data_Wod wod_data = new Data_Wod();
        Data_Movement movement_data = new Data_Movement();
        int[] algorithm = wod_data.Data_type("AMRAP", movements.size());
        for(int i = 0 ; i < algorithm[0]; i++ ) {
            int index = movement_data.get_index(movements.get(i));
            Movement movement = new Movement(index);
            movement.set_rep((int)(movement.get_rep()*algorithm[i+1]/15));
            this.wod.set_movement_add(movement);
        }
        this.basic_time = algorithm[algorithm.length-1];
    }


    public int get_time() {
        return basic_time; // AMRAP 시 시간을 알려줌
    }





}






















class Wod_function {


    private String name;
    private String level;  //
    private ArrayList<Movement> movement_list = new ArrayList<Movement>();
    private String type;
    private Wod_manager manager = new Wod_manager(this);
    private Wod_Algorithm algorithm= new Wod_Algorithm();
    // 추천 와드 생성하기 AMRAP
    public Wod_function(){

    }

    public Wod_function(UserInfo info) {
        this.name = "WOD";
        this.setWODtype("FORTIME");
        ArrayList<String> movement_recommend = algorithm.stimulation(algorithm.equipment(info));
        this.manager.FORTIME(movement_recommend);

    }


    public Wod_function(UserInfo info,String type) {
        this.name = "WOD";
        if(type.equals("FORTIME")) {
            this.setWODtype("FORTIME");
            ArrayList<String> movement_recommend = algorithm.stimulation(algorithm.equipment(info));
            this.manager.FORTIME(movement_recommend);
        }
        else if(type.equals("AMRAP")){
            this.setWODtype("AMRAP");
            ArrayList<String> movement_recommend = algorithm.stimulation(algorithm.equipment(info));
            this.manager.AMRAP(movement_recommend);
        }
    }


    ////////////////// Movement / Equipment / Movementnum /Weightlist 얻는 부분 //////////////////////
    public ArrayList<String> getMovement(){
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < movement_list.size(); i++) {
            output.add(this.movement_list.get(i).get_name());
        }
        return output;
    }


    public ArrayList<String> getEquipment(){
        Data_Movement data = new Data_Movement();
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < movement_list.size(); i++) {
            String name = data.get_equipment(data.get_index(this.movement_list.get(i).get_name()));
            output.add(name);
        }
        return output;
    }


    public ArrayList<String> getMovementnum(){
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < movement_list.size(); i++) {
            output.add(Integer.toString(this.movement_list.get(i).get_rep()));

        }
        return output;
    }
    public ArrayList<String> getWeightlist(){
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < movement_list.size(); i++) {
            output.add(Integer.toString((int)this.movement_list.get(i).get_weight()));

        }
        return output;
    }





    public Wod_manager manage_wod() {
        return this.manager;
    }

    public ArrayList<Movement> get_movement_Arraylist(){
        return this.movement_list;
    }

    // 정보를 저장하는 부분분
    public void setWODname(String input) {
        this.name = input;
    }
    public void setWODtype(String input) {
        this.type = input;
    }
    public void setWODlevel(String input) {
        this.level = input;
    }

    public String getWODname() {
        return this.name;
    }
    public String getWODtype() {
        return this.type;
    }
    public String getWODlevel() {
        return this.level;
    }



    public void set_movement_add(Movement input) {
        this.movement_list.add(input);
    }
    public void set_movement_remove(int index) {
        this.movement_list.remove(index);
    }
}




























class Data_Movement {
    private ArrayList<String> movement = new ArrayList<String>();
    private ArrayList<String> equipment = new ArrayList<String>();
    private ArrayList<int[]> exercise_area = new ArrayList<int[]>();
    private ArrayList<Integer> stimulation = new ArrayList<Integer>(); // 0 = 체조 , 1 = 메타볼릭컨디셔닝 , 2 = 역도
    private ArrayList<Double> score = new ArrayList<Double>();
    private ArrayList<Double> weight = new ArrayList<Double>();
    private ArrayList<Integer> rep = new ArrayList<Integer>();
    private ArrayList<String> equipment_list = new ArrayList<String>();



    // 데이터를 바로 읽어서 넘기는 장면
    // T는 추후에 오류가 생기면 이벤트리스너로 넘기면 된다 (오류가 있으면 F) .

    public Data_Movement() {
        Read_movement Data = new Read_movement();
        input_Data_Movement(Data.movement,Data.equipment,Data.exercise_area,Data.stimulate,Data.score,Data.weight,Data.rep);
    }




    // equipment 종류를 읽는 작업
    public void input_equipment_list(String[] input) {
        this.equipment_list = new ArrayList<>(Arrays.asList(input));
    }



    // input_Data_Movement  데이터를 읽었을 때 하나 씩 넣는 부분
    public boolean input_Data_Movement(String name,String equipment, int[] exercise_area,int stimulation ,double score,double weight,int rep) {
        this.movement.add(name);
        this.equipment.add(equipment);
        this.exercise_area.add(exercise_area);
        this.stimulation.add(stimulation);
        this.score.add(score);
        this.weight.add(weight);
        this.rep.add(rep);
        return true;

    }



    // input_Data_Movement 데이터 배열로 읽었을 때 넣는 부분
    public boolean input_Data_Movement(String[] name,String[] equipment, ArrayList<int[]> exercise_area,int[] stimulation ,double[] score,double[] weight,int[] rep) {
        for(int i = 0 ; i< name.length; i++) {
            input_Data_Movement(name[i], equipment[i], exercise_area.get(i),stimulation[i], score[i],weight[i],rep[i]);
        }
        return true;

    }








    // 수정
    public int search_movement_index(String name){
        for (int i = 0 ; i < this.movement.size(); i++) {
            if(this.movement.get(i).equals(name)){
                return i;
            }
        }
        return -1;
    }



    public ArrayList<String> get_equipment_list() {
        return this.equipment_list;
    }


    public int get_index(String movement) {
        for(int i = 0 ; i < this.movement.size(); i++) {
            if(movement.equals(this.movement.get(i))) {
                return i;
            }

        }
        return -1;
    }





    public String get_movement(int index) {
        return this.movement.get(index);
    }
    public ArrayList<String> get_movement() {
        return this.movement;
    }



    public ArrayList<String> get_equipment(){
        return this.equipment;
    }
    public String get_equipment(int index) {
        return this.equipment.get(index);
    }


    public ArrayList<int[]> get_exercise(){
        return this.exercise_area;
    }
    public int[] get_exercise_area(int index) {
        return this.exercise_area.get(index);
    }




    public ArrayList<Integer> get_stimulation(){
        return this.stimulation;
    }
    public int get_stimulation(int index) {
        return this.stimulation.get(index);
    }



    public ArrayList<Double> get_score(){
        return this.score;
    }
    public double get_score(int index) {
        return this.score.get(index);
    }



    public ArrayList<Integer> get_rep(){
        return this.rep;
    }
    public int get_rep(int index) {
        return this.rep.get(index);
    }


    public ArrayList<Double> get_weight(){
        return this.weight;
    }
    public double get_weight(int index) {
        return this.weight.get(index);
    }


    public int get_Data_length() {
        return this.movement.size();
    }


    //어디에 저장할지 정하지 않음 위에 함수 다 정의해둬서 바로바로 for문으로 10초면 저장함
    public void output_Data_Movement() {

    }
}























class Data_Wod {
    private ArrayList<int[]> FORTIME = new ArrayList<int[]>();
    private ArrayList<int[]> AMRAP = new ArrayList<int[]>();
    // FORTIME
    // 형식 맨 앞 운동의 갯수 , 반복할 횟수
    // 2 21 15 9  45
    // -> 21 21 15 15 9 9 의 비율
    // 1 -> 30
    // 2 -> 15  * 2
    // 3 -> 10  * 3


    // 1 30    30
    // 2 10 : 5
    // 2 21 : 15 : 9
    // 2 5 : 5 : 5
    // 3 5 : 3 : 2
    // 3 3 : 3 : 3


    // AMRAP

    public Data_Wod() {
        // FORTIME
        int[] input = {1,30};
        this.add_FORTIME(input);
        input = new int[] {2,10,5};
        this.add_FORTIME(input);
        input = new int[] {2,7,5,3};
        this.add_FORTIME(input);
        input = new int[] {2,5,5,5};
        this.add_FORTIME(input);
        input = new int[] {3,5,3,2};
        this.add_FORTIME(input);
        input = new int[] {3,3,3,3};
        this.add_FORTIME(input);

        //amrap
        // first = movement kind , 2 ~ n-1 = movement_count , last = time(min)
        input = new int[] {1 , 1, 10};
        this.add_AMRAP(input);
        input = new int[] {2 , 1,1, 10};
        this.add_AMRAP(input);
        input = new int[] {3 , 1,1,1, 10};
        this.add_AMRAP(input);
    }

    // 추후수정
    public int[] Data_type(String input,int movement_num){
        ArrayList<Integer> save = new ArrayList<Integer>();
        Random rand = new Random();
        if(input.equals("FORTIME")) {
            for(int i = 0 ; i < FORTIME.size(); i++) {
                if(FORTIME.get(i)[0] == movement_num ) {
                    save.add(i);
                }
            }
            return this.FORTIME.get(save.get(rand.nextInt(save.size())));


        }



        if(input.equals("AMRAP")) {
            for(int i = 0; i < AMRAP.size(); i++) {
                if(AMRAP.get(i)[0] == movement_num) {
                    save.add(i);
                }

            }
            return this.AMRAP.get(save.get(rand.nextInt(save.size())));
        }

        return null;

    }
    public void add_FORTIME(int[] input) {
        this.FORTIME.add(input);
    }

    public void add_AMRAP(int[] input) {
        this.AMRAP.add(input);
    }




}































class Movement {
    private String name; // Movement 이름
    private String equipment; // equipment 이름
    private int rep; // 반복 횟수
    private double weight; // 무게
    private double score; // rep*weight


    public Movement() {} // 기본 생성자
    public Movement(int index) {
        Data_Movement data = new Data_Movement();
        if(range(0,index,data.get_Data_length())){
            this.name = data.get_movement(index);
            this.equipment = data.get_equipment(index);
            this.rep = data.get_rep(index);
            this.weight = data.get_weight(index);
            this.score = get_score();
        }
        else {
            this.name = "error / Read_movement  /out of range";
        }

    }



    public Movement(String Name,String Equipment,int Rep,double Weight) {
        this.name = Name;
        this.equipment = Equipment;
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

    public void set_equipment(int index) {
        Data_Movement data = new Data_Movement();
        if(range(0,index,data.get_Data_length())) {
            this.equipment = data.get_equipment(index);
        }

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


    public String get_name() {
        return this.name;

    }
    public String get_equipement() {
        return this.equipment;
    }

    public int get_rep() {
        return this.rep;

    }
    public double get_weight() {
        return this.weight;

    }
    public double get_score() {
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

























class Read_movement {
    ArrayList<int[]> exercise_area = new ArrayList<int[]>();



    String[] movement = {"air squat",
            "pull up",
            "push up",
            "dips",
            "handstand push up",
            "rope climb",
            "muscle up",
            "handstand press",
            "back extension",
            "sit up",
            "jump",
            "runge",
            "run",
            "bicycle",
            "rowing",
            "jump rope",
            "dead lift",
            "clean",
            "bench press",
            "snatch",
            "clean and jerk",
            "medicine ball",
            "kettlebell swing",
            "Bench dips",
            "thruster"};

    String[] equipment = {
            "Body",
            "PullUpBar",
            "Body",
            "PullUpBar",
            "Body",
            "Body",
            "PullUpBar",
            "Dumbbell",
            "Body",
            "Body",
            "Body",
            "Body",
            "Body",
            "Body",
            "Body",
            "Jumprope",
            "Barbell",
            "Barbell",
            "Barbell",
            "Barbell",
            "Barbell",
            "WallBall",
            "kettlebell",
            "Body",
            "Barbell"};

    int[][] exercise_area_double = {
            {0,0,0,0,0,0,3,10},
            {5,3,0,10,0,5,0,0},
            {5,7,5,10,0,0,0,0},
            {5,7,5,10,0,0,0,0},
            {10,10,10,0,0,0,0,0},
            {10,0,0,10,0,5,5,0},
            {10,10,7,10,0,5,0,0},
            {10,10,10,0,0,0,0,0},
            {0,0,0,0,0,3,10,0},
            {0,0,0,0,0,0,3,10},
            {0,0,0,0,0,0,10,10},
            {0,0,0,0,0,0,10,10},
            {0,0,0,0,0,0,10,10},
            {0,0,0,0,0,0,10,10},
            {10,10,0,10,0,10,10,10},
            {0,0,0,0,0,0,10,10},
            {10,0,0,10,0,10,10,10},
            {10,10,10,5,5,10,10,5},
            {10,10,10,0,10,0,7,0},
            {10,3,10,5,0,10,10,10},
            {10,10,10,10,0,10,10,10},
            {10,10,10,10,10,10,10,10},
            {5,7,10,3,3,7,10,3},
            {5,7,5,10,0,0,0,0},
            {10,10,10,10,5,10,10,10},

    };

    int[] stimulate = {0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            1,
            1,
            1,
            1,
            2,
            2,
            2,
            2,
            2,
            2,
            2,
            1,
            2


    };

    double[] score = {
            0,
            2,
            1,
            2,
            2,
            2,
            3,
            2,
            0,
            0,
            0,
            0,
            0,
            0,
            2,
            0,
            2,
            3,
            3,
            3,
            3,
            1,
            2,
            0,
            3

    };

    double[] weight = {
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            100,
            60,
            60,
            60,
            55,
            10,
            30,
            0,
            40,
            0,


    };

    int[] rep = {
            100,
            20,
            100,
            20,
            20,
            3,
            10,
            50,
            25,
            100,
            100,
            100,
            800,
            1500,
            650,
            300,
            10,
            20,
            10,
            20,
            10,
            50,
            20,
            20,
            20,
            180

    };

    Read_movement(){
        for(int i = 0; i < movement.length; i++){
            this.exercise_area.add(this.exercise_area_double[i]);
        }

    }
}




















class Wod_Algorithm {

    // 두개로 분류 해보자 -> equipment 부분
    // equipment 를 분류해서 movement 추출하기?

    //userinfo에서 데이터 받아서 분류
    public ArrayList<Movement> equipment(UserInfo info) {
        ArrayList<Movement> output = new ArrayList<Movement>();
        if(info.isBarbell()) {
            output.addAll(equipment("Barbell"));
        }
        if(info.isBody()) {
            output.addAll(equipment("Body"));
        }
        if(info.isBox()) {
            output.addAll(equipment("Box"));

        }
        if(info.isDumbbell()) {
            output.addAll(equipment("Dumbell"));

        }
        if(info.isJumprope()) {
            output.addAll(equipment("Jumprope"));

        }
        if(info.isKettlebell()) {
            output.addAll(equipment("Kettlebell"));

        }
        if(info.isPullUpBar()) {
            output.addAll(equipment("isPullUpBar"));

        }
        if(info.isWallBall()) {
            output.addAll(equipment("isWallBall"));
        }




        return output;

    }


    //혹시 나중에 2차 검열 필요할 때 사용할 것.
    public ArrayList<Movement> equipment(UserInfo info,ArrayList<Movement> movement){
        ArrayList<Movement> output = new ArrayList<Movement>();
        if(info.isBarbell()) {
            output.addAll(equipment("Barbell",movement));
        }
        if(info.isBody()) {
            output.addAll(equipment("Body",movement));
        }
        if(info.isBox()) {
            output.addAll(equipment("Box",movement));

        }
        if(info.isDumbbell()) {
            output.addAll(equipment("Dumbell",movement));

        }
        if(info.isJumprope()) {
            output.addAll(equipment("Jumprope",movement));

        }
        if(info.isKettlebell()) {
            output.addAll(equipment("Kettlebell",movement));

        }
        if(info.isPullUpBar()) {
            output.addAll(equipment("isPullUpBar",movement));

        }
        if(info.isWallBall()) {
            output.addAll(equipment("isWallBall",movement));
        }
        return output;
    }





    // equipement 이름으로 분류
    public ArrayList<Movement> equipment(String equipment){
        Data_Movement data = new Data_Movement();
        ArrayList<Movement> output = new ArrayList<Movement>();
        for(int i = 0; i <data.get_Data_length(); i++ ) {  // 읽은 데이터 전부를 인덱싱
            if(equipment.equals(data.get_equipment(i))) {  // 읽은 movement의 equipement와 같다면
                Movement movement = new Movement(i);   //movement를 생성해서
                output.add(movement);  // output 에 추가한다.
            }
        }
        return output;
    }



    public ArrayList<Movement> equipment(String equipment,ArrayList<Movement> movements ){
        ArrayList<Movement> output = new ArrayList<Movement>();
        for(int i = 0; i <movements.size(); i++ ) {  // 이번엔 읽은 데이터를 인덱싱
            if(equipment.equals(movements.get(i).get_equipement())) {  // 읽은 movement의 equipement와 같다면
                Movement movement = new Movement();
                movement = movements.get(i); //movement를 생성해서
                output.add(movement);  // output 에 추가한다.
            }
        }
        return output;
    }





    // 근육 부위 exercise_area ***
    public void exercise_area() {

    }






    // 운동 달력에 대한 부분  stimulation 0 역도 / 1 메타볼릭 / 2 체조
    public ArrayList<String> stimulation() {
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < 3; i++) {

            if(stimulation(i) != null) {
                output.add(stimulation(i));
            }

        }

        return output;
    }


    public ArrayList<String> stimulation(ArrayList<Movement> movement) {
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < 3; i++) {
            if(stimulation(i,movement) != null) {
                output.add(stimulation(i,movement));
            }
        }

        return output;
    }


    public String stimulation(int stimulation,ArrayList<Movement> movement) {
        Data_Movement data = new Data_Movement();
        ArrayList<String> output_list = new ArrayList<String>();
        for(int i = 0; i < data.get_Data_length(); i++) {
            if(stimulation == data.get_stimulation(i)) {
                output_list.add(data.get_movement(i));
            }
        }

        Random random = new Random();
        String output =output_list.get(random.nextInt(output_list.size()));
        return output;



    }



    public String stimulation(int stimulation) {    //해당하는 movement 중에 하나 추천
        Data_Movement data = new Data_Movement();
        ArrayList<String> output_list = new ArrayList<String>();
        for(int i = 0; i < data.get_Data_length(); i++) {
            if(stimulation == data.get_stimulation(i)) {
                output_list.add(data.get_movement(i));
            }
        }

        Random random = new Random();
        String output =output_list.get(random.nextInt(output_list.size()));
        return output;
    }

    public void stimulation(boolean[] input) {


    }








}






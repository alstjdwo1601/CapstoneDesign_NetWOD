package com.example.netwod;


import java.util.ArrayList;

import java.util.Collections;
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


    public WOD(){
   movement=new ArrayList<String>();
        movementnum=new ArrayList<String>();
        weightlist=new ArrayList<String>();
        equipment=new ArrayList<String>();
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
//ㅇㅅㅇ



class WodManager {
    ArrayList<WOD> wodList = new ArrayList<WOD>();
    ArrayList<String> err = new ArrayList<String>();
    Data_Movement data;
    UserInfo info;
    WodAlgorithm algorithm;
    public WodManager() {

    }


    public WodManager(Data_Movement _data,UserInfo _info) {
        algorithm=new WodAlgorithm(_data,_info);
        data=_data;
        info=_info;
    }






    /* WodManager
     * wodList를 입력 받으면 저장하거나 새로운 와드를 만들어줌
     *
     *
     * 구현 필요
     * - Arraylist 으로 체계적 관리 o
     * - 로그기능 o
     * - 빈 wodList를 받으면 채우는 함수 o
     *
     *
     * Data_Movement
     * 엑셀 데이터를 클래스의 내의 변수로 저장
     *
     * 구현 필요
     * - 클래스 외부에서 접근하는 함수 o
     * - 엑셀 읽는 기능 x
     *
     * WodAlgorithm
     * 빈와드를 넣으면 알아서 맞는 Wod 넣도록
     *
     * 구현 필요
     *
     *  사용자 정보에 따른 Wod 생성 (1/5)
     *  사용자 장비 o
     *  사용자 점수 o
     *  사용자 랭킹 x
     *  사용자 레벨 o
     *
     *  사용자가 했던 wodList에 따라서 (1/2)  - 개발
     *  stimulation o
     *  area x 제거
     *
     *  +와드데이터를 통해서 학습하고 추천(0/0) // 제거
     *	//와드 데이터 만드는 공식이 있기에 머신러닝 쓸 이유가 없음
     *
     *  data collection x
     *  lerning tool x
     *
     *  WodLearning
     *
     *  11/25
     *
     */


    public WOD make(WOD wod) {

        algorithm._makeWod("FORTIME", 0);
        return algorithm.getWod();
    }

    public WOD make(String type) {

        algorithm._makeWod( type  ,2 );
        return algorithm.getWod();
    }

    public WOD make(String type,int level) {

        algorithm._makeWod( type , level );
        return algorithm.getWod();
    }


    public WOD make() {

        algorithm._makeWod("FORTIME", 0);
        return algorithm.getWod();
    }

    public int time(WOD wod) {

        return algorithm._getTime(wod);
    }

    public int AMRAPtime(WOD wod) {

        return 5*algorithm._getTime(wod);
    }


	/*public int replace(WOD wod,String target,String want) {
		return
	}
	*/

    public int score(WOD wod,int time) {

        return (int)algorithm._Score(wod, time);
    }

    public int level(WOD wod) {


        return algorithm._level(wod);
    }



    public ArrayList<WOD> _getWod(){
        return wodList;
    }


    public WOD _getWod(int index) {

        if(rangeArray(index,wodList.size())) {
            return wodList.get(index);}
        else {
            err.add("getWod/ wodList / out of index ");
            return null;}
    }


    public int _getWodSize() {
        return this.wodList.size();
    }




    public boolean _addWod(WOD input) {
        if(input != null) {
            this.wodList.add(input);
            return true;
        }
        else {
            err.add("addWod/ wodList / input is null ");
            return false;
        }

    }






    public void _addWod(ArrayList<WOD> inputs){
        for(int i = 0; i < inputs.size(); i++){
            this._addWod(inputs.get(i));}

    }




    public boolean _delWod(int index) {
        if(rangeArray(index,wodList.size())) {
            wodList.remove(index);
            return true;
        }
        else {
            err.add("delWod/ wodList / out of size ");
            return false;
        }
    }

    public void _delWod(ArrayList<Integer> indexs) {
        Collections.sort(indexs,Collections.reverseOrder());
        for(int i =0 ; i < indexs.size(); i++) {
            _delWod(indexs.get(i));
        }


    }



    public boolean _setWod(int index,WOD input) {
        if(rangeArray(index,wodList.size())){
            wodList.remove(index);
            wodList.add(index,input);
            return true;
        }
        else {
            err.add("setWod / index out of range");
            return false;
        }
    }





    public ArrayList<String> MgetErr(){
        return err;
    }

    public boolean rangeArray(int index,int max) {
        if(index > max) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean rangeArray(int index,int min,int max) {
        if((index < max )&&(index >= min)) {
            return true;
        }
        else {
            return false;
        }
    }

}


class WodAlgorithm {
    private Data_Movement data;
    private WOD wod = new WOD();
    private UserInfo info;

    private ArrayList<String> movement = new ArrayList<String>();
    private ArrayList<String> equipment= new ArrayList<String>();
    private ArrayList<String> rep = new ArrayList<String>();
    private ArrayList<String> weight = new ArrayList<String>();



    /*
     *   WodAlgorithm
     *
     *
     *
     */



    public WodAlgorithm() {


    }


    public WodAlgorithm(Data_Movement Data,UserInfo info) {
        this.data = Data;
        this.info = info;
    }




    public WodAlgorithm(Data_Movement Data, WOD Wod,UserInfo info) {
        this.wod = Wod;
        this.data = Data;
        this.info = info;
    }

    /*
     예상 time 구하는 부분

    */
    public int _getTime(WOD inputWOD) {
        if(wod == null) {
            return 0;
        }
        double Time = 0;

        for(int i = 0; i < inputWOD.getMovement().size(); i++) {
            int index = data.getIndex(inputWOD.getMovement().get(i));
            double movementNum = StringToDouble(inputWOD.getMovementnum().get(i));
            double score = data.getScore(index);
            double rep = data.getRep(index);
            double calc = score * movementNum / rep;
            Time += calc;
        }




        return (int)Time;
    }

    /*score 구하는 부분
     *
     *
     *
     *
     *
     */
    public double _Score(WOD inputWOD, int time) {
        int wodtime = _getTime(inputWOD);
        if(inputWOD.getWODtype().equals( "FORTIME")) {
            System.out.println("알고리즘 적정시간:"+wodtime);
            System.out.println("실제로 수행한 시간:"+time);
            System.out.println("나온 점수:"+100 + 100*(wodtime-time)/(wodtime+time));
            return 100 + 100*(wodtime-time)/(wodtime+time);
        }
        if(inputWOD.getWODtype().equals( "AMRAP")) {
            return 100 + 100*(time-4)/(time+5);
        }

        return 0;


    }
    // level 구하는 부분

    public int _level(WOD inputWOD) {
        if(inputWOD == null) {
            return -1;
        }

        for(int i = 0; i < inputWOD.getMovement().size(); i++) {
            if(!inputWOD.getWeightlist().get(i).equals("0") ) {
                return _levelsub(inputWOD.getMovement().get(i) ,inputWOD.getWeightlist().get(i));
            }


        }
        return -1;

    }



    public int _levelsub(String Movement,String Weight) {
        int index = data.getIndex(Movement);
        double weight = Double.parseDouble(Weight);
        double userWeight;
        if(info.getUserWeight() == null) {
            userWeight = 65;
        }
        else {
            userWeight = Double.parseDouble(info.getUserWeight());
        }

        double Weightmul = 1 + (userWeight - 65)/65;


        if(index == -1) {
            return -1;
        }


        // weight = data * mul * userWeight
        double mul = weight / data.getWeight(index) /Weightmul;

        if(mul < 0.74) {
            return 0;
        }

        if(mul < 0.99) {
            return 1;
        }

        if(mul < 1.24) {
            return 2;
        }
        if(mul < 1.49) {
            return 3;
        }
        if(mul < 1.99) {
            return 4;
        }
        if(mul < 3.0) {
            return 5;
        }



        return -1;
        // level 0 = 50%  // begineer
        // level 1 = 75%  // womans wod
        // level 2 = 100% // normal wod
        // level 3 = 125% // famous wod
        // level 4 = 150% // pro wod
        // level 5 = 200% // hero wod

    }









    /*
     *   wod 만드는 부분
     *
     *
     */

    public void _makeWod(String type,int level) {
        ArrayList<Integer> movement = new ArrayList<Integer>();

        // movement 받는 부분
        movement = _seleteMovement();
        //fortime 구현해야하고
        if(type.equals("FORTIME")) {
            _FORTIME(movement, level);
            wod.setMovement(this.movement);
            wod.setEquipment(this.equipment);
            wod.setMovementnum(this.rep);
            wod.setWeightlist(this.weight);
            wod.setWODtype("FORTIME");
            wod.setWODlevel(Integer.toString(level));

        }

        else if(type.equals("AMRAP")) {
            _AMRAP(movement,level);
            wod.setMovement(this.movement);
            wod.setEquipment(this.equipment);
            wod.setMovementnum(this.rep);
            wod.setWeightlist(this.weight);
            wod.setWODtype("AMRAP");
            wod.setWODlevel(Integer.toString(level));
        }

    }

    public void _addMovement(int index, int Level, int part) {

        // level 0 = 50%  // begineer
        // level 1 = 75%  // womans wod
        // level 2 = 100% // normal wod
        // level 3 = 125% // famous wod
        // level 4 = 150% // pro wod
        // level 5 = 200% // hero wod

        movement.add(data.getMovement(index));
        equipment.add(data.getEquipment(index));
        rep.add(_setMovementnum(index,part));
        weight.add(_setWeightlist(index,Level));

    }

    public String _setMovementnum(int index, int part){
        return numberToString((int)(data.getRep(index)*part));
    }


    public String _setWeightlist(int index,int level){
        double mul;
        double weight = 65;

        if(info.getUserWeight() != null) {
            weight = Double.parseDouble(info.getUserWeight());
        }
        double weightMul = 1+((weight-65)/65);

        // Level 조정 부분
        if(level == 0) {
            mul = 0.5;
        }

        else if(level == 1) {
            mul = 0.75;
        }
        else if(level == 2) {
            mul = 1.0;
        }
        else if(level == 3) {
            mul = 1.25;
        }

        else if(level == 4) {
            mul = 1.5;

        }
        else if(level == 5) {
            mul = 2.0;
        }
        else {
            mul = 1.0;
        }


        return numberToString((int)(data.getWeight(index)*mul*weightMul));
    }










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

    public void _FORTIME(ArrayList<Integer> indexList){
        if(indexList != null) { // 에러 생겼을 때 여기서 에러메세지 넣으면 될듯

            WodType type = new WodType();
            int[] count = type.getType("FORTIME", indexList);


            for(int i = 1; i < count.length; i++) {
                for(int mNum = 0; mNum < indexList.size(); mNum++) {
                    _addMovement(indexList.get(mNum), 0, count[i]);
                }
            }
        }

    }

    public void _FORTIME(ArrayList<Integer> indexList,int level){
        if(indexList != null) { // 에러 생겼을 때 여기서 에러메세지 넣으면 될듯

            WodType type = new WodType();
            int[] count = type.getType("FORTIME", indexList);


            for(int i = 1; i < count.length; i++) {
                for(int mNum = 0; mNum < indexList.size(); mNum++) {
                    _addMovement(indexList.get(mNum), level, count[i]);
                }
            }
        }

    }





    public void _AMRAP(ArrayList<Integer> indexList) {
        WodType type = new WodType();
        if(indexList != null) {
            int[] count = type.getType("AMRAP", indexList);


            for(int mNum = 0; mNum < indexList.size(); mNum++) {
                _addMovement(indexList.get(mNum), 0, 1);
            }
        }

    }
    // 수정필요

    public void _AMRAP(ArrayList<Integer> indexList,int level) {
        WodType type = new WodType();
        if(indexList != null) {
            int[] count = type.getType("AMRAP", indexList);


            for(int mNum = 0; mNum < indexList.size(); mNum++) {
                _addMovement(indexList.get(mNum), level, 1);
            }
        }

    }







    // _selteMovement(){}

    public ArrayList<Integer> _seleteMovement(){

        boolean area = false;
        ArrayList<Integer> movement;
        // area 로 정렬하고


        // equipment 로 분류하고
        movement = _getEquipementList();
        if(movement.isEmpty()) {return null;}
        movement = _WODstimulation(movement, area);
        if(movement.isEmpty()) {
            return _randomMovement(2,movement);
        }

        return movement;
    }


    public ArrayList<Integer> _randomMovement(int i,ArrayList<Integer> movement){
        ArrayList<Integer> output = new ArrayList<Integer>();
        Random rand = new Random();
        output.add(movement.get(rand.nextInt(movement.size())));
        output.add(movement.get(rand.nextInt(movement.size())));

        while(output.get(0) == output.get(1)) {
            output.set(1,movement.get(rand.nextInt(movement.size())));

        }

        return output;
    }



    // Equipement


    public ArrayList<String> _getUserEquipementList() {
        ArrayList<String> list =  new ArrayList<String>();
        if(info.isBarbell()) {
            list.add("Barbell");
        }
        if(info.isBody()) {
            list.add("Body");
        }
        if(info.isBox()) {
            list.add("Box");
        }
        if(info.isDumbbell()) {
            list.add("Dumbbell");
        }
        if(info.isJumprope()) {
            list.add("Jumprope");
        }
        if(info.isKettlebell()) {
            list.add("Kettlebell");
        }
        if(info.isPullUpBar()) {
            list.add("PullUpBar");
        }
        if(info.isWallBall()) {
            list.add("WallBall");
        }
        return list;
    }




    public ArrayList<Integer> _getEquipementList(){
        ArrayList<Integer> movements = new ArrayList<Integer>();
        ArrayList<String> list = _getUserEquipementList();
        for(int i = 0; i < data.getArraySize();i++) {
            if(_ArrayincludeString(data.getEquipment(i), list)) {
                movements.add(i);
            }
        }
        return movements;
    }


    public ArrayList<Integer> _getEquipementList(ArrayList<Integer> DataList){
        ArrayList<Integer> movements = new ArrayList<Integer>();
        ArrayList<String> list = _getUserEquipementList();
        for(int i = 0; i < DataList.size();i++) {
            if(_ArrayincludeString(data.getEquipment(DataList.get(i)), list)) {
                movements.add(DataList.get(i));
            }
        }
        return movements;
    }









    // exercise area


    public ArrayList<Integer> _sortExerciseArea(){
        ArrayList<Integer> movements = new ArrayList<Integer>();
        return movements;
    }










    // stimulation
    /*
     *  1. wod 를 통해서 stimulation 을 알아내는 것 (wod 넣으면 stimulation boolean type [3])
     *  2. stimulation 을 통해서 movement 추출하는 것 (전체에서 , 주어진 list에서  int type[size])
     *  3.
     */

    public ArrayList<Integer>_WODstimulation(WOD yesterday,ArrayList<Integer> movementList, boolean sorted) {
        ArrayList<Boolean> stimulation = _stimulationRecommand(yesterday);
        return _stimulationMain(stimulation,movementList,sorted);
    }

    public ArrayList<Integer>_WODstimulation(ArrayList<WOD> wodlist,ArrayList<Integer> movementList, boolean sorted) {
        ArrayList<Boolean> stimulation = _stimulationRecommand(wodlist);
        return _stimulationMain(stimulation,movementList,sorted);
    }

    public ArrayList<Integer>_WODstimulation(ArrayList<Integer> movementList, boolean sorted){
        ArrayList<Boolean> stimulation = _stimulationRecommand();
        return _stimulationMain(stimulation,movementList,sorted);
    }




    public ArrayList<Boolean> _getStimulaion(WOD wod){
        // wod 의 movement를 통해서 stimulation을 알아낸다.
        ArrayList<Boolean> stimulation = new ArrayList<Boolean>();
        ArrayList<String> movement = wod.getMovement();
        ArrayList<Integer> movementIndex = new ArrayList<Integer>();

        for(int i = 0; i < 3; i++) {
            stimulation.add(false);
        }

        for(int i = 0; i < movement.size(); i++) {
            movementIndex.add(data.getArrayIndex(movement.get(i)));
        }

        for(int i = 0; i < movementIndex.size(); i++) {
            int index = movementIndex.get(i);

            if(data.getStimulation(index) == 0) {
                stimulation.set(0, true);
            }

            else if(data.getStimulation(index) == 1) {
                stimulation.set(1, true);
            }

            else if(data.getStimulation(index) == 2) {
                stimulation.set(2, true);
            }
        }
        return stimulation;
    }


    public ArrayList<Integer> _stimulationBooltoInt(ArrayList<Boolean> input){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++) {
            output.add(0);
        }
        for(int i = 0; i < 3; i++) {
            if(input.get(i)) {
                output.set(i, 1);
            }
        }
        return output;

    }

    // WOD.. 전날 했던 wod 아니면 user 추천
    public ArrayList<Boolean> _stimulationRecommand(){
        Random rand = new Random();
        ArrayList<Boolean> output = new ArrayList<Boolean>();
        int SettingValue = rand.nextInt(100);
        if(SettingValue < 60) {
            for(int i = 0; i < 3; i++) {
                output.add(true);}

        }
        else if(SettingValue <80) {
            for(int i = 0; i < 3; i++) {
                output.add(true);}
            output.set(rand.nextInt(3), false);

        }
        else {
            for(int i = 0; i < 3; i++) {
                output.add(false);}
            output.set(rand.nextInt(3), true);


        }

        return output;


    }







    public ArrayList<Boolean> _stimulationRecommand(WOD yesterday){
        if(yesterday == null) {
            return null;
        }

        Random rand = new Random();

        ArrayList<Boolean> output = _getStimulaion(yesterday);
        if(output.get(0))
            if(output.get(1))
                if(output.get(2)) {
                    output.set(rand.nextInt(output.size()), false);
                    return output;
                }
        for(int i = 0; i < output.size(); i++) {
            if(!output.get(i)) {
                output.set(i, true);
                return output;
            }

        }

        return output;

    }






    public ArrayList<Boolean> _stimulationRecommand(ArrayList<WOD> wodlist){
        ArrayList<Boolean> output = new ArrayList<Boolean>();
        ArrayList<Integer> SumStimulation = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++) {
            SumStimulation.add(0);
        }




        for(int i = 0; i < wodlist.size(); i++) {
            ArrayList<Boolean> stimulation_bool = _getStimulaion(wodlist.get(i));
            ArrayList<Integer> stimulation_int = _stimulationBooltoInt(stimulation_bool);

            for(int j = 0; j < 3; j++) {
                stimulation_bool.add(false);
                int temp = SumStimulation.get(j) + stimulation_int.get(j);
                SumStimulation.set(j, temp);
            }
        }



        // 비교 sum
        if(SumStimulation.get(0) > SumStimulation.get(1)) {
            if(SumStimulation.get(1) > SumStimulation.get(2)){
                output.set(2, true);
                return output;
            }
            else if(SumStimulation.get(1) == SumStimulation.get(2)) {
                output.set(1, true);
                output.set(2, true);
                return output;
            }
            else {
                output.set(1, true);
                return output;

            }

        }
        else if(SumStimulation.get(0) == SumStimulation.get(1)) {
            if(SumStimulation.get(1) > SumStimulation.get(2)){
                output.set(2, true);
                return output;
            }
            else if(SumStimulation.get(1) == SumStimulation.get(2)) {

                output.set(0, true);
                output.set(1, true);
                output.set(2, true);

                return output;
            }
            else {
                output.set(0, true);
                output.set(1, true);
                return output;

            }
        }
        else{
            if(SumStimulation.get(0) > SumStimulation.get(2)){
                output.set(2, true);
                return output;
            }
            else if(SumStimulation.get(0) == SumStimulation.get(2)) {

                output.set(0, true);
                output.set(2, true);

                return output;
            }
            else {
                output.set(0, true);
                return output;

            }
        }
    }



    public ArrayList<Integer> _stimulation(ArrayList<Boolean> stimulation){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < data.getArraySize(); i++) {
            if(stimulation.get(data.getStimulation(i))) {
                output.add(i);
            }
        }
        return output;

    }




    public ArrayList<Integer> _stimulation(ArrayList<Boolean> stimulation,ArrayList<Integer> movementList){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < movementList.size(); i++) {
            if(stimulation.get(data.getStimulation(movementList.get(i)))) {
                output.add(movementList.get(i));
            }
        }
        return output;
    }

    public ArrayList<Integer> _stimulationMain(ArrayList<Boolean> stimultaion, ArrayList<Integer> movementList,boolean sorted){
        if(sorted) { // exercise area  적용된 movement list

            ArrayList<Integer> output = new ArrayList<Integer>();
            ArrayList<Integer> SubList_0 =_stimulationSub(0,movementList);
            ArrayList<Integer> SubList_1 =_stimulationSub(1,movementList);
            ArrayList<Integer> SubList_2 =_stimulationSub(2,movementList);
            output.add(_MovementSelectUpper(SubList_0));
            output.add(_MovementSelectUpper(SubList_1));
            output.add(_MovementSelectUpper(SubList_2));
            for(int i = output.size()-1; i >= 0 ; i--) {
                if(output.get(i) == -1) {
                    output.remove(i);
                }
            }
            return output;

        }

        else { //  exercise area 적용 안되었을 때

            ArrayList<Integer> output = new ArrayList<Integer>();
            ArrayList<Integer> SubList_0 =_stimulationSub(0,movementList);
            ArrayList<Integer> SubList_1 =_stimulationSub(1,movementList);
            ArrayList<Integer> SubList_2 =_stimulationSub(2,movementList);
            output.add(_MovementSelectRandom(SubList_0));
            output.add(_MovementSelectRandom(SubList_1));
            output.add(_MovementSelectRandom(SubList_2));

            for(int i = output.size()-1; i >= 0 ; i--) {
                if(output.get(i) == -1) {
                    output.remove(i);
                }
            }
            return output;
        }
    }


    public ArrayList<Integer> _stimulationMain(ArrayList<Boolean> stimultaion){
        ArrayList<Integer> output = new ArrayList<Integer>();
        ArrayList<Integer> SubList_0 =_stimulationSub(0);
        ArrayList<Integer> SubList_1 =_stimulationSub(1);
        ArrayList<Integer> SubList_2 =_stimulationSub(2);
        output.add(_MovementSelectRandom(SubList_0));
        output.add(_MovementSelectRandom(SubList_1));
        output.add(_MovementSelectRandom(SubList_2));

        for(int i = output.size()-1; i >= 0 ; i--) {
            if(output.get(i) == -1) {
                output.remove(i);
            }
        }
        return output;
    }


    public ArrayList<Integer> _stimulationSub(int stimulation){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < data.getArraySize(); i++) {
            if(data.getStimulation(i)==stimulation) {
                output.add(i);
            }
        }
        return output;
    }






    public ArrayList<Integer> _stimulationSub(int stimulation, ArrayList<Integer> movementList){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < movementList.size(); i++) {
            if(data.getStimulation(movementList.get(i))==stimulation) {
                output.add(movementList.get(i));
            }
        }
        return output;
    }

// stimulation end










// 내부 function


    public int _MovementSelectRandom(ArrayList<Integer> movementList) {
        if(movementList.isEmpty()) {
            return -1;

        }
        Random rand = new Random();
        int output = rand.nextInt(movementList.size());
        return movementList.get(output);
    }




    public int _MovementSelectUpper(ArrayList<Integer> movementList) {
        if(movementList.isEmpty()) {
            return -1;
        }
        return movementList.get(0);
    }



    public WOD getWod() {
        return this.wod;
    }





    public boolean _ArrayincludeString(String string,ArrayList<String> list) {
        if(list.size() == 0) {
            return false;
        }
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(string)){
                return true;
            }
        }
        return false;
    }

    public String numberToString(int number) {
        return Integer.toString(number);
    }
    public String numberToString(double number) {
        return Double.toString(number);
    }
    public double StringToDouble(String string) {
        return Double.parseDouble(string);
    }
    public int StringToInt(String string) {
        return Integer.parseInt(string);
    }




}




class WodType {
    ArrayList<int[]> FORTIME = new ArrayList<int[]>();
    ArrayList<int[]> AMRAP = new ArrayList<int[]>();

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

    public WodType() {
        // FORTIME
        int[] input = {1,30};
        this._addFORTIME(input);
        input = new int[] {2,30,15};
        this._addFORTIME(input);
        input = new int[] {2,21,15,9};
        this._addFORTIME(input);
        input = new int[] {2,15,15,15};
        this._addFORTIME(input);
        input = new int[] {3,15,9,6};
        this._addFORTIME(input);
        input = new int[] {3,10,10,10};
        this._addFORTIME(input);

        //amrap
        // first = movement kind , 2 ~ n-1 = movement_count , last = time(min)
        input = new int[] {1 , 6, 10};
        this._addAMRAP(input);
        input = new int[] {2 , 3,3, 10};
        this._addAMRAP(input);
        input = new int[] {3 , 2,2,2, 10};
        this._addAMRAP(input);





    }


    public int[] getType(String type, ArrayList<Integer> movement) {

        if(type.equals("FORTIME")) {
            return getFortime(movement.size());
        }

        if(type.equals("AMRAP")) {
            return getAMRAP(movement.size());
        }

        return null;

    }




    public int[] getFortime(int sizeOfmovement) {
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < this.FORTIME.size(); i++) {
            if(FORTIME.get(i)[0] == sizeOfmovement) {
                indexList.add(i);
            }
        }

        return FORTIME.get(indexList.get(rand.nextInt(indexList.size())));
    }

    public int[] getAMRAP(int sizeOfmovement) {
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < this.AMRAP.size(); i++) {
            if(AMRAP.get(i)[0] == sizeOfmovement) {
                indexList.add(i);
            }
        }

        return AMRAP.get(indexList.get(rand.nextInt(indexList.size())));
    }





    public void _addFORTIME(int[] input) {
        this.FORTIME.add(input);
    }

    public void _addAMRAP(int[] input) {
        this.AMRAP.add(input);
    }






}



class Data_Movement {
    private ArrayList<String> movement = new ArrayList<String>();
    private ArrayList<String> equipment = new ArrayList<String>();
    private ArrayList<int[]> exercise = new ArrayList<int[]>();
    private ArrayList<Integer> stimulation = new ArrayList<Integer>(); // 0 = 체조 , 1 = 메타볼릭컨디셔닝 , 2 = 역도
    private ArrayList<Double> score = new ArrayList<Double>();
    private ArrayList<Double> weight = new ArrayList<Double>();
    private ArrayList<Double> rep = new ArrayList<Double>();
    private int ArraySize = movement.size();


    public Data_Movement(){

    }

    public int getArraySize(){
        setArraySize();
        return this.ArraySize;
    }

    public int getArrayIndex(String movementName) {
        setArraySize();
        for(int i = 0; i < ArraySize; i++) {
            if(movement.get(i).equals(movementName)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<String> getMovement() {
        return movement;
    }
    public ArrayList<String> getEquipment() {
        return equipment;
    }
    public ArrayList<int[]> getExercise() {
        return exercise;
    }
    public ArrayList<Integer> getStimulation() {
        return stimulation;
    }
    public ArrayList<Double> getScore() {
        return score;
    }
    public ArrayList<Double> getWeight() {
        return weight;
    }
    public ArrayList<Double> getRep() {
        return rep;
    }
    public String getMovement(int index) {
        if(rangeArray(index, ArraySize)) {
            return movement.get(index);
        }
        else {
            return null;
        }
    }
    public String getEquipment(int index) {
        if(rangeArray(index, ArraySize)) {
            return equipment.get(index);
        }
        else {
            return null;
        }
    }
    public int[] getExercise(int index) {
        if(rangeArray(index, ArraySize)) {
            return exercise.get(index);
        }
        else {
            return null;
        }
    }
    public int getStimulation(int index) {
        if(rangeArray(index, ArraySize)) {
            return stimulation.get(index);
        }
        else {
            return -1;
        }
    }
    public double getScore(int index) {
        if(rangeArray(index, ArraySize)) {
            return score.get(index);
        }
        else {
            return -1;
        }
    }
    public double getWeight(int index) {
        if(rangeArray(index, ArraySize)) {
            return weight.get(index);
        }
        else {
            return -1;
        }
    }
    public Double getRep(int index) {
        if(rangeArray(index, ArraySize)) {
            return rep.get(index);
        }
        else {
            return -1.0;
        }
    }


    public int getIndex(String input) {
        for(int i = 0; i < this.getArraySize(); i++) {

            if(input.equals(movement.get(i))) {
                return i;
            }

        }
        return -1;
    }




    public boolean rangeArray(int index,int max) {
        if(index > max) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean rangeArray(int index,int min,int max) {
        if((index < max )&&(index >= min)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setArraySize() {
        ArraySize = movement.size();
    }

}
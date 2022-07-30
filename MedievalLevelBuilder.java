package dungeon;

public class MedievalLevelBuilder {
    private final int numOfRooms;
    private int accNumOfRooms;
    private final int numOfMonsters;
    private int accNumOfMonsters;
    private final int numOfTreasure;
    private int accNumOfTreasure;
    private Level level;


    public MedievalLevelBuilder(int levelNumber, int numOfRooms, int numOfMonsters, int numOfTreasure){
        if(numOfRooms<0 || numOfMonsters<0 || numOfTreasure<0){
            throw new IllegalArgumentException("Non-negative number");
        }
        this.numOfRooms = numOfRooms;
        this.numOfMonsters=numOfMonsters;
        this.numOfTreasure=numOfTreasure;
        accNumOfRooms=0;
        accNumOfMonsters=0;
        accNumOfTreasure=0;
        level=new Level(levelNumber);

    }

    public void addRoom(String description){
        level.addRoom(description);
        accNumOfRooms++;
        if(accNumOfRooms>numOfRooms){
            throw new IllegalStateException("Too many rooms created");
        }
    }

    public void addGoblins(int roomNumber,int number){

        for(int i = 0;i<number; i++){
            level.addMonster(roomNumber,new Monster("goblin","mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind",7));
            accNumOfMonsters++;
            if(accNumOfMonsters>numOfMonsters) {
                throw new IllegalStateException("Too many monsters created");
            }
            //TODO:throw error for not-created room
        }
    }

    public void addOrc(int roomNumber){
        level.addMonster(roomNumber,new Monster("orc","brutish, aggressive, malevolent being serving evil",20));
        accNumOfMonsters++;
        if(accNumOfMonsters>numOfMonsters) {
            throw new IllegalStateException("Too many monsters created");
        }
        //TODO:throw error for not-created room
    }

    public void addOgre(int roomNumber){
        level.addMonster(roomNumber,new Monster("ogre","large, hideous man-like being that likes to eat humans for lunch",50));
        accNumOfMonsters++;
        if(accNumOfMonsters>numOfMonsters) {
            throw new IllegalStateException("Too many monsters created");
        }
        //TODO:throw error for not-created room
    }
    public void addHuman(int roomNumber,String name, String description, int hitPoint){
        level.addMonster(roomNumber,new Monster(name,description,hitPoint));
        accNumOfMonsters++;
        if(accNumOfMonsters>numOfMonsters) {
            throw new IllegalStateException("Too many monsters created");
        }
        //TODO:throw error for not-created room
    }
    //Treasure
    public void addPotion(int roomNumber){
        level.addTreasure(roomNumber,new Treasure("a healing potion",1));
        accNumOfTreasure++;
        if(accNumOfTreasure>numOfTreasure){
            throw new IllegalStateException("Too many treasures created");
        }
    }
    public void addGold(int roomNumber,int value){
        level.addTreasure(roomNumber,new Treasure("pieces of gold",value));
        accNumOfTreasure++;
        if(accNumOfTreasure>numOfTreasure){
            throw new IllegalStateException("Too many treasures created");
        }
    }
    public void addWeapon(int roomNumber,String description){
        level.addTreasure(roomNumber,new Treasure(description,10));
        accNumOfTreasure++;
        if(accNumOfTreasure>numOfTreasure){
            throw new IllegalStateException("Too many treasures created");
        }
    }
    public void addSpecial(int roomNumber,String description, int value){
        level.addTreasure(roomNumber,new Treasure(description,value));
        accNumOfTreasure++;
        if(accNumOfTreasure>numOfTreasure){
            throw new IllegalStateException("Too many treasures created");
        }
    }
    public Level build(){
        if(accNumOfTreasure!=accNumOfTreasure || accNumOfMonsters!=numOfMonsters || accNumOfRooms!=numOfRooms){
            throw new IllegalStateException("Not finished yet");
        }

        return this.level;
    }



}

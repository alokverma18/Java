public class OOPS {
    public static void main(String[] args) {

        Cricketer A = new Cricketer();
        A.setName("Shubhman Gill");
        A.setAge(21);
        A.setTeams(new String[]{"GT", "India"});
        A.show();
        System.out.println();

        Cricketer B = new Cricketer("Yashasvi Jaiswal", 20, new String[]{"RR", "India"});
        B.show();
        System.out.println();

        Cricketer T = new Cricketer(B);
        T.show();
        System.out.println();




        Batsman vk = new Batsman("Virat Kohli", 34, new String[] {"RCB", "India"});
        vk.show();
        System.out.println();

        Bowler jb = new Bowler("Jasprit Bumrah", 30, new String[] {"MI", "India"});
        jb.show();

    }
}

class Cricketer {
    protected String name;
    protected int age;
    String[] teams;

    Cricketer(){
        System.out.println("Cricketer Constructor called");
    }

    Cricketer(String name, int age, String teams[]){
        this.name = name;
        this.age = age;
        this.teams = new String[teams.length];
        for(int i=0; i<teams.length; i++){
            this.teams[i] = teams[i];
        }
    }
    Cricketer(Cricketer b){
        this.name = b.name;
        this.age = b.age;
        this.teams = new String[b.teams.length];
        for (int i = 0; i < b.teams.length; i++) {
            this.teams[i] = b.teams[i];
        }
    }

    void getName(){
        System.out.println(this.name);
    }
    void setName(String name){
        this.name = name;
    }

    void setAge(int age){
        this.age = age;
    }

    void setTeams(String[] teams){
        this.teams = new String[teams.length];
        for(int i=0; i<teams.length; i++){
            this.teams[i] = teams[i];
        }
    }

    void show(){
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.print("Teams : ");
        for (int i = 0; i < this.teams.length; i++) {
            System.out.print(this.teams[i] + " ");
        }
    }

}

class Batsman extends Cricketer {
    private int runs;
    private double average;
    private int centuries;

    Batsman(String name, int age, String[] teams){
        this.name = name;
        this.age = age;
        this.teams = new String[teams.length];
        for(int i=0; i<teams.length; i++){
            this.teams[i] = teams[i];
        }
    }

    Batsman(){
        System.out.println("Default Batsman Constructor called");
    }


    void setBattingStats(int runs, double average, int centuries){
        this.runs = runs;
        this.average = average;
        this.centuries = centuries;
    }

    void show(){
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.print("Teams : ");
        for (int i = 0; i < this.teams.length; i++) {
            System.out.print(this.teams[i] + " ");
        }
        System.out.println("Runs : " + this.runs);
        System.out.println("Average : " + this.average);
        System.out.println("Centuries : "+ this.centuries);
    }
}

class Bowler extends Cricketer {
    private int wickets;
    private double average;

    Bowler(String name, int age, String[] teams){
        this.name = name;
        this.age = age;
        this.teams = new String[teams.length];
        for(int i=0; i<teams.length; i++){
            this.teams[i] = teams[i];
        }
    }

    Bowler(){
        System.out.println("Default Bowler Constructor called");
    }

    void setBattingStats(int wickets, double average){
        this.wickets = wickets;
        this.average = average;
    }

    void show(){
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.print("Teams : ");
        for (int i = 0; i < this.teams.length; i++) {
            System.out.print(this.teams[i] + " ");
        }
        System.out.println("Wickets : " + this.wickets);
        System.out.println("Average : " + this.average);
    }
}
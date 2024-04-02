public class Cafe extends Building {
    
    //attributes are all set to private so no one else can change them!
    private int nCoffeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);

        this.nCoffeOunces = 100;
        this.nSugarPackets = 200;
        this.nCreams = 200;
        this.nCups = 50;

        System.out.println("You have built a cafe: ☕");
    }

    
    /**
     * Checks the stock of the cafe 
     * @return concatenation of the total stock
     */
    public String getStock(){
        return "The " + this.name + " has " + this.nCoffeOunces + " ounces of coffee, " + 
        this.nSugarPackets + " packets of sugar, " + this.nCreams + " number of creams, and " + this.nCups + " cups.";
    }

    /**
     * Restocks the cafe with set number of items
     * @param nCoffeeOunces ounces of coffee
     * @param nSugarPackets number of sugar packets
     * @param nCreams number of creams
     * @param nCups number of cups 
     */
    private void restock(int nCoffeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeOunces = nCoffeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
    
    /**
     * Checks the stock then sells a coffee with specified parameters and subtracts from stock
     * @param size ounces of coffee
     * @param sugars number of sugar packets
     * @param creams number of creams
     */
    public void sellCoffee(int size, int sugars, int creams){
        if (size > this.nCoffeOunces || sugars > this.nSugarPackets || creams > this.nCreams || this.nCups < 0){
            restock(100, 200, 200, 50);
            this.nCoffeOunces -= size;
            this.nSugarPackets -= sugars;
            this.nCreams -= creams;
            this.nCups -= 1;
        }
        else {
            this.nCoffeOunces -= size;
            this.nSugarPackets -= sugars;
            this.nCreams -= creams;
            this.nCups -= 1;
        }
        
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        throw new RuntimeException("Customers are not allowed beyond the first floor!");
    }


    /**
     * Gives a readable list of all the methods the subclass can perform
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(size, sugars, creams)\n + restock(nCoffeOunces, nSugarPackets, nCreams, nCups)\n");
    }

    public static void main(String[] args) {
        Cafe CC = new Cafe("CC", "3 College Lane", 1);
        System.out.println(CC);
        CC.showOptions();
        CC.enter();
        CC.goToFloor(1);

        // System.out.println(CC.getStock());
        // CC.sellCoffee(12, 2, 2);
        // System.out.println(CC.getStock());
        // CC.sellCoffee(12, 2, 2);
        // System.out.println(CC.getStock());
    }
    
}

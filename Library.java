import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);

    this.collection = new Hashtable<String, Boolean>();

    System.out.println("You have built a library: 📖");
  }

  public Library(){
    this.name = "Neilson";
    this.address = "1 Neilson Way";
    this.nFloors = 4;

    this.collection = new Hashtable<String, Boolean>();

    System.out.println("You have built a library: 📖");
  }

  /**
   * Adds a title to the collection
   * @param title title of the book being added 
   */
  public void addTitle(String title){
    this.collection.put(title, true);
    System.out.println("Succesfully added " + title + " to the collection.");
  }
  
  /**
   * Removes a title from the collection if it's already there 
   * @param title title of the book being removed 
   */
  public void removeTitle(String title){
    if (this.containsTitle(title)) {
      this.collection.remove(title);
      System.out.println(title + " successfully removed.");
    } else{
      System.out.println("We can't remove a book we don't have!");
    }
  }

  /**
   * Checks a title out if it's already there by changing the value in Hashtable 
   * @param title title of the book being checked out 
   */
  public void checkOut(String title){
    if (this.containsTitle(title)){
      if (this.isAvailable(title)){
        this.collection.replace(title, false);
        System.out.println(title + " successfully checked out.");
      } else{
        System.out.println("Sorry, this book is already checked out!");
      }
    }else{
      System.out.println("This book is not in the collection.");
    }
     
  }

  /**
   * Returns a title if it's been checked out by changing the value in Hashtable 
   * @param title title of the book being returned 
   */
  public void returnBook(String title){
    if (this.containsTitle(title)){
      if (this.isAvailable(title)){
        System.out.println("You can't return a book that hasn't been checked out!");
      } else{
        this.collection.replace(title, true);
        System.out.println(title + " successfully returned.");
      }
    }else{
      System.out.println("This book is not in the collection.");
    }
  }

  /**
   * Checks if a the collection has a title  
   * @param title title of the book
   * @return T/F is the title within the collection?
   */
  public boolean containsTitle(String title){
    if(this.collection.containsKey(title)){
      return true;
    }
    return false;
  }

  public boolean containsTitle(String title1, String title2, String title3){
    if(this.collection.containsKey(title1) && this.collection.containsKey(title2) && this.collection.containsKey(title3)){
        return true;
    }
    return false;
  }

  /**
   * Checks if a title is available 
   * @param title title of the book
   * @return T/F is the title available?
   */
  public boolean isAvailable(String title){
    if (this.containsTitle(title)){
      if(this.collection.get(title).equals(true)){
        return true;
      }else{
        return false;
      }
    }else{
      return false;
    }
    
  }

  /**
   * Iterates through each set of key and value using Set<Entry>  
   */
  public void printCollection(){
    Set<Entry<String, Boolean>> entrySet = collection.entrySet();
    for (Entry<String, Boolean> entry : entrySet){
      System.out.println("Book : " + entry.getKey() + " \t\t Available for Checkout : " + entry.getValue());
    }
  }

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(title)\n + printCollection()\n");
}

  public static void main(String[] args) {
    Library Neilson = new Library("Neislon", "6 Neilson Way", 4);
    Library Neilson2 = new Library();
    // System.out.println(Neilson);
    // Neilson.showOptions();


    Neilson.addTitle("Green Eggs & Ham");

    // Neilson.removeTitle("Calvin & Hobbes");
    // Neilson.removeTitle("Green Eggs & Ham");

    // System.out.println(Neilson.containsTitle("Green Eggs & Ham"));
    // System.out.println(Neilson.isAvailable("Green Eggs & Ham"));

    // Neilson.returnBook("Green Eggs & Ham"); 
    // Neilson.checkOut("Green Eggs & Ham");
    
    Neilson.addTitle("Calvin & Hobbes");
    Neilson.addTitle("Pride & Prejudice");

    System.out.println(Neilson.containsTitle("Green Eggs & Ham", "Calvin & Hobbes", "Pride & Prejudice"));
    // Neilson.containsTitle("Green Eggs & Ham", "Calvin & Hobbes", "Pride & Prejudice");
    // Neilson.printCollection();

    // Neilson.enter();
    // Neilson.goToFloor(2);
    // Neilson.goToFloor(4);
  }

}
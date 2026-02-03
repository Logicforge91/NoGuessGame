
public class Main{
     public static void main(String args[]){
        
    //    GameService  game  = new GameService();
      // game.startGame();

      //Puzzle.playGame();

      int arr[] = {2, 4, 5, 7, 8, 9, 12, 15};
        int target = 15;
        
    int linearResult = SearchAlgorithms.linearSearch(arr, target);
    int binaryResult = SearchAlgorithms.binarySearch(arr, target);
    
    if (linearResult != -1) {
        System.out.println("Linear Search: Element Found At Index: " + linearResult);
    } else {
        System.out.println("Linear Search: Element Not Found");
    }
    if (binaryResult != -1) {
        System.out.println("Binary Search: Element Found At Index: " + binaryResult);
    } else {
        System.out.println("Binary Search: Element Not Found");
    }

    



    }

    
}
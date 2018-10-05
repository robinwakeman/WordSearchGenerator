
import java.util.Scanner;

public class WordSearch {
	private String title;
	private Grid grid;
	private String[] dictionary;
	private String[] wordList;
	private Scanner scan;
	
	public void makeGrid(int x, int y) {
		grid = new Grid(x, y);
		String [] tempList = {"one", "two", "three", "four"};
		grid.placeWords(tempList);
		//grid.fillGrid();
	}
	
	public void print() { // TODO format output
		System.out.println(title);
		grid.printGrid();
		// TODO print word list
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public static void main(String[] args) {
		
		WordSearch WS = new WordSearch();
		
//		System.out.print("What is the title? ");
		WS.setTitle("Word Search");
//		
//		System.out.print("How many columns? ");
//		
//		System.out.print("How many rows? ");
//		
		WS.makeGrid(10, 8);
//				
//		System.out.print("Would you like to choose a custom set of words? (y/n) ");
//		
//		System.out.print("How many words would you like to search for? ");
		
		// TODO - custom set option
		//TODO error checking on word length, max possible words etc. 

		
		WS.print();

	}

}

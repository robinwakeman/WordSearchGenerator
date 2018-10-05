
public class WordSearch {
	private Grid grid;
	private String[] dictionary;
	
	public void setGrid(String title, int x, int y) {
		grid = new Grid(title, x, y);
		grid.fillGrid();
	}
	
	public void print() {
		grid.printTitle();
		grid.printWordList();
		grid.printGrid();
	}

	public static void main(String[] args) {
		
		WordSearch WS = new WordSearch();
		
//		System.out.print("What is the title? ");
//		
//		System.out.print("How many columns? ");
//		
//		System.out.print("How many rows? ");
//		
		WS.setGrid("Word Search Title", 10, 8);
//				
//		System.out.print("Would you like to choose a custom set of words? (y/n) ");
//		
//		System.out.print("How many words would you like to search for? ");
		
		// TODO - custom set option
		//TODO error checking on word length, max possible words etc. 

		
		WS.print();

	}

}

import java.util.Random;
public class Grid {
	private char[][] grid;
	private Random random;
	private int lastIndexAcross, lastIndexDown;
	
	public Grid(int x, int y) {
		grid = new char[y][x];
		lastIndexAcross = x - 1;
		lastIndexDown = y - 1;
		random = new Random();
		//fillGrid();
	}
	
	public void placeWords(String[] wordList) {
		placeHorizontal(wordList);
	}

	private boolean placeHorizontal(String[] wordList) {
		
		for (String word : wordList) {
			//randomly generate placement spot
			 // length of the word should be < spot to the end 
			boolean placeAvailable;
			do {
				int x0 = random.nextInt(lastIndexAcross - word.length() + 2); // 1 or 2?
				 int y0 = random.nextInt(lastIndexDown);
				
				 placeAvailable = spaceIsFree('h', x0, y0, word.length());
				 //check if placement spot and row are available
				 if (placeAvailable) {				 
					 //place word
					 for(int x=0; x<word.length(); x++) {
						 grid[y0][x0+x] = word.charAt(x);
					 } 
				 }		
			} while(!placeAvailable);
		}
		return false;
	}
	
	private boolean placeVertical() {
		return false;
	}
	
	private boolean placeDiagonal() {
		return false;
	}
	
	private boolean spaceIsFree(char direction, int x0, int y0, int wordLength) {
		switch (direction) {
			case 'h':
				for(int x=x0; x<wordLength; x++) {
					if (grid[y0][x] != 0) return false;
				}
				return true;
			case 'v': 
				break;
			case 'd':
				break;
			default:
		}
		return false;
	}
	
	public void fillGrid() {
		for (int y=0; y<grid.length; y++) {
			for (int x=0; x<grid[0].length; x++) {
				if (grid[y][x] == 0) { // if spot is empty (default char is 0)
					// randomly generate a character based on it's ASCII code
					grid[y][x] = (char) (random.nextInt(26) + 65); // A-Z = 65-90
				}
			}
		}
	}
	
	public void printGrid() {
		for (int y=0; y<grid.length; y++) {
			for (int x=0; x<grid[0].length; x++) {
				System.out.print(" " + grid[y][x] + " ");
			}
			System.out.println();
		}
	}
 
	
}

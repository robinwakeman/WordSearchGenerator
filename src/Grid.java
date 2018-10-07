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
		String[] temp1 = {"cat", "dog", "cow", "chicken"};
		//String[] temp1 = {"abc"};
		placeHorizontal(temp1);
		placeVertical(temp1);
		//fillGrid();
	}

	// TODO: handle case where a spot can't be found for the word, maybe after x tries
	private boolean placeHorizontal(String[] wordList) {
		
		for (String word : wordList) {
			//randomly generate placement spot
			 // length of the word should be < spot to the end 
			boolean placeAvailable;
			do {
				int x0 = random.nextInt(lastIndexAcross - word.length() + 2); // why 2?
				 int y0 = random.nextInt(lastIndexDown + 1); // +1 since nextInt(n) is 0-n exclusive
				 
				 //TODO word never appears in the last  row/column
				
				 placeAvailable = spaceIsFree('h', x0, y0, word);
				 //check if placement spot and row are available
				 if (placeAvailable) {				 
					 //place word
					 for(int x=0; x<word.length(); x++) {
						 grid[y0][x0+x] = word.charAt(x);
					 } 
				 }		
			} while(!placeAvailable);
		}
		return true;
	}
	
	private boolean placeVertical(String[] wordList) {
		for (String word : wordList) {
			//randomly generate placement spot
			 // length of the word should be < spot to the end 
			boolean placeAvailable;
			do {
				int x0 = random.nextInt(lastIndexAcross + 1); //+1 since nextInt(n) is 0-n exclusive
				 int y0 = random.nextInt(lastIndexDown - word.length() + 2); // 1 or 2?
				
				 placeAvailable = spaceIsFree('v', x0, y0, word);
				 //check if placement spot and row are available
				 if (placeAvailable) {				 
					 //place word
					 for(int y=0; y<word.length(); y++) {
						 grid[y0+y][x0] = word.charAt(y);
					 } 
				 }		
			} while(!placeAvailable);
		}
		return true;
	}
	
	private boolean placeDiagonal() {
		return false;
	}
	
	//TODO: NEXT: add ability to check if a spot/node has been checked already
	private boolean spaceIsFree(char direction, int x0, int y0, String word) {
		switch (direction) {
			case 'h':
				for(int x=0; x<word.length(); x++) {
					if (grid[y0][x0+x] != 0) 
						if(grid[y0][x0+x] != word.charAt(x)) return false;
				}
				return true;
			case 'v': 
				for(int y=0; y<word.length(); y++) { 
					if (grid[y0+y][x0] != 0)
						if(grid[y0+y][x0] != word.charAt(y)) return false; 
				}
				return true;
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

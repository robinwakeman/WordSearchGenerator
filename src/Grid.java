import java.util.Random;
public class Grid {
	private char[][] grid;
	private String title;
	private String[] wordList;
	private Random random;
	
	public Grid(String title, int x, int y) {
		this.title = title;
		grid = new char[x][y];
		random = new Random();
		fillGrid();
	}
	
	public void fillGrid() {
		for (int x=0; x<grid.length; x++) {
			for (int y=0; y<grid[0].length; y++) {
				grid[x][y] = (char) (random.nextInt(26) + 65); // A-Z = 65-90
			}
		}
	}
	
	public void placeWords() {
		
	}
	
	public void printTitle() {
		System.out.println(title);
	}
	
	public void printWordList() {
		
	}
	
	public void printGrid() {
		for (int x=0; x<grid.length; x++) {
			for (int y=0; y<grid[0].length; y++) {
				System.out.print(" " + grid[x][y] + " ");
			}
			System.out.println();
		}
	}
 
	
}

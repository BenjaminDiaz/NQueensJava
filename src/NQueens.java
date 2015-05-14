import java.util.Arrays;
import java.util.Random;

public class NQueens {
	private int SIZE = 100;
	private int[] board;
	private int[] collision;

	public NQueens() {
		initBoard();
		collision = new int[SIZE];
		collision = getCollision();
	}

	// Initializes board pseudorandomly without repeating numbers, so there is no need for horizontal collision check
	public void initBoard() {
		board = new int[SIZE];
		Random r = new Random();
		int n, count = 0;
		boolean fill;

		do {
			fill = true;
			n = r.nextInt(SIZE);
			// If the number exists in the array already, don't add it again
			for (int i = 0; i < SIZE; i++) {
				if (board[i] == n) {
					fill = false;
				}
			}
			// If the number didn't already exist, put it in the array and move
			// To the next position.
			if (fill == true) {
				board[count] = n;
				count++;
			}
		} while (count < SIZE - 1);
	}

	@Override
	public String toString() {
		return "NQueens: \n\tSIZE=" + SIZE + ", \n\tboard=" + Arrays.toString(board)
				+ ", \n\tcollision=" + Arrays.toString(collision);
	}

	public int[] getCollision() {
		int[] collisionTemp = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			int c = 0;

			// minor diagonal
			for (int j = 0; j < SIZE; j++) {
				if ((i != j) && (board[i] + i == board[j] + j))
					c++;

			}
			// main diagonal
			for (int j = 0; j < SIZE; j++) {
				if ((i != j) && (board[i] - i == board[j] - j))
					c++;
			}
			collisionTemp[i] = c;
		}
		return collisionTemp;
	}

	public int getCollisionSum() {
		int i, j;
		int cSum = 0;
		// minor diagonal
		for (i = 0; i < SIZE; i++)
			for (j = 0; j < SIZE; j++)
				if ((i != j) && (board[i] + i == board[j] + j))
					cSum++;
		// main diagonal
		for (i = 0; i < SIZE; i++)
			for (j = 0; j < SIZE; j++)
				if ((i != j) && (board[i] - i == board[j] - j))
					cSum++;

		return cSum;

	}

	public int getCollision(int index) {
		int c = 0;
		// minor diagonal
		for (int j = 0; j < SIZE; j++) {
			if ((index != j) && (board[index] + index == board[j] + j))
				c++;

		}
		// main diagonal
		for (int j = 0; j < SIZE; j++) {
			if ((index != j) && (board[index] - index == board[j] - j))
				c++;
		}

		return c;
	}

	//Gets index of the queen with most collision. In case there is more than one, it gets the one with the smaller index.
	public int getMaxCollisionIndex() {
		int maxIndex = 0;
		for (int i = 0; i < SIZE; i++) {
			if (collision[i] > collision[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public boolean isSolved() {
		int sum = 0;
		for (int i = 0; i < SIZE; i++) {
			sum += collision[i];
		}
		return (sum == 0);
	}

	//Swap queens if it reduces or mantains collision sum
	public void swapQueens(int i1, int i2) {
		int[] T = getBoard();
		int oldCollision = getCollisionSum();
		int temp = T[i1];
		T[i1] = T[i2];
		T[i2] = temp;
		int newCollision = getCollisionSum();
		if (newCollision <= oldCollision) {
			setBoard(T);
			setCollision(getCollision());
		} else {
			temp = T[i1];
			T[i1] = T[i2];
			T[i2] = temp;
			setBoard(T);
			setCollision(getCollision());
		}
	}

	public int getSize() {
		return this.SIZE;
	}

	public void setSize(int size) {
		SIZE = size;
	}

	public int[] getBoard() {
		return board;
	}

	public void setBoard(int[] board) {
		this.board = board;
	}

	public void setCollision(int[] collision) {
		this.collision = collision;
	}
}

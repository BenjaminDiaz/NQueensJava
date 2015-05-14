import java.util.Random;

public class NQueensSolution {

	NQueens q;

	public NQueensSolution() {
		this.q = new NQueens();
	}

	public void findSolution() {
		int maxI, tempI;
		int c = 0;
		Random r = new Random();
		while (!q.isSolved()) {
			maxI = q.getMaxCollisionIndex();
			tempI = r.nextInt(q.getSize());
			q.swapQueens(maxI, tempI);
			q.setCollision(q.getCollision());
			c++;
			if (c > 1300) {
				q = new NQueens();
				c = 0;
			}
		}
		System.out.println(q);
	}

}

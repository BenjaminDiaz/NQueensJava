import java.util.Random;

public class NQueensSolution {

	NQueens q;

	public NQueensSolution() {
		this.q = new NQueens();
	}

	public void findSolution() {

		while (!q.isSolved()) {
			for (int i = 0; i < q.getSize(); i++) {
				for (int j = i + 1; j < q.getSize(); j++) {
					if ((q.getCollision(i) != 0) || (q.getCollision(j) != 0))
						q.swapQueens(i, j);

					System.out.println(q);
				}
			}
		}
		System.out.println(q);
	}

	public void findSolution2() {
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

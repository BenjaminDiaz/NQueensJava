import java.util.Random;

public class NQueensSolution {

	NQueens q;

	public NQueensSolution() {
		this.q = new NQueens();
	}

	public void findSolution() {
		int maxI, tempI;
		int c = 0;
		int a = 0;
		Random r = new Random();
		while (!q.isSolved()) {
			maxI = q.getMaxCollisionIndex();
			tempI = r.nextInt(q.getSize());
			q.swapQueens(maxI, tempI);
			q.setCollision(q.getCollision());
			c++;
			if (c > q.getSize() * 10) {
				q = new NQueens();
				c = 0;
				a++;
			}
		}
		System.out.println(q);
		System.out.println(c+" ciclos");
	}

}

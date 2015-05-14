public class NQueensMain {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		NQueensSolution nqs = new NQueensSolution();
		nqs.findSolution2();
		long endTime = System.nanoTime();
		double time = (endTime - startTime) / 1000000000.0;
		System.out.println("Demoró "+time + " segundos");
	}
}

package Aufgabe3;

import java.awt.Color;

public class ImageFilterThreaded extends ImageFilter {

	/* teilt das Bild in vier Felder auf und jedem Thread wird ein Feld zugewiesen
	 */
	@Override
	protected Color[][] filterMatrix(float[][] filter) {
		Color [] [] result = new Color[matrix.length] [matrix[0].length];
		Thread [] workers = new Thread[4];
		workers [0] = new Thread(new ImageWorker(result, 0, 0, matrix.length / 2, matrix[0].length / 2, filter));
		workers [1] = new Thread(new ImageWorker(result, matrix.length / 2, 0, matrix.length, matrix[0].length / 2, filter));
		workers [2] = new Thread(new ImageWorker(result, 0, matrix[0].length / 2, matrix.length / 2, matrix[0].length, filter));
		workers [3] = new Thread(new ImageWorker(result, matrix.length / 2, matrix[0].length / 2, matrix.length, matrix[0].length, filter));
		for (int i = 0; i < workers.length; i++) {
			workers[i].start();
		}
		try {
			for (int i = 0; i < workers.length; i++) {
				workers[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	Fuer jeden Thread wird eine Instanz der ImageWorker-Klasse erstellt
	 */
	private class ImageWorker implements Runnable {
		private Color[] [] result;
		private int x;
		private int y;
		private int width;
		private int height;
		private float [] [] filter;

		public ImageWorker(Color [] [] result, int x, int y, int width, int height, float [] [] filter) {
			super ();
			this.result = result;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.filter = filter;
		}

		/*
		Wendet die filterPixel-Methode auf dne übergebenen Bereich an
		 */
		@Override
		public void run() {
			for (int i = x; i < width; i++) {
				for (int j = y; j < height; j++) {
					filterPixel(result, i, j, filter);
				}
			}
		}
	}
}

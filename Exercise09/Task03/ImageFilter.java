package Aufgabe3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFilter {
	
	private static final int FILTER_SIZE = 3;
	private static final int OFFSET = FILTER_SIZE / 2;

	public static final float[][] FILTER_BLUR = new float[][] {
		{ 0.111f, 0.111f, 0.111f },
		{ 0.111f, 0.111f, 0.111f },
		{ 0.111f, 0.111f, 0.111f }
	};
	public static final float[][] FILTER_SHARPEN = new float[][] {
		{ 0.f, -1f, 0.f },
		{ -1f, 5f, -1f },
		{ 0.f, -1f, 0.f }
	};
	public static final float[][] FILTER_LINES = new float[][] {
		{ -1f, -1f, -1f },
		{ -1f, 8f, -1f },
		{ -1f, -1f, -1f }
	};
	
	protected Color[][] matrix = new Color[0][0];
	
	public void setImage(File input) throws IOException {
		BufferedImage img = ImageIO.read(input);
		getMatrix(img);
	}
	
	public void applyFilter(float[][] filter, File output) throws IOException, InvalidFilterException {
		if (filter == null || filter.length != FILTER_SIZE || filter[0].length != FILTER_SIZE) {
			throw new InvalidFilterException();
		}
		Color[][] result = filterMatrix(filter);
		BufferedImage img = new BufferedImage(result.length, result[0].length, BufferedImage.TYPE_INT_RGB);
		setMatrix(img, result);
		ImageIO.write(img, "jpg", output);
	}

	protected Color[][] filterMatrix(float[][] filter) {
		Color[][] result = new Color[matrix.length][matrix[0].length];
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				filterPixel(result, x, y, filter);
			}
		}
		return result;
	}

	protected void filterPixel(Color[][] result, int x, int y, float[][] filter) {
		Color[][] colors = getColorMatrix(x, y);
		float red = 0;
		float green = 0;
		float blue = 0;
		for (int i = 0; i < FILTER_SIZE; i++) {
			for (int j = 0; j < FILTER_SIZE; j++) {
				red += (float) colors[i][j].getRed() * filter[i][j];
				green += (float) colors[i][j].getGreen() * filter[i][j];
				blue += (float) colors[i][j].getBlue() * filter[i][j];
			}
		}
		red = Math.min(red, 255);
		red = Math.max(red, 0);
		green = Math.min(green, 255);
		green = Math.max(green, 0);
		blue = Math.min(blue, 255);
		blue = Math.max(blue, 0);
		result[x][y] = new Color(Math.round(red), Math.round(green), Math.round(blue));
	}

	protected Color[][] getColorMatrix(int x, int y) {
		Color[][] result = new Color[FILTER_SIZE][FILTER_SIZE];
		for (int i = 0; i < FILTER_SIZE; i++) {
			for (int j = 0; j < FILTER_SIZE; j++) {
				result[i][j] = getColor(x + (i - OFFSET), y + (j - OFFSET));
			}
		}
		return result;
	}

	protected Color getColor(int x, int y) {
		x = Math.min(x, matrix.length - 1);
		x = Math.max(x, 0);
		y = Math.min(y, matrix[0].length - 1);
		y = Math.max(y, 0);
		return matrix[x][y];
	}

	private void setMatrix(BufferedImage img, Color[][] matrix) {
		for (int x=0;x<matrix.length;x++) {
			for (int y=0;y<matrix[x].length;y++) {
				img.setRGB(x, y, matrix[x][y].getRGB());
			}
		}
	}

	private void getMatrix(BufferedImage img) {
		matrix = new Color[img.getWidth()][img.getHeight()];
		for (int x=0;x<img.getWidth();x++) {
			for (int y=0;y<img.getHeight();y++) {
				matrix[x][y] = new Color(img.getRGB(x, y));
			}
		}
	}

}

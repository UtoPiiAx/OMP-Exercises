import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Lights extends Application {

	final static int SIZE = 4;

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		DoubleProperty num = new SimpleDoubleProperty(SIZE);
		NumberBinding divWidth = pane.widthProperty().divide(num);
		NumberBinding divHeight = pane.heightProperty().divide(num);
		Rectangle[][] lights = new Rectangle[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				lights[i][j] = new Rectangle();
				lights[i][j].setFill(Color.WHITE);
				lights[i][j].setStroke(Color.BLACK);
				lights[i][j].addEventHandler(MouseEvent.MOUSE_PRESSED,
						new ClickHandler(lights, i, j));
				lights[i][j].widthProperty().bind(divWidth);
				lights[i][j].heightProperty().bind(divHeight);
				pane.add(lights[i][j], i, j);
			}
		}
		Scene scene = new Scene(pane, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lights");
		primaryStage.show();
	}

}

class ClickHandler implements EventHandler<MouseEvent> {

	Rectangle[][] lights;
	int row;
	int col;

	ClickHandler(Rectangle[][] rect, int r, int c) {
		this.lights = rect;
		this.row = r;
		this.col = c;
	}

	private void switchColor(Rectangle light) {
		if (light.getFill().equals(Color.WHITE)) {
			light.setFill(Color.YELLOW);
		} else {
			light.setFill(Color.WHITE);
		}
	}

	@Override
	public void handle(MouseEvent event) {
		switchColor(lights[row][col]);
		if (row - 1 >= 0) {
			switchColor(lights[row - 1][col]);
		}
		if (row + 1 < lights.length) {
			switchColor(lights[row + 1][col]);
		}
		if (col + 1 < lights[row].length) {
			switchColor(lights[row][col + 1]);
		}
		if (col - 1 >= 0) {
			switchColor(lights[row][col - 1]);
		}

	}

}

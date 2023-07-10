import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Colors extends Application {

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.BASELINE_CENTER);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		
		Rectangle rect = new Rectangle(0, 0, 200, 200);
		rect.setFill(Color.rgb(0, 0, 0));
		
		Slider red = new Slider(0, 255, 0);
		red.setOrientation(Orientation.HORIZONTAL);
		red.setShowTickMarks(true);
		red.setShowTickLabels(true);
		red.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));

		Slider green = new Slider(0, 255, 0);
		green.setOrientation(Orientation.HORIZONTAL);
		green.setShowTickMarks(true);
		green.setShowTickLabels(true);
		green.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

		Slider blue = new Slider(0, 255, 0);
		blue.setOrientation(Orientation.HORIZONTAL);
		blue.setShowTickMarks(true);
		blue.setShowTickLabels(true);
		blue.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));

		vbox.getChildren().addAll(rect, red, green, blue);

		red.valueProperty().addListener((observable, oldValue, newValue) -> {
			rect.setFill(Color.rgb((int) red.getValue(), (int) green.getValue(),
					(int) blue.getValue()));
		});
		green.valueProperty().addListener((observable, oldValue, newValue) -> {
			rect.setFill(Color.rgb((int) red.getValue(), (int) green.getValue(),
					(int) blue.getValue()));
		});
		blue.valueProperty().addListener((observable, oldValue, newValue) -> {
			rect.setFill(Color.rgb((int) red.getValue(), (int) green.getValue(),
					(int) blue.getValue()));
		});

		Scene scene = new Scene(vbox, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Color-Mixer");
		primaryStage.show();
	}

}

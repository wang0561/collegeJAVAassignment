package algonquin.practise;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
/*  w w  w. j a  v a  2  s .com*/
public class Main extends Application {

  @Override
  public void start(Stage stage) {
BorderPane bp = new BorderPane();
   

//
//    Text text = new Text("hhhsssss");
//    text.setStyle("-fx-font: 40px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
//    text.setFill(Color.VIOLET);
final String content = "hhhhhh";
final Text text = new Text(10, 20, "");
    final Transition animation = new Transition() {
        {
            setCycleDuration(Duration.millis(2000));
        }
    
        protected void interpolate(double frac) {
            final int length = content.length();
            final int n = Math.round(length * (float) frac);
            text.setText(content.substring(0, n));
        }
    
    };
    
    animation.play();


    PauseTransition pt = new PauseTransition(Duration.millis(1000));
    FadeTransition ft = new FadeTransition(Duration.millis(2000));
    ft.setFromValue(1.0f);
    ft.setToValue(0.3f);
    ft.setAutoReverse(true);
    TranslateTransition tt = new TranslateTransition(Duration.millis(2000));
    tt.setFromX(-100f);
    tt.setToX(100f);
    tt.setAutoReverse(true);
    RotateTransition rt = new RotateTransition(Duration.millis(2000));
   rt.setByAngle(180f);
    rt.setAutoReverse(true);
    ScaleTransition st = new ScaleTransition(Duration.millis(2000));
    st.setByX(1.5f);
    st.setByY(1.5f);
    st.setAutoReverse(true);

    SequentialTransition seqT = new SequentialTransition(text, pt, ft, tt, 
        st,rt);
    seqT.play();
  bp.setCenter(text);
    //.getChildren().add(text);
    Scene scene = new Scene(bp, 600, 400);
    stage.setScene(scene);
    stage.setTitle("");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
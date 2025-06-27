import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {

  private int hour;
  private int minute;
  private int second;

  public int getHour() { return hour; }
  public int getMinute() { return minute; }
  public int getSecond() { return second; }

  public ClockPane() {
    setCurrentTime();
    paintClock();
  }
  public void setCurrentTime(){
    Calendar cal = new GregorianCalendar();
    this.hour = cal.get(Calendar.HOUR);
    this.minute = cal.get(Calendar.MINUTE);
    this.second = cal.get(Calendar.SECOND);
    paintClock();
  }

  private void paintClock() {
    double radius = Math.min(getWidth(), getHeight()) * 0.4;
    double centerx = getWidth() / 2;
    double centery = getHeight() / 2;
    double slen = radius * 0.8;
    double mlen = radius * 0.6;
    double hlen = radius * 0.4;

    Circle circle = new Circle(centerx, centery, radius);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);

    // paint texts
    Text t1 = new Text(centerx - 5, centery + 12 - radius, "12");
    Text t2 = new Text(centerx - 10 + radius, centery + 3, "3");
    Text t3 = new Text(centerx - 3, centery + radius - 3, "6");
    Text t4 = new Text(centerx - radius + 3, centery + 5, "9");

    //paint secs
    double sEndX = centerx + slen * Math.sin((second * 2 * Math.PI) / 60);
    double sEndY = centery - slen * Math.cos((second * 2 * Math.PI) / 60);
    Line sLine = new Line(centerx, centery, sEndX, sEndY);
    sLine.setStroke(Color.RED);

    // paint mins
    double mEndX = centerx + mlen * Math.sin((minute * 2 * Math.PI) / 60);
    double mEndY = centery - mlen * Math.cos((minute * 2 * Math.PI) / 60);
    Line mLine = new Line(centerx, centery, mEndX, mEndY);
    mLine.setStroke(Color.GREEN);

    // paint hour
    double hEndX = centerx + hlen * Math.sin((((hour % 12) + minute / 60) * 2 * Math.PI) / 12);
    double hEndY = centery - hlen * Math.cos((((hour % 12) + minute / 60) * 2 * Math.PI) / 12);
    Line hLine = new Line(centerx, centery, hEndX, hEndY);
    hLine.setStroke(Color.BLUE);

    getChildren().clear();
    getChildren().addAll(circle, sLine, mLine, hLine);
    getChildren().addAll(t1, t2, t3, t4);
  }

  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paintClock();
  }

  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paintClock();
  }
}

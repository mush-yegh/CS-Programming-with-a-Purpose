import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {

  public static void main(String[] args) {

    In dataFile = new In(args[0]);
    int countPerGroup = Integer.parseInt(args[1]);

    String title = dataFile.readLine();
    String xAxis = dataFile.readLine();
    String source = dataFile.readLine();

    BarChart chart = new BarChart(title, xAxis, source);

    StdDraw.setCanvasSize(1000, 700);
    StdDraw.enableDoubleBuffering();

    Bar[] bars = null;

    while (dataFile.hasNextLine()) {
      chart.reset();
      dataFile.readLine(); // blank line
      int recordsCount = Integer.parseInt(dataFile.readLine()); // number of records in group
      bars = new Bar[recordsCount];
      for (int i = 0; i < recordsCount; i++) {
        String recordRow = dataFile.readLine();
        String[] splittedRecord = recordRow.trim().split(",");
        String year = splittedRecord[0];
        chart.setCaption(year);

        String city = splittedRecord[1];
        int value = Integer.parseInt(splittedRecord[3]);
        String category = splittedRecord[4];
        bars[i] = new Bar(city, value, category);
      }
      Arrays.sort(bars, Collections.reverseOrder());

      for (int i = 0; i < countPerGroup; i++) {
        chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
      }
      StdDraw.clear();
      chart.draw();
      StdDraw.show();
      StdDraw.pause(300);
      bars = null;
    }
  }
}


public class Clock {
  private static final int HOURS_PER_DAY = 24;
  private static final int MINUTES_PER_HOUR = 60;
  private static final String DELIMITER = ":";

  private int h;
  private int m;

  public Clock(int h, int m) {
    if (!isValid(h, m)) {
      throw new IllegalArgumentException("Invalid argument(s) provided!");
    }
    this.h = h;
    this.m = m;
  }

  public Clock(String s) {
    if (!isValid(s)) {
      throw new IllegalArgumentException("Invalid argument(s) provided!");
    }
    this.h = Integer.parseInt(s.substring(0, s.indexOf(DELIMITER)));
    this.m = Integer.parseInt(s.substring(s.indexOf(DELIMITER) + 1));
  }

  private boolean isValid(int hours, int minutes) {
    return hours >= 0 && hours < HOURS_PER_DAY && minutes >= 0 && minutes < MINUTES_PER_HOUR;
  }

  private boolean isValid(String s) {
    if (s == null) {
      return false;
    }
    int delimiterIndex = s.indexOf(DELIMITER);
    if (delimiterIndex == -1) {
      return false;
    }
    String hours = s.substring(0, delimiterIndex);
    String minutes = s.substring(delimiterIndex + 1);

    if (hours.length() != 2 || minutes.length() != 2) {
      return false;
    }
    return isValid(Integer.parseInt(hours), Integer.parseInt(minutes));
  }

  private void addOneHour() {
    this.h = this.h + 1 == HOURS_PER_DAY ? 0 : this.h + 1;
  }

  private void addDeltaHours(int delta) {
    int hoursToAdd = delta % HOURS_PER_DAY;
    for (int i = 0; i < hoursToAdd; i++) {
      addOneHour();
    }
  }

  public boolean isEarlierThan(Clock that) {
    return this.h < that.h || (this.h == that.h && this.m < that.m);
  }

  public void tic() {
    if (this.m + 1 == MINUTES_PER_HOUR) {
      addOneHour();
      this.m = 0;
    } else {
      this.m = this.m + 1;
    }
  }

  public void toc(int delta) {
    if (delta < 0) {
      throw new IllegalArgumentException("Invalid argument provided!");
    }
    addDeltaHours(delta / MINUTES_PER_HOUR);
    for (int i = 0; i < delta % MINUTES_PER_HOUR; i++) {
      tic();
    }
  }

  public String toString() {
    String HH = String.valueOf(this.h);
    HH = HH.length() == 2 ? HH : "0" + HH;
    String MM = String.valueOf(this.m);
    MM = MM.length() == 2 ? MM : "0" + MM;
    return HH + ":" + MM;
  }

  public static void main(String[] args) {
    Clock clockString = new Clock("23:59");
    clockString.tic();
    clockString.tic();
    clockString.tic();
    clockString.tic();
    clockString.toc(25);
    System.out.println(clockString);

    Clock clockInt = new Clock(12, 1);
    clockInt.tic();
    clockInt.tic();
    clockInt.addDeltaHours(25);
    System.out.println(clockInt);

    System.out.println(clockInt.isEarlierThan(clockString));
  }
}


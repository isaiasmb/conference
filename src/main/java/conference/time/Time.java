package conference.time;

public class Time {

	private int hour;
	private int minute;
	private int seconds;
	private String period;

	public Time(int hour, int minute, String period) {
		this.hour = hour;
		this.minute = minute;
		this.period = period;
	}

	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return TimeUtils.addZeroInTime(hour) + ":" + TimeUtils.addZeroInTime(minute) + period;
	}

}

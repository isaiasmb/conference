package conference;

import java.util.Comparator;

import conference.time.Time;

public class Talk implements Comparator<Talk> {

	private String title;
	private Time time;
	private int duration;

	public Talk(Time time, String title) {
		this.time = time;
		this.title = title;
	}

	public Talk(String title, int duration) {
		this.title = title;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int compare(Talk talk1, Talk talk2) {
		return (talk1.getDuration() > talk2.getDuration() ? 1 : 0);
	}

	@Override
	public String toString() {
		return time + " " + title + (duration > 0 ? " " + duration + "min" : "");
	}

}

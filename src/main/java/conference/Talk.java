package conference;

import conference.time.Time;

public class Talk implements Comparable<Talk> {

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

	public int compareTo(Talk talk1) {
		return (talk1.getDuration() < this.getDuration() ? -1 : 0);
	}
	
	@Override
	public String toString() {
		return time + " " + title + (duration > 0 ? " " + duration + "min" : "");
	}


}

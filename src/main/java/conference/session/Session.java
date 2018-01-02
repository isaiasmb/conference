package conference.session;

import java.util.ArrayList;
import java.util.List;

import conference.Talk;
import conference.time.Time;
import conference.time.TimeUtils;

public abstract class Session {

	public int hour;
	public int minute;
	public int limitTime;
	protected List<Talk> talks = new ArrayList<Talk>();

	public abstract void addTalkToSession(Talk talk);
	
	public void calculateTime(int talkDuration) {
		
		Time newTime = TimeUtils.addMinutesToTime(this.hour, this.minute, talkDuration);
		this.hour = newTime.getHour();
		this.minute = newTime.getMinute();
		
		this.limitTime -= talkDuration;
	}

	public List<Talk> getTalks() {
		return talks;
	}
	
}

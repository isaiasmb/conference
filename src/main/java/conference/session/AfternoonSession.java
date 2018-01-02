package conference.session;

import conference.Talk;
import conference.time.Time;

public class AfternoonSession extends Session {
	
	public AfternoonSession() {
		this.hour = 1;
		this.minute = 0;
		this.limitTime = 230;
	}

	@Override
	public void addTalkToSession(Talk talk) {
		talk.setTime(new Time(this.hour, this.minute, "PM"));
		this.talks.add(talk);
		this.calculateTime(talk.getDuration());
	}

}

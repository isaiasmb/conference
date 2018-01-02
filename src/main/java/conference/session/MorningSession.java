package conference.session;

import conference.Talk;
import conference.time.Time;

public class MorningSession extends Session {
	
	public MorningSession() {
		this.hour = 9;
		this.minute = 0;
		this.limitTime = 180;
	}

	@Override
	public void addTalkToSession(Talk talk) {
		talk.setTime(new Time(this.hour, this.minute, "AM"));
		this.talks.add(talk);
		this.calculateTime(talk.getDuration());
	}

}

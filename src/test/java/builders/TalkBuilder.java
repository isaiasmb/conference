package builders;

import conference.Talk;
import conference.time.Time;

public class TalkBuilder {

	private Talk talk;

	public TalkBuilder() {

	}

	public static TalkBuilder oneTalk() {
		TalkBuilder talkBuilder = new TalkBuilder();
		talkBuilder.talk = new Talk("Writing Fast Tests Against Enterprise Rails", 60);
		return talkBuilder;
	}
	
	public TalkBuilder withDuration(int duration) {
		talk.setDuration(duration);
		return this;
	}
	
	public TalkBuilder withTitle(String title) {
		talk.setTitle(title);
		return this;
	}
	
	public TalkBuilder withTime(Time time) {
		talk.setTime(time);
		return this;
	}

	public Talk now() {
		return talk;
	}

}

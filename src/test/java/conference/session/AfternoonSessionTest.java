package conference.session;

import static builders.TalkBuilder.oneTalk;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import conference.Talk;
import conference.session.AfternoonSession;

public class AfternoonSessionTest {

	@Test
	public void shouldAddTalkToSession() {
		Talk talk = oneTalk().now();

		AfternoonSession afternoonSession = new AfternoonSession();
		afternoonSession.addTalkToSession(talk);

		assertThat("01:00PM Writing Fast Tests Against Enterprise Rails 60min", is(afternoonSession.getTalks().get(0).toString()));
	}
}

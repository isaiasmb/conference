package conference.session;

import static builders.TalkBuilder.oneTalk;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import conference.Talk;
import conference.session.MorningSession;

public class MorningSessionTest {

	@Test
	public void shouldAddTalkToSession() {
		Talk talk = oneTalk().now();

		MorningSession morningSession = new MorningSession();
		morningSession.addTalkToSession(talk);

		assertThat("09:00AM Writing Fast Tests Against Enterprise Rails 60min", is(morningSession.getTalks().get(0).toString()));
	}
}

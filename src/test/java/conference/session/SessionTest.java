package conference.session;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import conference.session.Session;

public class SessionTest {

	@Spy
	private Session session;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldUpdateHourWhenCalculateTime() {
		session.hour = 1;
		session.calculateTime(60);

		assertThat(2, is(session.hour));
	}

	@Test
	public void shouldUpdateMinuteWhenCalculateTime() {
		session.minute = 30;
		session.calculateTime(45);

		assertThat(15, is(session.minute));
	}

	@Test
	public void shouldUpdateLimitTimeWhenCalculateTime() {
		session.limitTime = 180;
		session.calculateTime(30);

		assertThat(150, is(session.limitTime));
	}

}

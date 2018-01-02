package conference.time;

import static conference.time.TimeUtils.addMinutesToTime;
import static conference.time.TimeUtils.addZeroInTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import conference.time.Time;

public class TimeUtilsTest {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void shouldAddZeroInTime() {
		String timeWithZero = addZeroInTime(1);
		assertThat(timeWithZero, is("01"));
	}
	
	@Test
	public void shouldAddMinutesToTime() {
		Time time = addMinutesToTime(9, 30, 50);
		
		error.checkThat(time.getHour(), is(10));
		error.checkThat(time.getMinute(), is(20));
	}

}

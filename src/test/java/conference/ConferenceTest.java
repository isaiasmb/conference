package conference;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import builders.TalkBuilder;

public class ConferenceTest {

	@Spy
	private Conference conference;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldCreateConference() {
		List<Track> tracks = conference.createConference();
		
		for (Track track : tracks) {
			System.out.println(track);
		}
		
		assertThat(tracks.size() > 0, is(true));
	}

	@Test
	public void shouldCreateTracks() {

		List<Talk> talks = createTalks();
		List<Track> tracks = conference.createTracks(talks);

		List<String> tracksTitle = new ArrayList<String>();
		for (Track track : tracks) {
			tracksTitle.add(track.getTitle());
		}

		assertThat(tracksTitle, containsInAnyOrder("Track 1", "Track 2"));
	}

	@Test
	public void shouldAddTalksWhenCreateTracks() {
		List<Talk> talks = createTalks();
		List<Track> tracks = conference.createTracks(talks);

		List<Talk> talksToTricks = new ArrayList<Talk>();
		for (Track track : tracks) {
			talksToTricks.addAll(track.getTalks());
		}

		assertThat(talksToTricks, IsIterableWithSize.<Talk>iterableWithSize(23));
	}

	private List<Talk> createTalks() {
		Talk talk1 = TalkBuilder.oneTalk().now();
		Talk talk2 = TalkBuilder.oneTalk().withTitle("Overdoing it in Python").withDuration(45).now();
		Talk talk3 = TalkBuilder.oneTalk().withTitle("Lua for the Masses").withDuration(30).now();
		Talk talk4 = TalkBuilder.oneTalk().withTitle("Ruby Errors from Mismatched Gem Versions").withDuration(45).now();
		Talk talk5 = TalkBuilder.oneTalk().withTitle("Common Ruby Errors").withDuration(45).now();
		Talk talk6 = TalkBuilder.oneTalk().withTitle("Rails for Python Developers lightning").withDuration(5).now();
		Talk talk7 = TalkBuilder.oneTalk().withTitle("Communicating Over Distance").withDuration(60).now();
		Talk talk8 = TalkBuilder.oneTalk().withTitle("Accounting-Driven Development").withDuration(45).now();
		Talk talk9 = TalkBuilder.oneTalk().withTitle("Woah").withDuration(30).now();
		Talk talk10 = TalkBuilder.oneTalk().withTitle("Sit Down and Write").withDuration(30).now();
		Talk talk11 = TalkBuilder.oneTalk().withTitle("Pair Programming vs Noise").withDuration(45).now();
		Talk talk12 = TalkBuilder.oneTalk().withTitle("Rails Magic").withDuration(60).now();
		Talk talk13 = TalkBuilder.oneTalk().withTitle("Ruby on Rails: Why We Should Move On").withDuration(60).now();
		Talk talk14 = TalkBuilder.oneTalk().withTitle("Clojure Ate Scala (on my project)").withDuration(45).now();
		Talk talk15 = TalkBuilder.oneTalk().withTitle("Programming in the Boondocks of Seattle").withDuration(30).now();
		Talk talk16 = TalkBuilder.oneTalk().withTitle("Ruby vs. Clojure for Back-End Development").withDuration(30).now();
		Talk talk17 = TalkBuilder.oneTalk().withTitle("Ruby on Rails Legacy App Maintenance").withDuration(60).now();
		Talk talk18 = TalkBuilder.oneTalk().withTitle("A World Without HackerNews").withDuration(30).now();
		Talk talk19 = TalkBuilder.oneTalk().withTitle("User Interface CSS in Rails Apps").withDuration(30).now();

		return Arrays.asList(talk1, talk2, talk3, talk4, talk5, talk6, talk7, talk8, talk9, talk10, talk11, talk12, talk13,
				talk14, talk15, talk16, talk17, talk18, talk19);
	}

}

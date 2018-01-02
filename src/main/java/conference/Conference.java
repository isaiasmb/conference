package conference;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import conference.file.FileUtils;
import conference.session.AfternoonSession;
import conference.session.MorningSession;
import conference.session.Session;
import conference.time.Time;
import conference.time.TimeUtils;

public class Conference {
	
	private List<Track> tracks = new ArrayList<Track>();
	
	public List<Track> createConference() {
		InputStream inputStream = this.getClass().getResourceAsStream("/input.txt");
		List<Talk> talks = FileUtils.getTalksBy(inputStream);
		return createTracks(talks);
	}
	
	public List<Track> createTracks(List<Talk> talks) {
		List<Talk> remainingTalks = new ArrayList<Talk>(talks);
		Collections.sort(remainingTalks);
		List<Track> tracks = new ArrayList<Track>();
		
		int count = 1;
		while(remainingTalks.size() > 0) {
			// MORNING SESSION
			Session session = new MorningSession();			
			Track track = new Track("Track " + count);
			session = addTalksToSessions(remainingTalks, session);		
			remainingTalks.removeAll(session.getTalks());		
			track.getTalks().addAll(session.getTalks());
			
			track.getTalks().add(new Talk(new Time(12, 0, "PM"), "Lunch"));
			
			// AFTERNOON SESSION
			session = new AfternoonSession();		
			session = addTalksToSessions(remainingTalks, session);		
			remainingTalks.removeAll(session.getTalks());		
			track.getTalks().addAll(session.getTalks());		
			tracks.add(track);
			
			track.getTalks().add(createNetworkingEvent(track));
			
			count++;
		}
		
		return tracks;
	}
	
	private Session addTalksToSessions(List<Talk> talks, Session session) {
		for (Talk talk : talks) {
			if ((session.limitTime - talk.getDuration()) > 0) {
					session.addTalkToSession(talk);
			}
		}
		return session;
	}
	
	public static void main(String[] args) {
		int value = 0;
		System.out.println(value % 60);
	}
	
	private Talk createNetworkingEvent(Track track) {
		Talk lastTalk = track.getTalks().get(track.getTalks().size() - 1);
		Time newTime = TimeUtils.addMinutesToTime(lastTalk.getTime().getHour(), lastTalk.getTime().getMinute(), lastTalk.getDuration());
		newTime.setPeriod(lastTalk.getTime().getPeriod());
		return new Talk(newTime, "Networking Event");
	}

	public List<Track> getTracks() {
		return tracks;
	}
	
}

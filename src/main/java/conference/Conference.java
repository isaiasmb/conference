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
			session = addTalksToSessionMorning(remainingTalks, session);		
			remainingTalks.removeAll(session.getTalks());		
			track.getTalks().addAll(session.getTalks());
			
			track.getTalks().add(new Talk(new Time(12, 0, "PM"), "Lunch"));
			
			// AFTERNOON SESSION
			session = new AfternoonSession();		
			session = addTalksToSessionAfternoon(remainingTalks, session);		
			remainingTalks.removeAll(session.getTalks());		
			track.getTalks().addAll(session.getTalks());		
			tracks.add(track);
			
			track.getTalks().add(createNetworkingEvent(track));
			
			count++;
		}
		
		return tracks;
	}
	
	private Session addTalksToSessionMorning(List<Talk> talks, Session session) {
		int usedLimit = 0;
		int totalLimit = session.limitTime;
		for (Talk talk : talks) {
			if ((usedLimit + talk.getDuration()) <= totalLimit) {
				if (usedLimit % 60 == 0 && talk.getDuration() == 60) {
					session.addTalkToSession(talk);
					usedLimit += talk.getDuration();
				} else if ((usedLimit % 60 == 45 || usedLimit % 60 == 15 || usedLimit % 45 == 0) && (talk.getDuration() == 45)) {
					session.addTalkToSession(talk);
					usedLimit += talk.getDuration();
				} else if ((usedLimit % 60 != 0 && usedLimit % 30 == 0) && (talk.getDuration() == 30)) {
					session.addTalkToSession(talk);
					usedLimit += talk.getDuration();
				}
			}
		}
		return session;
	}
	
	private Session addTalksToSessionAfternoon(List<Talk> talks, Session session) {
		for (Talk talk : talks) {
			if ((session.limitTime - talk.getDuration()) > 0) {
					session.addTalkToSession(talk);
			}
		}
		return session;
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

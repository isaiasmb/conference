package conference;

import java.util.ArrayList;
import java.util.List;

public class Track {

	private String title;
	private List<Talk> talks = new ArrayList<Talk>();

	public Track(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Talk> getTalks() {
		return talks;
	}

	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(title + ":\n");

		for (Talk talk : talks) {
			string.append(talk + "\n");
		}

		return string.toString();
	}

}

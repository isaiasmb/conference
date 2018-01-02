package conference.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import conference.Talk;

public class FileUtils {
	
	public static List<Talk> getTalksBy(InputStream inputStream) {
		List<Talk> talks = new ArrayList<Talk>();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String readLine = bufferedReader.readLine();
			
			while (readLine != null) {
				String talkTitle = extractTalkTitle(readLine);				
				int talkDuration = extractTalkDuration(readLine);
				Talk talk = new Talk(talkTitle, talkDuration);
				
				talks.add(talk);
				
				readLine = bufferedReader.readLine();
			}			
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return talks;
	}

	private static String extractTalkTitle(String readLine) {
		String title = "";
		Pattern pattern = Pattern.compile("[a-zA-Z]+[ ]");
		Matcher matcher = pattern.matcher(readLine);		
		
		while (matcher.find()) {
			title += matcher.group();
		}
		
		return title;
	}

	private static int extractTalkDuration(String readLine) {
		int duration = 5;
		Pattern pattern = Pattern.compile("[\\d]+");
		Matcher matcher = pattern.matcher(readLine);		
		
		if (matcher.find()) {
			duration = Integer.parseInt(matcher.group(0));
		}	
		
		return duration;
	}

}

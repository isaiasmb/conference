package conference;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.reflect.Whitebox.invokeMethod;

import java.io.InputStream;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import conference.file.FileUtils;

@RunWith(PowerMockRunner.class)
public class FileUtilsTest {

	@InjectMocks
	private FileUtils fileUtils;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		fileUtils = PowerMockito.spy(fileUtils);
	}

	@Test
	public void shouldCreateTalksByFileInput() {
		InputStream inputStream = this.getClass().getResourceAsStream("/input.txt");
		List<Talk> talks = fileUtils.getTalksBy(inputStream);

		assertThat(talks.size() > 0, is(true));
	}

	@Test
	public void shouldExtractTalkTitle() throws Exception {
		String readLine = "Writing Fast Tests Against Enterprise Rails 60min";

		String talkTitle = invokeMethod(fileUtils, "extractTalkTitle", readLine);

		assertThat(talkTitle, is("Writing Fast Tests Against Enterprise Rails "));
	}

	@Test
	public void shouldExtractTalkDuration() throws Exception {
		String readLine = "Writing Fast Tests Against Enterprise Rails 60min";

		Integer talkDuration = Whitebox.invokeMethod(fileUtils, "extractTalkDuration", readLine);

		Assert.assertThat(talkDuration, CoreMatchers.is(60));
	}

}

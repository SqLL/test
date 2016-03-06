package tutorial.java.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReaderTest {
	
	Reader reader;
	
	// Before every test
	@Before
	public void init(){
		reader = new Reader();
	}

	@Test
	public void testgetContentFile() throws IOException, URISyntaxException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("LeagueOfLegend");
		String result = reader.getContentFile(url);
		assertNotNull(result);
	}
	
	@Test(expected = NullPointerException.class)
	public void testgetContentFileWithException() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("LeagueOfLegend2");
		String result = reader.getContentFile(url);
		assertNotNull(result);
	}
	
	// After everytest
	@After
	public void after() {
		// Rien pour le moment
	}
}

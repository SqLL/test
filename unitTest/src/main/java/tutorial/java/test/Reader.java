package tutorial.java.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class Reader {

	String defaultPath;

	public Reader() {

	}

	public String getContentFile(URL url) throws IOException {
		String result = "";

		ClassLoader classLoader = getClass().getClassLoader();
		InputStream in = url.openStream();
		result = IOUtils.toString(in);

		return result;

	}
}

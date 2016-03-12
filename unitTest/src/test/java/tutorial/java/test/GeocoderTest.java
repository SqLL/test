package tutorial.java.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * #cestpartiepourlesmocks.
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Geocoder.class, URL.class, HttpURLConnection.class})
public class GeocoderTest {

	@Mock
	Geocoder geoMocker;
	
	Geocoder geo;
	
	@Before
	public void init() throws MalformedURLException, IOException {
		geo = new Geocoder();
		MockitoAnnotations.initMocks(this);
	}
	
	// Exemple de powerMock
	@Test(expected = RuntimeException.class)
	public void testCallRuntime() throws Exception {
		
		// Mock url
        URL u = PowerMockito.mock(URL.class);
        PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(u);

        HttpURLConnection huc = PowerMockito.mock(HttpURLConnection.class);
        PowerMockito.when(u.openConnection()).thenReturn(huc);
        PowerMockito.when(huc.getResponseCode()).thenReturn(404);
		
        geo.call("Brussels");
	}

	// Exemple de verify
	@Test
	public void testCallUrl() throws Exception {	
		// Mock url
        URL u = PowerMockito.mock(URL.class);
        PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenThrow(new MalformedURLException());

        Mockito.when(geoMocker.call(Mockito.anyString())).thenCallRealMethod();
        
		assertEquals(null, geoMocker.call("Brussels"));	
		Mockito.verify(geoMocker).handlerException();
	}
}

package api2pdf;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.api2pdf.client.Api2PdfClient;
import com.api2pdf.models.Api2PdfResponse;

public class Api2PdfClientTest {

	private static Api2PdfClient a2pClient;

	@BeforeClass
	public static void initApi2PdfClient() {
		a2pClient = new Api2PdfClient("YOUR-API-KEY");
	}

	@Test
	public void testLibreofficeConvert() throws IOException {
		Api2PdfResponse response = a2pClient.libreofficeConvert("https://www.api2pdf.com/wp-content/themes/api2pdf/assets/samples/sample-word-doc.docx", true,
				"test.pdf");
		Assert.assertEquals(response.getSuccess(), true);
	}

	@Test
	public void testMerge() throws IOException {
		String[] urls = { "http://www.api2pdf.com/wp-content/uploads/2021/01/1a082b03-2bd6-4703-989d-0443a88e3b0f-4.pdf",
				"http://www.api2pdf.com/wp-content/uploads/2021/01/1a082b03-2bd6-4703-989d-0443a88e3b0f-4.pdf" };
		Api2PdfResponse response = a2pClient.merge(urls, true, "test.pdf");
		Assert.assertEquals(response.getSuccess(), true);
	}

	@Test
	public void testWkhtmlToPdfFromHtml() throws IOException {
		Api2PdfResponse response = a2pClient.wkhtmlToPdfFromHtml("<p>test</p>",
				true, "test.pdf");
		Assert.assertEquals(response.getSuccess(), true);
	}

	@Test
	public void testWkhtmlToPdfFromHtmlWithOptions() throws IOException {
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("orientation", "landscape");
		options.put("pageSize", "A4");
		Api2PdfResponse response = a2pClient.wkhtmlToPdfFromHtml("<p>test</p>",
				true, "test.pdf", options);
		Assert.assertEquals(response.getSuccess(), true);
	}
	
	@Test
	public void testWkhtmlToPdfFromUrl() throws IOException {
		Api2PdfResponse response = a2pClient.wkhtmlToPdfFromUrl("https://www.api2pdf.com",
				true, "test.pdf");
		Assert.assertEquals(response.getSuccess(), true);
	}
	
	@Test
	public void testWkhtmlToPdfFromUrlWithOptions() throws IOException {
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("orientation", "landscape");
		options.put("pageSize", "A4");
		Api2PdfResponse response = a2pClient.wkhtmlToPdfFromUrl("https://www.api2pdf.com",
				true, "test.pdf", options);
		Assert.assertEquals(response.getSuccess(), true);
	}
	
	@Test
	public void testHeadlessChromeFromHtml() throws IOException {
		Api2PdfResponse response = a2pClient.headlessChromeFromHtml("<p>test</p>",
				true, "test.pdf");
		Assert.assertEquals(response.getSuccess(), true);
	}
	
	@Test
	public void testHeadlessChromeFromHtmlWithOptions() throws IOException {
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("orientation", "landscape");
		options.put("pageSize", "A4");
		Api2PdfResponse response = a2pClient.headlessChromeFromHtml("<p>test</p>",
				true, "test.pdf", options);
		Assert.assertEquals(response.getSuccess(), true);
	}
	
	@Test
	public void testHeadlessChromeFromUrl() throws IOException {
		Api2PdfResponse response = a2pClient.headlessChromeFromUrl("https://www.api2pdf.com",
				true, "test.pdf");
		Assert.assertEquals(response.getSuccess(), true);
	}
	
	@Test
	public void testHeadlessChromeFromUrlWithOptions() throws IOException {
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("orientation", "landscape");
		options.put("pageSize", "A4");
		Api2PdfResponse response = a2pClient.headlessChromeFromUrl("https://www.api2pdf.com",
				true, "test.pdf", options);
		Assert.assertEquals(response.getSuccess(), true);
	}
}

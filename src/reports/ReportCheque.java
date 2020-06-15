package reports;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportCheque {

	public ReportCheque() {
	}

	public static void sendReportToBrowser(Vector detCheques,
			HttpServletResponse response) throws JRException {

		ServletOutputStream out = null;
		try {
			String oldSaxDriver = System.setProperty("org.xml.sax.driver",
					"org.apache.xerces.parsers.SAXParser");

			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObjectFromLocation("reports/LikeCouliCheque.jasper");


			Map param = new HashMap();
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, param, new ReportChequeDS(detCheques));

			byte[] byteArray = JasperExportManager
					.exportReportToPdf(jasperPrint);

			response.reset();

			out = response.getOutputStream();

			response.setContentType("application/pdf");
//			response.addHeader("Content-Disposition",
//					"attachment,filename=repcheques.pdf");

			
			String nombre = "repCheques";
			response.addHeader("Content-Disposition",
					"attachment; filename=\""+nombre+".pdf\";");

			response.setContentLength(byteArray.length);

			out.write(byteArray);
			out.flush();

			if (oldSaxDriver != null) {
				System.setProperty("org.xml.sax.driver", oldSaxDriver);
			}

		} catch (JRException e) {
			e.printStackTrace();
			throw e;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

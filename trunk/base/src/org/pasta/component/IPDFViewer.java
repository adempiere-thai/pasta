package org.pasta.component;

import java.io.InputStream;

public interface IPDFViewer {
	public void viewPdf(String title, InputStream pdfInput);
	public void display();
}

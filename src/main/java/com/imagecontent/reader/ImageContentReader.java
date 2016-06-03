package com.imagecontent.reader;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

public class ImageContentReader {

	public static void main(String[] args) {
		File imageFile = new File("love.jpg");
		String imageContent = imageToStringConvertor(imageFile);
		System.out.println(imageContent);
	}

	public static String imageToStringConvertor(File imageFile) {
		String result = null;
		ITesseract instance = new Tesseract();
		instance.setDatapath(LoadLibs.extractTessResources("tessdata")
				.getAbsolutePath());

		try {
			result = instance.doOCR(imageFile);
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}

		return result;
	}

}

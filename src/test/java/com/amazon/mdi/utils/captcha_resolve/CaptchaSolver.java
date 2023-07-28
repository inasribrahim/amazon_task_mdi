package com.amazon.mdi.utils.captcha_resolve;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;
public class CaptchaSolver {
    private static final Integer orcEngineMode = 1;
    private static final Integer pageSegmentationMode = 12 ;
    private static final String modelRecognizeLanguage="eng";
    private static final String imagePath = "captcha.png";
    private static final String preTrainedModelPath = System.getProperty("user.dir")
            .concat("/src/test/java/com/amazon/mdi/utils/tessdata/");

    public static String getTextFromCaptchaImage() throws TesseractException {

        File imageReader = new File(imagePath);

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(preTrainedModelPath);
        tesseract.setLanguage(modelRecognizeLanguage);
        tesseract.setOcrEngineMode(orcEngineMode);
        tesseract.setPageSegMode(pageSegmentationMode);

        return tesseract.doOCR(imageReader).toUpperCase().replaceAll(" ","").trim();
    }
}

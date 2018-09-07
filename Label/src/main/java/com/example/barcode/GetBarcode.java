/*package com.example.barcode;

import uk.org.okapibarcode.backend.*;
import uk.org.okapibarcode.backend.DataMatrix.ForceMode;
import uk.org.okapibarcode.output.Java2DRenderer;
 
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
 
public class GetBarcode {
    
    
     * These values adjust the size of the DataMatrix bitmap.
     * Border size sets the size of the surrounding white border (0 means none).
     * Magnification is used to enlarge the initial DataMatrix X times, as this will automatically have the smallest possible 
     * size that the data will fit inside. In this particular use case they were usually around 24x24, so we multiply by 10 to make it 240x240.
     * For crisp barcodes in for example a PDF, we want to generate bitmaps at least twice the size of the expected output size.
      
    private static final int MAGNIFICATION = 10;
    private static final int BORDER_SIZE = 0 * MAGNIFICATION;
    
    
     * Input has to be correctly formatted, meaning GS1 Application Identifiers are enclosed in square brackets.
     
    public static final BufferedImage getBarcode(String input){
        try{
            // Set up the DataMatrix object
            DataMatrix dataMatrix = new DataMatrix();
            // We need a GS1 DataMatrix barcode.
            dataMatrix.setDataType(Symbol.DataType.GS1); 
            // 0 means size will be set automatically according to amount of data (smallest possible).
            dataMatrix.setPreferredSize(0); 
            // Don't want no funky rectangle shapes, if we can avoid it.
            dataMatrix.setForceMode(ForceMode.SQUARE); 
            dataMatrix.setContent(input);
            return getMagnifiedBarcode(dataMatrix, MAGNIFICATION);
            //return getBase64FromByteArrayOutputStream(getMagnifiedBarcode(dataMatrix, MAGNIFICATION));
        } catch(OkapiException oe){
            java.util.logging.Logger.getLogger(GetBarcode.class.getName()).log(Level.SEVERE, null, oe);
            return getInvalidBarcodeImage(100);
        }
    }
    
    private static BufferedImage getMagnifiedBarcode(Symbol symbol, int magnification){
        // Make DataMatrix object into bitmap
        BufferedImage image = new BufferedImage((symbol.getWidth() * magnification) + (2 * BORDER_SIZE),
                                                (symbol.getHeight() * magnification) + (2 * BORDER_SIZE), 
                                                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, (symbol.getWidth() * magnification) + (2 * BORDER_SIZE),
                    (symbol.getHeight() * magnification) + (2 * BORDER_SIZE));
        Java2DRenderer renderer = new Java2DRenderer(g2d, magnification, Color.WHITE, Color.BLACK);
        renderer.render(symbol);
        
        return image;
    }
    
    private static String getBase64FromByteArrayOutputStream(BufferedImage image){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // Write the image into a stream
            ImageIO.write(image, "png", baos);
            // So that we can Base64 encode it directly and don't have to write it to disk
            Base64.Encoder encoder = Base64.getEncoder(); 
            return encoder.encodeToString(baos.toByteArray());
        }catch (IOException ioe) {
            java.util.logging.Logger.getLogger(GetBarcode.class.getName()).log(Level.SEVERE, null, ioe);
            return "Something went wrong, please check the logs for closer details.";
        }
    }
    
    *//**
     * Blatantly copied from StackOverflow: http://stackoverflow.com/questions/18800717/convert-text-content-to-image?answertab=votes#tab-top
     * @return Base64 encoded String representing an image containing the text "Invalid Barcode" (used in case of incorrectly formatted input data)
     *//*
    private static BufferedImage getInvalidBarcodeImage(int textSize){
        String errorMessage = "Invalid barcode";
 
        
           Because font metrics is based on a graphics context, we need to create
           a small, temporary image so we can ascertain the width and height
           of the final image
         
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, textSize);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(errorMessage);
        int height = fm.getHeight();
        g2d.dispose();
 
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.BLACK);
        g2d.drawString(errorMessage, 0, fm.getAscent());
        g2d.dispose();
        return img;
    }
}*/
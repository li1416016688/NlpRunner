
/**********************************************************************
 * <pre>
 * FILE : Demo.java
 * CLASS : Demo
 *
 * AUTHOR : caoxu-yiyang@qq.com
 *
 * FUNCTION : TODO
 *
 *
 *======================================================================
 * CHANGE HISTORY LOG
 *----------------------------------------------------------------------
 * MOD. NO.|   DATE   |   NAME  | REASON  | CHANGE REQ.
 *----------------------------------------------------------------------
 * 		    |2016年11月9日|caoxu-yiyang@qq.com| Created |
 * DESCRIPTION:
 * </pre>
 ***********************************************************************/
 
package com.pdf;
 
import java.io.IOException;

import org.w3c.dom.DOMException;

import com.itextpdf.awt.geom.Rectangle2D.Float;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
 
public class Demo
{
    // 定义关键字
    private static String KEY_WORD = "自然";
    // 定义返回值
    private static float[] resu = null;
    // 定义返回页码
    private static int i = 0;
 
    public static void main(String[] args) throws IOException ,DocumentException{
    	//float[] point = getKeyWords("I://ticket_in.pdf");
    	System.out.println("starting...");
//    	PdfReplacer textReplacer = new PdfReplacer("I://test.pdf");
		PdfReplacer textReplacer = new PdfReplacer("/Users/lihanxin/Desktop/test.pdf");

		textReplacer.replaceText("陈坤", "小白");
		textReplacer.replaceText("本科", "社会大学");
		textReplacer.replaceText("0755-29493863", "15112345678");
		textReplacer.toPdf("/Users/lihanxin/Desktop/ticket_out.pdf");
		System.out.println("end...");

	}
    /*
     * 返回关键字所在的坐标和页数 float[0] >> X float[1] >> Y float[2] >> page
     */
    private static float[] getKeyWords(String filePath)
    {
        try
        {
            PdfReader pdfReader = new PdfReader(filePath);
            int pageNum = pdfReader.getNumberOfPages();
            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(
                    pdfReader);
 
            // 下标从1开始
            for (i = 1; i <= pageNum; i++)
            {
                pdfReaderContentParser.processContent(i, new RenderListener()
                {
 
                    @Override
                    public void renderText(TextRenderInfo textRenderInfo)
                    {
                        String text = textRenderInfo.getText();
                        if (null != text && text.contains(KEY_WORD))
                        {
                            Float boundingRectange = textRenderInfo
                                    .getBaseline().getBoundingRectange();
                            resu = new float[3];
                            System.out.println("======="+text);
                            System.out.println("h:"+boundingRectange.getHeight());
                            System.out.println("w:"+boundingRectange.width);
                            System.out.println("centerX:"+boundingRectange.getCenterX());
                            System.out.println("centerY:"+boundingRectange.getCenterY());
                            System.out.println("x:"+boundingRectange.getX());
                            System.out.println("y:"+boundingRectange.getY());
                            System.out.println("maxX:"+boundingRectange.getMaxX());
                            System.out.println("maxY:"+boundingRectange.getMaxY());
                            System.out.println("minX:"+boundingRectange.getMinX());
                            System.out.println("minY:"+boundingRectange.getMinY());
                            resu[0] = boundingRectange.x;
                            resu[1] = boundingRectange.y;
                            resu[2] = i;
                        }
                    }
 
                    @Override
                    public void renderImage(ImageRenderInfo arg0)
                    {
                    }
 
                    @Override
                    public void endTextBlock()
                    {
 
                    }
 
                    @Override
                    public void beginTextBlock()
                    {
                    }
                });
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return resu;
    }
 
}



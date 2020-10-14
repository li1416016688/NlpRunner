package com.pdfTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.StringUtils;

import com.itextpdf.awt.geom.Rectangle2D.Float;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;


public class PDFUtils{
//	
//    // 定义关键词
//    private static String KEY_WORD = "日期：";
//    // 定义返回值
//    private static float[] resu = null;
//    // 定义返回页码
//    private static int i = 0;
//    //定义关键字数组
//    private static String[] WORD = null;
//    //定义关键字数组长度
//    private static int index = 0;
//    //返回结果
//    private static List resultList = Collections.synchronizedList(new ArrayList());
//
//    /*
//     * 返回关键字所在的坐标和页数 float[0] >> X float[1] >> Y float[2] >> page
//     */
//    private List getKeyWords(String filePath, String keyWord){
//    	if(!StringUtils.isEmpty(keyWord)){
//    		KEY_WORD = keyWord;
//    	}
//        try{
//            PdfReader pdfReader = new PdfReader(filePath);
//            int pageNum = pdfReader.getNumberOfPages();
//            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(
//                    pdfReader);
//
//            // 下标从1开始
//            for (i = 1; i <= pageNum; i++){
//            	
//            	WORD = KEY_WORD.split("");
//            	index = WORD.length;
//            	
//                pdfReaderContentParser.processContent(i, new RenderListener(){
//
//                	boolean f = false;	//是否寻找到与之匹配的的头文字
//                	int p = 1;
//                    @Override
//                    public void renderText(TextRenderInfo textRenderInfo){
//                        String text = textRenderInfo.getText();
//                        //doc转PDF
//                        //原理：textRenderInfo只能读取到一个字符，而我们要匹配的关键词往往是多个字符，所以分析后设计匹配关键词方法如下，
//                        //先匹配关键词的第一个字符
//                        if (null != text && text.contains(WORD[p]) && text.length()==1)
//                        {
//                        	//匹配到关键字第一个字符，可以进行关键字完整匹配流程
//                        	if(p==1){
//                        		f = true;
//                        	}
//                        	String str = WORD[p];
//                        	if(pt = ut.getKeyWords("d:/test.pdf","日期");
//    	for (float[] fs : t) {
//    		System.out.println("X>>" + fs[0] + "Y>>" +fs[1]+ "Page>>" + fs[2]);
//		}
//	}
}
       

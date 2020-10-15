package com.pdfSQ;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.core.layout.HtmlLayout.FontSize;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class Sukedai_pdf1 {
	private static int fontSize;
	private static ByteArrayOutputStream output;
	
	private static PdfReader reader;
	private static PdfStamper stamper;
	private static PdfContentByte canvas;
	private static Font font;
	public static void main(String[] args) throws Exception {
		System.out.println("starting...");
//		GREEN背景色,改为WHITE 可与源文件保持一致
		Sukedai_pdf1 cl1 = new Sukedai_pdf1();
//		String template_file ="F:\\RPA\\苏科贷\\备案申请表.pdf";
//		String outfile ="F:\\RPA\\苏科贷\\备案申请表aa.pdf";
		String template_file ="/Users/lihanxin/Desktop/申请备案表.pdf";
		String outfile ="/Users/lihanxin/Desktop/申请备案表aa.pdf";
		String data ="企业名称XX|+|贷款支行xx|+|贷款额度xx|+|质押条件xx|+|贷款利率xx|+|地方比例xx|+|省比例xx|+|审批额度xx";		
		cl1.GenePdf(template_file, outfile, data);
		System.out.println("end...");
		
		
	}
	public static void GenePdf(String template_file,String outfile ,String data) throws Exception{
		
//		data是按照names顺序以|+|分割字符串
		String [] data1=data.split("\\|\\+\\|",-1);//-1表示不删除尾部空格
		List<String> names = new ArrayList<String>(Arrays.asList("企业名称","贷款支行","贷款额度","抵质押条件","贷款利率","地方比例","省比例","审批额度"));
//		String fileName ="F:\\RPA\\苏科贷\\备案申请表.pdf";
		String fileName = template_file;
		FileInputStream in =null;
		try {
			in=new FileInputStream(fileName);
			byte [] pdfBytes=new byte[in.available()];
			in.read(pdfBytes);
			reader =new PdfReader(pdfBytes);
			output =new ByteArrayOutputStream();
			stamper=new PdfStamper(reader, output);
			canvas =stamper.getOverContent(1);
			fontSize =10;
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
			font = new Font(bf,fontSize,Font.BOLD); 
//			时间日期
			LocalDateTime time3=LocalDateTime.now();
			
			DateTimeFormatter format3 = DateTimeFormatter.ofPattern("yyyy 年MM 月dd 日");
			String f3 = time3.format(format3);
			System.out.println(f3);
			List<Integer> rect1 = new ArrayList<Integer>(Arrays.asList(400,152,108,12));
			canvas.saveState();
			canvas.setColorFill(BaseColor.GREEN);
			canvas.rectangle(rect1.get(0),rect1.get(1),rect1.get(2),rect1.get(3));
			canvas.fill();
			canvas.restoreState();
			canvas.setFontAndSize(font.getBaseFont(), fontSize);
//			修正背景与文本的相对位置
			canvas.setTextMatrix(rect1.get(0),rect1.get(1)+2);
			canvas.showText(f3);
			canvas.endText();
//			各部位坐标,Y是从下往上的x,y,w,h
			HashMap<String, String> map1 = new HashMap<String, String>();
//			"企业名称","贷款支行","贷款额度","抵质押条件","贷款利率","地方比例","省比例","审批额度"));
			map1.put("企业名称", "200,716,200,12");
			map1.put("贷款支行", "173,685,100,12");
			map1.put("贷款额度", "410,685,100,12");
			map1.put("抵质押条件", "173,652,100,12");
			map1.put("贷款利率", "410,652,100,12");
			map1.put("地方比例", "300,620,100,12");
			map1.put("省比例", "300,558,100,12");
			map1.put("审批额度", "308,495,60,12");
			for (int n1 = 0; n1 < names.size(); n1++) {
				canvas.saveState();
				canvas.setColorFill(BaseColor.GREEN);//背景色
				String[] xywh = map1.get(names.get(n1)).split(",");
				canvas.rectangle(Integer.valueOf(xywh[0]),Integer.valueOf(xywh[1]),Integer.valueOf(xywh[2]),Integer.valueOf(xywh[3]));
				canvas.fill();
				canvas.restoreState();
				canvas.setFontAndSize(font.getBaseFont(), fontSize);
//				修正背景与文本的相对位置
				canvas.setTextMatrix(Integer.valueOf(xywh[0]),Integer.valueOf(xywh[1])+2);
				canvas.showText(data1[n1]);
				canvas.endText();
			}
//			List<String> names = new ArrayList<String>(Arrays.asList("企业名称","贷款支行","贷款额度","抵质押条件","贷款利率","地方比例","省比例","审批额度"));
//			String data ="企业名称XX|+|贷款支行xx|+|贷款额度xx|+|质押条件xx|+|贷款利率xx|+|地方比例xx|+|省比例xx|+|审批额度xx";		
//			String [] data1=data.split("\\|\\+\\|",-1);//-1表示不删除尾部空格			
//			for (int i = 10; i < 600; i+=10) {
//				for (int j = 10; j < 900; j+=10) {
//					canvas.saveState();
//					canvas.setColorFill(BaseColor.RED);//背景色
//					canvas.rectangle(i,j,1,1);
//					canvas.fill();
//					canvas.restoreState();
//					canvas.setFontAndSize(font.getBaseFont(), fontSize);
////					修正背景与文本的相对位置
//					canvas.setTextMatrix(i,j+2);
//					if (i%100==0&j%100==0) {
//						canvas.showText(String.valueOf(i)+":"+String.valueOf(j));
//					}
//					canvas.endText();
//				}
//			}
			
			if(stamper!=null) {
				stamper.close();
			}
			FileOutputStream fileOutputStream =null;
			try {
				fileOutputStream = new FileOutputStream(outfile);
				fileOutputStream.write(output.toByteArray());
				fileOutputStream.flush();
			} catch (IOException e) {
				// TODO: handle exception
				throw e;
			}finally {
				if (fileOutputStream!=null) {
					fileOutputStream.close();
				}
				if (reader!=null) {
					reader.close();
				}
				if (output!=null) {
					output.close();
				}
				output=null;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			in.close();
		}
		
	}

}

package com.email;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sound.sampled.LineListener;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;

public class CommonsEmailTest {
	private String host= "smtp.qq.com";
	private int port=587;//587.465
//	plowoomqnycvgaee
	private String userName= "141@qq.com";
//	private String passWord= "plowoomqnycvgaee";
	private String passWord= "plo";
	private String to= "141@qq.com";
	private static List<String>too=new ArrayList<String>();
	public static void main(String[] args) throws Exception{
		too.add("141@qq.com");
		too.add("144@qq.com");
		System.out.println("144@qq.com");
		CommonsEmailTest a1 =new CommonsEmailTest();
		//a1.sendAttachmentMail();
		//a1.html();
		a1.image();
		System.out.println("end");
	}
//	发送html邮件
	public void html() throws Exception{
		HtmlEmail mail=new HtmlEmail();
		mail.setSmtpPort(port);
		mail.setHostName(host);
		mail.setAuthentication(userName, passWord);
		mail.setFrom(userName);
		mail.addTo(to);	
		
		mail.setCharset("UTF-8");
		mail.setSubject("江苏银行Test Email");
		mail.setHtmlMsg("<html><body><img src='/Users/lihanxin/Desktop/截屏2020-08-18 下午1.24.00.png'/><div>hahahhaha</div></body></html>");
		mail.setSentDate(new Date());
		mail.send();
	}

//	发送内嵌图片邮件
	public void image() throws Exception{
		HtmlEmail mail=new HtmlEmail();
		mail.setSmtpPort(port);
		mail.setHostName(host);
		mail.setAuthentication(userName, passWord);
		mail.setFrom(userName);
		mail.addTo(to);	
		
		mail.setCharset("UTF-8");
		mail.setSubject("江苏银行Test Email");
		String fileName ="/Users/lihanxin/Desktop/截屏2020-08-18 下午1.24.00.png";
		//String fileName ="https://mail.qq.com/cgi-bin/getqqicon?sid=2tbSnqelvLPAHEoV&uin=-2438067052&mode=newaddr&mailaddr=1416016688%40qq.com";
		mail.embed(new File(fileName),"image");
		mail.setHtmlMsg("<html><body><img src='cid:image'/><div>this is a email</div></body></html>");
		mail.setSentDate(new Date());
		mail.send();
	}
	//发送附件邮件
	public void sendAttachmentMail() throws Exception{
		HtmlEmail mail=new HtmlEmail();
		mail.setSmtpPort(port);
		mail.setHostName(host);
		mail.setAuthentication(userName, passWord);
		mail.setFrom(userName);
		for(String to:too) {
		mail.addTo(to);	
		}
		mail.setCharset("UTF-8");
		mail.setSubject("江苏银行Test Email");
		mail.setMsg("20200929江苏银行 this is a Attachment email. this email has a attachment!");
//	创建附件
		EmailAttachment attachment = new EmailAttachment();
		String  attachmentpath="/Users/lihanxin/Desktop/页面.docx";
		attachment.setPath(attachmentpath);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setName(attachmentpath);
		mail.attach(attachment);
		mail.setSentDate(new Date());
		mail.send();
	}

}

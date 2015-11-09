package com.zdz.maven.account.account_email;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import com.zdz.maven.account.email.AccountEmailService;
import com.zdz.maven.account.exception.AccountEmailException;

public class AccoutEmailServiceTest {
	private GreenMail greenMail;
	@Before
	public void startMailServer()
	{
		greenMail = new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("test@zdz.com", "123456");
		greenMail.start();
	}
	@Test
	public void testSendMail() throws AccountEmailException, MessagingException
	{
//		由于在resource目录下的xml找不到所以复制了在根目录下，可能maven会找不到
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService = (AccountEmailService)ctx.getBean("accountEmailService");
		String subject = "Test Subject";
		String htmlText = "<h3>Test</h3>";
		accountEmailService.sendMail("test@zdz.com", subject, htmlText);
		
		Message[] msgs = greenMail.getReceivedMessages();
		Assert.assertEquals(1,msgs.length);
		Assert.assertEquals(subject,msgs[0].getSubject());
		Assert.assertEquals(htmlText,GreenMailUtil.getBody(msgs[0]).trim());
	}
	
	@After
	public void stopMailServer()
	{
		greenMail.stop();
	}
	
}

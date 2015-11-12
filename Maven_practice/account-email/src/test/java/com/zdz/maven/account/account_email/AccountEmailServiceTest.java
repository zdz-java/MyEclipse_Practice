package com.zdz.maven.account.account_email;

import static junit.framework.Assert.assertEquals;

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

public class AccountEmailServiceTest {

	private GreenMail greenMail;

	@Before
	public void startMailServer() throws Exception {
		greenMail = new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("test@zdz.com", "123456");
		greenMail.start();
	}

	@Test
	public void testSendMail() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"account-email.xml");
		AccountEmailService accountEmailService = (AccountEmailService) ctx
				.getBean("accountEmailService");

		String subject = "Test Subject";
		String htmlText = "<h3>Test</h3>";
		accountEmailService.sendMail("test2@zdz.com", subject, htmlText);

		greenMail.waitForIncomingEmail(2000, 1);

		Message[] msgs = greenMail.getReceivedMessages();
		assertEquals(1, msgs.length);
		assertEquals(subject, msgs[0].getSubject());
		assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
		System.out.println("this is in the AccoutEmailServiceTest Class");
	}

	@After
	public void stopMailServer() throws Exception {
		greenMail.stop();
	}
}

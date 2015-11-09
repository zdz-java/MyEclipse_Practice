package com.zdz.maven.account.email;

import com.zdz.maven.account.exception.AccountEmailException;

public interface AccountEmailService {
	void sendMail(String to,String subject,String htmlText)
		throws AccountEmailException;
}

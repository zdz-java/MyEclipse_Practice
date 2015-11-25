package com.zdz.am.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zdz.am.dao.MessageDAO;
import com.zdz.am.model.Message;
import com.zdz.am.util.Page;


public class MessageDAOImpl implements MessageDAO{

	@Override
	public void addMessage(javax.mail.Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMessage(javax.mail.Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMessage(int messageID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<javax.mail.Message> findAllMessagee(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public javax.mail.Message findMessageById(int messageID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}

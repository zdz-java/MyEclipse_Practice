package com.zdz.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mysql.jdbc.Statement;
import com.zdz.bean.Vote;
import com.zdz.dao.VoteDAO;
import com.zdz.util.DBConnection;
import com.zdz.util.Page;

@Component
public class VoteDAOImpl implements VoteDAO{

	public void addVote(Vote vote) {
		Connection conn = DBConnection.getConnection();	//������Ӷ���
		String addSQL = "insert into " +
				"tb_vote(voteName,channelID) values(?,?)";
		PreparedStatement pstmt = null;					//����Ԥ�������
		try {
			pstmt = conn.prepareStatement(addSQL,Statement.RETURN_GENERATED_KEYS);		//���Ԥ������󲢸�ֵ
			pstmt.setString(1, vote.getVoteName());		//����ͶƱ���
			pstmt.setInt(2, vote.getChannelID());		//����Ƶ��ID
			pstmt.executeUpdate();								//ִ�����
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				long voteID = (long)rs.getObject(1);	
				vote.setVoteID((int)voteID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
	}

	public void deleteVote(int voteID) {
		Connection conn = DBConnection.getConnection();	//������Ӷ���
		String deleteSQL = "delete from tb_vote where voteID=?";
		PreparedStatement pstmt = null;					//����Ԥ�������
		try {
			pstmt = conn.prepareStatement(deleteSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, voteID);						//����ͶƱ���
			pstmt.executeUpdate();								//ִ��ɾ��
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
	}

	public List<Vote> findAllVote(Page page) {
		Connection conn = DBConnection.getConnection();		//������Ӷ���
		String findByIDSQL = "select * from tb_vote limit ?,?";		//��ѯSQL���
		PreparedStatement pstmt = null;	//����Ԥ�������
		ResultSet rs = null;
		List<Vote> votes = new ArrayList<Vote>();
		try {
			pstmt = conn.prepareStatement(findByIDSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();						//ִ�в�ѯ
			while(rs.next()) {
				Vote vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				votes.add(vote);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								//�رս�����
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
		return votes;
	}

	public Vote findVoteById(int voteID) {
		Connection conn = DBConnection.getConnection();	//������Ӷ���
		String querySQL  = "select * from tb_vote where voteID = ?";
		PreparedStatement pstmt = null;					//����Ԥ�������
		ResultSet rs = null;
		Vote vote = null;
		try {
			pstmt = conn.prepareStatement(querySQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, voteID);
			rs = pstmt.executeQuery();					//ִ�в�ѯ
			if(rs.next()) {
				vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								//�رս�����
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
		return vote;
	}

	public void updateVote(Vote vote) {
		
	}

	public Vote findVoteByName(String voteName) {
		Connection conn = DBConnection.getConnection();	//������Ӷ���
		String querySQL  = "select * from tb_vote where voteName = ?";
		PreparedStatement pstmt = null;					//����Ԥ�������
		ResultSet rs = null;
		Vote vote = null;
		try {
			pstmt = conn.prepareStatement(querySQL);		//���Ԥ������󲢸�ֵ
			pstmt.setString(1, voteName);
			rs = pstmt.executeQuery();					//ִ�в�ѯ
			if(rs.next()) {
				vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								//�رս�����
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
		return vote;
	}

	public int findAllCount() {
		Connection conn = DBConnection.getConnection();	//������Ӷ���
		String findSQL = "select count(*) from tb_vote";
		PreparedStatement pstmt = null;					//����Ԥ�������
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(findSQL);		//���Ԥ������󲢸�ֵ
			rs = pstmt.executeQuery();					//ִ�в�ѯ
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);						//�رս�����
			DBConnection.close(pstmt);					//�ر�Ԥ�������
			DBConnection.close(conn);					//�ر����Ӷ���
		}
		return count;
	}

	public List<Vote> findVoteByChannel(Page page, int channelID) {
		Connection conn = DBConnection.getConnection();		//������Ӷ���
		String findByIDSQL = "select * from tb_vote where channelID=? limit ?,?";		//��ѯSQL���
		PreparedStatement pstmt = null;	//����Ԥ�������
		ResultSet rs = null;
		List<Vote> votes = new ArrayList<Vote>();
		try {
			pstmt = conn.prepareStatement(findByIDSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, channelID);
			pstmt.setInt(2, page.getBeginIndex());
			pstmt.setInt(3, page.getEveryPage());
			rs = pstmt.executeQuery();						//ִ�в�ѯ
			while(rs.next()) {
				Vote vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				votes.add(vote);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								//�رս�����
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
		return votes;
	}

	public int fintCountByChannel(int channelID) {
		Connection conn = DBConnection.getConnection();	//������Ӷ���
		String findSQL = "select count(*) from tb_vote where channelID=?";
		PreparedStatement pstmt = null;					//����Ԥ�������
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(findSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, channelID);
			rs = pstmt.executeQuery();					//ִ�в�ѯ
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);						//�رս�����
			DBConnection.close(pstmt);					//�ر�Ԥ�������
			DBConnection.close(conn);					//�ر����Ӷ���
		}
		return count;
	}
}

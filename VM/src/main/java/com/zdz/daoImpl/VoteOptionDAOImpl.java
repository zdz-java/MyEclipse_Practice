package com.zdz.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zdz.bean.VoteOption;
import com.zdz.dao.VoteOptionDAO;
import com.zdz.util.DBConnection;
@Component
public class VoteOptionDAOImpl implements VoteOptionDAO {

	public void addVoteOption(VoteOption voteOption) {
		Connection conn = DBConnection.getConnection();	//������Ӷ���
		String addSQL = "insert into " +
				"tb_voteoption(voteOptionName,voteID,ticketNum) values(?,?,?)";
		PreparedStatement pstmt = null;					//����Ԥ�������
		try {
			pstmt = conn.prepareStatement(addSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setString(1, voteOption.getVoteOptionName());	//����ͶƱѡ�����
			pstmt.setInt(2, voteOption.getVoteID());		//����ͶƱID
			pstmt.setInt(3, voteOption.getTicketNum());		//����ͶƱ��
			pstmt.executeUpdate();								//ִ�����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
	}

	public void deleteVoteOption(int voteOptionID) {
		Connection conn = DBConnection.getConnection();	//������Ӷ���
		String deleteSQL = "delete from tb_voteoption where voteOptionID=?";
		PreparedStatement pstmt = null;					//����Ԥ�������
		try {
			pstmt = conn.prepareStatement(deleteSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, voteOptionID);						//����ͶƱ���
			pstmt.executeUpdate();								//ִ��ɾ��
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
	}

	public List<VoteOption> findVoteOptionByVoteID(int voteID) {
		Connection conn = DBConnection.getConnection();		//������Ӷ���
		String findByIDSQL = "select * from tb_voteoption where voteID = ?";//��ѯSQL���
		PreparedStatement pstmt = null;	//����Ԥ�������
		ResultSet rs = null;
		List<VoteOption> voteOptions = new ArrayList<VoteOption>();
		try {
			pstmt = conn.prepareStatement(findByIDSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, voteID);
			rs = pstmt.executeQuery();						//ִ�в�ѯ
			while(rs.next()) {
				VoteOption voteOption = new VoteOption();
				voteOption.setVoteOptionID(rs.getInt(1));
				voteOption.setVoteID(rs.getInt(2));
				voteOption.setVoteOptionName(rs.getString(3));
				voteOption.setTicketNum(rs.getInt(4));
				voteOptions.add(voteOption);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								//�رս�����
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
		return voteOptions;
	}

	public VoteOption findVoteOptionById(int voteOptionID) {
		Connection conn = DBConnection.getConnection();		//������Ӷ���
		String findByIDSQL = "select * from tb_voteoption where voteOptionID = ?";//��ѯSQL���
		PreparedStatement pstmt = null;	//����Ԥ�������
		ResultSet rs = null;
		VoteOption voteOption = null;
		try {
			pstmt = conn.prepareStatement(findByIDSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, voteOptionID);
			rs = pstmt.executeQuery();						//ִ�в�ѯ
			if(rs.next()) {
				voteOption = new VoteOption();
				voteOption.setVoteOptionID(rs.getInt(1));
				voteOption.setVoteID(rs.getInt(2));
				voteOption.setVoteOptionName(rs.getString(3));
				voteOption.setTicketNum(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								//�رս�����
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
		return voteOption;
	}

	public void updateVoteOption(VoteOption voteOption) {
		Connection conn = DBConnection.getConnection();	//������Ӷ���
		String deleteSQL = "update tb_voteoption set ticketNum = ? where voteOptionID = ?";
		PreparedStatement pstmt = null;					//����Ԥ�������
		try {
			pstmt = conn.prepareStatement(deleteSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, voteOption.getTicketNum());		//����Ʊ��
			pstmt.setInt(2, voteOption.getVoteOptionID());	
			pstmt.executeUpdate();								//ִ��ɾ��
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							//�ر�Ԥ�������
			DBConnection.close(conn);							//�ر����Ӷ���
		}
	}
	
}

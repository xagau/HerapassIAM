package ai.genpen.dao;
/** Copyright (c) 2022-2023 ai.genpen,
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * @author xagau | GenPen.AI
 * @email seanbeecroft@gmail.com | sean@genpen.ai
 * phone 1.416.878.5282
 */

import ai.genpen.models.Member;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.util.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	public static void main(String[] args)
	{
		MemberDAO dao = new MemberDAO();
		try {
			OrganizationDAO odao = new OrganizationDAO();
			List<Member> abc = odao.findAllMemberByOrgName("contact@herapass.com");
			System.out.println(abc);

			List<Member> ab = dao.findAll();
			System.out.println(ab.size());
			System.out.println(ab.get(0).getMemberEmail());
			System.out.println(ab);

		} catch (Exception throwables) {
			throwables.printStackTrace();
		}
	}

	String update = "UPDATE member SET member_name = ?, fk_subscription_id = ?, contact_number = ?, joined_programs_count = ?, member_email = ?, creation_date = ?, `name` = ?, is_active = ?, member_country = ?, status_type = ? WHERE id = ?";
	String insert = "INSERT INTO member (member_name, fk_subscription_id, contact_number, joined_programs_count, member_email, creation_date, `name`, is_active, member_country, status_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	String deleteById = "DELETE FROM member WHERE id = ?";
	String deleteByName = "DELETE FROM member WHERE `name` = ?";
	String findById = "SELECT * FROM member WHERE id = ?";
	String findByName = "SELECT * FROM member WHERE `name` = ?";
	String findByMemberName = "SELECT * FROM member WHERE member_name = ?";

	String findAll = "SELECT * FROM member";

	public int update(Member member) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = update;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setInt(2, member.getFkSubscriptionId());
			pstmt.setInt(3, member.getContactNumber());
			pstmt.setInt(4, member.getJoinedProgramsCount());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getCreationDate());
			pstmt.setString(7, member.getName());
			pstmt.setBoolean(8, member.getIsActive());
			pstmt.setString(9, member.getMemberCountry());
			pstmt.setInt(10, member.getStatusType());

			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;

	}

	public int insert(Member member) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = insert;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setInt(2, member.getFkSubscriptionId());
			pstmt.setInt(3, member.getContactNumber());
			pstmt.setInt(4, member.getJoinedProgramsCount());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getCreationDate());
			//pstmt.setInt(7, member.getId());
			pstmt.setString(7, member.getName());
			pstmt.setBoolean(8, member.getIsActive());
			pstmt.setString(9, member.getMemberCountry());
			pstmt.setInt(10, member.getStatusType());
			int affectedRows = pstmt.executeUpdate();
 			return affectedRows;
			
		} catch(Exception ex) { 
			ex.printStackTrace(); 
		} finally {
			try { Utility.closeQuietly(connection, pstmt, null); } catch(Exception ex) { ex.printStackTrace(); } 
		}
		return 0;
	}

	public int delete(int id) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = deleteById;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			int affectedRows = pstmt.executeUpdate();
 			return affectedRows;
			
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return 0;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

	public int delete(String name) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = deleteByName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			int affectedRows = pstmt.executeUpdate();
 			return affectedRows;
			
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return 0;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

	public Member find(String name) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findByName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
 			Member member = new Member();
			if( rs.next() ){ 
				member.setMemberName(rs.getString("member_name"));
				member.setFkSubscriptionId(rs.getInt("fk_subscription_id"));
				member.setContactNumber(rs.getInt("contact_number"));
				member.setJoinedProgramsCount(rs.getInt("joined_programs_count"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setCreationDate(rs.getString("creation_date"));
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setIsActive(rs.getBoolean("is_active"));
				member.setMemberCountry(rs.getString("member_country"));
				member.setStatusType(rs.getInt("status_type"));
				return member;
			}

		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);
			return null;
		}
	}

	public Member findByMemberName(String name) {
		System.out.println("findByMemberName");
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			String sql = findByMemberName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			Member member = new Member();
			if( rs.next() ){
				member.setMemberName(rs.getString("member_name"));
				member.setFkSubscriptionId(rs.getInt("fk_subscription_id"));
				member.setContactNumber(rs.getInt("contact_number"));
				member.setJoinedProgramsCount(rs.getInt("joined_programs_count"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setCreationDate(rs.getString("creation_date"));
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setIsActive(rs.getBoolean("is_active"));
				member.setMemberCountry(rs.getString("member_country"));
				member.setStatusType(rs.getInt("status_type"));
				return member;
			}

		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);
			return null;
		}
	}




	public Member find(int id) {
 		String sql = findById;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
 			Member member = new Member();
			if( rs.next() ){ 
				member.setMemberName(rs.getString("member_name"));
				member.setFkSubscriptionId(rs.getInt("fk_subscription_id"));
				member.setContactNumber(rs.getInt("contact_number"));
				member.setJoinedProgramsCount(rs.getInt("joined_programs_count"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setCreationDate(rs.getString("creation_date"));
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setIsActive(rs.getBoolean("is_active"));
				member.setMemberCountry(rs.getString("member_country"));
				member.setStatusType(rs.getInt("status_type"));
				return member;
			}
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
		return null;
	}

	public ArrayList<Member> findAll() {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findAll;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
 			ArrayList<Member> arrayList = new ArrayList<>();
 			while( rs.next() ){ 
				Member member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setFkSubscriptionId(rs.getInt("fk_subscription_id"));
				member.setContactNumber(rs.getInt("contact_number"));
				member.setJoinedProgramsCount(rs.getInt("joined_programs_count"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setCreationDate(rs.getString("creation_date"));
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setIsActive(rs.getBoolean("is_active"));
				member.setMemberCountry(rs.getString("member_country"));
				member.setStatusType(rs.getInt("status_type"));
				arrayList.add(member);
			}
 			System.out.println("Found:" + arrayList.size() + " Members");
			return arrayList;
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

}

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

import ai.genpen.models.Membership;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.util.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MembershipDAO {
	String update = "UPDATE membership SET last_login = ?, status = ?, fk_organization_id = ?, member_id = ?, fk_user_id = ?, `id` = ?, `name` = ?, is_active = ?, member_since = ?, num_logins = ?, fk_member_level_id = ? WHERE id = ?";
	String insert = "INSERT INTO membership (last_login, status, fk_organization_id, member_id, fk_user_id, `id`, `name`, is_active, member_since, num_logins, fk_member_level_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String deleteById = "DELETE FROM membership WHERE id = ?";
	String deleteByName = "DELETE FROM membership WHERE name = ?";
	String findById = "SELECT * FROM membership WHERE id = ?";
	String findByName = "SELECT * FROM membership WHERE name = ?";
	String findAll = "SELECT * FROM membership";
	String findAllByMember = "SELECT * FROM membership WHERE member_id = ?";

	public int update(Membership membership) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = update;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, membership.getLastLogin());
			pstmt.setString(2, membership.getStatus());
			pstmt.setInt(3, membership.getFkOrganizationId());
			pstmt.setInt(4, membership.getMemberId());
			pstmt.setInt(5, membership.getFkUserId());
			pstmt.setString(6, membership.getName());
			pstmt.setBoolean(7, membership.getIsActive());
			pstmt.setString(8, membership.getMemberSince());
			pstmt.setInt(9, membership.getNumLogins());
			pstmt.setInt(10, membership.getFkMemberLevelId());

			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;

	}

	public int insert(Membership membership) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = insert;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, membership.getLastLogin());
			pstmt.setString(2, membership.getStatus());
			pstmt.setInt(3, membership.getFkOrganizationId());
			pstmt.setInt(4, membership.getMemberId());
			pstmt.setInt(5, membership.getFkUserId());
			pstmt.setString(6, membership.getName());
			pstmt.setBoolean(7, membership.getIsActive());
			pstmt.setString(8, membership.getMemberSince());
			pstmt.setInt(9, membership.getNumLogins());
			pstmt.setInt(10, membership.getFkMemberLevelId());
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

	public Membership find(String name) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findByName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
 			Membership membership = new Membership();
			if( rs.next() ){ 
				membership.setLastLogin(rs.getString("last_login"));
				membership.setStatus(rs.getString("status"));
				membership.setFkOrganizationId(rs.getInt("fk_organization_id"));
				membership.setMemberId(rs.getInt("member_id"));
				membership.setFkUserId(rs.getInt("fk_user_id"));
				membership.setId(rs.getInt("id"));
				membership.setName(rs.getString("name"));
				membership.setIsActive(rs.getBoolean("is_active"));
				membership.setMemberSince(rs.getString("member_since"));
				membership.setNumLogins(rs.getInt("num_logins"));
				membership.setFkMemberLevelId(rs.getInt("fk_member_level_id"));
			}
			return membership;
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

	public Membership find(int id) {
 		String sql = findById;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
 			Membership membership = new Membership();
			if( rs.next() ){ 
				membership.setLastLogin(rs.getString("last_login"));
				membership.setStatus(rs.getString("status"));
				membership.setFkOrganizationId(rs.getInt("fk_organization_id"));
				membership.setMemberId(rs.getInt("member_id"));
				membership.setFkUserId(rs.getInt("fk_user_id"));
				membership.setId(rs.getInt("id"));
				membership.setName(rs.getString("name"));
				membership.setIsActive(rs.getBoolean("is_active"));
				membership.setMemberSince(rs.getString("member_since"));
				membership.setNumLogins(rs.getInt("num_logins"));
				membership.setFkMemberLevelId(rs.getInt("fk_member_level_id"));
				return membership;
			}
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);
		}
		return null;
	}

	public ArrayList<Membership> findAll() {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findAll;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
 			ArrayList<Membership> arrayList = new ArrayList<>();
 			while( rs.next() ){ 
				Membership membership = new Membership();
				membership.setLastLogin(rs.getString("last_login"));
				membership.setStatus(rs.getString("status"));
				membership.setFkOrganizationId(rs.getInt("fk_organization_id"));
				membership.setMemberId(rs.getInt("member_id"));
				membership.setFkUserId(rs.getInt("fk_user_id"));
				membership.setId(rs.getInt("id"));
				membership.setName(rs.getString("name"));
				membership.setIsActive(rs.getBoolean("is_active"));
				membership.setMemberSince(rs.getString("member_since"));
				membership.setNumLogins(rs.getInt("num_logins"));
				membership.setFkMemberLevelId(rs.getInt("fk_member_level_id"));
				arrayList.add(membership);
			}
			return arrayList;
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

	public ArrayList<Membership> findAllByMember(int memberId) {
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			String sql = findAllByMember;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Membership> arrayList = new ArrayList<>();
			while( rs.next() ){
				Membership membership = new Membership();
				membership.setLastLogin(rs.getString("last_login"));
				membership.setStatus(rs.getString("status"));
				membership.setFkOrganizationId(rs.getInt("fk_organization_id"));
				membership.setMemberId(rs.getInt("member_id"));
				membership.setFkUserId(rs.getInt("fk_user_id"));
				membership.setId(rs.getInt("id"));
				membership.setName(rs.getString("name"));
				membership.setIsActive(rs.getBoolean("is_active"));
				membership.setMemberSince(rs.getString("member_since"));
				membership.setNumLogins(rs.getInt("num_logins"));
				membership.setFkMemberLevelId(rs.getInt("fk_member_level_id"));
				arrayList.add(membership);
			}
			return arrayList;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);
		}
	}
}

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

import ai.genpen.models.MembershipLevels;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.util.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MembershipLevelsDAO {
	String update = "UPDATE membership_levels SET fk_member_id = ?, annual_fee = ?, expiry_date = ?, fk_merchant_id = ?, access_level = ?, renewal_notice_sent = ?, membership_level = ?, membership_active = ?, id = ?, monthly_fee = ?, name = ?, eligible_benefits = ? WHERE id = ?";
	String insert = "INSERT INTO membership_levels (fk_member_id, annual_fee, expiry_date, fk_merchant_id, access_level, renewal_notice_sent, membership_level, membership_active, id, monthly_fee, name, eligible_benefits) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String deleteById = "DELETE FROM membership_levels WHERE id = ?";
	String deleteByName = "DELETE FROM membership_levels WHERE name = ?";
	String findById = "SELECT * FROM membership_levels WHERE id = ?";
	String findByName = "SELECT * FROM membership_levels WHERE name = ?";
	String findAll = "SELECT * FROM membership_levels";

	public int update(MembershipLevels membershipLevels) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = update;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, membershipLevels.getFkCustomerId());
			pstmt.setDouble(2, membershipLevels.getAnnualFee());
			pstmt.setString(3, membershipLevels.getExpiryDate());
			pstmt.setInt(4, membershipLevels.getFkMerchantId());
			pstmt.setInt(5, membershipLevels.getAccessLevel());
			pstmt.setBoolean(6, membershipLevels.getRenewalNoticeSent());
			pstmt.setString(7, membershipLevels.getMembershipLevel());
			pstmt.setBoolean(8, membershipLevels.getMembershipActive());
			pstmt.setInt(9, membershipLevels.getId());
			pstmt.setDouble(10, membershipLevels.getMonthlyFee());
			pstmt.setString(11, membershipLevels.getName());
			pstmt.setString(12, membershipLevels.getEligibleBenefits());

			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;

	}

	public int insert(MembershipLevels membershipLevels) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = insert;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, membershipLevels.getFkCustomerId());
			pstmt.setDouble(2, membershipLevels.getAnnualFee());
			pstmt.setString(3, membershipLevels.getExpiryDate());
			pstmt.setInt(4, membershipLevels.getFkMerchantId());
			pstmt.setInt(5, membershipLevels.getAccessLevel());
			pstmt.setBoolean(6, membershipLevels.getRenewalNoticeSent());
			pstmt.setString(7, membershipLevels.getMembershipLevel());
			pstmt.setBoolean(8, membershipLevels.getMembershipActive());
			pstmt.setInt(9, membershipLevels.getId());
			pstmt.setDouble(10, membershipLevels.getMonthlyFee());
			pstmt.setString(11, membershipLevels.getName());
			pstmt.setString(12, membershipLevels.getEligibleBenefits());
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

	public MembershipLevels find(String name) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findByName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
 			MembershipLevels membershipLevels = new MembershipLevels();
			if( rs.next() ){ 
				membershipLevels.setFkCustomerId(rs.getInt("fk_customer_id"));
				membershipLevels.setAnnualFee(rs.getDouble("annual_fee"));
				membershipLevels.setExpiryDate(rs.getString("expiry_date"));
				membershipLevels.setFkMerchantId(rs.getInt("fk_merchant_id"));
				membershipLevels.setAccessLevel(rs.getInt("access_level"));
				membershipLevels.setRenewalNoticeSent(rs.getBoolean("renewal_notice_sent"));
				membershipLevels.setMembershipLevel(rs.getString("membership_level"));
				membershipLevels.setMembershipActive(rs.getBoolean("membership_active"));
				membershipLevels.setId(rs.getInt("id"));
				membershipLevels.setMonthlyFee(rs.getDouble("monthly_fee"));
				membershipLevels.setName(rs.getString("name"));
				membershipLevels.setEligibleBenefits(rs.getString("eligible_benefits"));
			}
			return membershipLevels;
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

	public MembershipLevels find(int id) {
 		String sql = findById;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
 			MembershipLevels membershipLevels = new MembershipLevels();
			if( rs.next() ){ 
				membershipLevels.setFkCustomerId(rs.getInt("fk_customer_id"));
				membershipLevels.setAnnualFee(rs.getDouble("annual_fee"));
				membershipLevels.setExpiryDate(rs.getString("expiry_date"));
				membershipLevels.setFkMerchantId(rs.getInt("fk_merchant_id"));
				membershipLevels.setAccessLevel(rs.getInt("access_level"));
				membershipLevels.setRenewalNoticeSent(rs.getBoolean("renewal_notice_sent"));
				membershipLevels.setMembershipLevel(rs.getString("membership_level"));
				membershipLevels.setMembershipActive(rs.getBoolean("membership_active"));
				membershipLevels.setId(rs.getInt("id"));
				membershipLevels.setMonthlyFee(rs.getDouble("monthly_fee"));
				membershipLevels.setName(rs.getString("name"));
				membershipLevels.setEligibleBenefits(rs.getString("eligible_benefits"));
				return membershipLevels;
			}
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
		return null;
	}

	public ArrayList<MembershipLevels> findAll() {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findAll;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
 			ArrayList<MembershipLevels> arrayList = new ArrayList<>();
 			while( rs.next() ){ 
				MembershipLevels membershipLevels = new MembershipLevels();
				membershipLevels.setFkCustomerId(rs.getInt("fk_customer_id"));
				membershipLevels.setAnnualFee(rs.getDouble("annual_fee"));
				membershipLevels.setExpiryDate(rs.getString("expiry_date"));
				membershipLevels.setFkMerchantId(rs.getInt("fk_merchant_id"));
				membershipLevels.setAccessLevel(rs.getInt("access_level"));
				membershipLevels.setRenewalNoticeSent(rs.getBoolean("renewal_notice_sent"));
				membershipLevels.setMembershipLevel(rs.getString("membership_level"));
				membershipLevels.setMembershipActive(rs.getBoolean("membership_active"));
				membershipLevels.setId(rs.getInt("id"));
				membershipLevels.setMonthlyFee(rs.getDouble("monthly_fee"));
				membershipLevels.setName(rs.getString("name"));
				membershipLevels.setEligibleBenefits(rs.getString("eligible_benefits"));
				arrayList.add(membershipLevels);
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

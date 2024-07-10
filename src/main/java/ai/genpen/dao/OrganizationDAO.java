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
import ai.genpen.models.Organization;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.util.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrganizationDAO {
	String update = "UPDATE organization SET status = ?, start_date = ?, `type` = ?, fk_owner_id = ?, primary_contact_id = ?, location_id = ?, `name` = ?, is_active = ?, end_date = ?, fk_parent_id = ?, contact = ? WHERE id = ?";
	String insert = "INSERT INTO organization (status, start_date, `type`, fk_owner_id, primary_contact_id, location_id, `name`, is_active, end_date, fk_parent_id, contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String deleteById = "DELETE FROM organization WHERE id = ?";
	String deleteByName = "DELETE FROM organization WHERE `name` = ?";
	String findById = "SELECT * FROM organization WHERE id = ?";
	String findByName = "SELECT * FROM organization WHERE `name` = ?";
	String findByContact = "SELECT * FROM organization WHERE contact = ?";
	String findAllMemberByOrgName = "SELECT * FROM organization where name = ?";
	String findAllMemberByOrgContact = "SELECT * FROM organization where contact = ?";
	String findAll = "SELECT * FROM organization";
	String isOrg = "SELECT * FROM organization WHERE contact = ?";

	public int update(Organization organization) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = update;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setBoolean(1, organization.getStatus());
			pstmt.setString(2, organization.getStartDate());
			pstmt.setString(3, organization.getType());
			pstmt.setInt(4, organization.getFkOwnerId());
			pstmt.setInt(5, organization.getPrimaryContactId());
			pstmt.setInt(6, organization.getLocationId());
			pstmt.setString(7, organization.getName());
			pstmt.setBoolean(8, organization.getIsActive());
			pstmt.setString(9, organization.getEndDate());
			pstmt.setInt(10, organization.getFkParentId());
			pstmt.setString(11, organization.getContact());

			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;

	}

	public boolean isOrganization(String str) {
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			String sql = isOrg;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, str);
			pstmt.executeUpdate();
			if( rs.next() ){
				return true;
			}
			return false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public int insert(Organization organization) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = insert;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setBoolean(1, organization.getStatus());
			pstmt.setString(2, organization.getStartDate());
			pstmt.setString(3, organization.getType());
			pstmt.setInt(4, organization.getFkOwnerId());
			pstmt.setInt(5, organization.getPrimaryContactId());
			pstmt.setInt(6, organization.getLocationId());
			pstmt.setString(7, organization.getName());
			pstmt.setBoolean(8, organization.getIsActive());
			pstmt.setString(9, organization.getEndDate());
			pstmt.setInt(10, organization.getFkParentId());
			pstmt.setString(11, organization.getContact());
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

	public Organization find(String name) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findByName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
 			Organization organization = new Organization();
			if( rs.next() ){ 
				organization.setStatus(rs.getBoolean("status"));
				organization.setStartDate(rs.getString("start_date"));
				organization.setType(rs.getString("type"));
				organization.setFkOwnerId(rs.getInt("fk_owner_id"));
				organization.setPrimaryContactId(rs.getInt("primary_contact_id"));
				organization.setId(rs.getInt("id"));
				organization.setLocationId(rs.getInt("location_id"));
				organization.setName(rs.getString("name"));
				organization.setIsActive(rs.getBoolean("is_active"));
				organization.setEndDate(rs.getString("end_date"));
				organization.setFkParentId(rs.getInt("fk_parent_id"));
				organization.setContact(rs.getString("contact"));
				return organization;
			}
		} catch(Exception ex) {
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
		return null;
	}

	public Organization findByContact(String name) {
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		System.out.println("findByContact");
		try {
			String sql = findByContact;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			Organization organization = new Organization();
			if( rs.next() ){
				organization.setStatus(rs.getBoolean("status"));
				organization.setStartDate(rs.getString("start_date"));
				organization.setType(rs.getString("type"));
				organization.setFkOwnerId(rs.getInt("fk_owner_id"));
				organization.setPrimaryContactId(rs.getInt("primary_contact_id"));
				organization.setId(rs.getInt("id"));
				organization.setLocationId(rs.getInt("location_id"));
				organization.setName(rs.getString("name"));
				organization.setIsActive(rs.getBoolean("is_active"));
				organization.setEndDate(rs.getString("end_date"));
				organization.setFkParentId(rs.getInt("fk_parent_id"));
				organization.setContact(name);
				return organization;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);
		}
		return null;
	}


	public List<Member> findAllMemberByOrgContact(String name) {
		System.out.println("findAllMemberByOrgContact");
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		ArrayList<Member> memberList = new ArrayList<>();
		try {
			String sql = findAllMemberByOrgContact;
			OrganizationDAO orgDAO = new OrganizationDAO();
			Organization o = orgDAO.findByContact(name);
			int oid = -1; //o.getId();
			if( o != null ){
				oid = o.getId();
			}

			Connection c = DatabaseManager.getConnection();
			PreparedStatement p1 = c.prepareStatement("SELECT member_id FROM membership WHERE fk_organization_id = ?");
			p1.setInt(1, oid);
			ResultSet rs1 = p1.executeQuery();

			MemberDAO memberDAO = new MemberDAO();
			int cnt = 0;
			ArrayList<Integer> mids = new ArrayList<>();
			while( rs1.next() ) {
				cnt++;
				System.out.println(cnt);
				mids.add(rs1.getInt("member_id"));
			}

			for(int i =0; i < mids.size(); i++ ){
				int mn = mids.get(i);
				Member m = memberDAO.find(mn);
				if( m == null ) {
					System.out.println(mn + " is null");
				}
				memberList.add(m);
			}

			return memberList;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);

		}
	}

	public List<Member> findAllMemberByOrgName(String name) {
		System.out.println("findAllMemberByOrgName");
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		ArrayList<Member> memberList = new ArrayList<>();
		try {
			String sql = findAllMemberByOrgName;
			OrganizationDAO orgDAO = new OrganizationDAO();
			Organization o = orgDAO.find(name);
			int oid = -1; //o.getId();
			if( o != null ){
				oid = o.getId();
			}

			Connection c = DatabaseManager.getConnection();
			PreparedStatement p1 = c.prepareStatement("SELECT member_id FROM membership WHERE fk_organization_id = ?");
			p1.setInt(1, oid);
			ResultSet rs1 = p1.executeQuery();

			MemberDAO memberDAO = new MemberDAO();
			int memberId = -1;
			int cnt = 0;
			while( rs1.next() ) {
				cnt++;
				connection = DatabaseManager.getConnection();
				pstmt = connection.prepareStatement("SELECT * FROM member WHERE id = ?");
				pstmt.setInt(1, rs1.getInt("member_id"));
				ResultSet rs2 = pstmt.executeQuery();
				int n = rs2.getInt("member_id");
				Member m = memberDAO.find(n);
				memberList.add(m);
				Utility.closeQuietly(connection, pstmt, null);
				System.out.println(cnt);
			}

			return memberList;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);
			return null;
		}
	}
	public Organization find(int id) {
 		String sql = findById;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
 			Organization organization = new Organization();
			if( rs.next() ){ 
				organization.setStatus(rs.getBoolean("status"));
				organization.setStartDate(rs.getString("start_date"));
				organization.setType(rs.getString("type"));
				organization.setFkOwnerId(rs.getInt("fk_owner_id"));
				organization.setPrimaryContactId(rs.getInt("primary_contact_id"));
				organization.setId(rs.getInt("id"));
				organization.setLocationId(rs.getInt("location_id"));
				organization.setName(rs.getString("name"));
				organization.setIsActive(rs.getBoolean("is_active"));
				organization.setEndDate(rs.getString("end_date"));
				organization.setFkParentId(rs.getInt("fk_parent_id"));
				organization.setContact(rs.getString("contact"));
				return organization;
			}
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
		return null;
	}

	public ArrayList<Organization> findAll() {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findAll;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
 			ArrayList<Organization> arrayList = new ArrayList<>();
 			while( rs.next() ){ 
				Organization organization = new Organization();
				organization.setStatus(rs.getBoolean("status"));
				organization.setStartDate(rs.getString("start_date"));
				organization.setType(rs.getString("type"));
				organization.setFkOwnerId(rs.getInt("fk_owner_id"));
				organization.setPrimaryContactId(rs.getInt("primary_contact_id"));
				organization.setId(rs.getInt("id"));
				organization.setLocationId(rs.getInt("location_id"));
				organization.setName(rs.getString("name"));
				organization.setIsActive(rs.getBoolean("is_active"));
				organization.setEndDate(rs.getString("end_date"));
				organization.setFkParentId(rs.getInt("fk_parent_id"));
				organization.setContact(rs.getString("contact"));

				arrayList.add(organization);
			}
			System.out.println("Found:" + arrayList.size() + " Organizations");

			return arrayList;
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}


	public static void main(String[] args)
	{
		OrganizationDAO dao = new OrganizationDAO();
		try {
			List<Member> ab = dao.findAllMemberByOrgContact("contact@herapass.com");

			if( ab != null ) {
				System.out.println(ab.size());
				System.out.println(ab);
			} else {
				System.out.println("ab is null");
			}

		} catch (Exception throwables) {
			throwables.printStackTrace();
		}
	}

}

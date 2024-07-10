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

import ai.genpen.models.Account;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.util.Globals;
import org.primefaces.rain.util.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountDAO {
	String update = "UPDATE account SET start_date = ?, is_primary = ?, account_name = ?, description = ?, wallet_address = ?, created_date = ?, account_status = ?, `name` = ?, end_date = ?, currency = ?, balance = ?, due_day = ?, fk_parent_account = ? WHERE id = ?";
	String insert = "INSERT INTO account (start_date, is_primary, account_name, description, wallet_address, created_date, account_status, `name`, end_date, currency, balance, due_day, fk_parent_account) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String deleteById = "DELETE FROM account WHERE id = ?";
	String deleteByName = "DELETE FROM account WHERE account_name = ?";
	String findById = "SELECT * FROM account WHERE id = ?";
	String findByName = "SELECT * FROM account WHERE account_name = ?";
	String findAll = "SELECT * FROM account";


	public static void main(String[] args)
	{
		AccountDAO dao = new AccountDAO();
		try {
			Account ab = dao.find(Globals.defaultUser);
			System.out.println(ab);
			System.out.println(ab.getWalletAddress());
			System.out.println(ab.getBalance());

		} catch (Exception throwables) {
			throwables.printStackTrace();
		}
	}

	public int update(Account account) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = update;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, account.getStartDate());
			pstmt.setBoolean(2, account.getIsPrimary());
			pstmt.setString(3, account.getAccountName());
			pstmt.setString(4, account.getDescription());
			pstmt.setString(5, account.getWalletAddress());
			pstmt.setString(6, account.getCreatedDate());
			pstmt.setInt(7, account.getAccountStatus());
			pstmt.setString(8, account.getName());
			pstmt.setString(9, account.getEndDate());
			pstmt.setString(10, account.getCurrency());
			pstmt.setDouble(11, account.getBalance());
			pstmt.setInt(12, account.getDueDay());
			pstmt.setInt(13, account.getFkParentAccount());
			pstmt.setInt(14, account.getId());


			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;

	}

	public int insert(Account account) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = insert;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, account.getStartDate());
			pstmt.setBoolean(2, account.getIsPrimary());
			pstmt.setString(3, account.getAccountName());
			pstmt.setString(4, account.getDescription());
			pstmt.setString(5, account.getWalletAddress());
			pstmt.setString(6, account.getCreatedDate());
			pstmt.setInt(7, account.getAccountStatus());
			//pstmt.setInt(8, account.getId()); TODO: REMOVE CODE GENPEN TEMPLATE

			pstmt.setString(8, account.getName());
			pstmt.setString(9, account.getEndDate());
			pstmt.setString(10, account.getCurrency());
			pstmt.setDouble(11, account.getBalance());
			pstmt.setInt(12, account.getDueDay());
			pstmt.setInt(13, account.getFkParentAccount());
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

	public Account find(String name) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findByName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			System.out.println(sql);
			rs = pstmt.executeQuery();
 			Account account = new Account();
			if( rs.next() ){ 
				account.setStartDate(rs.getString("start_date"));
				account.setIsPrimary(rs.getBoolean("is_primary"));
				account.setAccountName(rs.getString("account_name"));
				account.setDescription(rs.getString("description"));
				account.setWalletAddress(rs.getString("wallet_address"));
				account.setCreatedDate(rs.getString("created_date"));
				account.setAccountStatus(rs.getInt("account_status"));
				account.setName(rs.getString("name"));
				account.setEndDate(rs.getString("end_date"));
				account.setCurrency(rs.getString("currency"));
				account.setBalance(rs.getDouble("balance"));
				account.setDueDay(rs.getInt("due_day"));
				account.setFkParentAccount(rs.getInt("fk_parent_account"));
			}

			return account;
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

	public Account find(int id) {
 		String sql = findById;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
 			Account account = new Account();
			if( rs.next() ){ 
				account.setStartDate(rs.getString("start_date"));
				account.setIsPrimary(rs.getBoolean("is_primary"));
				account.setAccountName(rs.getString("account_name"));
				account.setDescription(rs.getString("descripton"));
				account.setWalletAddress(rs.getString("wallet_address"));
				account.setCreatedDate(rs.getString("created_date"));
				account.setAccountStatus(rs.getInt("account_status"));
				account.setName(rs.getString("name"));
				account.setEndDate(rs.getString("end_date"));
				account.setCurrency(rs.getString("currency"));
				account.setBalance(rs.getDouble("balance"));
				account.setDueDay(rs.getInt("due_day"));
				account.setFkParentAccount(rs.getInt("fk_parent_account"));
				return account;
			}
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);
		}
		return null;
	}

	public ArrayList<Account> findAll() {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findAll;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
 			ArrayList<Account> arrayList = new ArrayList<>();
 			while( rs.next() ){ 
				Account account = new Account();
				account.setStartDate(rs.getString("start_date"));
				account.setIsPrimary(rs.getBoolean("is_primary"));
				account.setAccountName(rs.getString("account_name"));
				account.setDescription(rs.getString("description"));
				account.setWalletAddress(rs.getString("wallet_address"));
				account.setCreatedDate(rs.getString("created_date"));
				account.setAccountStatus(rs.getInt("account_status"));
				account.setName(rs.getString("name"));
				account.setEndDate(rs.getString("end_date"));
				account.setCurrency(rs.getString("currency"));
				account.setBalance(rs.getDouble("balance"));
				account.setDueDay(rs.getInt("due_day"));
				account.setFkParentAccount(rs.getInt("fk_parent_account"));
				arrayList.add(account);
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

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

import ai.genpen.models.NFT;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.util.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class NFTDAO {
	String update = "UPDATE nft SET token_id = ?, ipfs_hash = ?, id = ?, `name` = ?, contract_address = ? WHERE id = ?";
	String insert = "INSERT INTO nft (token_id, ipfs_hash, id, `name`, contract_address) VALUES (?, ?, ?, ?, ?)";
	String deleteById = "DELETE FROM nft WHERE id = ?";
	String deleteByName = "DELETE FROM nft WHERE name = ?";
	String findById = "SELECT * FROM nft WHERE id = ?";
	String findByName = "SELECT * FROM nft WHERE name = ?";
	String findAll = "SELECT * FROM nft";

	public int update(NFT nft) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = update;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, nft.getTokenId());
			pstmt.setString(2, nft.getIpfsHash());
			pstmt.setInt(3, nft.getId());
			pstmt.setString(4, nft.getName());
			pstmt.setString(5, nft.getContractAddress());

			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;

	}

	public int insert(NFT nft) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = insert;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, nft.getTokenId());
			pstmt.setString(2, nft.getIpfsHash());
			pstmt.setInt(3, nft.getId());
			pstmt.setString(4, nft.getName());
			pstmt.setString(5, nft.getContractAddress());
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

	public NFT find(String name) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findByName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
 			NFT nft = new NFT();
			if( rs.next() ){ 
				nft.setTokenId(rs.getInt("token_id"));
				nft.setIpfsHash(rs.getString("ipfs_hash"));
				nft.setId(rs.getInt("id"));
				nft.setName(rs.getString("name"));
				nft.setContractAddress(rs.getString("contract_address"));
			}
			return nft;
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

	public NFT find(int id) {
 		String sql = findById;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
 			NFT nft = new NFT();
			if( rs.next() ){ 
				nft.setTokenId(rs.getInt("token_id"));
				nft.setIpfsHash(rs.getString("ipfs_hash"));
				nft.setId(rs.getInt("id"));
				nft.setName(rs.getString("name"));
				nft.setContractAddress(rs.getString("contract_address"));
				return nft;
			}
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
		return null;
	}

	public ArrayList<NFT> findAll() {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findAll;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
 			ArrayList<NFT> arrayList = new ArrayList<>();
 			while( rs.next() ){ 
				NFT nft = new NFT();
				nft.setTokenId(rs.getInt("token_id"));
				nft.setIpfsHash(rs.getString("ipfs_hash"));
				nft.setId(rs.getInt("id"));
				nft.setName(rs.getString("name"));
				nft.setContractAddress(rs.getString("contract_address"));
				arrayList.add(nft);
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

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

import ai.genpen.models.Notification;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.util.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class NotificationDAO {
	String update = "UPDATE notification SET fk_sender_id = ?, read_timestamp = ?, message = ?, recipient = ?, expired = ?, attachment = ?, priority = ?, `timestamp` = ?, `name` = ?, fk_conversation_id = ?, reference = ?, delivery_method = ?, `read` = ? WHERE id = ?";
	String insert = "INSERT INTO notification (fk_sender_id, read_timestamp, message, recipient, expired,  attachment, priority, `timestamp`, `name`, fk_conversation_id, reference, delivery_method, `read`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String deleteById = "DELETE FROM notification WHERE id = ?";
	String deleteByName = "DELETE FROM notification WHERE `name` = ?";

	String findById = "SELECT * FROM notification WHERE id = ?";
	String findByName = "SELECT * FROM notification WHERE `name` = ?";
	String findAll = "SELECT * FROM notification";
	String findAllForMe = "SELECT * FROM notification WHERE recipient = ?";

	public int update(Notification notification) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = update;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, notification.getFkSenderId());
			pstmt.setString(2, notification.getReadTimestamp());
			pstmt.setString(3, notification.getMessage());
			pstmt.setString(4, notification.getRecipient());
			pstmt.setBoolean(5, notification.getExpired());
			pstmt.setInt(6, notification.getAttachment());
			pstmt.setInt(7, notification.getPriority());
			pstmt.setString(8, notification.getTimestamp());
			pstmt.setString(9, notification.getName());
			pstmt.setInt(10, notification.getFkConversationId());
			pstmt.setString(11, notification.getReference());
			pstmt.setString(12, notification.getDeliveryMethod());
			pstmt.setBoolean(13, notification.getRead());

			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;

	}

	public int insert(Notification notification) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = insert;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, notification.getFkSenderId());
			pstmt.setString(2, notification.getReadTimestamp());
			pstmt.setString(3, notification.getMessage());
			pstmt.setString(4, notification.getRecipient());
			pstmt.setBoolean(5, notification.getExpired());
			pstmt.setInt(6, notification.getAttachment());
			pstmt.setInt(7, notification.getPriority());
			pstmt.setString(8, notification.getTimestamp());
			pstmt.setString(9, notification.getName());
			pstmt.setInt(10, notification.getFkConversationId());
			pstmt.setString(11, notification.getReference());
			pstmt.setString(12, notification.getDeliveryMethod());
			pstmt.setBoolean(13, notification.getRead());
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

	public Notification find(String name) {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findByName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
 			Notification notification = new Notification();
			if( rs.next() ){ 
				notification.setFkSenderId(rs.getInt("fk_sender_id"));
				notification.setReadTimestamp(rs.getString("read_timestamp"));
				notification.setMessage(rs.getString("message"));
				notification.setRecipient(rs.getString("recipient"));
				notification.setExpired(rs.getBoolean("expired"));
				notification.setId(rs.getInt("id"));
				notification.setAttachment(rs.getInt("attachment"));
				notification.setPriority(rs.getInt("priority"));
				notification.setTimestamp(rs.getString("timestamp"));
				notification.setName(rs.getString("name"));
				notification.setFkConversationId(rs.getInt("fk_conversation_id"));
				notification.setReference(rs.getString("reference"));
				notification.setDeliveryMethod(rs.getString("delivery_method"));
				notification.setRead(rs.getBoolean("read"));
			}
			return notification;
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

	public Notification findByOrg(String org) {
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			String sql = findByName;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, org);
			rs = pstmt.executeQuery();
			Notification notification = new Notification();
			if( rs.next() ){
				notification.setFkSenderId(rs.getInt("fk_sender_id"));
				notification.setReadTimestamp(rs.getString("read_timestamp"));
				notification.setMessage(rs.getString("message"));
				notification.setRecipient(rs.getString("recipient"));
				notification.setExpired(rs.getBoolean("expired"));
				notification.setId(rs.getInt("id"));
				notification.setAttachment(rs.getInt("attachment"));
				notification.setPriority(rs.getInt("priority"));
				notification.setTimestamp(rs.getString("timestamp"));
				notification.setName(rs.getString("name"));
				notification.setFkConversationId(rs.getInt("fk_conversation_id"));
				notification.setReference(rs.getString("reference"));
				notification.setDeliveryMethod(rs.getString("delivery_method"));
				notification.setRead(rs.getBoolean("read"));
			}
			return notification;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);
		}
	}

	public Notification find(int id) {
 		String sql = findById;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
 			Notification notification = new Notification();
			if( rs.next() ){ 
				notification.setFkSenderId(rs.getInt("fk_sender_id"));
				notification.setReadTimestamp(rs.getString("read_timestamp"));
				notification.setMessage(rs.getString("message"));
				notification.setRecipient(rs.getString("recipient"));
				notification.setExpired(rs.getBoolean("expired"));
				notification.setId(rs.getInt("id"));
				notification.setAttachment(rs.getInt("attachment"));
				notification.setPriority(rs.getInt("priority"));
				notification.setTimestamp(rs.getString("timestamp"));
				notification.setName(rs.getString("name"));
				notification.setFkConversationId(rs.getInt("fk_conversation_id"));
				notification.setReference(rs.getString("reference"));
				notification.setDeliveryMethod(rs.getString("delivery_method"));
				notification.setRead(rs.getBoolean("read"));
				return notification;
			}
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
		return null;
	}

	public ArrayList<Notification> findAll() {
 		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try { 
			String sql = findAll;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
 			ArrayList<Notification> arrayList = new ArrayList<>();
 			while( rs.next() ){ 
				Notification notification = new Notification();
				notification.setFkSenderId(rs.getInt("fk_sender_id"));
				notification.setReadTimestamp(rs.getString("read_timestamp"));
				notification.setMessage(rs.getString("message"));
				notification.setRecipient(rs.getString("recipient"));
				notification.setExpired(rs.getBoolean("expired"));
				notification.setId(rs.getInt("id"));
				notification.setAttachment(rs.getInt("attachment"));
				notification.setPriority(rs.getInt("priority"));
				notification.setTimestamp(rs.getString("timestamp"));
				notification.setName(rs.getString("name"));
				notification.setFkConversationId(rs.getInt("fk_conversation_id"));
				notification.setReference(rs.getString("reference"));
				notification.setDeliveryMethod(rs.getString("delivery_method"));
				notification.setRead(rs.getBoolean("read"));
				arrayList.add(notification);
			}
			System.out.println("Found:" + arrayList.size() + " Notifications");

			return arrayList;
		} catch(Exception ex) { 
			ex.printStackTrace(); 
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs); 
		}
	}

	public List<Notification> findAllForMe(String id) {
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			String sql = findAllForMe;
			connection = DatabaseManager.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			ArrayList<Notification> arrayList = new ArrayList<>();
			while( rs.next() ){
				Notification notification = new Notification();
				notification.setFkSenderId(rs.getInt("fk_sender_id"));
				notification.setReadTimestamp(rs.getString("read_timestamp"));
				notification.setMessage(rs.getString("message"));
				notification.setRecipient(rs.getString("recipient"));
				notification.setExpired(rs.getBoolean("expired"));
				notification.setId(rs.getInt("id"));
				notification.setAttachment(rs.getInt("attachment"));
				notification.setPriority(rs.getInt("priority"));
				notification.setTimestamp(rs.getString("timestamp"));
				notification.setName(rs.getString("name"));
				notification.setFkConversationId(rs.getInt("fk_conversation_id"));
				notification.setReference(rs.getString("reference"));
				notification.setDeliveryMethod(rs.getString("delivery_method"));
				notification.setRead(rs.getBoolean("read"));
				arrayList.add(notification);
			}
			System.out.println("Found:" + arrayList.size() + " Notifications");

			return arrayList;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			Utility.closeQuietly(connection, pstmt, rs);
		}
	}
}

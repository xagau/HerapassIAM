package org.primefaces.rain.dao;

import org.primefaces.rain.domain.Benefit;
import org.primefaces.rain.util.Globals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenefitDAO {

    Connection connection = null;
    public BenefitDAO() {
        try {
            connection = DatabaseManager.getConnection();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void insert(Benefit benefit) throws SQLException {
        String sql = "INSERT INTO benefit (id, action_date, activation_date, end_date, enabled, `name`, `description`, `action`, owner, organization, `member`) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, benefit.getId());
            stmt.setTimestamp(2, new java.sql.Timestamp(benefit.getActionDate().getTime()));
            stmt.setTimestamp(3, new java.sql.Timestamp(benefit.getActivationDate().getTime()));
            stmt.setTimestamp(4, new java.sql.Timestamp(benefit.getEndDate().getTime()));
            stmt.setBoolean(5, benefit.isEnabled());
            stmt.setString(6, benefit.getName());
            stmt.setString(7, benefit.getDescription());
            stmt.setString(8, benefit.getAction());
            stmt.setString(9, benefit.getOwner());
            stmt.setString(10, benefit.getOrganization());
            stmt.setString(11, benefit.getMember());

            stmt.executeUpdate();
        }
    }

    public void update(Benefit benefit) throws SQLException {
        String sql = "UPDATE benefit SET action_date = ?, activation_date = ?, end_date = ?, enabled = ?, `name` = ?, `desc` = ?, `action` = ?, owner = ?, organization = ?, member = ? "
                + "WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, new java.sql.Timestamp(benefit.getActionDate().getTime()));
            stmt.setTimestamp(2, new java.sql.Timestamp(benefit.getActivationDate().getTime()));
            stmt.setTimestamp(3, new java.sql.Timestamp(benefit.getEndDate().getTime()));
            stmt.setBoolean(4, benefit.isEnabled());
            stmt.setString(5, benefit.getName());
            stmt.setString(6, benefit.getDescription());
            stmt.setString(7, benefit.getAction());
            stmt.setString(8, benefit.getOwner());
            stmt.setString(9, benefit.getOrganization());
            stmt.setString(10, benefit.getMember());
            stmt.setInt(11, benefit.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM benefits WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

    public List<Benefit> findByOrganization(String organization) throws SQLException {
        String sql = "SELECT * FROM benefit WHERE organization = ?";
        List<Benefit> benefits = new ArrayList<>();

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, organization);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Benefit benefit = new Benefit();
                    benefit.setId(rs.getInt("id"));
                    benefit.setActionDate(rs.getDate("action_date"));
                    benefit.setActivationDate(rs.getDate("activation_date"));
                    benefit.setEndDate(rs.getDate("end_date"));
                    benefit.setEnabled(rs.getBoolean("enabled"));
                    benefit.setName(rs.getString("name"));
                    benefit.setDescription(rs.getString("desc"));
                    benefit.setAction(rs.getString("action"));
                    benefit.setOwner(rs.getString("owner"));
                    benefit.setOrganization(rs.getString("organization"));
                    benefit.setMember(rs.getString("member"));
                    benefits.add(benefit);
                }
            }
        }

        return benefits;
    }

    public List<Benefit> findByMember(String member) throws SQLException {
        String sql = "SELECT * FROM benefit WHERE `member` = ?";
        List<Benefit> benefits = new ArrayList<>();

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, member);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Benefit benefit = new Benefit();
                    benefit.setId(rs.getInt("id"));
                    benefit.setActionDate(rs.getDate("action_date"));
                    benefit.setActivationDate(rs.getDate("activation_date"));
                    benefit.setEndDate(rs.getDate("end_date"));
                    benefit.setEnabled(rs.getBoolean("enabled"));
                    benefit.setName(rs.getString("name"));
                    benefit.setDescription(rs.getString("description"));
                    benefit.setAction(rs.getString("action"));
                    benefit.setOwner(rs.getString("owner"));
                    benefit.setOrganization(rs.getString("organization"));
                    benefit.setMember(rs.getString("member"));
                    benefits.add(benefit);
                }
            }
        }

        return benefits;
    }

    public static void main(String[] args)
    {
        BenefitDAO dao = new BenefitDAO();
        try {
            List<Benefit> ab = dao.findByMember(Globals.defaultUser);
            System.out.println(ab.size());
            System.out.println(ab.get(0).getMember());

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}


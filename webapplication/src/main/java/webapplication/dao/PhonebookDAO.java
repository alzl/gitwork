package webapplication.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import webapplication.vo.PhonebookVO;

public class PhonebookDAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "oracle";  // 저는 초기설정 때 1234가 아닌 oracle로 해서 비밀번호 바꾸셔야 합니다.
        return DriverManager.getConnection(url, username, password);
    }

    
    // 전화번호부 입력
    public void insert(PhonebookVO phonebook) {
        String sql = "INSERT INTO phonebook (id, name, hp, memo) VALUES (phonebook_id_seq.nextval, ?, ?, ?)";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, phonebook.getName());
            pstmt.setString(2, phonebook.getHp());
            pstmt.setString(3, phonebook.getMemo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    // 전화번호부 전체 출력
    public List<PhonebookVO> selectAll() {
        List<PhonebookVO> list = new ArrayList<>();
        String sql = "SELECT * FROM phonebook";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql); 
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                PhonebookVO phonebook = new PhonebookVO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("hp"),
                        rs.getString("memo")
                );
                list.add(phonebook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    
    // id에 해당하는 전화번호 객체 데이터 가져오기
    public PhonebookVO selectById(int id) {
        PhonebookVO phonebook = null;
        String sql = "SELECT * FROM phonebook WHERE id = ?";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    phonebook = new PhonebookVO(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("hp"),
                            rs.getString("memo")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phonebook;
    }

    
    // 전화번호부 검색 출력
    public List<PhonebookVO> search(String keyword) {
        List<PhonebookVO> list = new ArrayList<>();
        String sql = "SELECT * FROM phonebook WHERE name LIKE ? OR hp LIKE ? OR memo LIKE ?";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String searchQuery = "%" + keyword + "%";
            pstmt.setString(1, searchQuery);
            pstmt.setString(2, searchQuery);
            pstmt.setString(3, searchQuery);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PhonebookVO phonebook = new PhonebookVO(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("hp"),
                            rs.getString("memo")
                    );
                    list.add(phonebook);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    
    // 선택한 id의 전화번호부를 수정
    public void update(PhonebookVO phonebook) {
        String sql = "UPDATE phonebook SET name = ?, hp = ?, memo = ? WHERE id = ?";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, phonebook.getName());
            pstmt.setString(2, phonebook.getHp());
            pstmt.setString(3, phonebook.getMemo());
            pstmt.setInt(4, phonebook.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    // 선택한 id의 전화번호부를 삭제
    public void delete(int id) {
        String sql = "DELETE FROM phonebook WHERE id = ?";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

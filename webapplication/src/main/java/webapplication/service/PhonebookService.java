package webapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webapplication.dao.PhonebookDAO;
import webapplication.vo.PhonebookVO;

@Service
public class PhonebookService {

    @Autowired
    private PhonebookDAO phonebookDAO;

    
    // 전화번호부 입력
    public void addContact(PhonebookVO phonebookVO) {
        phonebookDAO.insert(phonebookVO);
    }
    
    
    // 전화번호부 검색
    public List<PhonebookVO> searchContacts(String keyword) {
        return phonebookDAO.search(keyword);
    }
    
    
    // 전화번호부 전체 출력
    public List<PhonebookVO> getAllContacts() {
        return phonebookDAO.selectAll();
    }
    
    
    // 전화번호부 선택 출력
    public PhonebookVO getContactById(int id) {
        return phonebookDAO.selectById(id);
    }
    
    
    // 전화번호부 수정
    public void updateContact(PhonebookVO phonebookVO) {
        phonebookDAO.update(phonebookVO);
    }
    
    // 전화번호부 삭제
    public void deleteContact(int id) {
        phonebookDAO.delete(id);
    }
}

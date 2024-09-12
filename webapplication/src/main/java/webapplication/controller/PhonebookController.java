package webapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webapplication.service.PhonebookService;
import webapplication.vo.PhonebookVO;

@Controller
@RequestMapping("/")
public class PhonebookController {

	

    @Autowired
    private PhonebookService phonebookService;

    
	// 전화번호부 입력 기능
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("phonebookVO", new PhonebookVO());
        return "addContact";
    }

    @PostMapping("/add")
    public String addContact(@ModelAttribute("phonebookVO") PhonebookVO phonebookVO) {
        phonebookService.addContact(phonebookVO);
        return "redirect:/list";
    }
    
    
    
    // 전화번호부 검색 기능
    @GetMapping("/search")
    public String searchContact(@RequestParam("keyword") String keyword, Model model) {
        List<PhonebookVO> searchResults = phonebookService.searchContacts(keyword);
        model.addAttribute("contacts", searchResults);
        return "searchResults";
    }
    
    
    // 전화번호부 전체 출력 기능
    @GetMapping("/list")
    public String listContacts(Model model) {
        List<PhonebookVO> contactList = phonebookService.getAllContacts();
        model.addAttribute("contacts", contactList);
        return "listContacts";
    }
    
    
    // 전화번호부 선택 출력 기능
    @GetMapping("/view/{id}")
    public String viewContact(@PathVariable("id") int id, Model model) {
        PhonebookVO contact = phonebookService.getContactById(id);
        model.addAttribute("contact", contact);
        return "viewContact";
    }
    
    
    // 전화번호부 수정 기능
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        PhonebookVO contact = phonebookService.getContactById(id);
        model.addAttribute("phonebookVO", contact);
        return "editContact";
    }

    @PostMapping("/edit")
    public String editContact(@ModelAttribute("phonebookVO") PhonebookVO phonebookVO) {
        phonebookService.updateContact(phonebookVO);
        return "redirect:/list";
    }
    
    
    
    // 전화번호부 삭제 기능
    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") int id, Model model) {
        PhonebookVO contact = phonebookService.getContactById(id);
        model.addAttribute("contact", contact);
        return "deleteContact";
    }

    @PostMapping("/delete")
    public String deleteContact(@RequestParam("id") int id) {
        phonebookService.deleteContact(id);
        return "redirect:/list";
    }
}


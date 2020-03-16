package spring.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import spring.jdbc.dao.FamilyRepository;
import spring.jdbc.model.FamilyMember;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * @Created 14 / 03 / 2020 - 9:34 PM
 * @project SpringJDBC
 * @Author Hamdamboy
 */

@RestController
@RequestMapping("/member")
public class FamilyController {
    //
    @Autowired
    FamilyRepository familyRepository;

    @GetMapping("/test")
    public String test(){
        String testing = "testing";
        return testing;
    }

    @GetMapping("/all")
    public List<FamilyMember> getAllMembers() {
        return familyRepository.getMembers();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getMember(@PathVariable("id") Integer id){
        FamilyMember familyMember = familyRepository.getNameById(id);
        if(familyMember == null) {
            return new ResponseEntity<>("No member found with this " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(familyMember, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createMember(@RequestBody FamilyMember familyMember) throws SQLIntegrityConstraintViolationException {
        //
        if(familyRepository.getNameById(familyMember.getId())!= null){
            return new ResponseEntity<String>("Duplicate Entry" + familyMember.getId(), HttpStatus.IM_USED);
        }
        familyRepository.saveMember(familyMember);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@RequestBody FamilyMember member){
        //
        if(familyRepository.getNameById(member.getId())  == null) {
            return new ResponseEntity<String>("Unable to update as Family Member id   " + member.getId() + " not founded.", HttpStatus.NOT_FOUND);
        }

        familyRepository.updateMember(member);
        return new ResponseEntity<FamilyMember>(member, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
      //
      FamilyMember familyMember = familyRepository.getNameById(id);
      if(familyMember == null) {
          new ResponseEntity<String>("Unable to delete as Member id  " + id + " not found.", HttpStatus.NOT_FOUND);
      }
      familyRepository.deleteMember(id);
      return new ResponseEntity<FamilyMember>(HttpStatus.NO_CONTENT);
    }

//    int deleteMember(Integer id);
}

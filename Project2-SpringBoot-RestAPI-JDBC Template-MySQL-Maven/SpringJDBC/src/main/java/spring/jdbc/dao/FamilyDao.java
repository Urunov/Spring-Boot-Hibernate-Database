package spring.jdbc.dao;

import spring.jdbc.model.FamilyMember;

import java.util.List;

/**
 * @Created 14 / 03 / 2020 - 9:47 PM
 * @project SpringJDBC
 * @Author Hamdamboy
 */
public interface FamilyDao {
    //

    FamilyMember getNameById(int id);

    FamilyMember findByName(FamilyMember firstname);

    boolean saveMember(FamilyMember member);

    int updateMember(FamilyMember member);

    List<FamilyMember> findAll();

    void deleteMember(Integer id);
}

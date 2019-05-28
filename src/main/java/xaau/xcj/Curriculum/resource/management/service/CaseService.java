package xaau.xcj.Curriculum.resource.management.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.Case;
import xaau.xcj.Curriculum.resource.management.mapper.CaseMapper;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/4/23 15:23
 * @message:
 */
public interface CaseService {
    public int caseSum(Case cases);//查询总记录数
    public List<Case> findCase(Case cases,int ns,int ps );  //分页查询
    public int addCase(Case aCase);  //添加
    public String deleteCase(int id); //刪除
    public Case findCaseToId(int id); //根据id查找
    public int updateCase(Case case1); //修改
}

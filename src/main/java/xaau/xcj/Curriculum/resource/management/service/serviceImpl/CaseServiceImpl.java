package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.Case;
import xaau.xcj.Curriculum.resource.management.mapper.CaseMapper;
import xaau.xcj.Curriculum.resource.management.service.CaseService;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/4/23 15:35
 * @message:案例服務層
 */
@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    private CaseMapper caseMapper;
    @Override
    public int caseSum(Case cases) {  //查询总记录数
        return this.caseMapper.caseSum(cases);
    }

    @Override
    public List<Case> findCase(Case cases,int ns, int ps) {
        return this.caseMapper.findCase(cases,ns,ps);
    }

    @Override
    public int addCase(Case aCase) {
        return this.caseMapper.addCase(aCase);
    }

    @Override
    public String deleteCase(int id) {
        int row=this.caseMapper.deleteCase(id);
        if(row>0){
            return "ok";
        }else{
            return "no";
        }
    }

    @Override
    public Case findCaseToId(int id) {
        return this.caseMapper.findCaseToId(id);
    }

    @Override
    public int updateCase(Case case1) {
        return this.caseMapper.updateCase(case1);
    }


}

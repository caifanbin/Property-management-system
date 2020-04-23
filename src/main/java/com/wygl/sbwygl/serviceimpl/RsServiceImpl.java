package com.wygl.sbwygl.serviceimpl;


import com.wygl.sbwygl.bean.Rs;
import com.wygl.sbwygl.commons.AjaxResult;
import com.wygl.sbwygl.commons.Page;
import com.wygl.sbwygl.commons.StringUtil;
import com.wygl.sbwygl.mapper.RsMapper;
import com.wygl.sbwygl.service.RsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RsServiceImpl implements RsService {

    @Autowired
    private RsMapper rsMapper;

    @Override
    public void saveRs(Rs rs) {
        rs.setLoginName("666666");
        rs.setLoginPwd("666666");
        rsMapper.saveRs(rs);
    }

    @Override
    public Page queryPage(Map map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex",startIndex);
        List<Rs> datas = rsMapper.queryRsList(map);
        Integer totalsize = rsMapper.queryRscount(map);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public AjaxResult deleteRs(Integer id) {
        AjaxResult result = new AjaxResult();
        try {
            rsMapper.deleteRs(id);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除失败");

        }
        return result;
    }

    @Override
    public Rs getRsById(Integer id) {
        return rsMapper.getRsById(id);
    }

    @Override
    public AjaxResult updateRs(Rs rs) {
        AjaxResult result = new AjaxResult();
        try {
            if(StringUtil.iNotEmpty(rs.getAdminName())&&StringUtil.iNotEmpty(rs.getLoginName())&&StringUtil.iNotEmpty(rs.getLoginPwd())
                    &&StringUtil.iNotEmpty(rs.getBegDate())&&StringUtil.iNotEmpty(rs.getPersionNo())
                    &&StringUtil.iNotEmpty(rs.getSex())&&StringUtil.iNotEmpty(rs.getPost())) {
                rsMapper.updateRs(rs);
                result.setSuccess(true);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("修改失败");
            result.setSuccess(false);
        }
        return result;
    }
}

package cn.fv.service.serviceImpl;

import cn.fv.dao.LogtableMapper;
import cn.fv.pojo.Logtable;
import cn.fv.service.LogTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogTableServiceImpl implements LogTableService {

    @Autowired
    private LogtableMapper logtableMapper;

    public boolean addLog(Logtable logtable) {
        return logtableMapper.insert(logtable) > 0 ? true :false;
    }
}

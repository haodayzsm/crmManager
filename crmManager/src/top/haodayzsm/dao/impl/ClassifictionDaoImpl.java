package top.haodayzsm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import top.haodayzsm.dao.IClassificationDao;
import top.haodayzsm.pojo.Classification;
import top.haodayzsm.utils.PageBean;
@Repository(value="classificationDao")
@Scope(value="prototype")
public class ClassifictionDaoImpl extends BaseDaoImpl<Classification> implements IClassificationDao {

}

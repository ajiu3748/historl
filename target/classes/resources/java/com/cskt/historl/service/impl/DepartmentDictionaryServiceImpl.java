package com.cskt.historl.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cskt.historl.mapper.DepartmentDictionaryMapper;
import com.cskt.historl.entity.DepartmentDictionary;
import com.cskt.historl.service.DepartmentDictionaryService;

@Service
public class DepartmentDictionaryServiceImpl extends ServiceImpl<DepartmentDictionaryMapper, DepartmentDictionary> implements DepartmentDictionaryService{

}

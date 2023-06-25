package tao.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tao.reggie.entity.Employee;
import tao.reggie.mapper.EmployeeMapper;
import tao.reggie.service.EmployeeService;

/**
 * @author 彭桂涛
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>implements EmployeeService {
}

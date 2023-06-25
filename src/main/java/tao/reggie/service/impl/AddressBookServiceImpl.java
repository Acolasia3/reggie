package tao.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tao.reggie.entity.AddressBook;
import tao.reggie.mapper.AddressBookMapper;
import tao.reggie.service.AddressBookService;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}

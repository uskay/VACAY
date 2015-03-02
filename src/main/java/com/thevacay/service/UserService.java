package com.thevacay.service;

import com.thevacay.entity.User;
import com.thevacay.entity.UserAddress;
import com.thevacay.entity.UserCredential;
import com.thevacay.entity.vo.PaymentMethod;
import com.thevacay.repository.TestRepository;
import com.thevacay.service.interfaces.user.UserRequestBean;
import com.thevacay.service.interfaces.user.UserResponseBean;
import com.thevacay.service.interfaces.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uskay on 1/29/15.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private TestRepository test;


    @Override
    public UserResponseBean getCurrentSessionUserInfo() {
        return null;
    }

    @Override
    public UserResponseBean addUser(UserRequestBean request) {
        User user = new User();
        user.setLastUsedPaymentMethod(PaymentMethod.BANK_TRANSFER);
        user.setUserName("uskay");
        user.setAnonymous(false);
        user.setEmail("test@gmail.com");
        test.save(user);
        UserCredential credential = new UserCredential();
        credential.setUserID(user.getUserID());
        credential.setLoginID(user.getEmail());
        credential.setPassword("abcdefg");
        user.setUserCredential(credential);
        test.save(user);
        List<UserAddress> addressList = new ArrayList<UserAddress>();
        UserAddress address = new UserAddress();
        address.setUserID(user.getUserID());
        address.setAddress1("aaa");
        addressList.add(address);
        UserAddress address2 = new UserAddress();
        address2.setUserID(user.getUserID());
        address2.setAddress1("bbb");
        addressList.add(address2);
        user.setUserAddressList(addressList);
        test.save(user);
        return null;
    }

    @Override
    public UserResponseBean updateUserInfo(UserRequestBean request) {
        return null;
    }

}

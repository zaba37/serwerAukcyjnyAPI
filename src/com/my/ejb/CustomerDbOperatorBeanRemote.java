/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.ejb;

import com.my.model.Address;
import com.my.model.Customer;
import com.my.model.CustomerLogin;
import javax.ejb.Remote;

/**
 *
 * @author zaba37
 */

@Remote
public interface CustomerDbOperatorBeanRemote {
        
    boolean addCustomer(Customer customer, CustomerLogin customerLogin, Address address);

}

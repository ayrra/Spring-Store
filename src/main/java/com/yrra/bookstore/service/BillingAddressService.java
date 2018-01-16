package com.yrra.bookstore.service;

import com.yrra.bookstore.domain.BillingAddress;
import com.yrra.bookstore.domain.UserBilling;

public interface BillingAddressService {

	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);

}

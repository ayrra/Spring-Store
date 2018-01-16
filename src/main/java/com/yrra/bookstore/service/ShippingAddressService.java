package com.yrra.bookstore.service;

import com.yrra.bookstore.domain.ShippingAddress;
import com.yrra.bookstore.domain.UserShipping;

public interface ShippingAddressService {

	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);

}

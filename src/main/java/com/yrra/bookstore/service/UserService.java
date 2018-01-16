package com.yrra.bookstore.service;

import java.util.Set;

import com.yrra.bookstore.domain.User;
import com.yrra.bookstore.domain.UserBilling;
import com.yrra.bookstore.domain.UserPayment;
import com.yrra.bookstore.domain.UserShipping;
import com.yrra.bookstore.domain.security.PasswordResetToken;
import com.yrra.bookstore.domain.security.UserRole;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail(String email);

	User createUser(User user, Set<UserRole> userRoles) throws Exception;

	User save(User user);

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

	void setUserDefaultPayment(Long defaultPaymentId, User user);

	void updateUserShipping(UserShipping userShipping, User user);

	void setUserDefaultShipping(Long defaultShippingId, User user);

	User findById(long id);
	
}

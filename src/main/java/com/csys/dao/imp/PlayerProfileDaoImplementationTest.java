package com.csys.dao.imp;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

public class PlayerProfileDaoImplementationTest {
	PlayerProfileDaoImplementation obj = new PlayerProfileDaoImplementation();

	@Test
	@Ignore
	public void testValidateretiredplayer() throws Exception {
		String capNo = "a12";
		boolean expected = true;
		boolean actual = obj.validateretiredplayer(capNo);
		assertEquals(expected, actual);
	}

	@Test
	public void testValidateplayerprofile() throws Exception {
		String capNo = "i175";
		boolean expected = false;
		boolean actual = obj.validateplayerprofile(capNo);
		assertEquals(expected, actual);
	}
}

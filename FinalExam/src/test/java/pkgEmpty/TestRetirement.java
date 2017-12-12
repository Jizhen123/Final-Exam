package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class TestRetirement {
	
	@Test
	
	public void testRetirement() {
		Retirement Ret = new Retirement(40,0.07,20,0.02,10000,2642);
		assertEquals(Ret.TotalAmountSaved(),-1454485.55,0.01);
		assertEquals(Ret.AmountToSave(),554.13,0.01);
	}
}


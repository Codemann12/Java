package test;


import static org.junit.Assert.*;
import javax.naming.AuthenticationException;
import org.junit.*;
import org.junit.rules.Timeout;
import webstore.*;



public class TestForWebstore
{

	WebstoreImpl store; 
	public String sessionId;
	
	 
	// wrong dependency in the jar file for JUnit. 
	@Before 
	public void StoreCreator(){store =  (WebstoreImpl) WebstoreImpl.getWebstore();}
	
	@SuppressWarnings("deprecation")
	@Rule
	public Timeout timeout = new Timeout(2000);
	
	@Test
    public void testIfItemWasAdded()
	{
		try {
			store.register("cedric", "cedric123");
			sessionId = store.login("cedric", "cedric123");
		    store.addItemToCart(sessionId, "cedric", "macbook");
	    	assertEquals("macbook", store.getCartItems(sessionId, "cedric").get(0));
		} catch (AuthenticationException e) {
		e.printStackTrace();
		}		
	}
	
	// this test is not working... there is already something
	// in the cart when it is initialize.
	@Test
    public void testTheNumberOfAddedItem()
	{
		try {
			store.register("ced", "00");
			sessionId = store.login("ced", "00");
		    store.addItemToCart(sessionId, "ced", "item0");
	    	assertEquals(1, store.getCartItems(sessionId, "ced").size());
		} catch (AuthenticationException e) {
		e.printStackTrace();
		}		
	}
	
	
	@Test
    public void testAddedManyItem()
	{
		try {
			store.register("ce", "00");
			sessionId = store.login("ce", "00");
			int i = 90000;
		    while(i> 0) 
		    {
		    	 store.addItemToCart(sessionId, "ce", "item0");
		    	 i--;		    	
		    }
		    // 90001 because the cart is initialize with one element
	        assertEquals(90000, store.getCartItems(sessionId, "ce").size());
		} catch (AuthenticationException e) {
		e.printStackTrace();
		}		
	}
	
	@Test
    public void testAddItemWithBadPassword()
	{
		try {
			store.register("ced1", "001");
			sessionId = store.login("ced1", "cedric123");
		    store.addItemToCart(sessionId, "ced1", "item1");
	    	} catch (AuthenticationException e) {
		   Assert.fail("bad password for this user");
		}		
	}
	
	
	@Test
	public void testLogginAndRegister() 
	{
		store.register("ced1", "001");
		sessionId = store.login("ced1", "001");
		if(sessionId == null)
			Assert.fail("Loggin not working!!");		
	}
	
	
	@Test
	public void logginWithoutRegister() 
	{
		//store.register("ced1", "001");
		sessionId = store.login("ced", "001");
		if(sessionId == null)
			Assert.fail("Not register!! therefore loggin Impossible");		
	}
	
	
	@Test
	public void testLogginPassWord() 
	{
		store.register("ced1", "001");
		sessionId = store.login("ced1", "");
		if(sessionId == null)
			Assert.fail("Wrong password");		
	}
	
	@Test
	public void testLogginUsername() 
	{
		store.register("ced1", "001");
		sessionId = store.login("ced", "001");
		if(sessionId == null)
			Assert.fail("Wrong username");		
	}

	
	@Test
	public void testremoveItem() 
	{
		try {
			store.register("ce1", "001");
			sessionId = store.login("ce1", "001");
			store.addItemToCart(sessionId, "ce1", "item");
			assertEquals(1, store.getCartItems(sessionId, "ce1").size());
			store.removeItemFromCart(sessionId, "ce1", "item");
			assertEquals(0, store.getCartItems(sessionId, "ce1").size());
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}		
	}
	
	
	@Test
	public void testremoveItemWithBadUserName() 
	{
		try {
			store.register("ce2", "01");
			sessionId = store.login("ce2", "01");
			store.removeItemFromCart(sessionId, "", "item");
	 } catch (AuthenticationException e) {
			Assert.fail("user name not found");
		}		
	}
	
	
	@Test
	public void testGetCartItems() 
	{
		try {
			store.register("ce2", "01");
			sessionId = store.login("ce2", "01");
			store.addItemToCart(sessionId, "ce2", "BOOM");
			assertEquals("BOOM",store.getCartItems(sessionId, "ce2").get(0));
	 } catch (AuthenticationException e) {
			Assert.fail();
		}		
	}
	
	
	@Test
	public void testGetCartItemsBadID() 
	{
		try {
			store.register("ce2", "01");
			sessionId = store.login("ce2", "01");
			store.addItemToCart(sessionId, "ce2", "BOOM");
			assertEquals("BOOM",store.getCartItems("8424df54df6df", "ce2").get(0));
	 } catch (AuthenticationException e) {
			Assert.fail("Bad Id");
		}		
	}
	
	
	@Test
	public void testLogout() 
	{
		try {
			store.register("log", "1");
			sessionId = store.login("log", "1");
			store.addItemToCart(sessionId, "log", "pc");
			store.logout(sessionId);
		    store.addItemToCart(sessionId, "log", "o-o");			
		} catch (AuthenticationException e) {
			Assert.fail("Your are already out");			
		}		
	}
	
	@After
	public void clear() {store = null;}
}

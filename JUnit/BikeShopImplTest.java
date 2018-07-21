package bikeshop;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import org.junit.Test;
import persistence.IPersistence;
import bikeshop.BikeShopImpl;
import org.mockito.Mockito;



public final class BikeShopImplTest
{	 
	/**
	 * The bike shop component should not re-throw exceptions from the persistence 
	 * component. Instead the bike shop should simply return an "Error" string.
	 * 
	 */
    @Test
	public void exceptionFromPersistenceShouldResultInErrorString()
    {
    	try {
    	IPersistence persistenceMock = Mockito.mock(IPersistence.class);
    	BikeShopImpl bikeshop = new BikeShopImpl(persistenceMock);
    	persistenceMock.getAvailableBikes();
       	bikeshop.getAvailableBikesAsHTML();       	       	
    	} catch(SQLException e) {
    		assertEquals(e.getMessage(),"Error");
    	}
	}

	/**
	 * The bike shop component should deliver "N/A" when the bike list is empty.
	 */
	@Test
	public void emptyListFromPersistenceShouldResultInNAString()
	{
		IPersistence persistenceMock = Mockito.mock(IPersistence.class);
    	BikeShopImpl bikeshop = new BikeShopImpl(persistenceMock);
    	String persistenceResponce = bikeshop.getAvailableBikesAsHTML();
    	assertEquals(persistenceResponce, "N/A");		
	}

	/**
	 * The bike shop component should deliver a valid HTML list for a common case
	 *  (e.g., a single bike in the list).
	 */
	@Test
	public void commonCaseShouldWork()
	{
		IPersistence persistenceMock = Mockito.mock(IPersistence.class);
       	BikeShopImpl bikeshop = new BikeShopImpl(persistenceMock);
    	String persistenceResponce = bikeshop.getAvailableBikesAsHTML();
    	assertEquals(persistenceResponce, "<ul><li>Awesome Bike</li></ul>");
		
	}

}

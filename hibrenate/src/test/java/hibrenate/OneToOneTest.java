/**
 * 
 */
package hibrenate;

import java.math.BigDecimal;
import java.util.function.Supplier;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.mapping.onetoone.Address;
import com.rajni.hibernate.mapping.onetoone.Desk;
import com.rajni.hibernate.mapping.onetoone.Item;
import com.rajni.hibernate.mapping.onetoone.Room;
import com.rajni.hibernate.mapping.onetoone.Shipment;
import com.rajni.hibernate.mapping.onetoone.User;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class OneToOneTest {
	public static void main(String[] args) {
		//saveUser();
		//saveDesk();
		saveItemShipment();
	
	}
	static void saveUser() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		Address address = getAddress("one","chd","pun","India","160101");
		user.setAddress(address);
		address.setUser(user);
		user.setEmail("rajni@gmail.com");
		user.setName("Rajni");
		Room room = new Room();
		room.setRoomNumber("1234");
		room.setUser(user);
		user.setRoom(room);
		session.save(user);
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void saveItemShipment() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Supplier<Item> itemSupplier = Item::new;
		Item item = itemSupplier.get();
		item.setItemName("Item A");
		item.setItemPrice(new BigDecimal(10));
		Supplier<Shipment> shipmentSupplier = Shipment::new;
		Shipment shipment = shipmentSupplier.get();
		shipment.setItem(item);
		shipment.setName("Shipment A");
		item.setShipment(shipment);
		session.save(item);
		tx.commit();
		HibernateUtil.closeResources();
	}

	static void saveDesk() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Desk desk = new Desk();
		desk.setDeskName("Desk1");
		User user = session.get(User.class, 38l);
		desk.setUser(user);
		session.save(desk);
		tx.commit();
		HibernateUtil.closeResources();
	}
	static Address getAddress(String street, String city, String state, String country, String zipcode) {
		Address address = new Address();
		address.setStreet(street);
		address.setCountry(country);
		address.setCity(city);
		address.setState(state);
		address.setZipcode(zipcode);
		return address;
	}
}

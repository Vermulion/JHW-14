import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AirportManagerTest {
    TicketRepository repo = new TicketRepository();
    AirportManager manager = new AirportManager(repo);

    Ticket ticket1 = new Ticket(1, 14999, "LED", "DPS", 600);
    Ticket ticket2 = new Ticket(2, 5999, "DME", "IST", 365);
    Ticket ticket3 = new Ticket(3, 8999, "IST", "JFK", 510);
    Ticket ticket4 = new Ticket(4, 2350, "VKO", "DXB", 620);
    Ticket ticket5 = new Ticket(5, 7000, "DXB", "EZE", 980);
    Ticket ticket6 = new Ticket(6, 11800, "LED", "DPS", 600);


    @BeforeEach
    public void test() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Arrays.sort(repo.getTickets());
    }

    @Test
    public void shouldFindSeveralTickets() {
        Ticket[] expected = {ticket6, ticket1};
        Ticket[] actual = manager.searchBy("LED", "DPS");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTicket() {
        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.searchBy("DXB", "EZE");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoTickets() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("DXB", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByCost() {
        Ticket[] expected = {ticket4, ticket2, ticket5, ticket3, ticket6, ticket1};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

}



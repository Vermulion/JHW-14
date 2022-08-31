import java.util.Comparator;

public class TicketFlightTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getFlightTime() < o2.getFlightTime()) {
            return -1;
        } else if (o1.getFlightTime() > o2.getFlightTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}


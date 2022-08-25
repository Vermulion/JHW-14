public class AirportManager {
    private TicketRepository repo;

    public void add(Ticket ticket) {
        repo.save(ticket);
    }


    public AirportManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу билеты
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                // "добавляем в конец" массива result продукт product
                Ticket tmp[] = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.matches(from, to)) {
            return true;
        } else {
            return false;
        }
    }
}

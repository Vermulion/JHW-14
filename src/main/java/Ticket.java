public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int cost;
    protected String departureAirport;
    protected String arrivalAirport;
    protected int flightTime; //in minutes

    public Ticket(int id, int cost, String departureAirport, String arrivalAirport, int flightTime) {
        this.id = id;
        this.cost = cost;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public boolean matches(String from, String to) {
        if (getDepartureAirport().contains(from) && getArrivalAirport().contains(to)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.getCost() < o.getCost()) {
            return -1;
        } else if (this.getCost() > o.getCost()) {
            return 1;
        } else {
            return 0;
        }
    }
}

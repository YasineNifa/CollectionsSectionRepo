package theater;

import java.util.*;

public class Theater {
    private final String theatreName;
    //List -> Collection
    // Change ArrayList to different collection's classes to see the difference
    //private Collection<Seat> seats = new ArrayList<>();
    //private Collection<Seat> seats = new LinkedList<>();
    //private Collection<Seat> seats = new HashSet<>();
    //private Collection<Seat> seats = new LinkedHashSet<>();
    public List<Seat> seats = new ArrayList<>();
    static final Comparator<Seat> ORDER_PRICE = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()){
                return -1;
            }else if(seat1.getPrice() > seat2.getPrice()){
                return 1;
            }else{
                return 0;
            }
        }
    };
    public Theater(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        double price = 12;
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                if(row <= 'D'){
                    if(4 <= seatNum && seatNum <= 9){
                        price = 14;
                    }
                    else {
                        price = 12;
                    }
                }else{
                    price = 7;
                    }
                Seat seat = new Seat(row + String.format("%02d", seatNum),price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {

        // Now I will use Collections.binarysearch
        //Collections.binarySearch()
        Seat requestedSeat = new Seat(seatNumber,12);
        int index = Collections.binarySearch(seats,requestedSeat);
        if(index >= 0){
            return seats.get(index).reserve();
        }else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }


        //Seat requestedSeat = null;
        /*for (Seat seat : seats) {
            System.out.print(".");
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        if (requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return requestedSeat.reserve();*/
    }

    // for testing
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }




// private to public
    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }


}

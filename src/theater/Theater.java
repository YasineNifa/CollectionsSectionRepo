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
    private List<Seat> seats = new ArrayList<>();
    public Theater(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
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
        Seat requestedSeat = new Seat(seatNumber);
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

    private class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;



        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
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

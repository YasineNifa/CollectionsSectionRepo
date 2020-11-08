package theater;


public class Main {
    public static void main(String[] args) {
        // write your code here
        Theater theatre = new Theater("YassineHero", 8,12);
        theatre.getSeats();
        if(theatre.reserveSeat("A09")){
            System.out.println("Pay this Place");
        }else{
            System.out.println("The seat is reserved by another person");
        }

        if(theatre.reserveSeat("A09")){
            System.out.println("Pay this Place");
        }else{
            System.out.println("Sorry the seat is reserved by another person");
        }




    }
}

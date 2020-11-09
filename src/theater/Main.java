package theater;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*Difference btw shallow copy anfd a deep copy
Shallow Copy of a list : Arraylist<type> copyliste = new Arraylist<>(theatre.seats)
    Create a new liste
    les elements des deux liste font reference au meme objet
Deep Copy of a liste : Collections.copy(dest,src)
    create a new liste
    create new element
*/
public class Main {
    public static void main(String[] args) {
        // write your code here
        Theater theatre = new Theater("YassineHero", 8,12);




        // To copy a list in a list using shallow copy, So what that does is creates an array list containing all the elements from the list
        //that were passed to the constructor,
        // The two list share the same memory space
        //let's demonstarte it
        /*ArrayList<Theater.Seat> copyList = new ArrayList<>(theatre.seats);
        System.out.println("Shuffle the liste");
        Collections.shuffle(copyList);
        printlist(copyList);
        System.out.println("Sort the liste");
        sortList(copyList);
        printlist(copyList);*/

        //Deep Copy
        /*ArrayList<Theater.Seat> cop = new ArrayList<>(theatre.seats.size());
        cop.add(theatre.seats.get(0));
        Collections.copy(cop,theatre.seats);*/




        /*copyList.get(0).reserve();
        if(theatre.reserveSeat("A01")){
            System.out.println("Pay this Place");
        }else{
            System.out.println("The seat is reserved by another person");
        }*/

        // Reverse
        //shuffle
        /*Collections.shuffle(copyList);
        //Collections.reverse(copyList);
        System.out.println("Printing the copylist");
        printlist(copyList);

        System.out.println("Printing the original list");
        printlist(theatre.seats);*/

        // Min & Max
     /*   Theater.Seat minSeat = Collections.min(copyList);
        Theater.Seat maxSeat = Collections.max(copyList);
        System.out.println("min : " + minSeat.getSeatNumber());
        System.out.println("max : " + maxSeat.getSeatNumber());*/


        //theatre.getSeats();
        /*if(theatre.reserveSeat("A12")){
            System.out.println("Pay this Place");
        }else{
            System.out.println("The seat is reserved by another person");
        }

        if(theatre.reserveSeat("A09")){
            System.out.println("Pay this Place");
        }else{
            System.out.println("Sorry the seat is reserved by another person");
        }*/

        // COMPARATOR
        ArrayList<Theater.Seat> liste = new ArrayList<>(theatre.seats);
        printlist(liste);
        System.out.println("Sorted liste");
        Collections.sort(liste,theatre.ORDER_PRICE);
        printlist(liste);











    }















    public static void printlist(List<Theater.Seat> liste){
        for(Theater.Seat s: liste){
            System.out.print(s.getSeatNumber()+" $" + s.getPrice() + " ");
        }
        System.out.println();
    }
    // Sort a list with a nested for loop
    public static void sortList (List<Theater.Seat> liste){
        for (int i = 0; i<liste.size()-1;i++){
            for(int j = i+1; j<liste.size() ; j++){
                //i-j>0
                if(liste.get(i).compareTo(liste.get(j)) > 0){
                    Collections.swap(liste,i,j);
                }
            }
        }
    }
}

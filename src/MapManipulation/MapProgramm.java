package MapManipulation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapProgramm {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java","a compiled high level oriented object language");
        languages.put("Python","an interpreted high level object oriented language");
        languages.put("Algo","Algorithme programme");

        //System.out.println(languages.get("Java"));
        System.out.println(languages.put("C", "Native language programming"));
        //System.out.println(languages.put("Java","I am programming with Java"));
        //System.out.println(languages.put("Java","I am coding ..."));

        /*if(languages.containsKey("C")){
            System.out.println("C is already added");
        }else{
            System.out.println("you should add C");
        }
        languages.put("x" , "xxxxxxxxxxxxxxxxxxxxxxx");
        printmap(languages);*/

        /*// The remove method returns True or False
        languages.remove("x");
        printmap(languages);
        languages.remove("C", "native program");
        printmap(languages);*/

        // Replace method
        if(languages.replace("C", "xpxpx","Native language programming")){
            System.out.println("hello");
        }
        else{
            System.out.println("ji");
        }
        printmap(languages);
    }
    public static void printmap(Map<String,String> mapp){
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        for(String key : mapp.keySet()){
            System.out.println(key + " : " + mapp.get(key));
        }
    }

}

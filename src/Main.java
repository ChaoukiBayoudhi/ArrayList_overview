import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void removeContains(List<String> lst, String sch){
//        int i = 0;
//        while(i < lst.size()){
//            if(lst.get(i).contains(sch))
//                lst.remove(i);
//            else
//                i++;
//        }
        lst.removeIf(x->x.contains(sch));
    }
    //task 2
    public static void printCubeOdd(List<Integer> lst){
        for (int i = 0; i < lst.size(); i++) {
            if(lst.get(i)%2!=0)
                System.out.print(Math.pow(lst.get(i), 3)+" ");
        }
    }


    public static void printCubeOdd2(List<Integer> lst){
        lst.stream()
                .filter(x->x%2!=0)
                .map(x->Math.pow(x,3))
                .forEach(x->System.out.print(x+" "));
    }
    //task 3
    public static List<Integer> generateList(int nbElements, int valMin, int valMax){
        Random rand = new Random();
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nbElements; i++) {

            lst.add(rand.nextInt(valMax-valMin+1)+valMin);
        }
        return lst;
    }
    //other way to generate list randomly
    public static List<Integer> generateList2(int nbElements, int valMin, int valMax){
        Random rand = new Random();

        return rand.ints(nbElements,valMin,valMax+1)
                .boxed()
                .collect(Collectors.toList());
    }
    //task 4 max of list
    public static int max(List<Integer> lst){
        int max=lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            if(lst.get(i)>max)
                max=lst.get(i);
        }
        return max;
    }
    //using Stream on List
    public static int max2(List<Integer> lst){
        return lst.stream()//convert list to stream
                .max(Integer::compare)//find the max as Optional<Integer>
                .get();//get the value of Optional<Integer>
    }
    //task 5
    public static int countSubString(List<String> lst, String sch){
        int count=0;
        for (int i = 0; i < lst.size(); i++) {
            if(lst.get(i).contains(sch))
                count++;
        }
        return count;
    }
    //using Stream on List
    public static long countSubString2(List<String> lst, String sch){
        return lst.stream()
                .filter(x->x.contains(sch))
                .count();
    }

    public static void main(String[] args) {
        //task 1 : strategies to create a list

        //create an initialized List of integer
     /*   List<Integer> lst6=new ArrayList<>();
        List<Integer> lst=new ArrayList<>(20);
        List<Integer> lst0=List.of(1,14,8,6,9,18,5);
        List<Integer> lst5=new ArrayList<>(lst0);

        //1-method 1:
        List<Integer> lst1 = new ArrayList<>(Arrays.asList(1,14,8,6,9,18,5));
        //method 2:
        List<Integer> lst2=Arrays.asList(1,14,8,6,9,18,5);
        //method 3:
        List<Integer>  lst3=List.of(1,14,8,6,9,18,5);
        //method 4:
        List<Integer> lst4=new ArrayList<>();
        lst4.add(1);lst4.add(14);lst4.add(8);lst4.add(6);lst4.add(9);lst4.add(18);lst4.add(5);




        //show the cube of odd integers
        //using for i loop
        printCubeOdd(lst1);
        System.out.println();
        //using for each loop
        for (var x:lst1) {
            if(x%2!=0)
                System.out.print(Math.pow(x, 3)+" ");
        }
        System.out.println();
        //using .forEach() method
        //all the elements
        lst1.forEach(x->System.out.print(Math.pow(x, 3)+" "));
*/
        //create list of Strings
        /*List<String> lst=new ArrayList<>(Arrays.asList("hello","world","java","programming","language","student","teacher"));
        System.out.println("before removing :\n"+lst);
        //remove all the elements that contains "a"
        removeContains(lst,"a");
        System.out.println("after removing :\n"+lst);

         */
        List<Integer> lstRes=generateList(10, 30, 100);
        //lstRes.forEach(x->System.out.print(x+" "));
        lstRes.add(lstRes.get(0));
        System.out.println(lstRes);
        //remove redundant elements
        Set<Integer> st=new HashSet<>(lstRes);
        System.out.println(st);

        }
}
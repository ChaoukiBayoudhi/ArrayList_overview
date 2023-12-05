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
    //using Collections
    public static int max3 (List<Integer> lst){
        return  Collections.max(lst,Integer::compare);
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
                .filter(x->x.equals(sch))
                //.filter(x->x.equalsIgnoreCase(sch))//in case not sensitive to case
                .count();
    }
    //using Collections
    public static long countSubString3(List<String> lst, String sch){
        return Collections.frequency(lst,sch);
    }
    //task 6
public static long upgradeSalary(List<Employee> employees, double increasePercent){
    int count = 0;
        for (var e:employees) {
        if(e.getTitle()==EmployeeTitle.DEVELOPER) {
            e.setSalary(e.getSalary() * (1 + increasePercent));
            count++;
        }
    }
        return count;
}
//task 7:
public static double averageOfStringsLength(List<String> lst){
        return lst.stream()//convert to Stream
                .map(x->x.length())//get a stream of strings length
                .mapToDouble(Integer::doubleValue)
                .average()
                .getAsDouble();
}



    public static void initialize(List<Integer> lst){
        if(lst==null)
            lst=new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(11);
        lst.add(25);
        lst.add(77);
    }
    public static void initialize2(List<Integer> lst){
        lst=List.of(1,2,3,11,25,77);
    }
    public static void initialize3(List<Integer> lst,List<Integer> lst2){
        if(lst==null)
            lst=new ArrayList<>(lst2);
        else
            lst.addAll(lst2);
    }
    //initialize from Array
    public static void initialize4(List<Integer> lst,int[] arr){
        for(int i=0;i<arr.length;i++)
            lst.add(arr[i]);
    }
    public static void initialize5(List<Integer> lst){
        lst=Arrays.asList(1,2,3,11,25,77);
    }
    //task 2 : using Math.random()
    public static List<Integer> generateListRandomly(int nbValues,int minValue,int maxValue){
        List<Integer> lst=new ArrayList<>();
        for(int i=0;i<nbValues;i++)
            lst.add((int)(minValue+Math.random()*(maxValue-minValue+1)));

        return lst;
    }

    //task 3


    //task 4
    public static  int maxOfOddNumbers(List<Integer> lst){
        return lst.stream()
                .filter(x -> x%2!=0)//get the odd numbers
                .max(Integer::compare)
                .get();
    }
    public static int maxOfList(List<Integer> lst){
        return  Collections.max(lst, Integer::compare);
    }
    public static int menu(){
        System.out.println("1-Generate a list randomly");
        System.out.println("2-Get the list of odd values numbers");
        System.out.println("3-Get the maximum of odd numbers");
        System.out.println("4-Get the frequency of a substring");
        System.out.println("5-Increase developers salaries");
        System.out.println("6-Get the average of strings lengths");
        System.out.println("7-Exit");
        int choice;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
        }while(choice<1 || choice>7);
        return choice;
    }


    public static void main(String[] args) {
       /* System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);*/
        List<Integer> lst=new ArrayList<>();
        int choice;
        do{
            choice=menu();
            switch(choice){
                case 1:
                    System.out.println("Introduce the number of values: ");
                    Scanner sc=new Scanner(System.in);
                    int nbValues=sc.nextInt();
                    System.out.println("Introduce the minimum value: ");
                    int minValue=sc.nextInt();
                    System.out.println("Introduce the maximum value: ");
                    int maxValue=sc.nextInt();
                    lst=generateListRandomly(nbValues,minValue,maxValue);
                    System.out.println(lst);
                    break;
            }

        }while(choice!=7);
    }
}
import java.util.HashMap;
import java.util.Scanner;
public class HashMaps{
    public static void main(String[] args){
        HashMap<Integer, String> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ID and name (type -1 to stop):");
        while(true){
            System.out.print("ID: ");
            int id=sc.nextInt();
            if(id==-1) 
                   break;
            sc.nextLine();
            System.out.print("Name: ");
            String name=sc.nextLine();
            map.put(id,name);
        }
        System.out.print("Enter ID to search: ");
        int searchId=sc.nextInt();
        String result=map.get(searchId);
        System.out.println(result!=null?"Name: "+result:"ID not found");
    }
}
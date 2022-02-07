import java.util.ArrayList;

public class Runner
{
    public static void main(String[] args)
    {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        // numList empty: []

        numList.add(3);      //numList: [3]

        numList.add(0, 6);  //numList: [6, 3]

        numList.add(7);

        numList.add(2, 8);

        numList.set(3, 9);

        numList.add(1, 2);

        numList.add(1, numList.size());


        numList.remove(4);

        numList.set(numList.size()- 1, 0);


        System.out.println(numList);

    }

}

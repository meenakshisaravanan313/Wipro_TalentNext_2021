import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'isPower' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> isPower(List<Integer> arr) {
       
    // Write your code here
    int size =  arr.size();
    int[] a = new int[size];
    int[] b = new int[size];
    for(int i=0;i<size;i++){
        a[i]=arr.get(i);
    }  

    //
    for(int i=0;i<size;i++){
        int t = a[i];
        int count=0;
        while(t!=1){
            if(t%2!=0){
                count=1;
                break;
            }
            t=t/2;
        }
        if(count!=1){
            b[i]=1;
        }
        else{
            b[i]=0;
        }
       
    }
    List<Integer> ans= new ArrayList<>(b.length);
    for(int c :b){
        ans.add(Integer.valueOf(c));    
    }
    return(ans);
         
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.isPower(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

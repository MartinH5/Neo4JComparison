
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import socialnetwork.Neo4JData;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Opinator
 */
public class Main {

    public static void main(String[] args) {

        Neo4JData n4j = new Neo4JData();
        List<String> names = n4j.get25RandomIndexes();
        HashMap<Integer, ArrayList<Double>> neo4jMap = new HashMap<>();
        neo4jMap.put(1, new ArrayList<>());
        neo4jMap.put(2, new ArrayList<>());
        neo4jMap.put(3, new ArrayList<>());
        neo4jMap.put(4, new ArrayList<>());
        n4j.get25RandomIndexes().forEach((name) -> {
            n4j.DepthOne((String) name, neo4jMap); 
            n4j.DepthTwo((String) name, neo4jMap); 
            n4j.DepthThree((String) name, neo4jMap); 
            n4j.DepthFour((String) name, neo4jMap); 
          //ne.getDepthFive((String) name); //// This query is too slow and takes a long time to finish. 
        });
        System.out.println("Depth 1");
        System.out.println("avg: " + n4j.getAverage(neo4jMap.get(1)));
        System.out.println("median" + n4j.getMedian(neo4jMap.get(1)));

        System.out.println("Depth 2");
        System.out.println("avg: " + n4j.getAverage(neo4jMap.get(2)));
        System.out.println("median" + n4j.getMedian(neo4jMap.get(2)));

        System.out.println("Depth 3");
        System.out.println("avg: " + n4j.getAverage(neo4jMap.get(3)));
        System.out.println("median" + n4j.getMedian(neo4jMap.get(3)));

        System.out.println("Depth 4");
        System.out.println("avg: " + n4j.getAverage(neo4jMap.get(4)));
        System.out.println("median" + n4j.getMedian(neo4jMap.get(4)));
        
      //  System.out.println("Depth 5");
    //    System.out.println("avg: " + n4j.getAverage(neo4jMap.get(5)));
     //   System.out.println("median" + n4j.getMedian(neo4jMap.get(5)));
        
        DBConnection.closeDriver();

    }

}

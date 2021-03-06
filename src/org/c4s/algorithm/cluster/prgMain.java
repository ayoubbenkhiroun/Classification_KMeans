package org.c4s.algorithm.cluster;


/*-----------------PrgMain.java---------------*/

import org.c4s.algorithm.cluster.DataPoint;
import org.c4s.algorithm.cluster.JCA;
import java.util.Vector;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: shyam.s
 * Date: Apr 18, 2004
 * Time: 4:26:06 PM
 */
public class prgMain {
    public static void main (String args[]){
        Vector dataPoints = new Vector();
        dataPoints.add(new DataPoint(22,21,"p53"));
        dataPoints.add(new DataPoint(19,20,"bcl2"));
        dataPoints.add(new DataPoint(18,22,"fas"));
        dataPoints.add(new DataPoint(1,3,"amylase"));
        dataPoints.add(new DataPoint(3,2,"maltase"));

        JCA jca = new JCA(2,1000,dataPoints);
        jca.startAnalysis();

        Vector[] v = jca.getClusterOutput();
        for (int i=0; i<v.length; i++){
            Vector tempV = v[i];
            System.out.println("-----------Cluster"+i+"---------");
            Iterator iter = tempV.iterator();
            while(iter.hasNext()){
                DataPoint dpTemp = (DataPoint)iter.next();
                System.out.println(dpTemp.getObjName()+"["+dpTemp.getX()+","+dpTemp.getY()+"]");
            }
        }
    }
}
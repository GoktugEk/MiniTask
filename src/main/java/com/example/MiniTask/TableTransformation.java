package com.example.MiniTask;

import org.springframework.transaction.TransactionUsageException;

import java.io.*;
import java.util.Scanner;



public class TableTransformation {

    public static void main(String[] args) throws IOException {

        ///Users/macbookretina/MiniTask/consumerRecords.out

        File file = new File("/Users/macbookretina/MiniTask/consumerRecords.out");

        Scanner scan = new Scanner(file);

        String fileContent = "";
        while(scan.hasNextLine()){
            String oldLine = scan.nextLine();
            long id;
            String  createdAt;
            String lastUpdatedAt;
            int collectionDuration;
            int deliveryDuration;
            int eta;
            int leadTime;
            boolean orderInTime;

            //ID
            int indexIn = oldLine.indexOf("\"id\"");
            String sid = oldLine.substring(indexIn+5,indexIn+13);
            id = Long.parseLong(sid);

            //CREATED_AT
            int indexCreat = oldLine.indexOf("\"created_at\"");
            createdAt = oldLine.substring(indexCreat+14,indexCreat+40);

            //LAST_UPDATED_AT
            int indexLast = oldLine.indexOf("\"last_updated_at\"");
            lastUpdatedAt = oldLine.substring(indexLast+19,indexLast+45);

            //COLLECTION_DURATION
            int indexCollect = oldLine.indexOf("\"collected_at\"");
            int indexAssign = oldLine.indexOf("\"assigned_at\"");
            String scollect = oldLine.substring(indexCollect+16,indexCollect+42);
            String sassign = oldLine.substring(indexAssign+16,indexAssign+42);
        /*    int icollect = Integer.parseInt(scollect);
            int iassign = Integer.parseInt(sassign);
            collectionDuration = icollect - iassign; */
            collectionDuration=1;
            System.out.println(scollect+" mmmm "+ sassign);

            //DELIVERY_DURATION
            int indexDeliver = oldLine.indexOf("\"delivery_date\"");
            String sdeliver = oldLine.substring(indexDeliver+16,indexDeliver+42);
        /*    int ideliver = Integer.parseInt(sdeliver);
            deliveryDuration = ideliver - icollect;*/
            deliveryDuration=1;
        //    System.out.println(sdeliver+" mmmm "+ scollect);

            //ETA
            int indexEta = oldLine.indexOf("\"eta\"");
            int indexEtalast = oldLine.indexOf("\"eta_for_prep\"");
            String seta = oldLine.substring(indexEta+6,indexEtalast-1);
            System.out.println(seta);
            //if(seta == "null")
            eta = 0;
            //else eta = Integer.parseInt(seta);

            //LEAD_TIME
        //    int indexLead = oldLine.indexOf("\"collect\"");
        //    String slead = oldLine.substring(indexLead+5,indexLead+13);
        //    leadTime = Integer.parseInt(slead);
            leadTime=1;

            //ORDER_IN_TIME
        //    int indexOrder = oldLine.indexOf("\"collect\"");
        //    String sorder = oldLine.substring(indexOrder+5,indexOrder+13);
        //    orderInTime = true;
            orderInTime=true;

            MappedPackageObject newLine = new MappedPackageObject(id,createdAt,lastUpdatedAt,collectionDuration,deliveryDuration,eta,leadTime,orderInTime);

            String newiLine = "\"data\""+"{\"id\":"+id+","+"\"created_at\":"+createdAt+","+"\"last_updated_at\":"+lastUpdatedAt+","+"\"collection_duration\":"+collectionDuration+","+"\"delivery_duration\":"+deliveryDuration+","+"\"eta\":"+eta+","+"\"lead_time\":"+leadTime+"\"order_in_time\":"+orderInTime+"}";

            fileContent = fileContent.concat(newiLine + "\n");
            System.out.println(newiLine);
        }

        FileWriter writer = new FileWriter("/Users/macbookretina/MiniTask/mappedRecords.out");
        writer.write(fileContent);

        writer.close();
    }


}

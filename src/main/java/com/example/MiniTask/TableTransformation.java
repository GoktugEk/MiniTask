package com.example.MiniTask;

import org.springframework.transaction.TransactionUsageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TableTransformation {

    public static void main(String[] args) throws IOException {

        ///Users/macbookretina/MiniTask/consumerRecords.out

        File file = new File(System.getProperty("user.dir") + "/consumerRecords.out");

        Scanner scan = new Scanner(file);

        String fileContent = "";
        String oldLine = scan.nextLine();
        while(scan.hasNextLine()){
            long id = oldLine.indexOf("\"id\"");;
            List packageList = new ArrayList();
            packageList.add(oldLine);
            int len = 1;

            while(id != oldLine.indexOf("\"id\"")){
                oldLine = scan.nextLine();
                packageList.add(oldLine);
                len++;
            }
            String  createdAt;
            String lastUpdatedAt;
            int collectionDuration;
            int deliveryDuration;
            int eta;
            int leadTime;
            boolean orderInTime;

            for (int i = 0; i < len; i++){
                //buraya packageListteki bir package a ait line lari kullanarak istedigin parametrelerin hepsini bul
                //mesela collected at ilk baslarda null olabilir ama sonradan degisiyor o degiseni al
            }

            //Oldline i kullanma, eger bir paket icin degismeyecek bir feature ile ugrasacaksan packageList'in ilk indexini kullan

            //ID THIS IS COMPLETED
            String p1 = (String) packageList.get(0);
            int indexIn = p1.indexOf("\"id\"");
            String sid = p1.substring(indexIn+5,indexIn+13);
            id = Long.parseLong(sid);

            //CREATED_AT THIS IS COMPLETED
            p1 = (String) packageList.get(0);
            int indexCreat = p1.indexOf("\"created_at\"");
            createdAt = p1.substring(indexCreat+14,indexCreat+40);

            //LAST_UPDATED_AT THIS IS COMPLETED
            p1 = (String) packageList.get(len-1);
            int indexLast = p1.indexOf("\"last_updated_at\"");
            lastUpdatedAt = p1.substring(indexLast+19,indexLast+45);

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

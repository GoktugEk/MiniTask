package com.example.MiniTask;

import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.transaction.TransactionUsageException;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class TableTransformation {

    public static void main(String[] args) throws IOException, ParseException {


        File file = new File(System.getProperty("user.dir") + "/consumerRecords.out");

        Scanner scan = new Scanner(file);

        String fileContent = "";
        String oldLine = scan.nextLine();

        GsonJsonParser parser = new GsonJsonParser();
        Map<String, Object> lineParsed = parser.parseMap(oldLine);


        while(scan.hasNextLine()){

            List packageList = new ArrayList();
            int len = 0;

            Object temp1 = lineParsed.get("xid");
            long temp = ((Number) temp1).longValue();

            //ID THIS IS COMPLETED
            long id = temp;

            while( id == temp){
                packageList.add(lineParsed);
                if(scan.hasNextLine()) oldLine = scan.nextLine();
                parser = new GsonJsonParser();
                lineParsed = parser.parseMap(oldLine);
                temp1 = lineParsed.get("xid");
                temp = ((Number) temp1).longValue();
                len++;
            }



            String  createdAt;
            String lastUpdatedAt;
            int collectionDuration = 0;
            int deliveryDuration = 0;
            int eta = 0;
            int leadTime = 0;
            boolean orderInTime;

            Date icollect = null, iassign = null, ideliver = null, ilead1 = null, ilead2 = null;


            for (int i = 0; i < len; i++){
                Map<String, Object> tempP = (Map<String, Object>) packageList.get(i);
                Map<String, Object> dataMap = (Map<String, Object>) tempP.get("data");

                String indexCollect = String.valueOf(dataMap.get("collected_at"));
                String indexAssign = String.valueOf(dataMap.get("assigned_at"));
                String indexDeliver =String.valueOf(dataMap.get("in_delivery_at"));
                String indexEta = String.valueOf(dataMap.get("eta"));
                String indexLead1 = String.valueOf(dataMap.get("completed_at"));
                String indexLead2 = String.valueOf(dataMap.get("created_at"));




                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                if(indexCollect != "null") icollect = format.parse(indexCollect);
                if(indexAssign  != "null") iassign = format.parse(indexAssign);
                if(indexDeliver  != "null") ideliver = format.parse(indexDeliver);
                if(indexEta  != "null") eta = Integer.parseInt(indexEta);
                if(indexLead1  != "null") ilead1 = format.parse(indexLead1);
                if(indexLead2  != "null") ilead2 = format.parse(indexLead2);
            }


            //CREATED_AT THIS IS COMPLETED
            String p1 = (String) packageList.get(0);
            int indexCreat = p1.indexOf("\"created_at\"");
            createdAt = p1.substring(indexCreat+14,indexCreat+40);

            //LAST_UPDATED_AT THIS IS COMPLETED
            p1 = (String) packageList.get(len-1);
            int indexLast = p1.indexOf("\"last_updated_at\"");
            lastUpdatedAt = p1.substring(indexLast+19,indexLast+45);

            //COLLECTION_DURATION
            if(icollect != null && iassign != null) collectionDuration = (int) (icollect.getTime() - iassign.getTime());

            //DELIVERY_DURATION
            if(icollect != null && ideliver != null) deliveryDuration = (int) (ideliver.getTime() - icollect.getTime());

            //ETA

            //LEAD_TIME
            if(ilead1 != null && ilead2 != null) leadTime = (int) (ilead1.getTime() - ilead2.getTime());


            //ORDER_IN_TIME
            if(deliveryDuration+collectionDuration<=eta) orderInTime = true;
            else orderInTime = false;

            MappedPackageObject newLine = new MappedPackageObject(id,createdAt,lastUpdatedAt,collectionDuration,deliveryDuration,eta,leadTime,orderInTime);

            String newiLine = "\"data\""+"{\"id\":"+id+","+"\"created_at\":"+createdAt+","+"\"last_updated_at\":"+lastUpdatedAt+","+"\"collection_duration\":"+collectionDuration+","+"\"delivery_duration\":"+deliveryDuration+","+"\"eta\":"+eta+","+"\"lead_time\":"+leadTime+"\"order_in_time\":"+orderInTime+"}";

            fileContent = fileContent.concat(newiLine + "\n");
            System.out.println(newiLine);
        }

        FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/mappedRecords.out");
        writer.write(fileContent);

        writer.close();
    }


}

package com.example.MiniTask;

import org.springframework.transaction.TransactionUsageException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class TableTransformation {

    public static void main(String[] args) throws IOException, ParseException {

        ///Users/macbookretina/MiniTask/consumerRecords.out

        File file = new File(System.getProperty("user.dir") + "/consumerRecords.out");

        Scanner scan = new Scanner(file);

        String fileContent = "";
        String oldLine = scan.nextLine();
        while(scan.hasNextLine()){
            //ID THIS IS COMPLETED
            int indexIn = oldLine.indexOf("\"id\"");
            String sid = oldLine.substring(indexIn+5,indexIn+13);
            long id = Long.parseLong(sid);

            List packageList = new ArrayList();
            int len = 0;

            long temp = id;
            while(temp == id){
                packageList.add(oldLine);
                if(scan.hasNextLine()) oldLine = scan.nextLine();
                temp = Long.parseLong(oldLine.substring(oldLine.indexOf("\"id\"")+5,oldLine.indexOf("\"id\"")+13));
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
                String tempP = (String) packageList.get(i);

                int indexCollect = tempP.indexOf("\"collected_at\"");
                int indexAssign = tempP.indexOf("\"assigned_at\"");
                int indexDeliver = tempP.indexOf("\"in_delivery_at\"");
                int indexEta = tempP.indexOf("\"eta\"");
                int indexEtalast = tempP.indexOf("\"eta_for_prep\"");
                int indexLead1 = tempP.indexOf("\"completed_at\"");
                int indexLead2 = tempP.indexOf("\"created_at\"\"");


                String scollect = tempP.substring(indexCollect+27,indexCollect+42);
                String sassign = tempP.substring(indexAssign+27,indexAssign+42);
                String sdeliver = tempP.substring(indexDeliver+27,indexDeliver+42);
                String seta = tempP.substring(indexEta+6,indexEtalast-1);
                String slead1 = tempP.substring(indexLead1+27,indexLead1+42);
                String slead2 = tempP.substring(indexLead2+27,indexLead2+42);

                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                if(!scollect.matches(".*[^a-z].*") && !scollect.contains("null")) icollect = format.parse(scollect);
                if(!sassign.matches(".*[^a-z].*")&& !sassign.contains("null")) iassign = format.parse(sassign);
                if(!sdeliver.matches(".*[^a-z].*")&& !sdeliver.contains("null")) ideliver = format.parse(sdeliver);
                if(!seta.matches(".*[^a-z].*")&& !seta.contains("null")) eta = Integer.parseInt(seta);
                if(!slead1.matches(".*[^a-z].*")&& !slead1.contains("null")) ilead1 = format.parse(slead1);
                if(!slead2.matches(".*[^a-z].*")&& !slead2.contains("null")) ilead2 = format.parse(slead2);
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

        FileWriter writer = new FileWriter("/Users/macbookretina/MiniTask/mappedRecords.out");
        writer.write(fileContent);

        writer.close();
    }


}

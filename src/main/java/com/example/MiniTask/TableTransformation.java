package com.example.MiniTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;


public class TableTransformation {
    public static void main(String[] args) throws IOException, ParseException {

        File file = new File(System.getProperty("user.dir") + "/consumerRecords.out");
        Scanner scan = new Scanner(file);

        String fileContent = "";
        String oldLine = scan.nextLine();

        while(scan.hasNextLine()){
            List packageList = new ArrayList();
            int len = 0;

            ObjectMapper MAPPER = new ObjectMapper().disable(FAIL_ON_UNKNOWN_PROPERTIES);
            Package pac  = MAPPER.readValue(oldLine, Package.class);

            if ((! "package".equals(pac.table) ) && scan.hasNextLine()) {
                oldLine = scan.nextLine();
                continue;
            }

            //ID
            long id = pac.xid;
            long temp = id;

            while( id == temp){ //Getting all the updates on the same package to a list
                packageList.add(pac);
                if(scan.hasNextLine()) oldLine = scan.nextLine();
                else break;
                pac = MAPPER.readValue(oldLine, Package.class);
                temp = pac.xid;
                len++;
            }

            String  createdAt;
            String lastUpdatedAt;
            int collectionDuration = 0;
            int deliveryDuration = 0;
            int eta;
            int leadTime = 0;
            boolean orderInTime;

            Date icollect = null, iassign = null, ideliver = null, ilead1 = null, ilead2 = null; //DEFAULT PARAMETER VALUES


            pac = (Package) packageList.get(len-1); //PACKAGE OBJECT BELONGS TO THE LAST LINE OF REGARDING PACKAGE IN THE OLD MESSAGES

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //DATE PARSING
            if(pac.data.collected_at != null) icollect = format.parse(pac.data.collected_at);
            if(pac.data.assigned_at != null) iassign = format.parse(pac.data.assigned_at);
            if(pac.data.in_delivery_at != null)ideliver = format.parse(pac.data.in_delivery_at);
            eta = pac.data.eta;
            if(pac.data.completed_at != null)ilead1 = format.parse(pac.data.completed_at);
            if(pac.data.created_at != null)ilead2 = format.parse(pac.data.created_at);

            //CREATED_AT
            createdAt = pac.data.created_at;

            //LAST_UPDATED_AT
            lastUpdatedAt = pac.data.last_updated_at;

            //COLLECTION_DURATION
            if(icollect != null && iassign != null) {
                System.out.println(icollect+" mm "+ iassign+ " mm "+ (icollect.getTime() - iassign.getTime()));
                collectionDuration = ((int) (icollect.getTime() - iassign.getTime()))/ 1000;
            }

            //DELIVERY_DURATION
            if(icollect != null && ideliver != null) deliveryDuration = ((int) (ideliver.getTime() - icollect.getTime()))/ 1000;

            //LEAD_TIME
            if(ilead1 != null && ilead2 != null) leadTime = ((int) (ilead1.getTime() - ilead2.getTime()))/ 1000;

            //ORDER_IN_TIME
            if(deliveryDuration+collectionDuration<=eta) orderInTime = true;
            else orderInTime = false;

            MappedPackageObject newLine = new MappedPackageObject(id,createdAt,lastUpdatedAt,collectionDuration,deliveryDuration,eta,leadTime,orderInTime);

            ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = writer.writeValueAsString(newLine);

            fileContent = fileContent.concat(json); //NEW LINE ADDED TO THE FILE CONTENT
            System.out.println(json);
        }

        FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/mappedRecords.out");
        writer.write(fileContent);

        writer.close();
    }


}

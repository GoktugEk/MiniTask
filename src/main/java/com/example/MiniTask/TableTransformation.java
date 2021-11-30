package com.example.MiniTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.transaction.TransactionUsageException;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.MapperFeature.DEFAULT_VIEW_INCLUSION;


public class TableTransformation {
    public static void main(String[] args) throws IOException, ParseException {

        ///Users/macbookretina/MiniTask/consumerRecords.out

        File file = new File(System.getProperty("user.dir") + "/consumerRecords.out");

        Scanner scan = new Scanner(file);

        String fileContent = "";
        String oldLine = scan.nextLine();



        int counter = 0;
        while(scan.hasNextLine()){

            List packageList = new ArrayList();
            int len = 0;

            ObjectMapper MAPPER = new ObjectMapper().disable(DEFAULT_VIEW_INCLUSION).disable(FAIL_ON_UNKNOWN_PROPERTIES);
            Package pac  = MAPPER.readValue(oldLine, Package.class);

            if ((! "package".equals(pac.table) ) && scan.hasNextLine()) {
                oldLine = scan.nextLine();
                continue;
            }

            //ID THIS IS COMPLETED
            long id = pac.xid;
            long temp = id;

            while( id == temp){
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
            int eta = 0;
            int leadTime = 0;
            boolean orderInTime;

            Date icollect = null, iassign = null, ideliver = null, ilead1 = null, ilead2 = null;


            pac = (Package) packageList.get(len-1);

            if (counter == 627){
                counter = 627;
            }


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
            if(pac.data.collected_at != null) icollect = format.parse(pac.data.collected_at);
            if(pac.data.assigned_at != null)iassign = format.parse(pac.data.assigned_at);
            if(pac.data.in_delivery_at != null)ideliver = format.parse(pac.data.in_delivery_at);
            eta = pac.data.eta;
            if(pac.data.completed_at != null)ilead1 = format.parse(pac.data.completed_at);
            if(pac.data.created_at != null)ilead2 = format.parse(pac.data.created_at);



            //CREATED_AT THIS IS COMPLETED
            createdAt = pac.data.created_at;

            //LAST_UPDATED_AT THIS IS COMPLETED
            lastUpdatedAt = pac.data.last_updated_at;

            //COLLECTION_DURATION
            if(icollect != null && iassign != null) collectionDuration = (int) (icollect.getTime() - iassign.getTime());

            //DELIVERY_DURATION
            if(icollect != null && ideliver != null) deliveryDuration = (int) (ideliver.getTime() - icollect.getTime());


            //LEAD_TIME
            if(ilead1 != null && ilead2 != null) leadTime = (int) (ilead1.getTime() - ilead2.getTime());


            //ORDER_IN_TIME
            if(deliveryDuration+collectionDuration<=eta) orderInTime = true;
            else orderInTime = false;

            MappedPackageObject newLine = new MappedPackageObject(id,createdAt,lastUpdatedAt,collectionDuration,deliveryDuration,eta,leadTime,orderInTime);

            ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = writer.writeValueAsString(newLine);

            fileContent = fileContent.concat(json);
            System.out.println(json);
            counter++;
            System.out.println(counter);
        }

        FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/mappedRecords.out");
        writer.write(fileContent);

        writer.close();
    }


}

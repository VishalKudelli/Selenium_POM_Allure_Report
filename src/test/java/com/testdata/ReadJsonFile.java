package com.testdata;

import com.configurations.ReadConfigFile;
import com.genericmethods.GenericMethods;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile extends ReadConfigFile {

    private static JSONObject jsonObject;

    public void loadJSONFile() throws IOException, ParseException {
        //step1: file reader to read the jsonfile
        FileReader fileReader=new FileReader("./TestData/Testdata.json");
        // step2 : create a jsonparser object to parse the file read by file reader
        JSONParser jsonParser=new JSONParser();
        // store the parsed data into Object class object
        Object object=jsonParser.parse(fileReader);
        //parse the Object class with Json object to get the data based on the key
        jsonObject=(JSONObject)object;
    }

    public String getData(String fieldName)
    {
        JSONObject obj= (JSONObject) jsonObject.get(GenericMethods.currentTestCase);
        System.out.println(obj.get(fieldName));
        return obj.get(fieldName).toString();
    }

}
